package framework.pages;

import framework.pages.blocks.BaseMenuBlock;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public BaseMenuBlock getBaseMenuBlock() {
        return baseMenuBlock;
    }

    private BaseMenuBlock baseMenuBlock = new BaseMenuBlock();

    @FindBy(xpath = "//h2[text()='Hot this week']")
    WebElement headerHomePage;

    @Step("Проврка прогрузилось ли HomePage")
    public HomePage checkHeaderHomePage() {
        wait(500);
        Assertions.assertTrue(waitUntilElementToBeVisible(headerHomePage).isDisplayed(),
                "HomePage не прогрузилась");
        return this;
    }
}
