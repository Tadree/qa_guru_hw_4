package ru.jiehk;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsPageTests {

    @Test
    void jUnit5ExampleTest(){
        open("https://github.com/");
        $("[placeholder=\"Search GitHub\"]").setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("#wiki-tab").click();
//        $("#wiki-pages-filter").setValue("A");
        $(".wiki-more-pages-link button").click();
        $(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
