package driverScript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationLayer.CustomerPage;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil{
	String Inputpath="./FileInput/Customerdata.xlsx";
	String Outputpath="./FileOutput/POMRes.xlsx";
	ExtentReports report;
	ExtentTest logger;
	String sheetname="CustomerData";
	@Test
	public void startTest() throws Throwable
	{
		report=new ExtentReports("./target/ExtentReports/Customer.html");
		//create object for excel file util class
		ExcelFileUtil xl=new ExcelFileUtil(Inputpath);
		//count no of rows
		int rc=xl.rowCount(sheetname);
		//iterate all rows
		for(int i=1;i<=rc;i++)
		{
			logger=report.startTest("Customer Validation");
			//read cells from CustomerData sheet
			String Customername=xl.getCellData(sheetname, i, 0);
			String Address=xl.getCellData(sheetname, i, 1);
			String City=xl.getCellData(sheetname, i, 2);
			String Country=xl.getCellData(sheetname, i, 3);
			String Cperson=xl.getCellData(sheetname, i, 4);
			String Pnumber=xl.getCellData(sheetname, i, 5);
			String Email=xl.getCellData(sheetname, i, 6);
			String Mnumber=xl.getCellData(sheetname, i, 7);
			String Notes=xl.getCellData(sheetname, i, 8);
			logger.log(LogStatus.INFO, Customername+"---"+Address+"---"+City+"---"+Country+"---"+Cperson+"---"+Pnumber+"---"+Email+"---"+Mnumber+"----"+Notes);
			CustomerPage cus=PageFactory.initElements(driver, CustomerPage.class);
		  boolean res=cus.add_customer(Customername, Address, City, Country, Cperson, Pnumber, Email, Mnumber, Notes);
		  if(res)
		  {
			  //if res is true write as pass status into status cell
			  xl.setcellData(sheetname, i, 9, "Pass", Outputpath);
			  logger.log(LogStatus.INFO, "Customer Added success");
			  
			  
		  }
		  else
		  {
			  //if res is false write as fail status into status cell
			  xl.setcellData(sheetname, i, 9, "Fail", Outputpath);
			  logger.log(LogStatus.INFO, "Customer Added Fail");
		  }
		  report.endTest(logger);
		  report.flush();
		}
		
	}
	

}



