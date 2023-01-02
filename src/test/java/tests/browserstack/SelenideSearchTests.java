package tests.browserstack;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearchTests extends TestBase {

    @Test
    void successSearchTest() {
        back();
        $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Twin Peaks");
        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        $(AppiumBy.className("android.widget.TextView")).shouldHave(text("Twin Peaks"));
    }
}