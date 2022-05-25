package pages.web;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class ComparePage {
    private final SelenideElement
            compareScreen = $("div[data-widget=webCompare]");

    public void open() {
        Selenide.open("/product/compare");
    }

    public void checkCompareItems(String itemName) {
        compareScreen.shouldHave(Condition.text(itemName));
    }
}
