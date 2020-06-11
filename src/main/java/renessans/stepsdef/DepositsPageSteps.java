package renessans.stepsdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import renessans.pages.DepositsPage;
import renessans.utils.AllureUtils;


public class DepositsPageSteps {

    private DepositsPage depositsPage = new DepositsPage();

    @When("выбираем Валюту {string}")
    public void chooseCurrency(String currency) {
        depositsPage.currencyChose(currency);

    }

    @When("Заполняем значения Вклада")
    public void fillFields(DataTable dataTable) {
        dataTable.asMap(String.class, String.class)
                .forEach((field, value) -> depositsPage.fillFields((String) field, (String) value));
    }

    @When("Отмечаем Ежемесячная капитализация")
    public void clickCap() {
        depositsPage.clickCap();
    }

    @When("Проверяем значения:")
    public void checkValues(DataTable values) {
        values.asMap(String.class, String.class)
                .forEach((field, value) -> depositsPage.getFields((String) field, (String) value));
    }


}
