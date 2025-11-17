import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTests {

    @BeforeAll
    static void beforAll(){
        Configuration.browserSize="1980x1080";
        Configuration.baseUrl="https://demoqa.com/";
        Configuration.pageLoadStrategy="eager";
    }

    @Test
    void fillInFileds(){

        open("/automation-practice-form");
        $("#firstName").setValue("Saten");
        $("#lastName").setValue("Asatryan");
        $("#userEmail").setValue("tester@gmail.com");
        $(byText("Female")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1980");
        $("div.react-datepicker__day--06").click();




       // $("#amount").setValue("1005");
       // $("#category").setValue("Education_5");
       // $("#save").click();
      //  $("[placeholder=Search").setValue("Education_5").pressEnter();
      //  $("tbody").$("tr").shouldHave(text("Education_5")).shouldHave(text("1005"));
        sleep(5000L);
      //  $("#submit").click();
       // $("#userNumber").setValue("8978449393)


    }
}

