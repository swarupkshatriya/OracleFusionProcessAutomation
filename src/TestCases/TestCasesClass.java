package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ExcelFileRead.ExcelFileReaderClass;
import ReportGenerator.ReportingClass;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;


public class TestCasesClass extends ReportingClass{

	WebDriver driver;
	public ATUTestRecorder recorder;
	
	public static int noOfTestCasesPass=0;
	public static int noOfTestCasesFailed=0;
	public static int noOfTestCasesSkiped=0;
	
	
	
	
	public ATUTestRecorder getRecorder() {
		return recorder;
	}


	public void setRecorder(ATUTestRecorder recorder) {
		this.recorder = recorder;
	}


	@BeforeMethod
	public void setupRecorder() {
		
	}
	
	
	
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod (Method m){
		Object[][] arrayObject;
		switch (m.getName()) {
		case "TestCase01_Candela_EDI_850_Shipments_Pre_Validation_Report": 
			arrayObject = getExcelData("C:\\TestDataSheet\\AutomationExcerciseWorkBook.xlsx","Candela EDI 850 Shipments Pre-V");
			return arrayObject;
		case "TestCase02": 
			arrayObject = getExcelData("C:\\TestDataSheet\\AutomationExcerciseWorkBook.xlsx","AutomationExcercise");
			return arrayObject;
		}
		return null;
		
	}
	
	
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getRow(1).getLastCellNum();
			int totalNoOfRows = sh.getPhysicalNumberOfRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getRow(i).getCell(j).toString();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} 
		return arrayExcelData;
	}
	
	
	
