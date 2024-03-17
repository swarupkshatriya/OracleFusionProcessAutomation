package ReportGenerator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.EmailException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExcelFileRead.ExcelFileReaderClass;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;


public class ReportingClass extends ExcelFileReaderClass{
	
	public static ExtentTest test;
	public static ExtentReports report;
	
	
	public String testcasename;
	public static String reportName;
	public String reportGenerationTime;
	
	SendReportByEmail emailReport=new SendReportByEmail();
	public String getReportGenerationTime() {
		return reportGenerationTime;
	}

	public void setReportGenerationTime(String reportGenerationTime) {
		this.reportGenerationTime = reportGenerationTime;
	}

	public static String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getTestcasename() {
		return testcasename;
	}

	public void setTestcasename(String testcasename) {
		this.testcasename = testcasename;
	}

	@BeforeSuite
	public void ExtentReportGeneration() {
		getDateAndTime();
		report=new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport\\"+getDateAndTime()+"_ExtentReport.html");
		setReportName(System.getProperty("user.dir")+"\\ExtentReport\\"+getReportGenerationTime()+"_ExtentReport.html");
		 
	}
	
	public String getDateAndTime() {
		
		SimpleDateFormat df=new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss_mm");
		Date date=new Date();
		setReportGenerationTime(df.format(date));
		return df.format(date);
	}
	
	public void before(String testcaseName) {
		 test=report.startTest(testcaseName);
		 setTestcasename(testcaseName);
		 test.log(LogStatus.INFO, "<B>Test Case Started</B>");
		 readExcelFile(testcaseName);
	}
	
	@AfterSuite
	public void endReport() {
		
		report.flush();
		
		
			emailReport.sendEmail("swarup.kshatriya@gmail.com", "");
		
	}

}
