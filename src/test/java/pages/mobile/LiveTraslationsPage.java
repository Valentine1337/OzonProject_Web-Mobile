package pages.mobile;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class LiveTraslationsPage {
    private final SelenideElement
            firstBanner = $(AppiumBy.id("ru.ozon.app.android:id/imageIV")),
            reminderButton = $(AppiumBy.id("ru.ozon.app.android:id/previewImageView")),
            popUpMessage = $(AppiumBy.id("ru.ozon.app.android:id/navigationUpIcon"));

    public void selectTranslation() {
        firstBanner.click();
    }

    public void clickReminder() {
        reminderButton.click();
    }

    public void checkPopUpMessage() {
        popUpMessage.attr("focusable").equals(true);
    }
}
