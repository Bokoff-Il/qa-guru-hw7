package bokoff.il;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class GithubTestAnnotatedSteps {

  private static final String REPOSITORY = "Bokoff-Il/qa-guru-hw6";
  private static final String ISSUE_NUMBER = "1";

    @Test
    public void testGithubIssue(){
      SelenideLogger.addListener("allure", new AllureSelenide());
      WebSteps steps = new WebSteps();

      steps.openMainPage();
      steps.searchRepository(REPOSITORY);
      steps.clickOnRepositoryLink(REPOSITORY);
      steps.openIssuesTab();
      steps.checkIssueWithNumber(ISSUE_NUMBER);
    }
}

