package framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {
    @FindBy(xpath = "//h1[contains(text(),'Shopping cart')]")
    WebElement headerBasketPage;
    @FindBy(xpath = "//th[@id='cartTotal']")
    WebElement priceBasket;

    public static List<Double> priceProductList = new ArrayList<>();

    @Step("Проврка прогрузилась ли BasketPage")
    public BasketPage checkHeaderBasketPage() {
        waitStabilityPage(5000, 10);
        wait(500);
        Assertions.assertTrue(waitUntilElementToBeVisible(headerBasketPage).isDisplayed(),
                "BasketPage не прогрузилась");
        return this;
    }

    @Step("Стоимость корзины")
    public void checkPriceBasket() {
        double priceBasketDouble = Double.parseDouble(priceBasket.getText().replaceAll("[^0-9,.]", ""));
        double sumList = priceProductList.stream().reduce(0.0, Double::sum);
        Assertions.assertEquals(sumList, priceBasketDouble, "Сумма товаров и в корзине не совпадает");
        priceProductList.clear();
    }
}
