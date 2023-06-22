package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class ParametrizedTestBase {
        @BeforeAll
        static void beforeAll() {
        Configuration.baseUrl = "https://dodopizza.ru/moscow";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    }
}
