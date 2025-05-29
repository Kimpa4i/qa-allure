package guru.qa.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://www.github.com");
    }


    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".search-input").click();
        $(".QueryBuilder-StyledInput").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(By.linkText(repo)).click();

    }

//    @Step
//    public void openIssueStep() {
//    }


    @Step("Проверяем наличие ссылки {link}")
    public void shouldSeeLink(String link) {
        $(withText(link)).should(Condition.exist);

    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
