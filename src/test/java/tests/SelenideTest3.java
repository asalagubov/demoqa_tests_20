package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest3 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop"); //Открываем https://the-internet.herokuapp.com/drag_and_drop
        $("#column-a.column").dragAndDropTo($("#column-b.column")); // Переносим прямоугольник А на место В
        $("#column-a.column").shouldHave(text("B")); //Проверяем, что прямоугольники действительно поменялись
        $("#column-b.column").shouldHave(text("A"));
    }
}