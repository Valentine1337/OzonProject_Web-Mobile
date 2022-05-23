package pages.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FinancePage {
    private final SelenideElement
            commonHintElement = $(".svelte-1a5z05k");

    public void openAllHints() {
        commonHintElement.scrollTo();
        commonHintElement.$(byText("Как открыть")).click();
        commonHintElement.$(byText("Пополнить")).click();
        commonHintElement.$(byText("Вывести деньги")).click();
        commonHintElement.$(byText("Повысить лимиты")).click();
    }

    public void checkTextUnderHints() {
        commonHintElement
                .shouldHave(Condition.text("Заполните недостающие данные на анкете"));
        commonHintElement
                .shouldHave(Condition.text("Пополнить Ozon Счёт можно с карты и по номеру"));
        commonHintElement
                .shouldHave(Condition.text("С Анонимного Счёта вы сможете потратить деньги только на покупки"));
        commonHintElement
                .shouldHave(Condition.text("Можно хранить на Счёте до 15 000 рублей"));
    }
}
