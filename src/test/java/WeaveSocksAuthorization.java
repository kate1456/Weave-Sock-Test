import framework.pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class WeaveSocksAuthorization extends BaseTests {
    @ParameterizedTest
    @MethodSource("framework.datatest.DataClass#msMP")
    @DisplayName("Авторизация и проверка суммы в корзине")
    public void weaveSocksAuthorization(String userName, String password) {
        pageManager.getPage(HomePage.class)
                .getBaseMenuBlock()
                .checkHeaderMenuBlock()
                .clickLogin()
                .checkHeaderLoginForm()
                .inputAuthorizationDate(userName, password)
                .checkHeaderHomePage()
                .getBaseMenuBlock()
                .clickOnCatalogue()
                .checkHeaderFilters()
                .addProductToBasket("Holy")
                .checkHeaderFilters()
                .addProductToBasket("Colourful")
                .getBaseMenuBlock()
                .checkCountOnBasket()
                .clickOnBasket()
                .checkHeaderBasketPage()
                .checkPriceBasket();
    }
}
