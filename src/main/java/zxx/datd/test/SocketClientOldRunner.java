package zxx.datd.test;/*
 * 版权：（版权〉
 * 描述：〈描述〉
 * 修改人：姓名(工号)
 * 修改时间：YYYY-MM-DD
 * 需求单号：〈需求单号，如果不明确，可不写〉
 * 修改内容：〈修改内容〉
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class SocketClientOldRunner {

    public static void main(String[]args)
    {
        try {
            Socket socket = new Socket("10.21.17.168", 18384);
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
            Scanner scanner=new Scanner(System.in);
            new Thread(()->{
                try {
                    String re = "";
                    while ((re = reader.readLine()) != null) {
                        System.out.println("receivemesg:"+re);
                    }
                    System.out.println("ert");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }).start();
            String input="";
            while((input=scanner.nextLine())!=null)
            {
//                while(true) {
                    Long starttime=System.currentTimeMillis();
                    List<String> tunneldata=InputStr.getTunneldata();
                printWriter.write( "192.168.249.139|pafaso2q.dns.datd.work.|20211011155812|20\r\n");
                    printWriter.flush();

//                for (String data:tunneldata) {
//                    printWriter.write(data+"\r\n");
//                    printWriter.flush();
//                }
                System.out.println("consumetime:"+(System.currentTimeMillis()-starttime));
                Thread.sleep(1000L);
            }
//            }
        }catch (Exception e)
        {
            System.out.println("sdfdf"+e.getMessage());

        }

    }
}
