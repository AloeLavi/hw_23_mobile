package tests.browserstack;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideSearchTests extends TestBase {

    @Test
    void searchArticleTest() {
        back();
        step("Нажать на Search Wikipedia", () -> {
             $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        });
        step("Ввести Twin Peaks", () -> {
             $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Twin Peaks");
             $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        });
        step("Открыть статью Twin Peaks", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
            $(AppiumBy.className("android.view.View")).click();
            $(AppiumBy.className("android.widget.TextView")).shouldHave(text("Twin Peaks"));
        });
    }
}