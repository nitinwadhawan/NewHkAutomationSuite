package browserStack;

import elementLocaters.BrowserStack;
import framework.SharedLibHtml;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nitin
 * Date: 11/15/13
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Stack extends SharedLibHtml {

	private String userName="rahul.agarwal@healthkart.com";
	private String userPass="hk@browser";
	String tcid="browserStack";
	String dynamicBrowserXpath1=".//*[@id='browser-"  ;
	String dynamicBrowserXpath2="']/a";
	BrowserStack browserStack=new BrowserStack();
	//@Parameters({"testUrl"})
	@Test(dataProvider = "placeOrderCredentials", enabled = true)
	public void openPageInBrowser(List<String> dataArray) throws IOException {

		openBrowser("http://www.browserstack.com","chrome");
		Click(browserStack.getSignInHomePage(), "Browser stack home page", "Sign in home screen", driver.getCurrentUrl(), driver, tcid);
		sendKeys(browserStack.getEmailTextBox(), "Browser stack home page", "Sign in home screen", driver.getCurrentUrl(), userName, driver, tcid);
		sendKeys(browserStack.getPasswordBox(), "Browser stack home page", "Sign in home screen", driver.getCurrentUrl(), userPass, driver, tcid);
		Click(browserStack.getSignInBtn(),"Browser stack home page","Sign in home screen",driver.getCurrentUrl(),driver,tcid);
		Click(browserStack.getPullDownBrowser(),"Browser stack home page","Sign in home screen",driver.getCurrentUrl(),driver,tcid);
		Click(dynamicBrowserXpath1+dataArray.get(0)+"_"+dataArray.get(1)+dynamicBrowserXpath2,"Browser stack home page","Sign in home screen",driver.getCurrentUrl(),driver,tcid);
		Click(browserStack.getStartTestingBtn(),"Browser stack home page","Sign in home screen",driver.getCurrentUrl(),driver,tcid);
	}

	@DataProvider(name = "placeOrderCredentials")
	public Iterator<Object[]> readFromExcelIterator() throws FileNotFoundException, IOException {
		//	prop.load(getClass().getResourceAsStream("AutomationEnv.properties"));
		//String sourceXlsFileName=(String)prop.get("signUpAndOrderCard");
		String fileName = "C:\\Users\\WINQA\\workspace\\NewHkAutomationSuite\\Excel\\browserStack.xls";
		int sheetNo = 0;
		ArrayList<Object[]> excelDataArray = new ArrayList<Object[]>();
		int cnt = 0;
		try {

			InputStream input = new BufferedInputStream(
					new FileInputStream(fileName));

			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(sheetNo);

			Iterator rows = sheet.rowIterator();

			while (rows.hasNext()) {
				int cellCount = 0;
				int flagStop = 0;
				HSSFRow row = (HSSFRow) rows.next();
				System.out.println("\n");
				Iterator cells = row.cellIterator();

				List<String> readExcelData = new LinkedList<String>();

				while (cells.hasNext()) {
					if (cellCount <= 10) {
						int cellValueInt;
						String CellValue;
						HSSFCell cell = (HSSFCell) cells.next();

						if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
							//System.out.print( cell.getNumericCellValue()+"     " );
							cellValueInt = (int) cell.getNumericCellValue();
							CellValue = Integer.toString(cellValueInt);
						} else {
							CellValue = cell.getStringCellValue();
						}
						readExcelData.add(CellValue);
						cnt++;

						cellCount++;
					}

					if (cellCount == 11)
						break;
				}
				excelDataArray.add(new Object[]{readExcelData});
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return excelDataArray.iterator();
	}


}