//	@Test
//	public void TestCase01() throws ATUTestRecorderException{
//		before("TestingSK01");
//		ExcelFileReaderClass efrc=new ExcelFileReaderClass();
//		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
//			
////			ChromeOptions options = new ChromeOptions();
////			options.addArguments("--headless=new");
////			 driver = new ChromeDriver(options);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//			Date date = new Date();
//			recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
//			recorder.start();
//			setRecorder(recorder);
//			
//			driver= new ChromeDriver();
//			
//			driver.get(efrc.getTestData("URL"));
//			driver.manage().window().maximize();
//			new TestCases.HomePage().TestCase14_PlaceOrder_Register_WhileCheckout(driver,efrc.getTestData("EmailID"),efrc.getTestData("Password"),efrc.getTestData("Days"),efrc.getTestData("Month"),efrc.getTestData("Year"),efrc.getTestData("Firstname"),efrc.getTestData("Lastname"),efrc.getTestData("Company"),efrc.getTestData("Addressline1"),efrc.getTestData("Addressline2"),efrc.getTestData("State"),efrc.getTestData("City"),efrc.getTestData("Zipcode"),efrc.getTestData("MobileNumber"),efrc.getTestData("Name On Card"),efrc.getTestData("CardNumber"),efrc.getTestData("CVC"),efrc.getTestData("ExpireMonth"),efrc.getTestData("ExpireYear"));
//					
//		}else {
//			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+"TestingSK01"+"</B>");
//			throw new SkipException("Skipping this test case");
//		}
//	
//	}
	
	
	

	@Test 
	public void TestCase01_Candela_EDI_850_Shipments_Pre_Validation_Report() {
		before("TestCase01_Candela_EDI_850_Shipments_Pre_Validation_Report");
		ExcelFileReaderClass efrc=new ExcelFileReaderClass();
		
		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
			
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=new");
//			 driver = new ChromeDriver(options);
			driver= new ChromeDriver();
			 try {
				 SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
				  Date date = new Date();
				 recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
				 recorder.start();
				 setRecorder(recorder);
				} catch (ATUTestRecorderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			driver.get(efrc.getTestData("URL"));
			driver.manage().window().maximize();
			new OracleCloudPages.Scheduling().Login(driver,efrc.getTestData("UserID"),efrc.getTestData("Password"));
			new OracleCloudPages.Scheduling().schedulingJob_Candela_EDI_850_Shipments_Pre_Validation_Report(driver,efrc.getTestData("JobName"),efrc.getTestData("DelayTime"),efrc.getTestData("Frequency"),efrc.getTestData("Minutes"),efrc.getTestData("Hours"),efrc.getTestData("StartDate"),efrc.getTestData("EndDate") );
			new OracleCloudPages.Scheduling().logOut(driver);	
			
		}else {
			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
			throw new SkipException("Skipping this test case");
		}
	
	}
	
	
	@Test
	public void TestCase02_Collections_Scoring_and_Strategy_Assignment() {
		before("TestCase02_Collections_Scoring_and_Strategy_Assignment");
		ExcelFileReaderClass efrc=new ExcelFileReaderClass();
		
		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
			
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=new");
//			 driver = new ChromeDriver(options);
			 try {
				 
				 SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
				  Date date = new Date();
				  recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
				  recorder.start();
				  setRecorder(recorder);
				} catch (ATUTestRecorderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			driver= new ChromeDriver();
			 
			driver.get(efrc.getTestData("URL"));
			driver.manage().window().maximize();
			new OracleCloudPages.Scheduling().Login(driver,efrc.getTestData("UserID"),efrc.getTestData("Password"));
			new OracleCloudPages.Scheduling().schedulingJob_Collections_Scoring_and_Strategy_Assignment(driver,efrc.getTestData("JobName"),efrc.getTestData("Bussiness Unit"),efrc.getTestData("Frequency"),efrc.getTestData("StartDate"),efrc.getTestData("EndDate") );
			new OracleCloudPages.Scheduling().logOut(driver);	
			
		}else {
			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
			throw new SkipException("Skipping this test case");
		}
	
	}
	
	
	@Test
	public void TestCase03_Collections_Delinquency_Management() {
		before("TestCase03_Collections_Delinquency_Management");
		ExcelFileReaderClass efrc=new ExcelFileReaderClass();
		
		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
			
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=new");
//			 driver = new ChromeDriver(options);
			 try {
				 
				 SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
				  Date date = new Date();
				  recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
				  recorder.start();
				  setRecorder(recorder);
				} catch (ATUTestRecorderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			driver= new ChromeDriver();
			 
			driver.get(efrc.getTestData("URL"));
			driver.manage().window().maximize();
			new OracleCloudPages.Scheduling().Login(driver,efrc.getTestData("UserID"),efrc.getTestData("Password"));
			new OracleCloudPages.Scheduling().Collections_Delinquency_Management(driver,efrc.getTestData("JobName"),efrc.getTestData("Bussiness Unit"),efrc.getTestData("Mode"),efrc.getTestData("Frequency"),efrc.getTestData("StartDate"),efrc.getTestData("EndDate") );
			new OracleCloudPages.Scheduling().logOut(driver);	
			
		}else {
			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
			throw new SkipException("Skipping this test case");
		}
	
	}
	

	@Test
	public void TestCase04_Create_Receivables_Accounting() {
		before("TestCase04_Create Receivables Accounting");
		ExcelFileReaderClass efrc=new ExcelFileReaderClass();
		
		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
			
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=new");
//			 driver = new ChromeDriver(options);
			 try {
				 
				 SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
				  Date date = new Date();
				  recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
				  recorder.start();
				  setRecorder(recorder);
				} catch (ATUTestRecorderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			driver= new ChromeDriver();
			 
			driver.get(efrc.getTestData("URL"));
			driver.manage().window().maximize();
			new OracleCloudPages.Scheduling().Login(driver,efrc.getTestData("UserID"),efrc.getTestData("Password"));
			new OracleCloudPages.Scheduling().Create_Receivables_Accounting(driver,efrc.getTestData("JobName"),efrc.getTestData("PrintFormat"),efrc.getTestData("Maximum_Bussiness_Worker_Per_Unit"),efrc.getTestData("Ledger"),efrc.getTestData("LedgerEndDate"),efrc.getTestData("CreatingAccounting"),efrc.getTestData("AccountingMode"),efrc.getTestData("ProcessErrorOnly"),efrc.getTestData("AccountingReportLevel"),efrc.getTestData("Transfer_To_General_Ledger"),efrc.getTestData("Post_in_General_Ledger"),efrc.getTestData("Include_User_Transaction_Identifier"),efrc.getTestData("Frequency"),efrc.getTestData("StartDate"),efrc.getTestData("EndDate") );
			new OracleCloudPages.Scheduling().logOut(driver);	
			
		}else {
			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
			throw new SkipException("Skipping this test case");
		}
	
	}
	
	
	@Test
	public void TestCases05_Create_Accounting() {
		before("TestCases05_Create Accounting");
		ExcelFileReaderClass efrc=new ExcelFileReaderClass();
		
		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
			
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=new");
//			 driver = new ChromeDriver(options);
			 try {
				 
				 SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
				  Date date = new Date();
				  recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
				  recorder.start();
				  setRecorder(recorder);
				} catch (ATUTestRecorderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			driver= new ChromeDriver();
			 
			driver.get(efrc.getTestData("URL"));
			driver.manage().window().maximize();
			new OracleCloudPages.Scheduling().Login(driver,efrc.getTestData("UserID"),efrc.getTestData("Password"));
			new OracleCloudPages.Scheduling().Create_Accounting(driver,efrc.getTestData("JobName"),efrc.getTestData("Subledger Application"),efrc.getTestData("Ledger"),efrc.getTestData("LedgerEndDate"),efrc.getTestData("AccountingMode"),efrc.getTestData("Process Events"),efrc.getTestData("Report Style"),efrc.getTestData("Transfer_To_General_Ledger"),efrc.getTestData("Post_in_General_Ledger"),efrc.getTestData("Include_User_Transaction_Identifier"),efrc.getTestData("Frequency"),efrc.getTestData("StartDate"),efrc.getTestData("EndDate") );
			new OracleCloudPages.Scheduling().logOut(driver);	
			
		}else {
			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
			throw new SkipException("Skipping this test case");
		}
	
	}
	
	
