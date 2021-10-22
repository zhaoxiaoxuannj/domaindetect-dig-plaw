package zxx.datd.test;/*
 * 版权：（版权〉
 * 描述：〈描述〉
 * 修改人：姓名(工号)
 * 修改时间：YYYY-MM-DD
 * 需求单号：〈需求单号，如果不明确，可不写〉
 * 修改内容：〈修改内容〉
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientFromFileRunner {

    public static void main(String[]args)
    {
        try {
            Socket socket = new Socket("10.21.17.168", 18384);
//            Socket socket = new Socket("10.21.41.51", 18384);
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
            new Thread(()->{
                try {
                    String re = "";
                    while ((re = reader.readLine()) != null) {
                        System.out.println("receivemesg:"+re);
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }).start();
            String input="";
            String[] filepath={"C:\\Users\\Zxx\\Downloads\\testresult.ter","C:\\Users\\Zxx\\Downloads\\dgaresult.ter"};
            for(String filetmp:filepath) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filetmp));
                String content=bufferedReader.readLine();
                while(content!=null)
                {
//                    printWriter.write(content+"\r\n");
//                    printWriter.flush();
//                    content=bufferedReader.readLine();
//                    Thread.sleep(1L);
                }
                bufferedReader.close();
            }
//            }
        }catch (Exception e)
        {
            System.out.println("sdfdf"+e.getMessage());

        }

    }
}
