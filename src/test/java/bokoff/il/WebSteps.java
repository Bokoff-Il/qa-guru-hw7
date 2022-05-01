package bokoff.il;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebSteps {

  @Step("Открываем главную страницу")
  public void openMainPage(){
    open("https://github.com");
  }

  @Step("Ищем репозиторий {repo}")
  public void searchRepository(String repo){
      $(".header-search-input").click();
      $(".header-search-input").setValue(repo);
      $(".header-search-input").pressEnter();
  }

  @Step("Открываем репозиторий {repo}")
  public void clickOnRepositoryLink(String repo){
    $(linkText(repo)).click();
  }

  @Step("Жмем на Issues")
  public void openIssuesTab(){
    $(partialLinkText("Issues")).click();
  }

  @Step("Проверяем имя issue с номером {number}")
  public void checkIssueWithNumber(String number){
    $("#issue_" + number + "_link").shouldBe(text("Test issue"));
    attachScreenshot();
  }

  @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
  public byte[] attachScreenshot(){
    return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }
}
