package zxx.datd.utils;	/*
	 * 版权： 
	 * 描述：
	 * 修改人： zhaoxx
	 * 修改时间：2021-08-01
	 * 修改内容：新增
	 */

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectContentTransForm {
    private static String[]ignoreStri={"error=502","error=404","error=400","error=410","error=403"};
	public static void main(String[]args) {
		int i=0;
		int k=0;
		List<String> arr=new ArrayList<>();
		List<String> arrline=new ArrayList<>();
		String[]parentfilepath={"51","168"};
		for(String pfile:parentfilepath)
        {
            File innerFile=new File("C:\\Users\\Zxx\\Downloads\\result3\\"+pfile);
            String[] dfilelist=innerFile.list();
            for(String filename:dfilelist) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(innerFile.getAbsolutePath()+File.separator+filename));
                    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Zxx\\Downloads\\result3\\yangchun1.txt",true));
                    BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\Zxx\\Downloads\\result3\\yangchunempty.txt",true));
                    BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\Users\\Zxx\\Downloads\\result3\\yangchunerror.txt",true));
                    BufferedWriter writer3 = new BufferedWriter(new FileWriter("C:\\Users\\Zxx\\Downloads\\result3\\yangchuother.txt",true));
                    String line = reader.readLine();

                    StringBuilder stringBuilder = new StringBuilder();
                    while (line != null) {
                        if (line.contains(":空")) {

                            writer1.write(line.split(":")[0] + "\r\n");
                            writer1.flush();
                        } else if (line.contains(":{error=")) {
                            writer2.write(line.split(":")[0] + "\r\n");
                            writer2.flush();
                        } else if (line.contains(":{bodyText")) {
                            String domain = line.split(":")[0];
                            String content = line.split(":\\{bodyText")[1];
                            writer.write(domain + "::-::{bodyText" + content + "]}\r\n");
                            writer.flush();
                        } else {
                            writer3.write(line);
                            writer3.flush();
                        }
                        line = reader.readLine();
                    }
//			String[] strarr=stringBuilder.toString().split("\\]\\}");
//			for(String tmp:strarr)
//            {
//                String[] tmpcontent=tmp.split(":\\{");
//                if(tmpcontent.length==2)
//                {
//                    String domain = tmpcontent[0].split(":")[0];
////                    String ip=tmpcontent[1];
//                    String content = "{"+tmpcontent[1];
//                    if(isContans(Arrays.asList(ignoreStri),content))
//                    {
//                        writer2.write(domain+"\r\n");
//                        writer2.flush();
//                    }
//                    else {
//                        writer.write(domain + "::-::" + content + "]}\r\n");
//                        writer.flush();
//                    }
//                }
//            }
                    writer.flush();
                    writer1.flush();
                    writer2.flush();
                    writer3.flush();
                    reader.close();
                    writer.close();
                    writer1.close();
                    writer2.close();
                    writer3.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
		System.out.println("arr"+arr.size()+",arrim:"+k);
	}
	public static boolean isContans(List<String>lists,String content){
	    boolean flag=false;
	    for(String string:lists)
        {
            if(content.contains(string))
            {
                flag=true;
                break;
            }
        }
        return flag;
    }
}
