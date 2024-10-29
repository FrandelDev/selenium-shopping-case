package shoppingcase.TestComponents;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {
    
    public static ExtentReports getReporter(){
       ExtentSparkReporter sparkReporter = new ExtentSparkReporter("src\\test\\resources\\report.html");
       sparkReporter.config().setDocumentTitle("Shopping Case Report");
       sparkReporter.config().setReportName("Results:");

      ExtentReports reporter = new ExtentReports();
        reporter.attachReporter(sparkReporter);
        reporter.setSystemInfo("Tester", "Frandel");
        return reporter;
    }
}
