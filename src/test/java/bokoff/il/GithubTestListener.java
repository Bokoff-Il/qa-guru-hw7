package bokoff.il;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class GithubTestListener {

    @Test
    public void testGithubIssue(){
      SelenideLogger.addListener("allure", new AllureSelenide());
      open("https://github.com");

      $(".header-search-input").click();
      $(".header-search-input").setValue("Bokoff-Il/qa-guru-hw6");
      $(".header-search-input").pressEnter();

      $(linkText("Bokoff-Il/qa-guru-hw6")).click();
      $(partialLinkText("Issues")).click();
      $(withText("#1")).click();
    }
}

