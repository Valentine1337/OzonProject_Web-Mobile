package pages.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {
    private final SelenideElement
            headerSelector = $(AppiumBy.id("ru.ozon.app.android:id/titleTv"));

    public void checkHeaderText() {
        headerSelector.shouldHave(text("Введите свой номер телефона, чтобы войти"));
    }
}
