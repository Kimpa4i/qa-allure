package guru.qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Exist;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://www.github.com");
        $(".search-input").click();
        $(".QueryBuilder-StyledInput").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").submit();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $(withText(".github/workflows")).should(Condition.exist);
        sleep(1000);
    }
}
