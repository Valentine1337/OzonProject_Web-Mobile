package tests.web;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.web.*;

import static io.qameta.allure.Allure.step;

public class WebTests extends TestbaseWeb {
    //Test data
    String[] nominalForGiftCertificates = {"2000", "8000"};
    String favoriteItem = "Honor",
            categoryName = "Смартфоны",
            itemToCompare = "iPhone 12",
            searchTextOnSellerPage = "Аналитика";

    //Page object's
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    CartPage cartPage = new CartPage();
    FavoritePage favoritePage = new FavoritePage();
    ComparePage comparePage = new ComparePage();
    GiftPage giftPage = new GiftPage();
    FinancePage financePage = new FinancePage();
    SellerPage sellerPage = new SellerPage();

    //Tests
    @ValueSource(strings = {"iPhone 12", "Samsung"})
    @ParameterizedTest(name = "Добавление товара \"{0}\" в корзину через поиск")
    @AllureId("10044")
    @Tags({@Tag("ui"), @Tag("web")})
    @Story("Ozon основной")
    @Owner("valentin.gordeev")
    @Feature("UI тесты")
    void addItemToCartTest(String testData) {
        step("Открыть главную страницу", () -> {
            mainPage.open();
        });
        step("В строке поиска ввести наименование товара и нажать кнопку поиска", () -> {
            mainPage.searchItemAndSubmit(testData);
        });
        step("Добавить товар в корзину и открыть её", () -> {
            searchPage.addItemToCart(testData);
            mainPage.openCart();
        });
        step("Проверить, что товар добавлен в корзину (и закрыть поп-ап, если он есть)", () -> {
            if (cartPage.popUpCrossElement.exists()) {
                cartPage.closePopUp();
            }
            cartPage.checkItem(testData);
        });
    }

    @Test
    @AllureId("10049")
    @DisplayName("Добавление товара в избранное")
    @Tags({@Tag("ui"), @Tag("web")})
    @Story("Ozon основной")
    @Owner("valentin.gordeev")
    @Feature("UI тесты")
    void addItemToFavoriteTest() {
        step("Открыть главную страницу", () -> {
            mainPage.open();
        });
        step("Через строку поиска найти любой товар", () -> {
            mainPage.searchItemAndSubmit(favoriteItem);
        });
        step("Добавить товар в избранное", () -> {
            searchPage.addToFavorite();
        });
        step("Убедиться, что товар появился в избранном", () -> {
            favoritePage.open();
            favoritePage.checkFavoriteItem(favoriteItem);
        });
    }

    @Test
    @AllureId("10048")
    @DisplayName("Добавление нескольких товаров в список сравнения")
    @Tags({@Tag("ui"), @Tag("web")})
    @Story("Ozon основной")
    @Owner("valentin.gordeev")
    @Feature("UI тесты")
    void compareItemsTest() {
        step("Открыть главную страницу", () -> {
            mainPage.open();
        });
        step("Нажать на каталог и выбрать любую категорию", () -> {
            mainPage.catalogButtonClickAndSelectCategory(categoryName);
        });
        step("Добавить любой товар к сравнению через меню троеточия справа", () -> {
            searchPage.addToCompare();
        });
        step("Убедиться, что появилось всплывающее окно", () -> {
            searchPage.checkComparePopUpMessage();
        });
        step("Найти через строку поиска iPhone 12", () -> {
            mainPage.searchItemAndSubmit(itemToCompare);
        });
        step("Добавить iPhone 12 к сравнению", () -> {
            searchPage.addToCompare();
        });
        step("Перейти к меню сравнения и убедиться, что оба товара добавлены", () -> {
            comparePage.open();
            comparePage.checkCompareItems(itemToCompare);
        });
    }

    @Test
    @AllureId("10045")
    @DisplayName("Добавление подарочных сертификатов с разным номиналом")
    @Tags({@Tag("ui"), @Tag("web")})
    @Story("Ozon основной")
    @Owner("valentin.gordeev")
    @Feature("UI тесты")
    void addGiftCertificateTest() {
        step("Открыть раздел подарочных сертификатов", () -> {
            mainPage.open();
            mainPage.openGiftPage();
        });
        step("Кликнуть на номинал 2000 руб.", () -> {
            giftPage.selectGiftNominal(nominalForGiftCertificates[0]);
        });
        step("Проверить, что номинал в названии поменялся", () -> {
            giftPage.checkGiftCertificateTitle(nominalForGiftCertificates[0]);
        });
        step("Кликнуть на номинал 8000", () -> {
            giftPage.selectGiftNominal(nominalForGiftCertificates[1]);
        });
        step("Проверить, что номинал поменялся в названии", () -> {
            giftPage.checkGiftCertificateTitle(nominalForGiftCertificates[1]);
        });
        step("Добавить подарочный сертификат в корзину", () -> {
            giftPage.addToCart();
        });
        step("Убедиться, что в корзине появился сертификат", () -> {
            cartPage.open();
            if (cartPage.popUpCrossElement.exists()) {
                cartPage.closePopUp();
            }
            cartPage.checkItem("Электронный подарочный сертификат");
        });
    }

