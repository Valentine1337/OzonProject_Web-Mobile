package pages.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement
            searchBar = $(".search-bar-wrapper").$("input"),
            submitSearchButton = $(".z1u [type=submit]"),
            cartSelector = $(byText("Корзина")),
            catalogButtonAndCategorySelector = $("div[data-widget=catalogMenu"),
            giftPage = $("div[data-widget=topBar]").$(byText("Подарочные сертификаты")),
            financePage = $("ul[data-widget=horizontalMenu]").$(byText("Ozon Счёт")),
            sellerPage = $("div[data-widget=topBar]").$(byText("Продавайте на Ozon"));

    public void open() {
        Selenide.open("");
    }

    public void openCart() {
        cartSelector.click();
    }

    public void openFinance() {
        financePage.click();
    }

    public void searchItemAndSubmit(String item) {
        searchBar.setValue(item);
        submitSearchButton.click();
    }

    public void catalogButtonClickAndSelectCategory(String categoryName) {
        catalogButtonAndCategorySelector.click();
        catalogButtonAndCategorySelector.$(byText(categoryName)).click();
    }

    public void openGiftPage() {
        giftPage.click();
    }

    public void openSellerPage() {
        sellerPage.click();
    }
}
