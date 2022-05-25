package pages.web;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private final SelenideElement
            addToCart = $(byText("В корзину")),
            addToFavoriteButton = $("[data-widget=searchResultsV2] button", 1),
            additionalMenu = $("[data-widget=searchResultsV2]").$("button", 2),
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
