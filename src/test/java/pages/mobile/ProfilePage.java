package pages.mobile;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private final SelenideElement
            deliveryPoints = $(AppiumBy.id("ru.ozon.app.android:id/sectionRootLl"), 1),
            filterMenu = $(AppiumBy.id("ru.ozon.app.android:id/clickableContainerLl")),
            deliviryPointsFilter = $(AppiumBy.id("ru.ozon.app.android:id/checkboxV")),
            submitButton = $(AppiumBy.id("ru.ozon.app.android:id/buttonAtomTitleTv")),
            deliveryPointsButtonOnMap = $(AppiumBy.id("ru.ozon.app.android:id/titleTv"));

    public void openDeliveryPoints() {
        deliveryPoints.click();
    }

    public void openFilterMenu() {
        filterMenu.click();
    }

    public void selectFilters() {
        deliviryPointsFilter.click();
        submitButton.click();
    }

    public void checkFilterIsEnabled() {
        deliveryPointsButtonOnMap.attr("enabled").equals(true);
    }
}
