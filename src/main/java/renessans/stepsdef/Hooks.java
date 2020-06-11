package renessans.stepsdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import renessans.PropsSettings;
import renessans.utils.AllureUtils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {
    private static WebDriver driver;
    public static WebDriverWait wait;

    public static void startUp() {
        Properties properties = PropsSettings.getInstance().getProperties();

        String browser = properties.getProperty("browser", "chrome");
        switch (browser) {
            case "chrome":
                System.setProperty(properties.getProperty("chromeDriver"), properties.getProperty("driverPathChrome"));
                driver = new ChromeDriver();
                break;
            case "opera":
                System.setProperty(properties.getProperty("operaDriver"), properties.getProperty("driverPathOpera"));
                driver = new OperaDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 8);
        driver.get(properties.getProperty("urlBank"));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quit() {
        driver.quit();
    }

    @Before
    public void setUp() {
        Hooks.startUp();
    }

    @After
    public void tearDown() {
        AllureUtils.addScreen();
        Hooks.quit();
    }

}
