package ResuableMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.LogStatus;


import ReportGenerator.ReportingClass;


public class ResuableMethodClass extends ReportingClass{
	
	public void click(String Message, WebDriver driver,By locator) {
		
		if(isExist(driver, locator)) {
			
			try {
				driver.findElement(locator).click();
				Assert.assertTrue(true, Message);
				test.log(LogStatus.PASS, "Click ","<B>"+Message+" clicking is successful</B>");
				
					test.log(LogStatus.INFO, "Click",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
					
				
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Click ","<B>"+Message+" clicking is not successful element is not available</B>");
			
					test.log(LogStatus.INFO, "Click",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
				
				Assert.assertTrue(false, Message);
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			test.log(LogStatus.FAIL, "Click ",Message+" clicking is not successful element is not available");
			try {
				test.log(LogStatus.INFO, "Click",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.assertTrue(false, Message);
			
		}
		
		
	}
	
	public void hoverElement(WebDriver driver,By locator) {
		
		if(isExist(driver, locator)) {
			try {
				Actions act=new Actions(driver);
				WebElement element=driver.findElement(locator);
				act.moveToElement(element).perform();
				Assert.assertTrue(true,"Hovering on element is successful");
				test.log(LogStatus.PASS, "<B>Hovering","Hovering is successful</B>");
				String str=captureScreenshot(driver);
				test.log(LogStatus.PASS, "Scroll", test.addBase64ScreenShot(captureScreenshotBase64(driver)));
			//	test.addBase64ScreenShot(captureScreenshotBase64(driver));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				test.log(LogStatus.FAIL, "<B>Hovering","Hovering is not successful</B>");
				Assert.assertTrue(false, "<element is not available");
			}
		}else {
			test.log(LogStatus.FAIL, "Hovering","<B>Hovering is not successful</B>");
			try {
				test.log(LogStatus.INFO, "Hovering",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.assertTrue(false, "element is not available");
			
				//test.addScreenCapture(captureScreenshot(driver));
			
		
		}
		
		
	}
	
	public void javaScriptExecutor(WebDriver driver,By locator) {
		
		if(isVisible(driver,locator)) {
			try {
				JavascriptExecutor js=(JavascriptExecutor)driver;
				WebElement element=driver.findElement(locator);
				js.executeScript("arguments[0].scrollIntoView();",element);
				Assert.assertTrue(true,"Scrolling Till element is successful");
				test.log(LogStatus.PASS, "Scroll","<B>Scrolling Till element is successful</B>");
				String str=captureScreenshot(driver);
				test.log(LogStatus.INFO, "Scroll", test.addBase64ScreenShot(captureScreenshotBase64(driver)));
					
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				test.log(LogStatus.FAIL, "Scroll","<B>Scrolling Till element not is successful</B>");
				try {
					String str=captureScreenshot(driver);
					test.log(LogStatus.INFO, "Scroll", test.addBase64ScreenShot(captureScreenshotBase64(driver)));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Assert.assertTrue(false, "Element is not available");
			
			}
			
		}else {
			test.log(LogStatus.FAIL, "Scroll","<B>Scrolling Till element not is successful</B>");
			Assert.assertTrue(false, "Element is not available");
		
				//test.addScreenCapture(captureScreenshot(driver));
				try {
					test.addBase64ScreenShot(captureScreenshot(driver));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+Screenshot.getScreenshot(driver)).build();
			
		}
		
	}
	
	public void ExplicitWait(WebDriver driver,By locator) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(3), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	
	public void type(String message,WebDriver driver,By Locator,String data) {
		
		if(isExist(driver, Locator)) {
			try {
				javaScriptExecutor(driver, Locator);
				driver.findElement(Locator).sendKeys(data);
				Assert.assertTrue(true, "<B>"+data+" has been entered</B>");
				test.log(LogStatus.PASS,message,"<B>"+data+" has been entered.</B>");
				
					test.log(LogStatus.INFO, "Type",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				test.log(LogStatus.FAIL, "Type","<B>"+data+" has not entered</B>");
				
					test.log(LogStatus.INFO, "Type",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
				
				Assert.assertTrue(false, "Element is not available");
			}
		}else {
			test.log(LogStatus.FAIL, "Type","</B>"+data+" has not entered</B>");
			try {
				test.log(LogStatus.INFO, "Type",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.assertTrue(false, "Element is not available");
			
		}
		
	}
	
	public void selectByValue(WebDriver driver,By Locator,String value) {
		
		if(isExist(driver, Locator)) {
			try {
				WebElement element=driver.findElement(Locator);
				Select option=new Select(element);
				option.selectByValue(value);
				Assert.assertTrue(true, value+" has been selected");
				test.log(LogStatus.PASS, "Select","<B>"+value+" has been selected</B>");
				try {
					test.log(LogStatus.INFO, "Select",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Select","<B>"+value+" is not selected</B>");
				try {
					test.log(LogStatus.INFO, "Select",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Assert.assertTrue(false, value+" is not selected");
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
			test.log(LogStatus.FAIL, "Select","</B>"+value+" is not selected</B>");
			try {
				test.log(LogStatus.INFO, "Select",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.assertTrue(false, value+" is not selected");
		}
		
	}
	
	public void selectByIndex(WebDriver driver,By Locator,int index) {
		
		if(isExist(driver, Locator)) {
			try {
				WebElement element=driver.findElement(Locator);
				Select option=new Select(element);
				option.selectByIndex(index);
				
				test.log(LogStatus.PASS, "Select","<B>"+index+" has been selected</B>");
				try {
					test.log(LogStatus.INFO, "Select",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Assert.assertTrue(true, index+" has been selected");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				test.log(LogStatus.FAIL, "Select","<B>"+index+" is not selected</B>");
				try {
					test.log(LogStatus.INFO, "Select",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				Assert.assertTrue(false, index+" is not selected");
			}
		}else {
			
			test.log(LogStatus.FAIL, "Select","<B>"+index+" is not selected</B>");
			try {
				test.log(LogStatus.INFO, "Select",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Assert.assertTrue(false, index+" is not selected");
		}
		
		
	}
	
	public void selectByVisibleText(WebDriver driver,By Locator,String visibleText) {
		if(isExist(driver, Locator)) {
			try {
				WebElement element=driver.findElement(Locator);
				Select option=new Select(element);
				option.selectByVisibleText(visibleText);
				Assert.assertTrue(true, visibleText+" has been selected");
				test.log(LogStatus.PASS, "Select","<B>"+visibleText+" has been selected</B>");
				try {
					test.log(LogStatus.INFO, "Select",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertTrue(false, visibleText+" is not selected");
				test.log(LogStatus.FAIL, "Select","<B>"+visibleText+" is not selected</B>");
				try {
					test.log(LogStatus.INFO, "Select",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else {
			Assert.assertTrue(false, visibleText+" is not selected");
			test.log(LogStatus.FAIL, "Select","<B>"+visibleText+" is not selected</B>");
			try {
				test.log(LogStatus.INFO, "Select",test.addBase64ScreenShot(captureScreenshotBase64(driver)));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
	
	public boolean isExist(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		List<WebElement>list1=driver.findElements(locator);
		if(list1.size()>=1) {
			driver.findElement(locator);
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean isVisible(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(180));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		List<WebElement>list1=driver.findElements(locator);
		if(list1.size()>=1) {
			driver.findElement(locator);
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean clear(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(180));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		List<WebElement>list1=driver.findElements(locator);
		if(list1.size()>=1) {
			driver.findElement(locator).clear();
			return true;
		}else {
			return false;
		}
	}
	
	public static String captureScreenshot(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir")+"\\"+"Images\\" + System.currentTimeMillis()+".png");
		
	
		Files.copy(scrFile, Dest);
		//String path=Dest.toString();
		return Dest.getAbsolutePath(); 	
		
	}
	
	public String captureScreenshotBase64(WebDriver driver) {
		String scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		
		return  "data:image/jpg;base64, " +scrFile;
	}
	
	public boolean isClickable(WebDriver driver,By Locator) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(180));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
		boolean isenabled=driver.findElement(Locator).isEnabled();
		if(isenabled) {
			return true;
		}else {
		 return	false;
		}
	}
	
	
	
	
	// test.fail("Failed step: ",MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+Screenshot.getScreenshot(driver)).build());
	
	

}
