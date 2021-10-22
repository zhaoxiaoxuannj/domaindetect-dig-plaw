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
import java.util.Scanner;

public class SocketClientRunner {

    public static void main(String[]args)
    {
        try {
            Socket socket = new Socket("10.21.41.51", 18384);
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
            Scanner scanner=new Scanner(System.in);
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
            while((input=scanner.nextLine())!=null)
            {
                input=input.replace("\\r\\n","");
                int i=0;
                long starttime=System.currentTimeMillis();
                while (i++<65536) {
                    printWriter.write("10.21.17.168|0mnarrhABR7En4jXXQmp5Fk-ubKPf0O-NpbxegbSMDVxB9RRXT17yV9Zd8JnLf.Y8IRb1lYJRpBuiPHPfq1okbORgN3JMpzIc9Wmn9kcr6bMqX80C9f7ogpb.wb-cAS4Ic1il3utqLclFldwCjO2TcZLZu8mr4yypO9NbZX4A9mHOZYaQm.k2YIIvdmzVafdJ3MkN1KFHtUbmDHsvpjm213eydbpkrcpsKKORf6.dns.wangfangjian.work|20210506110202|1\r\n" +
                            "10.21.17.168|0mnarrhABR7En4jXXQmp5Fk-ubKPf0O-NpbxegbSMDVxB9RRXT17yV9Zd8JnLf.Y8IRb1lYJRpBuiPHPfq1okbORgN3JMpzIc9Wmn9kcr6bMqX80C9f7ogpb.wb-cAS4Ic1il3utqLclFldwCjO2TcZLZu8mr4yypO9NbZX4A9mHOZYaQm.k2YIIvdmzVafdJ3MkN1KFHtUbmDHsvpjm213eydbpkrcpsKKORf6.dns.wangfangjian.work|20210506110202|1\r\n");
                    printWriter.flush();
                }
                System.out.println("时间"+(System.currentTimeMillis()-starttime));
            }
//            }
        }catch (Exception e)
        {
            System.out.println("sdfdf"+e.getMessage());

        }

    }
}
