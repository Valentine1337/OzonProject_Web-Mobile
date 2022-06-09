package tests.mobile;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.mobile.*;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MobileTests extends TestbaseMobile {
    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    LiveTraslationsPage liveTraslationsPage = new LiveTraslationsPage();
    ProfilePage profilePage = new ProfilePage();
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    @AllureId("10140")
    @DisplayName("Отображение значка 'Поделиться' в рекламном банере")
    @Tags({@Tag("ui"), @Tag("mobile")})
    @Owner("valentin.gordeev")
    @Feature("UI mobile тесты")
    void tranferIconInAdvertisingPageTest() {
        step("Открыть приложение, закрыть рекламные баннеры", (Allure.ThrowableRunnableVoid) Selenide::open);
        step("Закрыть выпадающие меню, если они есть", mainPage::closeAllAdvertising);
        step("Кликнуть снизу на кнопку Каталог", mainPage::openCatalog);
        step("Выбрать категорию Одежда и обувь", catalogPage::selectClothingCategory);
        step("Кликнуть на рекламный банер", catalogPage::clickOnAdvBanner);
        step("Убедиться, что значок Поделиться кликабельный", catalogPage::checkTrancferIcon);
    }

    @Test
    @AllureId("10144")
    @DisplayName("Напоминания в разделе с лайв видео")
    @Tags({@Tag("ui"), @Tag("mobile")})
    @Owner("valentin.gordeev")
    @Feature("UI mobile тесты")
    void reminderInLiveSectionTest() {
        step("Открыть приложение, закрыть рекламные баннеры", () -> {
            open();
            mainPage.closeAllAdvertising();
        });
        step("Перейти в раздел лайв видео с главной страницы", mainPage::openLiveSection);
        step("Кликнуть на любой баннер лайв трансляции", liveTraslationsPage::selectTranslation);
        step("Нажать 'Напомнить о начале'", liveTraslationsPage::clickReminder);
        step("Убедиться, что появилось поп-ап сообщение о напоминании", liveTraslationsPage::checkPopUpMessage);
    }

    @Test
    @AllureId("10150")
    @DisplayName("Фильтры в разделе 'Пункты выдачи на карте' в профиле")
    @Tags({@Tag("ui"), @Tag("mobile")})
    @Owner("valentin.gordeev")
    @Feature("UI mobile тесты")
    void deliveryPointsOnMapFilterTest() {
        step("Открыть приложение, закрыть рекламные баннеры", () -> {
            open();
            mainPage.closeAllAdvertising();
        });
        step("Зайти в 'Профиль Ozon'", mainPage::openProfile);
        step("Перейти в раздел 'Пункты выдачи на карте'", profilePage::openDeliveryPoints);
        step("Нажать на кнопку 'меню фильтров'", profilePage::openFilterMenu);
        step("Выбрать фильтр 'Пункт выдачи' и применить", profilePage::selectFilters);
        step("Убедиться, что выбранный фильтр подсвечен", profilePage::checkFilterIsEnabled);
    }

    @Test
    @AllureId("10151")
    @DisplayName("Необходимость авторизации для добавления видео в 'Моменты'")
    @Tags({@Tag("ui"), @Tag("mobile")})
    @Owner("valentin.gordeev")
    @Feature("UI mobile тесты")
    void helpSectionInProfileTest() {
        step("Открыть приложение, закрыть рекламные баннеры", () -> {
            open();
            mainPage.closeAllAdvertising();
        });
        step("Зайти в Моменты", mainPage::openMomentsSection);
        step("Кликнуть на значок +", mainPage::addMoment);
        step("Убедиться, что появилось окно с требованием ввести номер телефона", authorizationPage::checkHeaderText);
    }

    @Test
    @AllureId("10196")
    @DisplayName("Работоспособность функции 'Скан товара'")
    @Tags({@Tag("ui"), @Tag("mobile")})
    @Owner("valentin.gordeev")
    @Feature("UI mobile тесты")
    public void travelSectionTest() {
        step("Открыть приложение, закрыть рекламные баннеры", () -> {
            open();
            mainPage.closeAllAdvertising();
        });
        step("Открыть раздел Скан товаров (значок штрихкода справа от поисковой строки)",
                mainPage::openScanSection);
        step("Убедиться, что есть надпись Хотите быстро сравнить цену магазину Ozon?",
                mainPage::checkTextInHeader);
        step("Нажать кнопку 'Далее', " +
                "убедиться, что есть надпись 'Отсканируйте наклейку штрихкода на упаковке'",
                mainPage::clickNextButtonAndCheckText);
        step("Нажать кнопку 'Начать сканирование' и убедиться, что кнопка 'Разрешить' активна",
                mainPage::clickNextButtonAndCheckAcceptButton);
    }

}
