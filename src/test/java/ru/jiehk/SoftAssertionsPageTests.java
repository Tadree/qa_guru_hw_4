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
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
