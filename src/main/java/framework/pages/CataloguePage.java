package framework.pages;

import framework.pages.blocks.BaseMenuBlock;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static framework.pages.BasketPage.priceProductList;

public class CataloguePage extends BasePage {
    @FindBy(xpath = "//h3[contains(text(),'Filters')]")
    WebElement headerFilters;

    @FindBy(xpath = "//div[@class='text']")
    List<WebElement> productList;

    //public static List<Double> priceProductList = new ArrayList<>();
    Double price = null;
    BaseMenuBlock baseMenuBlock = new BaseMenuBlock();

    public BaseMenuBlock getBaseMenuBlock() {
        return baseMenuBlock;
    }

    @Step("Проврка прогрузилась ли CataloguePage")
    public CataloguePage checkHeaderFilters() {
        waitStabilityPage(5000, 10);
        Assertions.assertTrue(waitUntilElementToBeVisible(headerFilters).isDisplayed(),
                "CataloguePage не прогрузилась");
        return this;
    }

    @Step("Добавить элемент {nameProduct} в корзину")
    public CataloguePage addProductToBasket(String nameProduct) {
        for (WebElement product :productList) {
            waitStabilityPage(5000, 10);
            if (waitUntilElementToBeVisible(product.findElement(By.xpath(".//h3/a"))).getText().contains(nameProduct)) {
                price = Double.parseDouble(product.findElement(By.xpath(".//p[@class='price']")).getText().replaceAll("[^0-9,.]",""));
                clickToElementJs(waitUntilElementToBeClicable(product.findElement(By.xpath(".//a[@class='btn btn-primary']"))));
             break;
            }
        }
        priceProductList.add(price);
        return this;
    }
}
