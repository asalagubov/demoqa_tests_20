package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedTestBase {
    @BeforeAll
    static void beforeAll() {
        pageLoadStrategy = "eager";
        browserSize = "1920x1080";
    }
    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
