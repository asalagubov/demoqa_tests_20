package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedTests extends ParametrizedTestBase {
    @DisplayName("Поиск статей в Wikipedia.org")
    @ValueSource(strings = {"McDonald’s", "Burger King"})
    @ParameterizedTest(name = "Проверка результата поиска для запроса {0}")
    void wikipediaSearchTest(String testData) {
        open("https://ru.wikipedia.org/");
        $("#searchInput").setValue(testData);
        $("#searchButton").click();
        $(".mw-page-title-main").shouldHave(text(testData));
    }


    static Stream<Arguments> getTopicCategories() {
        return Stream.of(
                Arguments.of("Женский", List.of("Звёзды" + "Психология" + "Еда" + "Любовь" + "Здоровье" + "Красота" + "Мода" + "Дети" + "Дом и сад")),
                Arguments.of("Финансы", List.of("Экономика", "Компании", "Рынки Личный","счет", "Недвижимость", "Импортозамещение", "Курсы валют", "Конвертер валют", "Ещё")));
    }

    @ParameterizedTest(name = "Соответствие списка категорий заданному топику {0}")
    @MethodSource("getTopicCategories")
    public void categoryShouldBeOpenAfterClick(String categoryName, List<String> buttonName) {
        open("https://www.rambler.ru/");
        $(".rc__XaSn3 li").$(byText(categoryName)).click();
        $$("._3Ufez li").filter(visible).shouldHave(texts(buttonName));
    }


    @CsvSource({
            "Java, Java[прим. 1] — строго типизированный объектно-ориентированный язык программирования",
            "Oracle,  Oracle (Oracle Corporation) — американская корпорация, второй по размеру выручки разработчик программного обеспечения"
    })
    @ParameterizedTest(name = "При вводе в поиск {0} на старнице присутствует текст {1}")
    @DisplayName("Проверка поиска статьи на wikipedia")

    void successfulSearchTextTest(String testData) {
        open("https://ru.wikipedia.org/");
        $("#searchInput").setValue(testData);
        $("#searchButton").click();
        $(".mw-page-title-main").shouldHave(text(testData));
    }



}