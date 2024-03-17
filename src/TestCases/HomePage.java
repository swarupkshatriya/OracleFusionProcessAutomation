package TestCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openxmlformats.schemas.drawingml.x2006.chart.STRadarStyle;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.relevantcodes.extentreports.LogStatus;

import ReportGenerator.ReportingClass;
import ResuableMethods.ResuableMethodClass;

public class HomePage {
	
	
	public By Home=By.xpath("//a[text()=' Home']");
	public By homecolor=By.xpath("//a[@style='color: orange;']");
	public By BlueTop=By.xpath("(//p[text()='Blue Top'])[1]");
	public By addToCart=By.xpath("(//p[text()='Blue Top']//following::a[text()='Add to cart'])[1]");
	public By MenTshir=By.xpath("(//p[text()='Men Tshirt'])[1]");
	public By addToCartMenTshirt=By.xpath("(//p[text()='Men Tshirt'])[1]//following::a[text()='Add to cart'][1]");
	public By cottonSlikHandBlockPrintSaree=By.xpath("(//p[text()='Cotton Silk Hand Block Print Saree'])[1]");
	public By cottonSlikHandBlockPrintSareeaddToCart=By.xpath("(//p[text()='Cotton Silk Hand Block Print Saree'])[1]//following::a[text()='Add to cart'][1]");
	public By cartlink=By.xpath("//a[text()=' Cart']");
	public By continueshoppingButton=By.xpath("//button[text()='Continue Shopping']");
	public By proceedToCheckout=By.xpath("//a[text()='Proceed To Checkout']");
	public By registerLoginLink=By.xpath("//u[text()='Register / Login']");
	public By NameTextField=By.xpath("//h2[text()='New User Signup!']//following::input[@placeholder='Name']");
	public By emailAddressTextField=By.xpath("//h2[text()='New User Signup!']//following::input[@placeholder='Email Address']");
	public By signupButton=By.xpath("//button[text()='Signup']");
	public By titleMrRadioButton=By.xpath("//input[@id='id_gender1']");
	public By titleMrsRadioButton=By.xpath("//input[@id='id_gender2']");
	public By Password=By.xpath("//label[text()='Password ']//following::input[1]");
	public By selectdays=By.xpath("//select[@id='days']");
	public By selectMonths=By.xpath("//select[@id='months']");
	public By selectYear=By.xpath("//select[@id='years']");
	public By newslaterCheckBox=By.xpath("//label[text()='Sign up for our newsletter!']");
	public By offerFromPartnerCheckBox=By.xpath("//input[@id='optin']");
	
	public By firstName=By.xpath("//label[text()='First name ']//following::input[1]");
	public By lastName=By.xpath("//label[text()='Last name ']//following::input[1]");
	public By company=By.xpath("//label[text()='Company']//following::input[1]");
	public By addressline1=By.xpath("//label[text()='Address ']//following::input[1]");
	public By addressLine2=By.xpath("//label[text()='Address 2']//following::input[1]");
	public By state=By.xpath("//label[text()='State ']//following::input[1]");
	public By city=By.xpath("//label[text()='City ']//following::input[1]");
	public By zipcode=By.xpath("//label[text()='Zipcode ']//following::input[1]");
	public By mobileNumber=By.xpath("//label[text()='Mobile Number ']//following::input[1]");
	public By CreateAccount=By.xpath("//button[text()='Create Account']");
	
	public By continueBtn=By.xpath("//a[text()='Continue']");
	public By username=By.xpath("//a[text()=' Logged in as ']//following::b[1]");
	
	public By commentAboutOrder=By.xpath("//label[text()='If you would like to add a comment about your order, please write it in the field below.']//following::textarea[1]");
	
