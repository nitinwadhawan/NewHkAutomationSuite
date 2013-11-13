package orderPlacement;

import elementLocaters.*;
import framework.SharedLibHtml;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nitin
 * Date: 10/24/13
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExistingUserOrderCOD {

	public class SignUpandOrderCard extends SharedLibHtml {
		public String sourceXlsFileName = "C:\\Users\\Nitin Wadhwan\\workspace\\NewHkAutomationSuite\\Excel\\signUpandPlace.xls";
		public String backgroundHtmlPrefix = "<table id = 'mytable' width='100%' border='1' cellpadding='2' cellspacing='2' style='background-color: #DAEBE6;'>";
		public String backgroundHtmlSufix = "</table>";
		public String screenShotCaptureFileName = "";
		public String tcID = "HK-Order-01";
		public String emailBodyText = "";
		public String msgBody = "<tr valign='top'><td class = 'td'>";
		CartFlow cartFlow = new CartFlow();
		HomePage homePage = new HomePage();
		LoginPage loginPage = new LoginPage();
		PaymentPage paymentPage = new PaymentPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		SearchResultPage searchResultPage = new SearchResultPage();
		SignUpPage signUpPage = new SignUpPage();
		Properties prop = new Properties();
		String baseUrl;
		private String signUpName = "automation";
		private String signUpPass = "Abc123";
		private String newUserPass = "123456";

		//test for cod
		//@Parameters("BaseURL")
		@Test(dataProvider = "placeOrderCredentials", enabled = true)
		public void navigateAndAddToCart(List<String> dataArray) throws InterruptedException, IOException {
			openBrowser(baseUrl, browser);
			sendKeys(homePage.getSearchBox(), "After search products grid", "sign up", driver.getCurrentUrl(), dataArray.get(3), driver, tcID);
			Thread.sleep(3000);
			Click(homePage.getSearchBtn(), "search btn", "homepage", driver.getCurrentUrl(), driver, tcID);
			Click(searchResultPage.getFirstProductResult(), "First product", "Search results", driver.getCurrentUrl(), driver, tcID);
			Click(productDetailPage.getBuyNowBtn(), "Buy now btn", "Product detail page", driver.getCurrentUrl(), driver, tcID);
			Thread.sleep(3000);

			boolean isCartExist = verifyIsExist(productDetailPage.getCartMouseOver(), "Mouse over on your cart", "Product detail page", driver.getCurrentUrl(), driver, tcID);
			System.out.println("Is cart exist? "+isCartExist);
			if (isCartExist) {
				//proceedToCart();
				driver.get(baseUrl+"/beta/cart/Cart.action");
			}
			Click(cartFlow.getPlaceOrderBtn(), "Place order btn in Cart", "Product detail page", driver.getCurrentUrl(), driver, tcID);
			//Sign up
			sendKeys(loginPage.getEmailIdTextBox(), "Login page", "sign up", driver.getCurrentUrl(), dataArray.get(0), driver, tcID);
			sendKeys(loginPage.getPasswordTextBox(), "Login page", "sign up", driver.getCurrentUrl(), dataArray.get(1), driver, tcID);
			Click(loginPage.getSignInBtn(), "Create an account button", "Sign in page", driver.getCurrentUrl(), driver, tcID);
			boolean isExistingAddress = verifyIsExist(cartFlow.getAddress1Box(), "Address 1 box", "Address page", driver.getCurrentUrl(), driver, tcID);
			if (!isExistingAddress) {
				sendKeys(cartFlow.getNewAddNameTextBox(), "Login page", "sign up", driver.getCurrentUrl(), signUpName, driver, tcID);
				sendKeys(cartFlow.getNewAddMobileTextBox(), "Login page", "sign up", driver.getCurrentUrl(), "9560489739", driver, tcID);
				sendKeys(cartFlow.getNewAddLine1TextBox(), "Login page", "sign up", driver.getCurrentUrl(), signUpPass, driver, tcID);
				sendKeys(cartFlow.getNewAddPinCode(), "Login page", "sign up", driver.getCurrentUrl(), "110085", driver, tcID);
				sendKeys(cartFlow.getNewAddCity(), "Login page", "sign up", driver.getCurrentUrl(), signUpPass, driver, tcID);
				selectDropdownElementByIndex(cartFlow.getNewAddStateDropDown(), "Address page", "Selecting state", driver.getCurrentUrl(), driver, 10, tcID);
				Click(cartFlow.getNewAddContinueBtn(), "Continue btn", "Continue Btn", driver.getCurrentUrl(), driver, tcID);
			} else {
				Click(cartFlow.getAddress1Box(), "Continue btn", "Continue Btn", driver.getCurrentUrl(), driver, tcID);
			}
			Click(cartFlow.getPayNowBtn(), "Continue btn", "Continue Btn", driver.getCurrentUrl(), driver, tcID);
			Click(paymentPage.getCodTab(), "Continue btn", "Continue Btn", driver.getCurrentUrl(), driver, tcID);
			Click(paymentPage.getCodPayment(), "Continue btn", "Continue Btn", driver.getCurrentUrl(), driver, tcID);
			driver.quit();

		}

		public void proceedToCart() throws InterruptedException {
			Thread.sleep(1000);
			System.out.println("inside proceed to cart")  ;
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(productDetailPage.getCartMouseOver())));
			actions.pause(1000);
			WebElement proceedToCart= driver.findElement(By.xpath(productDetailPage.getProceedToCartBtn()));
			actions.moveToElement(proceedToCart).sendKeys(Keys.ENTER).perform();
			String title=driver.getTitle();
			System.out.println(title);
			/*(new WebDriverWait(driver, 5))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productDetailPage.getProceedToCartBtn()))).click();*/
			String temp=driver.getTitle();
		if(temp.equals(title)){
				System.out.println("Cart button was not clicked,trying again")  ;
				proceedToCart();
			}
			else return;


		}
		//@AfterMethod
		public void teardown() {
			if (!(driver == null)) {
				driver.close();
			}
		}

		@Parameters({"BaseURL","Browser"})
		@BeforeClass
		public void g(String baseUrl,String browser) {
			this.baseUrl = baseUrl;
			this.browser=browser;
		}

		@DataProvider(name = "placeOrderCredentials")
		public Iterator<Object[]> readFromExcelIterator() throws FileNotFoundException, IOException {
			//	prop.load(getClass().getResourceAsStream("AutomationEnv.properties"));
			//String sourceXlsFileName=(String)prop.get("signUpAndOrderCard");
			String fileName = "C:\\Users\\Nitin Wadhwan\\workspace\\NewHkAutomationSuite\\Excel\\signUpandPlace.xls";
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

		//@Test
		public String randomEmail() {
			String email = "";
			//String temp="";
			long e2 = Math.round(Math.random() * 10000);
			String temp = "testNewUI" + e2;
			email = temp.concat(temp).concat("@automation.com");
			System.out.println(email);

			return email;

		}
	}//class


}
