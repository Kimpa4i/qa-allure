package guru.qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String LINK = ".github/workflows";

    //Хуже переиспользуемость,но больше читаемость

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://www.github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input").click();
            $(".QueryBuilder-StyledInput").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();

        });
        step("Проверяем наличие ссылки " + LINK, () -> {
            $(withText(LINK)).should(Condition.exist);

        });
    }

    //Круче переиспользуемость,но меньше читаемость

    //Без опыта лучше использовать этот подход
    @Test
    void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
//        steps.openIssueStep();
        steps.shouldSeeLink(LINK);


    }
}
