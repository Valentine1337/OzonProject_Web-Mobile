package pages.web;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.ClickMethod.JS;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GiftPage {
    private final SelenideElement
            giftCerfificatesNominals = $("div[data-widget=webAspects]"),
            giftCerfificatesTitle = $("div[data-widget=webProductHeading]"),
            saleFormWithPrice = $("div[data-widget=webSale]"),
            priceReductionButton = saleFormWithPrice.$("button[type=button]"),
            priceReductionForm = $(".ui-i7 form[novalidate=novalidate]"),
            priceReductionEmailField = priceReductionForm.$("input[type=text]"),
            priceReductionFormSubmitButton = priceReductionForm.$("button[type=submit]"),
            addToCartButton = $("div[data-widget=webSale]").$(byText("Добавить в корзину")),
            tooltipSelector = $("div[data-widget=webBrand] button");

    public void selectGiftNominal(String nominal) {
        giftCerfificatesNominals.$(byText(nominal)).parent().parent().parent().click();
    }

    public void checkGiftCertificateTitle(String nominalInHeader) {
        giftCerfificatesTitle.shouldHave(text(nominalInHeader));
    }

    public void clickOnReductionPriceButton() {
        saleFormWithPrice.shouldHave(text("Узнать о снижении цены"));
        priceReductionButton.click();
    }

    public void setTestDataAndSubmit() {
        priceReductionEmailField.setValue("test-qaguru@yandex.ru");
        priceReductionFormSubmitButton.click();
    }

    public void checkReductionPriceEnabled() {
        saleFormWithPrice.shouldHave(text("Мы сообщим о снижении цены"));
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void clickOnToolTip() {
        tooltipSelector.click();

    }

    public void checkTooltipIsVisible() {
        $(byText("Поддержка производителя")).shouldBe(visible);
    }
}
