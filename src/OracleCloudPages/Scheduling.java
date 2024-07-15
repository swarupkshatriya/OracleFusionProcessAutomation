package OracleCloudPages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import ReportGenerator.ReportingClass;
import ResuableMethods.ResuableMethodClass;

public class Scheduling extends ReportingClass{
	
	public By userIdLabel=By.xpath("//label[text()='User ID']");
	public By userId=By.xpath("//input[@id='userid']");
	public By passWord=By.xpath("//input[@id='password']");
	public By signInBtn=By.xpath("//button[@id='btnActive']");
	public By HomeImage=By.xpath("//a[@title='Home']");
	public By userIcon=By.xpath("//a[@title='Settings and Actions']");
	public By signOut=By.xpath("//a[text()='Sign Out']");
	public By confirmBtn=By.xpath("//button[@id='Confirm']");
	
	public By toolsIcon=By.xpath("//a[text()='Tools']");
	public By scheduleProcess=By.xpath("//a[text()='Scheduled Processes']");
	public By scheduleNewProcess=By.xpath("//span[text()='Schedule New Process']");
	public By scheduleNewProcessPage=By.xpath("//div[text()='Schedule New Process']");
	public By nameInput=By.xpath("//label[text()='Name']//following::input[1]");
	
	public By okBtn=By.xpath("(//button[text()='OK'])[1]");
	public By processDetails=By.xpath("//div[text()='Process Details']");
	public By delayTime=By.xpath("//label[text()='Delay Time']//following::input[1]");
	public By advancedBtn=By.xpath("//span[text()='Advanced']");
	public By adVancedOption=By.xpath("//h1[text()='Advanced Options']");
	public By scheduleLink=By.xpath("//a[text()='Schedule']");
	public By usingScheduleRadioLabel=By.xpath("//label[text()='Using a schedule']");
	public By frequecy=By.xpath("//label[text()='Frequency']//following::select[1]");
	public By frequencyValue=By.xpath("//option[text()='Hourly/Minute']");
	public By minuteTextField=By.xpath("//label[text()='Minutes']//following::input[1]");
	public By hoursTextField =By.xpath("//label[text()='Hours']//following::input[1]");
	
	public By scheduleStartDate=By.xpath("//label[text()='Start Date']//following::input[1]");
	public By scheduleEndDate=By.xpath("//label[text()='End Date']//following::input[1]");		
	public By submitBtn=By.xpath("//span[text()='Sub']");
	
	public By confirmationWindow=By.xpath("//div[text()='Confirmation']");
	public By confirmationOkBtn=By.xpath("//div[text()='Confirmation']//following::button[text()='OK'][1]");
	public By confirmationMessageLabel=By.xpath("//label[contains(text(),'Process')]");
	
	public By expandSearch=By.xpath("//a[@title='Expand Search']");
	public By processIDTextField=By.xpath("//label[text()='Process ID']//following::input[1]");
	public By searchButton=By.xpath("//button[text()='Search']");
	
	public By processName=By.xpath("//span[text()='Candela EDI 850 Shipments Pre-Validation Report']");
	public By processIDTableRows=By.xpath("//table[@summary='List of Processes Meeting Search Criteria']//table//tr");
	
	public By BussinessUnit= By.xpath("//label[text()='Business Unit']//following::select[1]");
	
	public By Mode=By.xpath("//label[text()='Mode']//following::select[1]");
	
	public By printFormat=By.xpath("//label[text()='Print Format']//following::select[1]");
	public By maximumNoOfWorker=By.xpath("//label[text()='Maximum Number of Workers per Business Unit']//following::input[1]");
	public By ledger=By.xpath("//label[text()='Ledger']//following::input[1]");
	public By endDate=By.xpath("//label[text()='End Date']//following::input[1]");
	public By createAccounting=By.xpath("//label[text()='Create Accounting']//following::select[1]");
	public By accountingMode=By.xpath("//label[text()='Accounting Mode']//following::select[1]");
	public By processErrorOnly=By.xpath("//label[text()='Process Errors Only']//following::select[1]");
	public By accountingReportLevel=By.xpath("//label[text()='Accounting Report Level']//following::select[1]");
	public By transferToGeneralLedger=By.xpath("//label[text()='Transfer to General Ledger']//following::select[1]");
	public By postInGeneralLedger=By.xpath("//label[text()='Post in General Ledger']//following::select[1]");
	public By IncludeUserTransactionIdentifier=By.xpath("//label[text()='Include User Transaction Identifiers']//following::select[1]");
	
	public By createAccountingJob=By.xpath("//span[@class='x2hi' and text()='Create Accounting']");
	public By SearchAndSelectWindow=By.xpath("//div[text()='Search and Select: Name']");
	public By buttonOK=By.xpath("(//button[text()='OK'])[2]");
	public By subLedgerApplication=By.xpath("//label[text()='Subledger Application']//following::select[1]");
	public By processEvent=By.xpath("//label[text()='Process Events']//following::select[1]");
	public By reportStyle=By.xpath("//label[text()='Report Style']//following::select[1]");
	
	public By submitionNotes=By.xpath("//label[text()='Submission Notes']//following::input[1]");
	public By SubmitionTimeBefore=By.xpath("//label[text()='Submission Time']//following::select[1]");
	
	
	ResuableMethodClass rmc=new ResuableMethodClass();
	
	public void Login(WebDriver driver,String strUserId, String strPassword) {
		
		if(rmc.isVisible(driver, userIdLabel)) {
			
		}
		
		if(rmc.isVisible(driver, userId)) {
			rmc.clear(driver, userId);
			rmc.type("userId",driver,userId, strUserId);
		}
		
		if(rmc.isVisible(driver, passWord)) {
			rmc.clear(driver, passWord);
			rmc.type("passWord",driver,passWord, strPassword);
		}
		
		if(rmc.isVisible(driver, signInBtn)) {
			rmc.click("Clicking on Sign in Button",driver, signInBtn);
		}
	}
	