//	
//	@Test(dataProvider ="data-provider")
//	public void TestCase02(String strURL,String stremailID,String strPassword,String strDays,String strMonths,String strYear,String strFirstName,String strLastName,String strCompany,String strAddressLine1,String strAddressLine2,String strState,String strCity,String strZipCode,String strMobileNumber,String strNameOnCard,String strCardNumber,String strCVC,String strExpireMonth,String strExpireYear) {
//			before("TestingSK02");
//			ExcelFileReaderClass efrc=new ExcelFileReaderClass();
//			
//		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
////			ChromeOptions options = new ChromeOptions();
////			options.addArguments("--headless=new");
////			 driver = new ChromeDriver(options);
//			try {
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//				  Date date = new Date();
//				 recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
//				recorder.start();
//				setRecorder(recorder);
//			} catch (ATUTestRecorderException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}  
//			driver=new ChromeDriver();
//			
//			driver.get(strURL);
//			driver.manage().window().maximize();
//			new TestCases.HomePage().TestCase14_PlaceOrder_Register_WhileCheckout(driver,stremailID,strPassword,strDays,strMonths,strYear,strFirstName,strLastName,strCompany,strAddressLine1,strAddressLine2,strState,strCity,strZipCode,strMobileNumber,strNameOnCard,strCardNumber,strCVC,strExpireMonth,strExpireYear);
//		
//		}else {
//			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
//			throw new SkipException("Skipping this test case");
//		}	
//	}
//	
	
//	@Test
//	public void TestCase03() {
//		before("TestingSK03");
//		ExcelFileReaderClass efrc=new ExcelFileReaderClass();
//		
//		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=new");
//			try {
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//				 Date date = new Date();
//				 recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
//				recorder.start();
//				setRecorder(recorder);
//			} catch (ATUTestRecorderException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			driver = new ChromeDriver(options);
//			 
//			driver.get(efrc.getTestData("URL"));
//			driver.manage().window().maximize();
//			new TestCases.HomePage().TestCase14_PlaceOrder_Register_WhileCheckout(driver,efrc.getTestData("EmailID"),efrc.getTestData("Password"),efrc.getTestData("Days"),efrc.getTestData("Month"),efrc.getTestData("Year"),efrc.getTestData("Firstname"),efrc.getTestData("Lastname"),efrc.getTestData("Company"),efrc.getTestData("Addressline1"),efrc.getTestData("Addressline2"),efrc.getTestData("State"),efrc.getTestData("City"),efrc.getTestData("Zipcode"),efrc.getTestData("MobileNumber"),efrc.getTestData("Name On Card"),efrc.getTestData("CardNumber"),efrc.getTestData("CVC"),efrc.getTestData("ExpireMonth"),efrc.getTestData("ExpireYear"));		
//		}else {
//			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
//			throw new SkipException("Skipping this test case");
//		}
//	}
//	

