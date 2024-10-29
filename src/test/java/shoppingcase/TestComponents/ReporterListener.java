package shoppingcase.TestComponents;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReporterListener implements ITestListener {

   ExtentTest test;
    ExtentReports reporter = Reporter.getReporter();

    public ReporterListener(){
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestStart(ITestResult result) {
       test = reporter.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "well done");
    }

    @Override
    public void onFinish(ITestContext context) {
        reporter.flush();
    }

    
}
