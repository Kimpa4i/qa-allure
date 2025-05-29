package guru.qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String LINK = ".github/workflows";

    //Хуже переиспользуемость,но больше читаемость

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://www.github.com");
            attachment("Source", webdriver().driver().source());
        });

    }

    //Круче переиспользуемость,но меньше читаемость

    //Без опыта лучше использовать этот подход
    @Test
    void testAnnotatedAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.takeScreenshot();


    }
}
