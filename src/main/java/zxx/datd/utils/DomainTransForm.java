package zxx.datd.utils;	/*
	 * 版权： 
	 * 描述：
	 * 修改人： zhaoxx
	 * 修改时间：2021-08-01
	 * 修改内容：新增
	 */

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DomainTransForm {
	public static void main(String[]args) {
		int i=0;
		int k=0;
		List<String> arr=new ArrayList<>();
		List<String> arrline=new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Zxx\\Downloads\\test1.ter"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Zxx\\Downloads\\result323.txt"));
			String line = reader.readLine();
			String key = "hget threat_analysis %s %s|11300|11308\r\n";
			StringBuilder stringBuilder=new StringBuilder();

			while (StringUtils.hasLength(line)) {
               String domain=line.split(",")[1];
               if(arr.contains(domain))
			   {
			   	System.out.println(domain);
				   k++;
			   }
			   arr.add(domain);
               String command=String.format(key,domain,domain);
               writer.write(command);
               writer.flush();
//				stringBuilder.append(command);
               i++;
				line = reader.readLine();
			}
//            writer.write(stringBuilder.toString());
			writer.flush();
			reader.close();
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("arr"+arr.size()+",arrim:"+k);
	}
}
