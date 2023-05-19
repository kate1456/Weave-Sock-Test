package framework.pages.blocks;

import framework.pages.AuthorizationPage;
import framework.pages.BasePage;
import framework.pages.BasketPage;
import framework.pages.CataloguePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.pages.BasketPage.priceProductList;


public class BaseMenuBlock extends BasePage {
    @FindBy(xpath = "//ul[@class]//a[@data-target='#login-modal']")
    WebElement login;
    @FindBy(xpath = "//div[@id='navbar']")
    WebElement firstHeaderMenuBlock;
    @FindBy(xpath = "//ul[contains(@class,'navbar-left')]//a[contains(text(),'Catalogue')]")
    WebElement buttonCatalogue;

    @FindBy(xpath = "//a[contains(@class,'btn btn-primary navbar-btn')]")
    WebElement buttonBasket;
    @Step("Клик по логину")
    public AuthorizationPage clickLogin() {
        Assertions.assertTrue(waitUntilElementToBeVisible(login).isDisplayed(),
                "Кнопка login не прогрузилась");
        login.click();
        return pageManager.getPage(AuthorizationPage.class);
    }

    @Step("Проврка прогрузилось ли верхнее меню")
    public BaseMenuBlock checkHeaderMenuBlock() {
        Assertions.assertTrue(waitUntilElementToBeVisible(firstHeaderMenuBlock).isDisplayed(),
                "Блок меню не прогрузился");
        return this;
    }

    @Step("Перейти в католог")
    public CataloguePage clickOnCatalogue() {
        clickWithCheckReferenceException(buttonCatalogue);
        return pageManager.getPage(CataloguePage.class);
    }

    @Step("Перейти в корзину")
    public BasketPage clickOnBasket() {
        clickWithCheckReferenceException(buttonBasket);
        return pageManager.getPage(BasketPage.class);
    }

    @Step("Проверить количество в корзине")
    public BaseMenuBlock checkCountOnBasket() {
        wait(1000);
        WebElement textBasket = buttonBasket.findElement(By.xpath(".//span"));
        Integer countProduct =Integer.parseInt(textBasket.getText().replaceAll("[^0-9]", ""));
        Integer countProductInList = priceProductList.size();
        Assertions.assertEquals(countProduct, countProductInList, "Колличество товаров в корзине не совпадает");
        return this;
    }
}