	public By placeOrder=By.xpath("//a[text()='Place Order']");
	public By NameOnCard=By.xpath("//label[text()='Name on Card']//following::input[1]");
	public By cardNumber=By.xpath("//label[text()='Card Number']//following::input[1]");
	public By cvc=By.xpath("//label[text()='CVC']//following::input[1]");
	public By expirationMonthonCard=By.xpath("//label[text()='Expiration']//following::input[1]");
	public By expireYearOnCard=By.xpath("//input[@placeholder='YYYY']");
	
	public By payAndConfirmBtn=By.xpath("//button[text()='Pay and Confirm Order']");
	public By confirmationMsg=By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
	public By deleteAccount=By.xpath("//a[text()=' Delete Account']");
	public By confirmationAccountDeleted=By.xpath("//b[text()='Account Deleted!']");
	
	
	static int  rows;
	static int  col;
	
	Map<Integer, Map<String, Object>> map3=new HashMap<Integer, Map<String,Object>>();
	
	
	Map<String, Object> map=new HashMap<String, Object>();
	
	ResuableMethodClass rmc=new ResuableMethodClass();
	
	public Map<String, Object> excelReader() {
		
		try {
			XSSFWorkbook wb=new XSSFWorkbook("C:\\TestDataSheet\\AutomationExcerciseWorkBook.xlsx");
			XSSFSheet sheet=wb.getSheet("TestData");
			 rows=sheet.getPhysicalNumberOfRows();
			System.out.println("Number of Rows "+rows);
			col=sheet.getRow(rows-1).getLastCellNum();
			
			 
			
			 Object obj1[]=new Object[rows];
			 
			for(int i=1;i<rows;i++) {
				
				for(int j=0;j<col;j++) {
					XSSFCell cell=sheet.getRow(i).getCell(j);
					
					switch (cell.getCellType()) {
					case STRING:
						
						obj1[i]=cell.getStringCellValue();
						
						break;
					case NUMERIC:
					
						obj1[i]=cell.getNumericCellValue();
						break;
					case BOOLEAN:
						
						obj1[i]=cell.getBooleanCellValue();
						break;
					case FORMULA:
						
						obj1[i]=cell.getCellFormula();
						break;
					case BLANK:
						
						obj1[i]="";
						break;
					case _NONE:
						
						obj1[i]="";
						break;
					case ERROR:
						break;
					 default:
						 break;
						
				
				}
				map.put(sheet.getRow(0).getCell(j).toString(), obj1[i]);
			}
				map3.put((int)(Thread.currentThread().getId()), map);
			
		}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	public String getData(String data) {
		Map<String, Object>map2=new HashMap<String, Object>();
		map2=excelReader();
		Object d1=map2.get(data);
		return d1.toString();
		
	}
	
	
	
	
	public void TestCase14_PlaceOrder_Register_WhileCheckout(WebDriver driver,String stremailid,String strPassword,String strDays,String strMonth,String strYear,String strFirstname,String strLastname,String strCompany,String strAddressline1,String strAddressline2,String strState,String strCity,String strZipcode,String strMobileNumber,String strNameOnCard,String strCardNumber,String strCVC,String strExpireMonth,String strExpireYear) {
	
				String style=driver.findElement(homecolor).getAttribute("style");
				if(style.equals("color: orange;")) {
					Assert.assertEquals(style, "color: orange;");
				}
				rmc.javaScriptExecutor(driver, BlueTop);
				//rmc.hoverElement(driver, BlueTop);
				
				rmc.javaScriptExecutor(driver, addToCart);
				rmc.click("Clcking on BlueTop Add To Cart",driver, addToCart);
				rmc.ExplicitWait(driver, continueshoppingButton);
				rmc.click("Clicking on Continue Shopping Button",driver, continueshoppingButton);
				
				rmc.javaScriptExecutor(driver, MenTshir);
			//	rmc.hoverElement(driver, MenTshir);
				
				rmc.click("Clcking on MensTshirt Add To Cart",driver, addToCartMenTshirt);
				rmc.ExplicitWait(driver, continueshoppingButton);
				rmc.click("Clicking on Continue Shopping Button",driver, continueshoppingButton);
				
				
				rmc.javaScriptExecutor(driver, cottonSlikHandBlockPrintSaree);
				//rmc.hoverElement(driver, cottonSlikHandBlockPrintSaree);
				
				rmc.click( "Clcking on cottonSlikHandBlcokPRnitSaree Add to Cart",driver, cottonSlikHandBlockPrintSareeaddToCart);
				rmc.ExplicitWait(driver, continueshoppingButton);
				rmc.click( "Clicking on Continue Shopping Button",driver, continueshoppingButton);
				
				rmc.javaScriptExecutor(driver, cartlink);
				rmc.click("Clicking on CartLink",driver, cartlink );
				
				rmc.javaScriptExecutor(driver, proceedToCheckout);
				rmc.ExplicitWait(driver, proceedToCheckout);
				rmc.click( "Clicking on Proceed to Checkout",driver, proceedToCheckout);
				
				
				rmc.javaScriptExecutor(driver, registerLoginLink);
				rmc.ExplicitWait(driver, registerLoginLink);
				rmc.click("registerLoginLink",driver, registerLoginLink);
				
				rmc.ExplicitWait(driver, NameTextField);
				rmc.javaScriptExecutor(driver, NameTextField);
				rmc.type("NameTextField",driver, NameTextField,strFirstname);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String name=driver.findElement(NameTextField).getAttribute("value");
				
				ReportingClass.test.log(LogStatus.INFO, "<B>Entered name is "+name+"</B>");
				
				rmc.javaScriptExecutor(driver, emailAddressTextField);
				Random rand = new Random(); 
				int value = rand.nextInt(10000); 
				rmc.type("emailAddressTextField",driver, emailAddressTextField, stremailid+value);
				
				
				rmc.javaScriptExecutor(driver, signupButton);
				rmc.click("Clicking on signupButton",driver, signupButton);
				
				rmc.javaScriptExecutor(driver, titleMrRadioButton);
				rmc.click("Clicking on Mr Radio Button",driver, titleMrRadioButton);
				
				rmc.javaScriptExecutor(driver, Password);
				rmc.type("Password",driver, Password, strPassword);
				
				rmc.click("Clicking on Days",driver, selectdays);
				rmc.selectByValue(driver,selectdays , strDays);
				
				rmc.click( "Clicking on Month",driver, selectMonths);
				rmc.selectByIndex(driver,selectMonths , Integer.parseInt(strMonth));
				
				rmc.click("Clicking on Year",driver, selectYear);
				rmc.selectByVisibleText(driver,selectYear ,strYear);
				
				rmc.javaScriptExecutor(driver, newslaterCheckBox);
				rmc.click("Clicking on NewsLater checkbox",driver, newslaterCheckBox);
				
				
				rmc.javaScriptExecutor(driver, firstName);
				rmc.type("firstName",driver, firstName, strFirstname);
				
				rmc.javaScriptExecutor(driver, lastName);
				rmc.type("lastName",driver, lastName, strLastname);
				
				rmc.javaScriptExecutor(driver, company);
				rmc.type("company",driver, company, strCompany);
				
				
				rmc.javaScriptExecutor(driver, addressline1);
				rmc.type("addressline1",driver, addressline1, strAddressline1);
				
				rmc.javaScriptExecutor(driver, addressLine2);
				rmc.type("addressLine2",driver, addressLine2, strAddressline2);
				
				rmc.javaScriptExecutor(driver, state);
				rmc.type("State",driver, state, strState);
				
				rmc.javaScriptExecutor(driver, city);
				rmc.type("City",driver, city, strCity);
				
				rmc.javaScriptExecutor(driver, zipcode);
				rmc.type("zipcode",driver, zipcode, strZipcode);
				
				rmc.javaScriptExecutor(driver, mobileNumber);
				rmc.type("MobileNumber",driver, mobileNumber, strMobileNumber);
				
				rmc.javaScriptExecutor(driver, CreateAccount);
				rmc.click( "Clicking on Create Account",driver, CreateAccount);
				
				rmc.javaScriptExecutor(driver, continueBtn);
				rmc.ExplicitWait(driver, continueBtn);
				rmc.click("Clicking on Continue Button",driver, continueBtn);
				
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String usrname=driver.findElement(username).getText();
				ReportingClass.test.log(LogStatus.INFO, "<B>Fetched name is "+usrname+"</B>");
				if(usrname.equals(name)) {
					ReportingClass.test.log(LogStatus.PASS	,"<B>User name is equal</B>" );
					Assert.assertTrue(true, "User name is equal");
					
				}else {
					ReportingClass.test.log(LogStatus.FAIL	,"<B>User name is not equal</B>" );
					Assert.assertTrue(false, "User name is not equal");
					
				}
				
				rmc.javaScriptExecutor(driver, cartlink);
				rmc.click("Clicking on Cartlink",driver, cartlink);
				
				rmc.javaScriptExecutor(driver, proceedToCheckout);
				rmc.ExplicitWait(driver, proceedToCheckout);
				rmc.click("Clicking on Proceed to Checkout",driver, proceedToCheckout);
				
				rmc.javaScriptExecutor(driver, commentAboutOrder);
				rmc.type("commentAboutOrder",driver, commentAboutOrder, "OK to proceed");
				
				rmc.javaScriptExecutor(driver, placeOrder);
				rmc.click("Clicking on placeOrder",driver, placeOrder);
				
				rmc.javaScriptExecutor(driver, NameOnCard);
				rmc.type("NameOnCard",driver, NameOnCard, strNameOnCard);
				

				rmc.javaScriptExecutor(driver, cardNumber);
				rmc.type("CardNumber",driver, cardNumber, strCardNumber);
				
				rmc.javaScriptExecutor(driver, cvc);
				rmc.type("CVC",driver, cvc, getData("CVC"));
				
				rmc.javaScriptExecutor(driver, expirationMonthonCard);
				rmc.type("ExpirationMonth",driver, expirationMonthonCard, strExpireMonth);
				
				rmc.javaScriptExecutor(driver, expireYearOnCard);
				rmc.type("ExpireYear",driver, expireYearOnCard,strExpireYear);
				
				rmc.javaScriptExecutor(driver, payAndConfirmBtn);
				rmc.click("Clicking on Pay and Confirm Button",driver, payAndConfirmBtn);
				
				String message=driver.findElement(confirmationMsg).getText();
				System.out.println("confirmation message "+message);
				
				if(message.equalsIgnoreCase("Congratulations! Your order has been confirmed!")) 
				{
					ReportingClass.test.log(LogStatus.PASS	,"<B>your order has been placed<B>" );
					Assert.assertTrue(true, "your order has been placed");
				}else {
					ReportingClass.test.log(LogStatus.FAIL	,"<B>your order has not been placed<B>" );
					Assert.assertFalse(true, "Order has not been placed");
				}
				
				rmc.javaScriptExecutor(driver, deleteAccount);
				rmc.click("Clicking on Delete Account link",driver, deleteAccount);
				
				 message=driver.findElement(confirmationAccountDeleted).getText();
				 System.out.println("Confirmation message "+message);
				 
				 if(message.equalsIgnoreCase("ACCOUNT DELETED!")) {
					 ReportingClass.test.log(LogStatus.PASS	,"<B>ACCOUNT DELETED!<B>" );
					 Assert.assertTrue(true, "Account has been deleted");
				 }else {
					 ReportingClass.test.log(LogStatus.FAIL	,"<B>ACCOUNT has not DELETED!<B>" );
					 Assert.assertFalse(true, "Account has not deleted");
				 }
				 
				 rmc.javaScriptExecutor(driver, continueBtn);
				 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 rmc.click("Clicking on continue Button",driver, continueBtn);
				
				
				
				
	}
			
		
		
		
	
	
	
	
	
	
	

}
