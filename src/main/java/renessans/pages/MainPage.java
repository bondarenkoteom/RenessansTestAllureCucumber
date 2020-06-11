package renessans.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'service__title']//a[@href = '/contributions/']")
    public WebElement deposit;

    public void goToDeposit()  { // переходим во вкладку Влады
        visibilityElementWait(deposit);
        waitElementClickable(deposit).click();

    }
}


