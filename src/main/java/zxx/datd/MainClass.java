package zxx.datd;	/*
	 * 版权： 
	 * 描述：
	 * 修改人： zhaoxx
	 * 修改时间：2021-08-01
	 * 修改内容：新增
	 */

import cn.hutool.core.thread.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import zxx.datd.utils.HtmlGetter;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainClass {
	private static Logger logger= LoggerFactory.getLogger(MainClass.class);
	public static void main(String[]args){
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, Long.MAX_VALUE, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1000),
				new ThreadFactoryBuilder().setNamePrefix("receivemsg-thread").build(),new ThreadPoolExecutor.DiscardOldestPolicy());
		String sourcefilepath=args[0];
		String destfilepath=args[1];
		String shellpath=args[2];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(sourcefilepath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(destfilepath,false));
			String line=reader.readLine();
			while(line!=null){
				logger.debug("line:"+line);
				String[] linearr=line.split("\t");
				threadPoolExecutor.execute(()->{
					try {
						logger.debug("domain:" + linearr[0]);
						String domain = linearr[0];
						Runtime runtime = Runtime.getRuntime();
						String[] cmdargs = {"sh", shellpath, domain};
						logger.debug(String.join(" ", cmdargs));
						Process process = runtime.exec(cmdargs);
						process.waitFor();
						BufferedReader reader1 = new BufferedReader(new InputStreamReader(process.getInputStream()));
						String ipline = reader1.readLine().trim();
                        if(domain.contains(".zhangkoubei.com"))
                        {
                            writer.write(domain +  ":" +ipline+"{}"+"\r\n");
                            writer.flush();
                        }
                        else {
                            if (StringUtils.hasLength(ipline)) {
                                logger.debug("ipline:" + ipline);
                                String[] iplinearr = ipline.split(" ");
                                for (String ipinfo : iplinearr) {
                                    List<Map> resultList = HtmlGetter.htmpGet(ipinfo);
                                    if (resultList.size() == 0) {
                                        String result = domain + ":" + ipinfo;
                                        writer.write(result + "\r\n");
                                    } else {
                                        for (Map tmp : resultList) {
                                            String result = domain + ":" + ipinfo + ":" + tmp.toString();
                                            writer.write(result + "\r\n");
                                        }
                                    }
                                }
                            } else {
                                writer.write(domain + ":空\r\n");
                            }
                            writer.flush();
                            reader1.close();
                        }
					}catch (Exception e){
						logger.debug("中间的异常信息:"+e.getMessage());
					}
				});
				Thread.sleep(1000L);
				line=reader.readLine();
			}
		}catch (Exception e)
		{
			logger.debug("异常信息:"+e.getMessage());
		}
	}
}
