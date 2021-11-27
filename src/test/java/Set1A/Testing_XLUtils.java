package Set1A;

import java.io.IOException;

import com.testing.base.XLUtils;

public class Testing_XLUtils extends XLUtils{

	public static void main(String[] args) throws IOException {
		
		
	  String path="./testdata.xlsx";
		
      
      String s=XLUtils.getCellData(path, "Sheet1", 0, 0);
      System.out.println(s);
      
      String s1=XLUtils.getCellData(path, "Sheet1", 0, 1);
      System.out.println(s1);
      
      int a=XLUtils.getCellCount(path, "Sheet1", 0);
      System.out.println(a);
      
      int b=XLUtils.getRowCount(path, "Sheet1");
      System.out.println(b);
      
      
     

	}

}
