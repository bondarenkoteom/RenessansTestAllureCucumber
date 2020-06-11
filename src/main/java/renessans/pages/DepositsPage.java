package renessans.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DepositsPage extends BasePage {


    @FindBy(xpath = "//input[@name='amount']")
    private WebElement depositAmount;

    @FindBy(xpath = "//label[contains(text(),'На срок')]")
    private WebElement period;

    @FindBy(xpath = "//input[@name='replenish']")
    private WebElement monthlyReplenishment;

    @FindBy(xpath = "//span[contains(text(),'Рубли')]")
    private WebElement chooseRub;

    @FindBy(xpath = "//span[contains(text(),'Доллары')]")
    private WebElement chooseUsa;

    @FindBy(xpath = "//div[@class='jq-selectbox__select-text']")
    private WebElement chooseMonth;

    @FindBy(xpath = "//span[text()='Ежемесячная капитализация']")
    private WebElement capitalization;

    @FindBy(xpath = "//span[@class = 'js-calc-earned']")
    private WebElement havePercent;

    @FindBy(xpath = "//span[@class = 'js-calc-replenish']")
    private WebElement replenishment;


    @FindBy(xpath = "//span[@class = 'js-calc-result']")
    private WebElement withdraw;

    public void currencyChose(String nameCurrency) { // выбираем валюту
        switch (nameCurrency) {
            case "Рубли":
                waitElementClickable(chooseRub).click();
                break;
            case "Доллары":
                waitElementClickable(chooseUsa).click();
                break;

        }

    }

    public void fillFields(String fieldName, String value) { // заполняем поля
        switch (fieldName) {
            case "Сумма вклада":
                fillField(depositAmount, value);
                break;
            case "На срок":
                findData(value);
                break;
            case "Ежемесячное пополнение":
                fillField(monthlyReplenishment, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void fillField(WebElement fieldElement, String value) { // вводим значения
        fieldElement.sendKeys(value);
        changeWait();

    }

    public void findData(String value) { // выбираем дату
        waitElementClickable(chooseMonth).click();
        WebElement data = findElement(By.xpath(String.format("//li[text()='%s месяцев']", value)));
        data.click();

    }

    public void clickCap() { // отмечаем капитализацию
        visibilityElementWait(capitalization);
        waitElementClickable(capitalization).click();
        changeWait();
    }

    public void getFields(String fieldName, String value) { // проверяем значения
        String factCost;
        switch (fieldName) {
            case "Начислено %":
                factCost = havePercent.getText();
                Assert.assertTrue(String.format("Ожидаемое значение %s, фактическое %s", value, factCost), visibilityTextWait(havePercent, value));
                break;
            case "Пополнение за 9 месяцев":
                factCost = replenishment.getText();
                Assert.assertTrue(String.format("Ожидаемое значение %s, фактическое %s", value, factCost), visibilityTextWait(replenishment, value));
                break;
            case "К снятию черпез 9 месяцев":
                factCost = withdraw.getText();
                Assert.assertTrue(String.format("Ожидаемое значение %s, фактическое %s", value, factCost), visibilityTextWait(withdraw, value));
                break;
        }
    }


}

