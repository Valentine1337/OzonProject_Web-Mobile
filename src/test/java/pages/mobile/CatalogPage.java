package pages.mobile;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    private final SelenideElement
            clothingCategory = $(AppiumBy.id("ru.ozon.app.android:id/categoryIv")),
            advBanner = $(AppiumBy.id("ru.ozon.app.android:id/imageView")),
            transferIcon = $(AppiumBy.id("ru.ozon.app.android:id/shareIv"));

    public void selectClothingCategory() {
        clothingCategory.click();
    }

    public void clickOnAdvBanner() {
        advBanner.click();
    }

    public void checkTrancferIcon() {
        transferIcon.attr("clickable").equals(true);
    }
}
