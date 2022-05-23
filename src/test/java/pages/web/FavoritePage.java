package pages.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FavoritePage {
    private final SelenideElement
            favoriteSection = $("div a[data-widget=favoriteCounter]"),
            favoriteList = $(".widget-search-result-container"),
            compareScreen = $("div[data-widget=column]").$(byText("Сравнение товаров"));

    public void open() {
        favoriteSection.click();
    }

    public void openComparePage() {
        compareScreen.click();
    }

    public void checkFavoriteItem(String item) {
        favoriteList.shouldHave(text(item));
    }

}
