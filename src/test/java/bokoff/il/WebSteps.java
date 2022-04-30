package bokoff.il;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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

  @Step("Проверяем существование issue с номером {number}")
  public void shouldBeIssueWithNumber(String number){
    $(withText(number)).click();
    attachScreenshot();
  }

  @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
  public byte[] attachScreenshot(){
    return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }
}
