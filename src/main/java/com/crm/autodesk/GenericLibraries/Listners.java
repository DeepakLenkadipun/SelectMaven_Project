package com.crm.autodesk.GenericLibraries;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listners implements ITestListener
{
	 JavaUtility jLib = new JavaUtility();
	ExtentReports reports;//attach the reporter
	ExtentTest test;// to make evtreis of test cases and logs
	
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());

	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"is passed");

	}
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getThrowable());

		test.log(Status.FAIL, result.getMethod().getMethodName()+"is failed");
		BaseClass baseclass=new BaseClass();
		try {
			String path=baseclass.getscreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		}catch(IOException e){

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"is skipped");

	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
	
	public void onStart(ITestContext context) {

		ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReportsSDET21/ExtentReports"+jLib.getrandomNum()+".html");
		reporter.config().setDocumentTitle("SDET21");
		reports=new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("BuildNo", "5.1");
		reports.setSystemInfo("Env", "pre-prod");
		reports.setSystemInfo("PlatForm", "Windows");
		reports.setSystemInfo("Browser Version", "Chrome-93");
	}



	public void onFinish(ITestContext context) {
		reports.flush();

	}

	

}
