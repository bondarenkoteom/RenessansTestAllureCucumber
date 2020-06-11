package renessans.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import renessans.stepsdef.Hooks;

public class AllureUtils {
    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreen() {
        return ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
