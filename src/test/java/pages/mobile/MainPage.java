package pages.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {
    private final SelenideElement
            outsideScreen = $(AppiumBy.id("ru.ozon.app.android:id/touch_outside")),
            advertisingAtStart = $(AppiumBy.id("ru.ozon.app.android:id/closeSIB")),
            catalogMenu = $(AppiumBy.id("ru.ozon.app.android:id/menu_catalog")),
            liveButton = $(AppiumBy.id("ru.ozon.app.android:id/liveBtn")),
            profileButton = $(AppiumBy.id("ru.ozon.app.android:id/menu_profile")),
            openMoments = $(AppiumBy.id("ru.ozon.app.android:id/menu_cart")),
            addButtonInMoments = $(AppiumBy.id("ru.ozon.app.android:id/button")),
            openScanSection = $(AppiumBy.id("ru.ozon.app.android:id/scanItIv")),
            headerInScanSection = $(AppiumBy.id("ru.ozon.app.android:id/titleTv")),
            nextButtonInScanSection = $(AppiumBy.id("ru.ozon.app.android:id/buttonAtomTitleTv")),
            descriptionInScanSection = $(AppiumBy.id("ru.ozon.app.android:id/descriptionTv")),
            acceptButton = $(AppiumBy.id("ru.ozon.app.android:id/buttonB"));

    public void closeAllAdvertising() {
        sleep(1500);
        if (outsideScreen.exists()) {
            outsideScreen.click();
        } else if (advertisingAtStart.exists()) {
            advertisingAtStart.click();
        }
    }

    public void openCatalog() {
        catalogMenu.click();
    }

    public void openLiveSection() {
        liveButton.click();
    }

    public void openProfile() {
        profileButton.click();
    }

    public void openMomentsSection() {
        openMoments.click();
    }

    public void addMoment() {
        addButtonInMoments.click();
    }

    public void openScanSection() {
        openScanSection.click();
    }

    public void checkTextInHeader() {
        headerInScanSection.shouldHave(text("Хотите быстро сравнить цену магазина с Ozon?"));
    }

    public void clickNextButtonAndCheckText() {
        nextButtonInScanSection.click();
        descriptionInScanSection.shouldHave(text("Отсканируйте наклейку штрихкода на упаковке"));
    }

    public void clickNextButtonAndCheckAcceptButton() {
        nextButtonInScanSection.click();
        acceptButton.shouldHave(text("РАЗРЕШИТЬ"));
    }
}
