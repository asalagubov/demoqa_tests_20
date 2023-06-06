package demoqa;


import org.junit.jupiter.api.Test;
import demoqa.pages.RegistrationPage;

public class DemoqaTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successTest() {

        registrationPage
                .openPage()
                .setFirstName("Александр")
                .setLastName("Ваш")
                .setUserEmail("test@mail.ru")
                .setGender("Other")
                .setUserNumber("9999999999")
                .setBirthDay("01", "0", "1997")
                .setSubjects("Arts")
                .setHobbies("Music", "Sports")
                .setUploadPicture("3x.png")
                .setAddress("Москва, Украинский бульвар, д. 6")
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit();

        registrationPage
                .verifyThanksText()
                .verifyResult("Student Name", "Александр Ваш")
                .verifyResult("Student Email", "test@mail.ru")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "9999999999")
                .verifyResult("Date of Birth", "01 January,1997")
                .verifyResult("Subjects", "Arts")
                .verifyResult("Hobbies", "Music, Sports")
                .verifyResult("Picture", "3x.png")
                .verifyResult("Address", "Москва, Украинский бульвар, д. 6")
                .verifyResult("State and City", "Александр Ваш")
                .verifyResult("Student Name", "Александр Ваш")
                .verifyResult("Student Name", "NCR Delhi");
    }
}