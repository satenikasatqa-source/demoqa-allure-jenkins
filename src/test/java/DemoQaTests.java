import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 60000;

    }

    @Test
    void fillInFields() {

        open("/automation-practice-form");



        $("#firstName").shouldBe(visible).setValue("Ivana");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("tester@gmail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("9876543210");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Hiking");
        $(byText("Reading")).click();
        $("#currentAddress").setValue("Yerevan some street");
        $("#uploadPicture").uploadFromClasspath("For DemoQaTests.jpeg");
        $("#state").scrollIntoView(true).click();
        $(byText("NCR")).shouldBe(visible).click();
        $("#city").scrollIntoView(true).click();
        $(byText("Noida")).shouldBe(visible).click();
        $("#submit").click();






        $(".table-responsive table")
                .shouldHave(text("Ivana"))
                .shouldHave(text("Ivanova"))
                .shouldHave(text("Female"))
                .shouldHave(text("06 January,1980"))
                .shouldHave(text("Hiking"))
                .shouldHave(text("Reading"))
                .shouldHave(text("Yerevan some street"))
                .shouldHave(text("For DemoQaTests.jpeg"))
                .shouldHave(text("NCR Noida"));

        sleep(5000L);







    }
}