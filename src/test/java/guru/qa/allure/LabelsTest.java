package guru.qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LabelsTest {


    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Andrew_Kim")
    @Link(value = "Testing", url = "https://testing.github.com")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Создание issue для авторизованого пользователя")
    public void testStaticLabels() {

    }

    @Test
    void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(t -> t.setName("Создание issue для авторизованого пользователя"));
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("Owner", "Andrew Kim");
        Allure.label("Severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}
