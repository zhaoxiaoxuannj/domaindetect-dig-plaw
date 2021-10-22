package zxx.datd.test;	/*
	 * 版权： 
	 * 描述：
	 * 修改人： zhaoxx
	 * 修改时间：2021-08-01
	 * 修改内容：新增
	 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TransmitParam {
	public static void main(String[]args)
	{
		StringBuilder strB=new StringBuilder();
		JSONArray arr=new JSONArray();
		TransmitParam transmitParam=new TransmitParam();
		transmitParam.test(strB,arr);
		System.out.println(strB.toString()+"....."+arr.size());
	}
	public void test(StringBuilder strB,JSONArray arr)
	{
		strB.append("233333333333");
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("23","er");
		arr.add(jsonObject);
	}
}
