package renessans.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import renessans.stepsdef.Hooks;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(Hooks.getDriver(), this);
    }

    public WebElement waitElementClickable(WebElement element) { // метод ожидания кликабельности элемента
        return Hooks.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement visibilityElementWait(WebElement element) { // метод ожидания видимости элемента
        return Hooks.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean visibilityTextWait(WebElement element, String text) { // метод ожидания видимости текста
        return Hooks.wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    WebElement findElement(By by) {
        return Hooks.getDriver().findElement(by);
    }

    public void changeWait() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
