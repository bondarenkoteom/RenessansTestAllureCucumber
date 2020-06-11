package renessans.stepsdef;

import io.cucumber.java.ru.Когда;
import renessans.pages.MainPage;

public class MainPageSteps {
    private MainPage mainPage = new MainPage();

    @Когда("выбрано поле Вклады и переход на страницу Вклады")
    public void goToDeposit() throws InterruptedException {
        mainPage.goToDeposit();
    }
}
