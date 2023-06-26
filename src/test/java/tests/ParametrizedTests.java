package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedTests  extends ParametrizedTestBase {

    @ValueSource(strings = {"Пицца", "Закуски"})
    @ParameterizedTest(name = "Отображение заголовка при переходе в меню {0}")
    void headerMenuValues(String value) {
        open(baseUrl);
        $$("a[data-menu-block]").findBy(text(value)).click();
        $(".title").shouldHave(text(value));
    }
}