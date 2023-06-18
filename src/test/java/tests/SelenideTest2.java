package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest2 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void chooseSolutionsElement() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover(); //Выбираем меню Solutions с помощью команды hover для Solutions
        $(byText("Enterprise")).click(); //Жмем Enterprize
        $(".enterprise-hero").shouldHave(text("Build like the best"));// Убедились что заголовок - "Build like the best."
    }
}