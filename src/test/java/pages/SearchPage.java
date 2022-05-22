package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement
            searchList = $(".widget-search-result-container").$(".iw7"),
            addToCart = $(byText("В корзину")),
            addToFavoriteButton = $(".widget-search-result-container").$(".o6d button"),
            additionalMenu = $(".widget-search-result-container").$(".ui-b1 button", 2),
            addToCompareButton = $(".ui-k3").$(byText("Добавить в сравнение")),
            comparePopUpMessage = $(byText("Товар добавлен в сравнение"));

    public void addItemToCart(String item) {
        addToCart.click();
    }

    public void addToFavorite() {
        addToFavoriteButton.click();
    }

    public void addToCompare() {
        additionalMenu.click();
        addToCompareButton.click();
    }

    public void checkComparePopUpMessage() {
        comparePopUpMessage.shouldBe(visible);
    }
}
