package pages.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;

public class SellerPage {
    private final SelenideElement
            newsInHeader = $(".header__menu a"),
            searchInput = $(".search-input__input"),
            newsList = $(".news-list"),
            firstButton = $(".index-promo__button-wrapper").$(byText("Начать продавать")),
            countrySelectButton = $(".country-select_title_JDvDj"),
            secondButton = $(".start__container").$(byText("Начать продавать")),
            thirdButton = $(".support__content").$(byText("Начать продавать")),
            fourthButton = $(".join__container").$(byText("Начать продавать"));

    public void open() {
        Selenide.open("https://seller.ozon.ru/");
    }

    public void openNews() {
        newsInHeader.click();
    }

    public void searchText(String text) {
        searchInput.click();
        searchInput.setValue(text).pressEnter();
    }

    public void checkTextInNewsList(String text) {
        newsList.shouldHave(text(text));
    }

    public void clickFirstButton() {
        firstButton.click();
    }

    public void checkCountrySelect() {
        countrySelectButton.shouldHave(text("Выберите страну"));
    }

    public void checkSecondThirdAndFourthButton() {
        secondButton.click();
        checkCountrySelect();
        back();
        thirdButton.click();
        checkCountrySelect();
        back();
        fourthButton.click();
        checkCountrySelect();
    }
}