    @Test
    @AllureId("10105")
    @DisplayName("Функция 'Узнать о снижении цены' в разделе подарочных сертификатов")
    @Tags({@Tag("ui"), @Tag("web")})
    @Story("Ozon основной")
    @Owner("valentin.gordeev")
    @Feature("UI тесты")
    void reductionPriceOnGiftPageTest() {
        step("Открыть раздел подарочных сертификатов", () -> {
            mainPage.open();
            mainPage.openGiftPage();
        });
        step("Нажать кнопку Узнать о снижении цены", () -> {
            giftPage.clickOnReductionPriceButton();
        });
        step("Ввести тестовый емейл test-qaguru@yandex.ru и нажать 'Готово'", () -> {
            giftPage.setTestDataAndSubmit();
        });
        step("Убедиться, что надпись сменилась на Мы сообщим о снижении цены", () -> {
            giftPage.checkReductionPriceEnabled();
        });
    }

    @Test
    @AllureId("10046")
    @DisplayName("Подсказки 'Поддержка производителя' у подарочного сертификата")
    @Tags({@Tag("ui"), @Tag("web")})
    @Story("Ozon основной")
    @Owner("valentin.gordeev")
    @Feature("UI тесты")
    void tooltipOnGiftPageTest() {
        step("Открыть раздел подарочных сертификатов", () -> {
            mainPage.open();
            mainPage.openGiftPage();
        });
        step("Кликнуть на подсказку рядом с надписью 'Только лицензионный продукт'", () -> {
            giftPage.clickOnToolTip();
        });
        step("Убедиться, что подсказка появилась", () -> {
            giftPage.checkTooltipIsVisible();
        });
    }

    @Test
    @AllureId("10052")
    @DisplayName("Выпадающие меню в разделе 'Помощь'")
    @Tags({@Tag("ui"), @Tag("web")})
    @Story("Ozon счёт")
    @Owner("valentin.gordeev")
    @Feature("UI тесты")
    void dropDownMenusOnFinancePageTest() {
        step("Открыть страницу Ozon счет", () -> {
            mainPage.open();
            mainPage.openFinance();
        });
        step("Внизу страницу открыть каждую из подсказок", () -> {
            financePage.openAllHints();
        });
        step("Проверить, что текст соответствует каждой подсказке", () -> {
            financePage.checkTextUnderHints();
        });
    }

    @Test
    @AllureId("10057")
    @DisplayName("Поиск новостей в разделе 'Новости'")
    @Tags({@Tag("ui"), @Tag("web")})
    @Story("Ozon Seller")
    @Owner("valentin.gordeev")
    @Feature("UI тесты")
    void newsOnSellerPageTest() {
        step("Открыть страницу Продавайте на Ozon", () -> {
            sellerPage.open();
        });
        step("Перейти на страницу Новости", () -> {
            sellerPage.openNews();
        });
        step("Ввести в строку поиска Аналитика", () -> {
            sellerPage.searchText(searchTextOnSellerPage);
        });
        step("Убедиться, что нашлись подходящие статьи", () -> {
            sellerPage.checkTextInNewsList(searchTextOnSellerPage);
        });
    }

    @Test
    @AllureId("10056")
    @DisplayName("Работоспособность всех кнопок 'Начать продавать'")
    @Tags({@Tag("ui"), @Tag("web")})
    @Story("Ozon Seller")
    @Owner("valentin.gordeev")
    @Feature("UI тесты")
    void allButtonsOnSellerPageTest() {
        step("Открыть страницу Продавайте на Ozon", () -> {
            sellerPage.open();
        });
        step("Вначале страницы кликнуть на кнопку 'Начать продавать'", () -> {
            sellerPage.clickFirstButton();
        });
        step("Проверить, что произошел переход на страницу и в заголовке есть текст 'Выберите страну'", () -> {
            sellerPage.checkCountrySelect();
        });
        step("Вернуться обратно на страницу из п.2", Selenide::back);
        step("Повторить п.3 со всеми кнопками на странице (их всего 4)", () -> {
            sellerPage.checkSecondThirdAndFourthButton();
        });
    }
}