//	@Test
//	public void TestCase03_01() {
//		before("TestingSK03");
//		ExcelFileReaderClass efrc=new ExcelFileReaderClass();
//	
//		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=new");
//			try {
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//				  Date date = new Date();
//				 recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
//				recorder.start();
//				setRecorder(recorder);
//			} catch (ATUTestRecorderException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 driver = new ChromeDriver(options);
//			  
//			driver.get(efrc.getTestData("URL"));
//			driver.manage().window().maximize();
//			new TestCases.HomePage().TestCase14_PlaceOrder_Register_WhileCheckout(driver,efrc.getTestData("EmailID"),efrc.getTestData("Password"),efrc.getTestData("Days"),efrc.getTestData("Month"),efrc.getTestData("Year"),efrc.getTestData("Firstname"),efrc.getTestData("Lastname"),efrc.getTestData("Company"),efrc.getTestData("Addressline1"),efrc.getTestData("Addressline2"),efrc.getTestData("State"),efrc.getTestData("City"),efrc.getTestData("Zipcode"),efrc.getTestData("MobileNumber"),efrc.getTestData("Name On Card"),efrc.getTestData("CardNumber"),efrc.getTestData("CVC"),efrc.getTestData("ExpireMonth"),efrc.getTestData("ExpireYear"));		
//		}else {
//			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
//			throw new SkipException("Skipping this test case");
//		}
//	}
	
//	
//	@Test
//	public void TestCase03_02() {
//		before("TestingSK03");
//		ExcelFileReaderClass efrc=new ExcelFileReaderClass();
//		 
//		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=new");
//			try {
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//				  Date date = new Date();
//				 recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
//				recorder.start();
//				setRecorder(recorder);
//			} catch (ATUTestRecorderException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			 driver = new ChromeDriver(options);
//			
//			driver.get(efrc.getTestData("URL"));
//			driver.manage().window().maximize();
//			new TestCases.HomePage().TestCase14_PlaceOrder_Register_WhileCheckout(driver,efrc.getTestData("EmailID"),efrc.getTestData("Password"),efrc.getTestData("Days"),efrc.getTestData("Month"),efrc.getTestData("Year"),efrc.getTestData("Firstname"),efrc.getTestData("Lastname"),efrc.getTestData("Company"),efrc.getTestData("Addressline1"),efrc.getTestData("Addressline2"),efrc.getTestData("State"),efrc.getTestData("City"),efrc.getTestData("Zipcode"),efrc.getTestData("MobileNumber"),efrc.getTestData("Name On Card"),efrc.getTestData("CardNumber"),efrc.getTestData("CVC"),efrc.getTestData("ExpireMonth"),efrc.getTestData("ExpireYear"));		
//		}else {
//			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
//			throw new SkipException("Skipping this test case");
//		}
//	}
//	
	
	
	
