package by.vek.listeners;

import by.vek.utils.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MethodsTestListneres implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(MethodsTestListneres.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Test" + result.getMethod().getMethodName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test " + result.getMethod().getMethodName() + " Success");
        DriverManager.quitDriver();
        LOGGER.info("Test " + result.getName() + " quitDriver");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("Test " + result.getMethod().getMethodName() + " Failure");
        LOGGER.info(DriverManager.getDriver().getPageSource());
        DriverManager.quitDriver();
        LOGGER.info("Test " + result.getName() + " quitDriver");
    }
}
