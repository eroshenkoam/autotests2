package io.eroshenkoam.autotests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

/**
 * @author Artem Eroshenko.
 */
public class GoogleTest {

    @Before
    public void initAllureLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    public void testGoogleSearch() {
        open("https://google.com");
        $x("//input[@name='q']").sendKeys("Яндекс");
        $x("//input[@name='q']").submit();
        $x("//div[@id='rso']//h3")
                .should(Condition.visible)
                .should(text("Яндекс"));
    }

}