//	@Test
//	public void TestCase04() {
//		
//			before("TestingSK04");
//			ExcelFileReaderClass efrc=new ExcelFileReaderClass();
//			
//			if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--headless=new");
//				try {
//					SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//					  Date date = new Date();
//					 recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
//					recorder.start();
//					setRecorder(recorder);
//				} catch (ATUTestRecorderException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				 driver = new ChromeDriver(options);
//				  
//				driver.get(efrc.getTestData("URL"));
//				driver.manage().window().maximize();
//				new TestCases.HomePage().TestCase14_PlaceOrder_Register_WhileCheckout(driver,efrc.getTestData("EmailID"),efrc.getTestData("Password"),efrc.getTestData("Days"),efrc.getTestData("Month"),efrc.getTestData("Year"),efrc.getTestData("Firstname"),efrc.getTestData("Lastname"),efrc.getTestData("Company"),efrc.getTestData("Addressline1"),efrc.getTestData("Addressline2"),efrc.getTestData("State"),efrc.getTestData("City"),efrc.getTestData("Zipcode"),efrc.getTestData("MobileNumber"),efrc.getTestData("Name On Card"),efrc.getTestData("CardNumber"),efrc.getTestData("CVC"),efrc.getTestData("ExpireMonth"),efrc.getTestData("ExpireYear"));		
//			
//			}else {
//				
//				ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
//				throw new SkipException("Skipping this test case");
//			}
//		}
//		
	
	
//	@Test
//	public void TestCase05() {
//		before("TestingSK05");
//		ExcelFileReaderClass efrc=new ExcelFileReaderClass();
//		
//		if(efrc.getTestData("Run Mode").equals("Y")&& efrc.getTestData("Status").equalsIgnoreCase("No Run")) {
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless=new");
//			try {
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//				  Date date = new Date();
//				 recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\ScriptVideos\\","TestVideo-"+getTestcasename()+dateFormat.format(date),false);
//				recorder.start();
//				setRecorder(recorder);
//			} catch (ATUTestRecorderException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 driver = new ChromeDriver(options);
//			  
//			driver.get(efrc.getTestData("URL"));
//			driver.manage().window().maximize();
//			new TestCases.HomePage().TestCase14_PlaceOrder_Register_WhileCheckout(driver,efrc.getTestData("EmailID"),efrc.getTestData("Password"),efrc.getTestData("Days"),efrc.getTestData("Month"),efrc.getTestData("Year"),efrc.getTestData("Firstname"),efrc.getTestData("Lastname"),efrc.getTestData("Company"),efrc.getTestData("Addressline1"),efrc.getTestData("Addressline2"),efrc.getTestData("State"),efrc.getTestData("City"),efrc.getTestData("Zipcode"),efrc.getTestData("MobileNumber"),efrc.getTestData("Name On Card"),efrc.getTestData("CardNumber"),efrc.getTestData("CVC"),efrc.getTestData("ExpireMonth"),efrc.getTestData("ExpireYear"));		
//		}else {
//			ReportingClass.test.log(LogStatus.SKIP, "<B>Skipping Test Case As Flag is N for the test Case"+getTestcasename()+"</B>");
//			throw new SkipException("Skipping this test case");
//		}
//	}
	
	public static void main(String[] args) {
		  
		  TestListenerAdapter testla = new TestListenerAdapter();
		  TestNG testng = new TestNG();
		  testng.setTestClasses(new Class[] {TestCasesClass.class});
		  testng.run();
		 }
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		 //To stop video recording.
		ExcelFileReaderClass ef=new ExcelFileReaderClass();
		    try {
		        if (result.getStatus() == ITestResult.SUCCESS) {
		        	test.log(LogStatus.PASS, "<B><color='Green'>Test Case is passed</color></B>");
		        		noOfTestCasesPass=noOfTestCasesPass+1;
		        		if(getRecorder()!=null) {
		        			recorder.stop();
		        		}
		        		 driver.quit();
		        	//ef.writeStatusToExcelSheet("Pass");
		         
		        } else if (result.getStatus() == ITestResult.FAILURE) {
		        	test.log(LogStatus.FAIL, "<B><color='red'>Test Case is Failed</color></B>");
		        		noOfTestCasesFailed=noOfTestCasesFailed+1;
		        		if(getRecorder()!=null) {
		        			recorder.stop();
		        		}
		        		 driver.quit();
		        //	ef.writeStatusToExcelSheet("Fail");
		        
		          
		        } else if (result.getStatus() == ITestResult.SKIP) {
		        	test.log(LogStatus.SKIP, "<B><color='Yellow'>Test Case is skipped</color><B>");
		        		noOfTestCasesSkiped=noOfTestCasesSkiped+1;
//		        		if(getRecorder()!=null) {
//		        			recorder.stop();
//		        		}
		    			
		    			
		        	//ef.writeStatusToExcelSheet("SKIP");
		            
		        }
		      
				
		        report.endTest(test);
					
					 //driver.quit();
			
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	
	@AfterClass
	public void stopRecording() {
		
	}
	
	

	

}
