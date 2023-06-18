package tests;

import com.github.javafaker.Faker;
import demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import java.util.Locale;
import static utils.RandomUtils.*;

public class DemoqaTestsFaker extends TestBase {

        RegistrationPage registrationPage = new RegistrationPage();
        Faker faker = new Faker(new Locale("en"));

    String  firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            gender = getRandomGender(),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = getRandomMonth(),
            year = String.valueOf(getRandomInt(1900, 2100)),
            subject = getRandomSubject(),
            hobbies1 = getRandomHobbies(),
           // hobbies2 = getRandomHobbiestwo(),
            address = faker.address().fullAddress(),
            state = getRandomState(),
            city = getRandomCity(state),
            fileName = "3x.png";


        @Test
        void successTest() {

            registrationPage
                    .openPage()
                    .closeBanners()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(email)
                    .setGender(gender)
                    .setUserNumber(phoneNumber)
                    .setBirthDay(day, month, year)
                    .setSubjects(subject)
                    .setHobbies(hobbies1)
                    //.setHobbiestwo(hobbies2)
                    .setUploadPicture(fileName)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .setSubmit();

            registrationPage
                    .verifyThanksText()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", email)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", phoneNumber)
                    .verifyResult("Date of Birth", day + " " + month + "," + year)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobbies1) //+ ", " + hobbies2)
                    .verifyResult("Picture",  fileName)
                    .verifyResult("Address", address)
                    .verifyResult("State and City", state + " " + city);
        }

}
