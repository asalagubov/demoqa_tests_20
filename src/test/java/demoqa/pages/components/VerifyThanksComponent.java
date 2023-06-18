package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerifyThanksComponent {

    String thanksText = "Thanks for submitting the form";
    SelenideElement

            tableResp = $(".table-responsive"),

    thankText = $(byText(thanksText));

    public void verifyThankText() {
        thankText.shouldBe(visible);
    }

    public void verifyResult(String key, String value) {
        tableResp.$(byText(key)).parent().shouldHave(text(value));
    }
}