	/**
	 * @param driver
	 * @param strJobName
	 * @param strDealayTime
	 * @param strFrequency
	 */
	public void schedulingJob_Candela_EDI_850_Shipments_Pre_Validation_Report(WebDriver driver,String strJobName,String strDealayTime,String strFrequency,String strMinute,String strHours,String strStartDate,String strEndDate,String strOuputDataWorkbook,String strOuptDataWorkSheet,String strOutputDataColumn1,String strOuputDataColumn2) {
		
		if(rmc.isVisible(driver, HomeImage)) {
			rmc.click("Clicking on HomeImage",driver, HomeImage);
		}
		
		rmc.javaScriptExecutor(driver, toolsIcon);
		
		if(rmc.isVisible(driver, toolsIcon)) {
			rmc.click("Clicking on toolsIcon",driver, toolsIcon);
		}
		
		if(rmc.isVisible(driver, scheduleProcess)) {
			rmc.click("Clicking on scheduleProcess",driver, scheduleProcess);
		}
		
		
		
		if(rmc.isVisible(driver, scheduleNewProcess)) {
			rmc.click("Clicking on scheduleNewProcess",driver, scheduleNewProcess);
		}
		
		if(rmc.isVisible(driver, scheduleNewProcessPage)) {
			
		}
		
		if(rmc.isVisible(driver, nameInput)) {
			rmc.click("Clicking on nameInput",driver, nameInput);
			rmc.clear(driver, nameInput);
			rmc.type("Name", driver, nameInput, strJobName);
			driver.findElement(nameInput).sendKeys(Keys.ENTER);
		}
		
		writeExcelFileforOutputData(strOuputDataWorkbook, strOuptDataWorkSheet,strOuputDataColumn2,strJobName);
		
		if(rmc.isClickable(driver, okBtn)) {
			rmc.click("Clicking on okBtn",driver, okBtn);
		}
		
		if(rmc.isVisible(driver, processDetails)) {
			
		}
		
		if(rmc.isVisible(driver, delayTime)) {
			rmc.click("Clicking on delayTime",driver, delayTime);
			rmc.clear(driver, delayTime);
			rmc.type("delayTime", driver, delayTime, strDealayTime);
			
		}
		
		if(rmc.isVisible(driver, submitionNotes)) {
			rmc.click("Clicking on submitionNotes",driver, submitionNotes);
			rmc.clear(driver, submitionNotes);
			rmc.type("submitionNotes", driver, submitionNotes, "SK Automation Job Scheduling");
			
		}
		
		rmc.javaScriptExecutor(driver, advancedBtn);
		
		if(rmc.isVisible(driver, advancedBtn)) {
			rmc.click("Clicking on advancedBtn",driver, advancedBtn);
		}
		
		
		if(rmc.isVisible(driver, adVancedOption)) {
			
		}
		
		if(rmc.isVisible(driver, scheduleLink)) {
			rmc.click("Clicking on scheduleLink",driver, scheduleLink);
		}
		
		
		if(rmc.isVisible(driver, usingScheduleRadioLabel)) {
			rmc.click("Clicking on usingScheduleRadioLabel",driver, usingScheduleRadioLabel);
		}
		
//		if(rmc.isVisible(driver, frequecy)) {
//			rmc.click("Clicking on frequecy",driver, frequecy);
//		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rmc.isVisible(driver, frequecy)) {
			rmc.selectByVisibleText(driver, frequecy,strFrequency);
		}
		
		
		if(rmc.isVisible(driver, minuteTextField)) {
			rmc.click("Clicking on minuteTextField",driver, minuteTextField);
			rmc.clear(driver, minuteTextField);
			rmc.type("minuteTextField", driver, minuteTextField, strMinute);
		}
		
		if(rmc.isVisible(driver, hoursTextField)) {
			rmc.click("Clicking on hoursTextField",driver, hoursTextField);
			rmc.clear(driver, hoursTextField);
			rmc.type("hoursTextField", driver, hoursTextField, strHours);
		}
		
		
		if(rmc.isVisible(driver, scheduleLink)) {
			rmc.click("Clicking on scheduleLink",driver, scheduleLink);
		}
		
	       

//		DateFormat  inputFormat = new SimpleDateFormat("MM/dd/yy HH:mm a");
//		inputFormat.setTimeZone( TimeZone.getTimeZone("UTC") );  
//		 	Date date = null;
//          try {
//			 date = inputFormat.parse(strStartDate);
			 if(rmc.isVisible(driver, scheduleStartDate)) {
		  			rmc.click("Clicking on scheduleStartDate",driver, scheduleStartDate);
		  			rmc.clear(driver, scheduleStartDate);
		  			rmc.type("scheduleStartDate", driver, scheduleStartDate, strStartDate);
		  		   }
//          	} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//          	}

         
          
        
 			   if(rmc.isVisible(driver, scheduleEndDate)) {
 	    			rmc.click("Clicking on scheduleEndDate",driver, scheduleEndDate);
 	    			rmc.clear(driver, scheduleEndDate);
 	    			rmc.type("scheduleEndDate", driver, scheduleEndDate, strEndDate);
 	    		   }

          
 			  if(rmc.isVisible(driver, submitBtn)) {
 					rmc.click("Clicking on submitBtn",driver, submitBtn);
 			  }
 			  
 			  if(rmc.isVisible(driver, confirmationWindow)) {
					
 			  }
 			 String message=driver.findElement(confirmationMessageLabel).getText();
 			 String Str = new String(message);
 			 
 			 int processIDstartIndex=Str.indexOf(" ");
 			 int processIdEndIndex=Str.indexOf("was");
 			 
 			 String processID=Str.substring(processIDstartIndex+1, processIdEndIndex-1);
 			 writeExcelFileforOutputData(strOuputDataWorkbook, strOuptDataWorkSheet, strOutputDataColumn1, processID);
 			 
