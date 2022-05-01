package bokoff.il;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class GithubTestLambdaSteps {

  private static final String REPOSITORY = "Bokoff-Il/qa-guru-hw6";
  private static final String ISSUE_NUMBER = "1";

    @Test
    public void testGithubIssue(){
      SelenideLogger.addListener("allure", new AllureSelenide());

      step("Открываем главную страницу", () -> {
        open("https://github.com");
      });

      step("Ищем репозиторий " + REPOSITORY, () -> {
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY);
        $(".header-search-input").pressEnter();
      });

      step("Открываем репозиторий " + REPOSITORY, () -> {
        $(linkText(REPOSITORY)).click();
      });

      step("Жмем на Issues", () -> {
        $(partialLinkText("Issues")).click();
      });
      step("Проверяем существование issue с номером " + ISSUE_NUMBER, () -> {
        $("#issue_" + ISSUE_NUMBER + "_link").shouldBe(text("Test issue"));
      });
    }
}

