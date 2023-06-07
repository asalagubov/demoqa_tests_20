package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionsTest {

    @Test
    void verifyJUnit5CodeExample() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

        //открыть страницу Selenide в Github:
        open("https://github.com/selenide/selenide");
        //перейти в раздел Wiki проекта:
        $("#wiki-tab").click();
        //убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").sendKeys("sof");
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("SoftAssertions"));
        //открыть страницу SoftAssertions
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        //проверить что внутри есть пример кода для JUnit5
        $("#wiki-content .markdown-body")
                .$$("div pre")
                .findBy(text("@ExtendWith({SoftAssertsExtension.class})"))
                .shouldHave(text("""
                        class Tests {
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                                               
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                        }"""));

    }
}