 			 try {
				test.log(LogStatus.INFO, "Process ID is "+processID);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			 if(rmc.isVisible(driver, confirmationOkBtn)) {
					rmc.click("Clicking on confirmationOkBtn",driver, confirmationOkBtn);
			 }
 			 
 			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			 
 			 if(rmc.isVisible(driver, expandSearch)) {
 				rmc.click("Clicking on expandSearch",driver, expandSearch);
			  }
 			 
 			 if(rmc.isVisible(driver, processIDTextField)) {
  				rmc.click("Clicking on processIDTextField",driver, processIDTextField);
  				rmc.clear(driver, processIDTextField);
  				rmc.type("processIDTextField", driver, processIDTextField, processID);
  				
 			  }
 			 
 			if(rmc.isVisible(driver, searchButton)) {
				rmc.click("Clicking on expandSearch",driver, searchButton);
 			}
 			 
 			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			List<WebElement>list1=driver.findElements(processIDTableRows);
 			if(list1.size()>=1) {
 				test.log(LogStatus.PASS, "<B>Process ID is Available in Table "+processID);
 				try {
					test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}else {
 				test.log(LogStatus.FAIL, "<B>Process ID is not Available in Table "+processID);
 				try {
					test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
 			processName=By.xpath("//span[text()='"+strJobName+"']");
 			
 			String tableJobname=driver.findElement(processName).getText();
 			list1=driver.findElements(processName);
 			
 			if(list1.size()>=1) {
 				test.log(LogStatus.PASS, "<B>Job Name is Available in Table "+strJobName);
 				try {
					test.log(LogStatus.INFO, "<B>Job Name is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}else {
 				test.log(LogStatus.FAIL, "<B>Job Name is not Available in Table "+tableJobname);
 				try {
					test.log(LogStatus.INFO, "<B>Job Name is not Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
		
	}
	
	public void schedulingJob_Collections_Scoring_and_Strategy_Assignment(WebDriver driver,String strJobName,String strBussinessUnit,String strFrequency,String strStartDate,String strEndDate,String strOuputDataWorkbook,String strOuptDataWorkSheet,String strOutputDataColumn1,String strOuputDataColumn2) {
		
		if(rmc.isVisible(driver, HomeImage)) {
			rmc.click("Clicking on HomeImage",driver, HomeImage);
		}
		
		rmc.javaScriptExecutor(driver, toolsIcon);
		
		if(rmc.isVisible(driver, toolsIcon)) {
			rmc.click("Clicking on toolsIcon",driver, toolsIcon);
		}
		
		if(rmc.isVisible(driver, scheduleProcess)) {
			rmc.click("Clicking on scheduleProcess",driver, scheduleProcess);
		}
		
		
		
		if(rmc.isVisible(driver, scheduleNewProcess)) {
			rmc.click("Clicking on scheduleNewProcess",driver, scheduleNewProcess);
		}
		
		if(rmc.isVisible(driver, scheduleNewProcessPage)) {
			
		}
		
		if(rmc.isVisible(driver, nameInput)) {
			rmc.click("Clicking on nameInput",driver, nameInput);
			rmc.clear(driver, nameInput);
			rmc.type("Name", driver, nameInput, strJobName);
			driver.findElement(nameInput).sendKeys(Keys.ENTER);
		}
		
		writeExcelFileforOutputData(strOuputDataWorkbook, strOuptDataWorkSheet,strOuputDataColumn2,strJobName);
		
		if(rmc.isClickable(driver, okBtn)) {
			rmc.click("Clicking on okBtn",driver, okBtn);
		}
		
		if(rmc.isVisible(driver, processDetails)) {
			
		}
		
		if(rmc.isVisible(driver, BussinessUnit)) {
			rmc.selectByVisibleText(driver, BussinessUnit,strBussinessUnit);
		}
		
		if(rmc.isVisible(driver, submitionNotes)) {
			rmc.click("Clicking on submitionNotes",driver, submitionNotes);
			rmc.clear(driver, submitionNotes);
			rmc.type("submitionNotes", driver, submitionNotes, "SK Automation Job Scheduling");
			
		}
		
		
		
		rmc.javaScriptExecutor(driver, advancedBtn);
		
		if(rmc.isVisible(driver, advancedBtn)) {
			rmc.click("Clicking on advancedBtn",driver, advancedBtn);
		}
		
		
		if(rmc.isVisible(driver, adVancedOption)) {
			
		}
		
		if(rmc.isVisible(driver, scheduleLink)) {
			rmc.click("Clicking on scheduleLink",driver, scheduleLink);
		}
		
		
		if(rmc.isVisible(driver, usingScheduleRadioLabel)) {
			rmc.click("Clicking on usingScheduleRadioLabel",driver, usingScheduleRadioLabel);
		}
		
//		if(rmc.isVisible(driver, frequecy)) {
//			rmc.click("Clicking on frequecy",driver, frequecy);
//		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rmc.isVisible(driver, frequecy)) {
			rmc.selectByVisibleText(driver, frequecy,strFrequency);
		}
		
		
//		if(rmc.isVisible(driver, minuteTextField)) {
//			rmc.click("Clicking on minuteTextField",driver, minuteTextField);
//			rmc.clear(driver, minuteTextField);
//			rmc.type("minuteTextField", driver, minuteTextField, strMinute);
//		}
//		
//		if(rmc.isVisible(driver, hoursTextField)) {
//			rmc.click("Clicking on hoursTextField",driver, hoursTextField);
//			rmc.clear(driver, hoursTextField);
//			rmc.type("hoursTextField", driver, hoursTextField, strHours);
//		}
//		
		
		if(rmc.isVisible(driver, scheduleLink)) {
			rmc.click("Clicking on scheduleLink",driver, scheduleLink);
		}
		
	       

//		DateFormat  inputFormat = new SimpleDateFormat("MM/dd/yy HH:mm a");
//		inputFormat.setTimeZone( TimeZone.getTimeZone("UTC") );  
//		 	Date date = null;
//          try {
//			 date = inputFormat.parse(strStartDate);
			 if(rmc.isVisible(driver, scheduleStartDate)) {
		  			rmc.click("Clicking on scheduleStartDate",driver, scheduleStartDate);
		  			rmc.clear(driver, scheduleStartDate);
		  			rmc.type("scheduleStartDate", driver, scheduleStartDate, strStartDate);
		  		   }
//          	} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//          	}

         
          
        
 			   if(rmc.isVisible(driver, scheduleEndDate)) {
 	    			rmc.click("Clicking on scheduleEndDate",driver, scheduleEndDate);
 	    			rmc.clear(driver, scheduleEndDate);
 	    			rmc.type("scheduleEndDate", driver, scheduleEndDate, strEndDate);
 	    		   }

          
 			  if(rmc.isVisible(driver, submitBtn)) {
 					rmc.click("Clicking on submitBtn",driver, submitBtn);
 			  }
 			  
 			  if(rmc.isVisible(driver, confirmationWindow)) {
					
 			  }
 			 String message=driver.findElement(confirmationMessageLabel).getText();
 			 String Str = new String(message);
 			 
 			 int processIDstartIndex=Str.indexOf(" ");
 			 int processIdEndIndex=Str.indexOf("was");
 			 
 			 String processID=Str.substring(processIDstartIndex+1, processIdEndIndex-1);
 			 
 			 writeExcelFileforOutputData(strOuputDataWorkbook, strOuptDataWorkSheet, strOutputDataColumn1, processID);
 			 
 			 
 			 try {
				test.log(LogStatus.INFO, "<B><I>Process ID is "+processID+"</B>");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			 if(rmc.isVisible(driver, confirmationOkBtn)) {
					rmc.click("Clicking on confirmationOkBtn",driver, confirmationOkBtn);
			 }
 			 
 			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			 
 			 if(rmc.isVisible(driver, expandSearch)) {
 				rmc.click("Clicking on expandSearch",driver, expandSearch);
			  }
 			 
 			 if(rmc.isVisible(driver, processIDTextField)) {
  				rmc.click("Clicking on processIDTextField",driver, processIDTextField);
  				rmc.clear(driver, processIDTextField);
  				rmc.type("processIDTextField", driver, processIDTextField, processID);
  				
 			  }
 			 
 			if(rmc.isVisible(driver, searchButton)) {
				rmc.click("Clicking on expandSearch",driver, searchButton);
 			}
 			 
 			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			List<WebElement>list1=driver.findElements(processIDTableRows);
 			if(list1.size()>=1) {
 				test.log(LogStatus.PASS, "<B>Process ID is Available in Table "+processID);
 				try {
					test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}else {
 				test.log(LogStatus.FAIL, "<B>Process ID is not Available in Table "+processID);
 				try {
					test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
 			processName=By.xpath("//span[text()='"+strJobName+"']");
 			
 			String tableJobname=driver.findElement(processName).getText();
 			list1=driver.findElements(processName);
 			
 			if(list1.size()>=1) {
 				test.log(LogStatus.PASS, "<B>Job Name is Available in Table "+strJobName);
 				try {
					test.log(LogStatus.INFO, "<B>Job Name is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}else {
 				test.log(LogStatus.FAIL, "<B>Job Name is not Available in Table "+tableJobname);
 				try {
					test.log(LogStatus.INFO, "<B>Job Name is not Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
		
	}
	
	
public void Collections_Delinquency_Management(WebDriver driver,String strJobName,String strBussinessUnit,String strMode,String strFrequency,String strStartDate,String strEndDate,String strOuputDataWorkbook,String strOuptDataWorkSheet,String strOutputDataColumn1,String strOuputDataColumn2) {
		
		if(rmc.isVisible(driver, HomeImage)) {
			rmc.click("Clicking on HomeImage",driver, HomeImage);
		}
		
		rmc.javaScriptExecutor(driver, toolsIcon);
		
		if(rmc.isVisible(driver, toolsIcon)) {
			rmc.click("Clicking on toolsIcon",driver, toolsIcon);
		}
		
		if(rmc.isVisible(driver, scheduleProcess)) {
			rmc.click("Clicking on scheduleProcess",driver, scheduleProcess);
		}
		
		
		
		if(rmc.isVisible(driver, scheduleNewProcess)) {
			rmc.click("Clicking on scheduleNewProcess",driver, scheduleNewProcess);
		}
		
		if(rmc.isVisible(driver, scheduleNewProcessPage)) {
			
		}
		
		if(rmc.isVisible(driver, nameInput)) {
			rmc.click("Clicking on nameInput",driver, nameInput);
			rmc.clear(driver, nameInput);
			rmc.type("Name", driver, nameInput, strJobName);
			driver.findElement(nameInput).sendKeys(Keys.ENTER);
		}
		
		writeExcelFileforOutputData(strOuputDataWorkbook, strOuptDataWorkSheet,strOuputDataColumn2,strJobName);
		
		if(rmc.isClickable(driver, okBtn)) {
			rmc.click("Clicking on okBtn",driver, okBtn);
		}
		
		if(rmc.isVisible(driver, processDetails)) {
			
		}
		
		if(rmc.isVisible(driver, BussinessUnit)) {
			rmc.selectByVisibleText(driver, BussinessUnit,strBussinessUnit);
		}
		
		if(rmc.isVisible(driver, Mode)) {
			rmc.selectByVisibleText(driver, Mode,strMode);
		}
		
		if(rmc.isVisible(driver, submitionNotes)) {
			rmc.click("Clicking on submitionNotes",driver, submitionNotes);
			rmc.clear(driver, submitionNotes);
			rmc.type("submitionNotes", driver, submitionNotes, "SK Automation Job Scheduling");
			
		}
		
		
		rmc.javaScriptExecutor(driver, advancedBtn);
		
		if(rmc.isVisible(driver, advancedBtn)) {
			rmc.click("Clicking on advancedBtn",driver, advancedBtn);
		}
		
		
		if(rmc.isVisible(driver, adVancedOption)) {
			
		}
		
		if(rmc.isVisible(driver, scheduleLink)) {
			rmc.click("Clicking on scheduleLink",driver, scheduleLink);
		}
		
		
		if(rmc.isVisible(driver, usingScheduleRadioLabel)) {
			rmc.click("Clicking on usingScheduleRadioLabel",driver, usingScheduleRadioLabel);
		}
		
//		if(rmc.isVisible(driver, frequecy)) {
//			rmc.click("Clicking on frequecy",driver, frequecy);
//		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rmc.isVisible(driver, frequecy)) {
			rmc.selectByVisibleText(driver, frequecy,strFrequency);
		}
		
		
//		if(rmc.isVisible(driver, minuteTextField)) {
//			rmc.click("Clicking on minuteTextField",driver, minuteTextField);
//			rmc.clear(driver, minuteTextField);
//			rmc.type("minuteTextField", driver, minuteTextField, strMinute);
//		}
//		
//		if(rmc.isVisible(driver, hoursTextField)) {
//			rmc.click("Clicking on hoursTextField",driver, hoursTextField);
//			rmc.clear(driver, hoursTextField);
//			rmc.type("hoursTextField", driver, hoursTextField, strHours);
//		}
//		
		
		if(rmc.isVisible(driver, scheduleLink)) {
			rmc.click("Clicking on scheduleLink",driver, scheduleLink);
		}
		
	       

//		DateFormat  inputFormat = new SimpleDateFormat("MM/dd/yy HH:mm a");
//		inputFormat.setTimeZone( TimeZone.getTimeZone("UTC") );  
//		 	Date date = null;
//          try {
//			 date = inputFormat.parse(strStartDate);
			 if(rmc.isVisible(driver, scheduleStartDate)) {
		  			rmc.click("Clicking on scheduleStartDate",driver, scheduleStartDate);
		  			rmc.clear(driver, scheduleStartDate);
		  			rmc.type("scheduleStartDate", driver, scheduleStartDate, strStartDate);
		  		   }
//          	} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//          	}

         
          
        
 			   if(rmc.isVisible(driver, scheduleEndDate)) {
 	    			rmc.click("Clicking on scheduleEndDate",driver, scheduleEndDate);
 	    			rmc.clear(driver, scheduleEndDate);
 	    			rmc.type("scheduleEndDate", driver, scheduleEndDate, strEndDate);
 	    		   }

          
 			  if(rmc.isVisible(driver, submitBtn)) {
 					rmc.click("Clicking on submitBtn",driver, submitBtn);
 			  }
 			  
 			  if(rmc.isVisible(driver, confirmationWindow)) {
					
 			  }
 			 String message=driver.findElement(confirmationMessageLabel).getText();
 			 String Str = new String(message);
 			 
 			 int processIDstartIndex=Str.indexOf(" ");
 			 int processIdEndIndex=Str.indexOf("was");
 			 
 			 String processID=Str.substring(processIDstartIndex+1, processIdEndIndex-1);
 			 
 			writeExcelFileforOutputData(strOuputDataWorkbook, strOuptDataWorkSheet,strOutputDataColumn1,processID);
 			 try {
				test.log(LogStatus.INFO, "<B><I>Process ID is "+processID+"</B>");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			 if(rmc.isVisible(driver, confirmationOkBtn)) {
					rmc.click("Clicking on confirmationOkBtn",driver, confirmationOkBtn);
			 }
 			 
 			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			 
 			 if(rmc.isVisible(driver, expandSearch)) {
 				rmc.click("Clicking on expandSearch",driver, expandSearch);
			  }
 			 
 			 if(rmc.isVisible(driver, processIDTextField)) {
  				rmc.click("Clicking on processIDTextField",driver, processIDTextField);
  				rmc.clear(driver, processIDTextField);
  				rmc.type("processIDTextField", driver, processIDTextField, processID);
  				
 			  }
 			 
 			if(rmc.isVisible(driver, searchButton)) {
				rmc.click("Clicking on expandSearch",driver, searchButton);
 			}
 			 
 			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			List<WebElement>list1=driver.findElements(processIDTableRows);
 			if(list1.size()>=1) {
 				test.log(LogStatus.PASS, "<B>Process ID is Available in Table "+processID);
 				try {
					test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}else {
 				test.log(LogStatus.FAIL, "<B>Process ID is not Available in Table "+processID);
 				try {
					test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
 			processName=By.xpath("//span[text()='"+strJobName+"']");
 			
 			String tableJobname=driver.findElement(processName).getText();
 			list1=driver.findElements(processName);
 			
 			if(list1.size()>=1) {
 				test.log(LogStatus.PASS, "<B>Job Name is Available in Table "+strJobName);
 				try {
					test.log(LogStatus.INFO, "<B>Job Name is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}else {
 				test.log(LogStatus.FAIL, "<B>Job Name is not Available in Table "+tableJobname);
 				try {
					test.log(LogStatus.INFO, "<B>Job Name is not Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
		
	}




public void Create_Receivables_Accounting(WebDriver driver,String strJobName,String strPrintFormat,String strMaximum_Bussiness_Worker_Per_Unit,String strLedger,String strLedgerEndDate,String strCreatingAccounting,String strAccountingMode,String strProcessErrorOnly,String strAccountingReportLevel,String strTransfer_To_General_Ledger,String strPost_in_General_Ledger,String strInclude_User_Transaction_Identifier,String strFrequency,String strStartDate,String strEndDate,String strOuputDataWorkbook,String strOuptDataWorkSheet,String strOutputDataColumn1,String strOuputDataColumn2) {
	
	if(rmc.isVisible(driver, HomeImage)) {
		rmc.click("Clicking on HomeImage",driver, HomeImage);
	}
	
	rmc.javaScriptExecutor(driver, toolsIcon);
	
	if(rmc.isVisible(driver, toolsIcon)) {
		rmc.click("Clicking on toolsIcon",driver, toolsIcon);
	}
	
	if(rmc.isVisible(driver, scheduleProcess)) {
		rmc.click("Clicking on scheduleProcess",driver, scheduleProcess);
	}
	
	
	
	if(rmc.isVisible(driver, scheduleNewProcess)) {
		rmc.click("Clicking on scheduleNewProcess",driver, scheduleNewProcess);
	}
	
	if(rmc.isVisible(driver, scheduleNewProcessPage)) {
		
	}
	
	if(rmc.isVisible(driver, nameInput)) {
		rmc.click("Clicking on nameInput",driver, nameInput);
		rmc.clear(driver, nameInput);
		rmc.type("Name", driver, nameInput, strJobName);
		driver.findElement(nameInput).sendKeys(Keys.ENTER);
	}
	
	writeExcelFileforOutputData(strOuputDataWorkbook, strOuptDataWorkSheet,strOuputDataColumn2,strJobName);
	
	if(rmc.isClickable(driver, okBtn)) {
		rmc.click("Clicking on okBtn",driver, okBtn);
	}
	
	if(rmc.isVisible(driver, processDetails)) {
		
	}
	
	if(rmc.isVisible(driver, printFormat)) {
		rmc.selectByVisibleText(driver, printFormat,strPrintFormat);
	}
	
	if(rmc.isVisible(driver, maximumNoOfWorker)) {
		rmc.click("Clicking on maximumNoOfWorker",driver, maximumNoOfWorker);
		rmc.clear(driver, maximumNoOfWorker);
		rmc.type("maximumNoOfWorker", driver, maximumNoOfWorker, strMaximum_Bussiness_Worker_Per_Unit);
		
	}
	
	
	if(rmc.isVisible(driver, ledger)) {
		rmc.click("Clicking on ledger",driver, ledger);
		rmc.clear(driver, ledger);
		rmc.type("ledger", driver, ledger, strLedger);
		driver.findElement(ledger).sendKeys(Keys.ENTER);
	}
	
	
	
	if(rmc.isVisible(driver, endDate)) {
		rmc.click("Clicking on endDate",driver, endDate);
		rmc.clear(driver, endDate);
		rmc.type("endDate", driver, endDate, strLedgerEndDate);
		driver.findElement(endDate).sendKeys(Keys.ENTER);
	}
	if(rmc.isVisible(driver, createAccounting)) {
		rmc.selectByVisibleText(driver, createAccounting,strCreatingAccounting);
	}
	
	if(rmc.isVisible(driver, accountingMode)) {
		rmc.selectByVisibleText(driver, accountingMode,strAccountingMode);
	}
	
	if(rmc.isVisible(driver, processErrorOnly)) {
		rmc.selectByVisibleText(driver, processErrorOnly,strProcessErrorOnly);
	}
	
	if(rmc.isVisible(driver, accountingReportLevel)) {
		rmc.selectByVisibleText(driver, accountingReportLevel,strAccountingReportLevel);
	}
	if(rmc.isVisible(driver, transferToGeneralLedger)) {
		rmc.selectByVisibleText(driver, transferToGeneralLedger,strTransfer_To_General_Ledger);
	}
	
	if(rmc.isVisible(driver, postInGeneralLedger)) {
		rmc.selectByVisibleText(driver, postInGeneralLedger,strPost_in_General_Ledger);
	}
	
	if(rmc.isVisible(driver, IncludeUserTransactionIdentifier)) {
		rmc.selectByVisibleText(driver, IncludeUserTransactionIdentifier,strInclude_User_Transaction_Identifier);
	}
	
	if(rmc.isVisible(driver, submitionNotes)) {
		rmc.click("Clicking on submitionNotes",driver, submitionNotes);
		rmc.clear(driver, submitionNotes);
		rmc.type("submitionNotes", driver, submitionNotes, "Swarup Automation Job Scheduling");
		
	}
	
	
	rmc.javaScriptExecutor(driver, advancedBtn);
	
	if(rmc.isVisible(driver, advancedBtn)) {
		rmc.click("Clicking on advancedBtn",driver, advancedBtn);
	}
	
	
	if(rmc.isVisible(driver, adVancedOption)) {
		
	}
	
	if(rmc.isVisible(driver, scheduleLink)) {
		rmc.click("Clicking on scheduleLink",driver, scheduleLink);
	}
	
	
	if(rmc.isVisible(driver, usingScheduleRadioLabel)) {
		rmc.click("Clicking on usingScheduleRadioLabel",driver, usingScheduleRadioLabel);
	}
	
//	if(rmc.isVisible(driver, frequecy)) {
//		rmc.click("Clicking on frequecy",driver, frequecy);
//	}
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(rmc.isVisible(driver, frequecy)) {
		rmc.selectByVisibleText(driver, frequecy,strFrequency);
	}
	
	
//	if(rmc.isVisible(driver, minuteTextField)) {
//		rmc.click("Clicking on minuteTextField",driver, minuteTextField);
//		rmc.clear(driver, minuteTextField);
//		rmc.type("minuteTextField", driver, minuteTextField, strMinute);
//	}
//	
//	if(rmc.isVisible(driver, hoursTextField)) {
//		rmc.click("Clicking on hoursTextField",driver, hoursTextField);
//		rmc.clear(driver, hoursTextField);
//		rmc.type("hoursTextField", driver, hoursTextField, strHours);
//	}
//	
	
	if(rmc.isVisible(driver, scheduleLink)) {
		rmc.click("Clicking on scheduleLink",driver, scheduleLink);
	}
	
       

//	DateFormat  inputFormat = new SimpleDateFormat("MM/dd/yy HH:mm a");
//	inputFormat.setTimeZone( TimeZone.getTimeZone("UTC") );  
//	 	Date date = null;
//      try {
//		 date = inputFormat.parse(strStartDate);
		 if(rmc.isVisible(driver, scheduleStartDate)) {
	  			rmc.click("Clicking on scheduleStartDate",driver, scheduleStartDate);
	  			rmc.clear(driver, scheduleStartDate);
	  			rmc.type("scheduleStartDate", driver, scheduleStartDate, strStartDate);
	  		   }
//      	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//      	}

     
      
    
			   if(rmc.isVisible(driver, scheduleEndDate)) {
	    			rmc.click("Clicking on scheduleEndDate",driver, scheduleEndDate);
	    			rmc.clear(driver, scheduleEndDate);
	    			rmc.type("scheduleEndDate", driver, scheduleEndDate, strEndDate);
	    		   }

      
			  if(rmc.isVisible(driver, submitBtn)) {
					rmc.click("Clicking on submitBtn",driver, submitBtn);
			  }
			  
			  if(rmc.isVisible(driver, confirmationWindow)) {
				
			  }
			 String message=driver.findElement(confirmationMessageLabel).getText();
			 String Str = new String(message);
			 
			 int processIDstartIndex=Str.indexOf(" ");
			 int processIdEndIndex=Str.indexOf("was");
			 
			 String processID=Str.substring(processIDstartIndex+1, processIdEndIndex-1);
			 writeExcelFileforOutputData(strOuputDataWorkbook, strOuptDataWorkSheet,strOutputDataColumn1,processID);
			 try {
			test.log(LogStatus.INFO, "<B><I>Process ID is "+processID+"</B>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 if(rmc.isVisible(driver, confirmationOkBtn)) {
				rmc.click("Clicking on confirmationOkBtn",driver, confirmationOkBtn);
		 }
			 
			 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
			 if(rmc.isVisible(driver, expandSearch)) {
				rmc.click("Clicking on expandSearch",driver, expandSearch);
		  }
			 
			 if(rmc.isVisible(driver, processIDTextField)) {
				rmc.click("Clicking on processIDTextField",driver, processIDTextField);
				rmc.clear(driver, processIDTextField);
				rmc.type("processIDTextField", driver, processIDTextField, processID);
				
			  }
			 
			if(rmc.isVisible(driver, searchButton)) {
			rmc.click("Clicking on expandSearch",driver, searchButton);
			}
			 
			try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			List<WebElement>list1=driver.findElements(processIDTableRows);
			if(list1.size()>=1) {
				test.log(LogStatus.PASS, "<B>Process ID is Available in Table "+processID);
				try {
				test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else {
				test.log(LogStatus.FAIL, "<B>Process ID is not Available in Table "+processID);
				try {
				test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			processName=By.xpath("//span[text()='"+strJobName+"']");
			
			String tableJobname=driver.findElement(processName).getText();
			list1=driver.findElements(processName);
			
			if(list1.size()>=1) {
				test.log(LogStatus.PASS, "<B>Job Name is Available in Table "+strJobName);
				try {
				test.log(LogStatus.INFO, "<B>Job Name is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}else {
				test.log(LogStatus.FAIL, "<B>Job Name is not Available in Table "+tableJobname);
				try {
				test.log(LogStatus.INFO, "<B>Job Name is not Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
	
}
	

public void Create_Accounting(WebDriver driver,String strJobName,String strSubledgerApplication,String strLedger,String strLedgerEndDate,String strAccountingMode,String strProcessEvents,String strReportStyle,String strTransfer_To_General_Ledger,String strPost_in_General_Ledger,String strInclude_User_Transaction_Identifier,String strFrequency,String strStartDate,String strEndDate) {
	
	if(rmc.isVisible(driver, HomeImage)) {
		rmc.click("Clicking on HomeImage",driver, HomeImage);
	}
	
	rmc.javaScriptExecutor(driver, toolsIcon);
	
	if(rmc.isVisible(driver, toolsIcon)) {
		rmc.click("Clicking on toolsIcon",driver, toolsIcon);
	}
	
	if(rmc.isVisible(driver, scheduleProcess)) {
		rmc.click("Clicking on scheduleProcess",driver, scheduleProcess);
	}
	
	
	
	if(rmc.isVisible(driver, scheduleNewProcess)) {
		rmc.click("Clicking on scheduleNewProcess",driver, scheduleNewProcess);
	}
	
	if(rmc.isVisible(driver, scheduleNewProcessPage)) {
		
	}
	
	if(rmc.isVisible(driver, nameInput)) {
		rmc.click("Clicking on nameInput",driver, nameInput);
		rmc.clear(driver, nameInput);
		rmc.type("Name", driver, nameInput, strJobName);
		driver.findElement(nameInput).sendKeys(Keys.ENTER);
	}
	
	if(rmc.isVisible(driver, SearchAndSelectWindow)) {
		
		rmc.click("Clicking on CreateAccounting",driver,createAccountingJob);
	}
	
	if(rmc.isVisible(driver, buttonOK)) {
		rmc.click("Clicking on buttonOK",driver, buttonOK);
	}
	
	if(rmc.isVisible(driver, scheduleNewProcessPage)) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rmc.click("Clicking on okBtn",driver, okBtn);
	}
	
	if(rmc.isVisible(driver, processDetails)) {
		
	}
	
	if(rmc.isVisible(driver, subLedgerApplication)) {
		rmc.selectByVisibleText(driver, subLedgerApplication,strSubledgerApplication);
	}
	
	
	if(rmc.isVisible(driver, ledger)) {
		rmc.click("Clicking on ledger",driver, ledger);
		rmc.clear(driver, ledger);
		rmc.type("ledger", driver, ledger, strLedger);
		driver.findElement(ledger).sendKeys(Keys.ENTER);
	}
	
	
	
	if(rmc.isVisible(driver, endDate)) {
		rmc.click("Clicking on endDate",driver, endDate);
		rmc.clear(driver, endDate);
		rmc.type("endDate", driver, endDate, strLedgerEndDate);
		driver.findElement(endDate).sendKeys(Keys.ENTER);
	}
	
	
	if(rmc.isVisible(driver, accountingMode)) {
		rmc.selectByVisibleText(driver, accountingMode,strAccountingMode);
	}
	
	if(rmc.isVisible(driver, processEvent)) {
		rmc.selectByVisibleText(driver, processEvent,strProcessEvents);
	}
	
	if(rmc.isVisible(driver, reportStyle)) {
		rmc.selectByVisibleText(driver, reportStyle,strReportStyle);
	}
	if(rmc.isVisible(driver, transferToGeneralLedger)) {
		rmc.selectByVisibleText(driver, transferToGeneralLedger,strTransfer_To_General_Ledger);
	}
	
	if(rmc.isVisible(driver, postInGeneralLedger)) {
		rmc.selectByVisibleText(driver, postInGeneralLedger,strPost_in_General_Ledger);
	}
	
	if(rmc.isVisible(driver, IncludeUserTransactionIdentifier)) {
		rmc.selectByVisibleText(driver, IncludeUserTransactionIdentifier,strInclude_User_Transaction_Identifier);
	}
	
	
	if(rmc.isVisible(driver, submitionNotes)) {
		rmc.click("Clicking on submitionNotes",driver, submitionNotes);
		rmc.clear(driver, submitionNotes);
		rmc.type("submitionNotes", driver, submitionNotes, "SK Automation Job Scheduling");
		
	}
	
	rmc.javaScriptExecutor(driver, advancedBtn);
	
	if(rmc.isVisible(driver, advancedBtn)) {
		rmc.click("Clicking on advancedBtn",driver, advancedBtn);
	}
	
	
	if(rmc.isVisible(driver, adVancedOption)) {
		
	}
	
	if(rmc.isVisible(driver, scheduleLink)) {
		rmc.click("Clicking on scheduleLink",driver, scheduleLink);
	}
	
	
	if(rmc.isVisible(driver, usingScheduleRadioLabel)) {
		rmc.click("Clicking on usingScheduleRadioLabel",driver, usingScheduleRadioLabel);
	}
	
//	if(rmc.isVisible(driver, frequecy)) {
//		rmc.click("Clicking on frequecy",driver, frequecy);
//	}
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(rmc.isVisible(driver, frequecy)) {
		rmc.selectByVisibleText(driver, frequecy,strFrequency);
	}
	
	
//	if(rmc.isVisible(driver, minuteTextField)) {
//		rmc.click("Clicking on minuteTextField",driver, minuteTextField);
//		rmc.clear(driver, minuteTextField);
//		rmc.type("minuteTextField", driver, minuteTextField, strMinute);
//	}
//	
//	if(rmc.isVisible(driver, hoursTextField)) {
//		rmc.click("Clicking on hoursTextField",driver, hoursTextField);
//		rmc.clear(driver, hoursTextField);
//		rmc.type("hoursTextField", driver, hoursTextField, strHours);
//	}
//	
	
	if(rmc.isVisible(driver, scheduleLink)) {
		rmc.click("Clicking on scheduleLink",driver, scheduleLink);
	}
	
       

//	DateFormat  inputFormat = new SimpleDateFormat("MM/dd/yy HH:mm a");
//	inputFormat.setTimeZone( TimeZone.getTimeZone("UTC") );  
//	 	Date date = null;
//      try {
//		 date = inputFormat.parse(strStartDate);
		 if(rmc.isVisible(driver, scheduleStartDate)) {
	  			rmc.click("Clicking on scheduleStartDate",driver, scheduleStartDate);
	  			rmc.clear(driver, scheduleStartDate);
	  			rmc.type("scheduleStartDate", driver, scheduleStartDate, strStartDate);
	  		   }
//      	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//      	}

     
      
    
			   if(rmc.isVisible(driver, scheduleEndDate)) {
	    			rmc.click("Clicking on scheduleEndDate",driver, scheduleEndDate);
	    			rmc.clear(driver, scheduleEndDate);
	    			rmc.type("scheduleEndDate", driver, scheduleEndDate, strEndDate);
	    		   }

      
			  if(rmc.isVisible(driver, submitBtn)) {
					rmc.click("Clicking on submitBtn",driver, submitBtn);
			  }
			  
			  if(rmc.isVisible(driver, confirmationWindow)) {
				
			  }
			 String message=driver.findElement(confirmationMessageLabel).getText();
			 String Str = new String(message);
			 
			 int processIDstartIndex=Str.indexOf(" ");
			 int processIdEndIndex=Str.indexOf("was");
			 
			 String processID=Str.substring(processIDstartIndex+1, processIdEndIndex-1);
			 try {
			test.log(LogStatus.INFO, "<B><I>Process ID is "+processID+"</B>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 if(rmc.isVisible(driver, confirmationOkBtn)) {
				rmc.click("Clicking on confirmationOkBtn",driver, confirmationOkBtn);
		 }
			 
			 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
			 if(rmc.isVisible(driver, expandSearch)) {
				rmc.click("Clicking on expandSearch",driver, expandSearch);
		  }
			 
			 if(rmc.isVisible(driver, processIDTextField)) {
				rmc.click("Clicking on processIDTextField",driver, processIDTextField);
				rmc.clear(driver, processIDTextField);
				rmc.type("processIDTextField", driver, processIDTextField, processID);
				
			  }
			 
			if(rmc.isVisible(driver, searchButton)) {
			rmc.click("Clicking on expandSearch",driver, searchButton);
			}
			 
			try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			List<WebElement>list1=driver.findElements(processIDTableRows);
			if(list1.size()>=1) {
				test.log(LogStatus.PASS, "<B>Process ID is Available in Table "+processID);
				try {
				test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else {
				test.log(LogStatus.FAIL, "<B>Process ID is not Available in Table "+processID);
				try {
				test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			processName=By.xpath("//span[text()='"+strJobName+"']");
			
			String tableJobname=driver.findElement(processName).getText();
			list1=driver.findElements(processName);
			
			if(list1.size()>=1) {
				test.log(LogStatus.PASS, "<B>Job Name is Available in Table "+strJobName);
				try {
				test.log(LogStatus.INFO, "<B>Job Name is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}else {
				test.log(LogStatus.FAIL, "<B>Job Name is not Available in Table "+tableJobname);
				try {
				test.log(LogStatus.INFO, "<B>Job Name is not Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
	
	}

	public void SearchProcessIDandValidation(WebDriver driver,String strSubmitionTime,String strInputWorkBook,String strInputSheet,String strInputTestCaseName,String strInputParameter1,String strInputParameter2) {
		
		String processID=readExcelFileforOutputData(strInputWorkBook, strInputSheet, strInputTestCaseName, strInputParameter1);
		
		if(rmc.isVisible(driver, HomeImage)) {
			rmc.click("Clicking on HomeImage",driver, HomeImage);
		}
		
		rmc.javaScriptExecutor(driver, toolsIcon);
		
		if(rmc.isVisible(driver, toolsIcon)) {
			rmc.click("Clicking on toolsIcon",driver, toolsIcon);
		}
		
		if(rmc.isVisible(driver, scheduleProcess)) {
			rmc.click("Clicking on scheduleProcess",driver, scheduleProcess);
		}
		
		
		
//		if(rmc.isVisible(driver, scheduleNewProcess)) {
//			rmc.click("Clicking on scheduleNewProcess",driver, scheduleNewProcess);
//		}
//		
//		if(rmc.isVisible(driver, scheduleNewProcessPage)) {
//			
//		}
		
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 if(rmc.isVisible(driver, expandSearch)) {
				rmc.click("Clicking on expandSearch",driver, expandSearch);
			  }
			 
			 if(rmc.isVisible(driver, processIDTextField)) {
				rmc.click("Clicking on processIDTextField",driver, processIDTextField);
				rmc.clear(driver, processIDTextField);
				rmc.type("processIDTextField", driver, processIDTextField, processID);
				
			  }
			 
			 if(rmc.isVisible(driver, SubmitionTimeBefore)) {
					rmc.selectByVisibleText(driver, SubmitionTimeBefore,strSubmitionTime);
			  }
			 
			if(rmc.isVisible(driver, searchButton)) {
				rmc.click("Clicking on expandSearch",driver, searchButton);
			}
			 
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement>list1=driver.findElements(processIDTableRows);
			if(list1.size()>=1) {
				test.log(LogStatus.PASS, "<B>Process ID is Available in Table "+processID);
				try {
					test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				test.log(LogStatus.FAIL, "<B>Process ID is not Available in Table "+processID);
				try {
					test.log(LogStatus.INFO, "<B>Process ID is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			String strJobName=readExcelFileforOutputData(strInputWorkBook, strInputSheet, strInputTestCaseName, strInputParameter2);
			processName=By.xpath("//span[text()='"+strJobName+"']");
			
			String tableJobname=driver.findElement(processName).getText();
			list1=driver.findElements(processName);
			
			if(list1.size()>=1) {
				test.log(LogStatus.PASS, "<B>Job Name is Available in Table "+strJobName);
				try {
					test.log(LogStatus.INFO, "<B>Job Name is Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				test.log(LogStatus.FAIL, "<B>Job Name is not Available in Table "+tableJobname);
				try {
					test.log(LogStatus.INFO, "<B>Job Name is not Available in Table ",test.addBase64ScreenShot(rmc.captureScreenshotBase64(driver)));
				} catch (Exception e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	
	
	public void logOut(WebDriver driver) {
		if(rmc.isVisible(driver, HomeImage)) {
			rmc.click("Clicking on HomeImage",driver, HomeImage);
		}
		
		if(rmc.isVisible(driver, userIcon)) {
			rmc.click("Clicking on userIcon",driver, userIcon);
		}
		
		if(rmc.isVisible(driver, signOut)) {
			rmc.click("Clicking on signOut",driver, signOut);
		}
		
		if(rmc.isVisible(driver, confirmBtn)) {
			rmc.click("Clicking on confirmBtn",driver, confirmBtn);
		}
	}
	
	
}
