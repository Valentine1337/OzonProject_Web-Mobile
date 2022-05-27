package pages.web;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement
            itemsInTheCart = $("div[data-widget=split]");
    public final SelenideElement popUpCrossElement = $(".ui-i7").$(".d4c");

    public void open() {
        Selenide.open("/cart");
    }

    public void closePopUp() {
        popUpCrossElement.click();
    }

    public void checkItem(String item) {
        itemsInTheCart.shouldHave(text(item));
    }
}
