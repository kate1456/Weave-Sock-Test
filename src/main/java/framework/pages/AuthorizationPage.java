package framework.pages;

import framework.pages.blocks.BaseMenuBlock;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {
    @FindBy(xpath = "//h4[text()='Customer login']")
    WebElement windowTitleLogin;
    @FindBy(xpath = "//input[@id='username-modal']")
    WebElement fieldUserName;
    @FindBy(xpath = "//input[@id='password-modal']")
    WebElement fieldPassword;

    @FindBy(xpath = "//button[@onclick='return login()']")
    WebElement buttonLogin;

    @Step("Проврка прогрузилось ли окно формы для входа")
    public AuthorizationPage checkHeaderLoginForm() {
        Assertions.assertTrue(waitUntilElementToBeVisible(windowTitleLogin).isDisplayed(),
                "Модальное окно не прогрузилось");
        return this;
    }

    @Step("Заполнение формы авторизации и вход")
    public HomePage inputAuthorizationDate(String userName, String password) {
        waitUntilElementToBeClicable(fieldUserName).sendKeys(userName);
        waitUntilElementToBeClicable(fieldPassword).sendKeys(password);
        waitUntilElementToBeClicable(buttonLogin).click();
        return pageManager.getPage(HomePage.class);
    }

}
