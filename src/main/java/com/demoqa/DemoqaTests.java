package com.demoqa;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = " https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void successTest() {

            open("/automation-practice-form");

            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");

            $("#firstName").setValue("Александр");
            $("#lastName").setValue("Ваш");
            $("#userEmail").setValue("test@mail.ru");
            $("#genterWrapper").$(byText("Other")).click();
            $("#userNumber").setValue("9999999999");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOptionByValue("0");
            $(".react-datepicker__year-select").selectOptionByValue("1997");
            $(".react-datepicker__day--001").click();
            $("#subjectsInput").setValue("A");
            $(byText("Arts")).click();
            $("#hobbiesWrapper").$(byText("Music")).click();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("3x.png");
            $("#currentAddress").setValue("Москва, Украинский бульвар, д. 6");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#submit").click();

           $(".modal-header").shouldHave(text("Thanks for submitting the form"));
           $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Александр Ваш"));
           $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@mail.ru"));
           $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
           $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9999999999"));
           $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("01 January,1997"));
           $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
           $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music, Sports"));
           $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("3x.png"));
           $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Москва, Украинский бульвар, д. 6"));
           $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));

        }


}