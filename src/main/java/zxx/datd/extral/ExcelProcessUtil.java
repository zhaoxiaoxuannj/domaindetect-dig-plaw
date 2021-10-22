package zxx.datd.extral;	/*
	 * 版权： 
	 * 描述：
	 * 修改人： zhaoxx
	 * 修改时间：2021-08-01
	 * 修改内容：新增
	 */

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProcessUtil {
	private static String originStr="update DOMAIN_CATEGORY_INFO set category_code='%s' where category_code='%s';\r\n";
	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Zxx\\Desktop\\malduim到datd分类库映射关系.xlsx");
			XSSFWorkbook hssWorkbook=new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet=hssWorkbook.getSheet("mald-dtad映射");
			int rownum=sheet.getLastRowNum();
			StringBuilder stringBuilder=new StringBuilder();
			for(int i=2;i<=rownum;i++)
			{
				XSSFRow row=sheet.getRow(i);
				Integer malduimtype=Integer.valueOf(Double.valueOf(row.getCell(2).getNumericCellValue()).toString().replaceAll("\\.0",""));
				Integer selftype=Integer.parseInt(Double.valueOf(row.getCell(5).getNumericCellValue()).toString().replaceAll("\\.0",""));
				String single=String.format(originStr,selftype,malduimtype);
				stringBuilder.append(single);

			}
			fileInputStream.close();
			hssWorkbook.close();
			System.out.println(stringBuilder.toString());
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
