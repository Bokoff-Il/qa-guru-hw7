package bokoff.il;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class GithubTestListener {

  private static final String REPOSITORY = "Bokoff-Il/qa-guru-hw6";
  private static final String ISSUE_NUMBER = "1";

    @Test
    public void testGithubIssue(){
      SelenideLogger.addListener("allure", new AllureSelenide());
      open("https://github.com");

      $(".header-search-input").click();
      $(".header-search-input").setValue(REPOSITORY);
      $(".header-search-input").pressEnter();

      $(linkText(REPOSITORY)).click();
      $(partialLinkText("Issues")).click();
      $("#issue_" +ISSUE_NUMBER+"_link").shouldBe(text("Test issue"));
    }
}

