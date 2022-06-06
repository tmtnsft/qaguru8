package guru.qa8.lesson;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class ParameterizedLessonTest {

    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach");
    }

//  @ValueSource(strings = {"Selenide", "Allure", "JUnit"})
    @CsvSource(value = {
            "Selenide, фреймворк для автоматизированного тестирования веб-приложений",
            "JUnit, JUnit team’s statement on the war in Ukraine"
    })
    @ParameterizedTest(name = "Тестирование поиска {0} через Яндекс")
    void commonSearchTest(String testData, String expectedResult) {
        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item").first().shouldHave(Condition.text(expectedResult));
    }

    static Stream<Arguments> commonSearchTestDataProvider() {
        return Stream.of(
                Arguments.of("Selenide", false, List.of("1", "2")),
                Arguments.of("JUnit", false, List.of("3", "4"))
        );
    }
    @MethodSource("commonSearchTestDataProvider")
    @ParameterizedTest(name = "MethodSource тестирование поиска {0} через Яндекс")
    void commonSearchDataTest(String testData, boolean flag, List<String> list) {
        System.out.println("Flag: " + flag);
        System.out.println("List: " + list);

        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item").first().shouldHave(Condition.text(testData));
    }
}
