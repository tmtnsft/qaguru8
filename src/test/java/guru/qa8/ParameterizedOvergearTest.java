package guru.qa8;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ParameterizedOvergearTest {

    @CsvSource(value = {
            "//*[@id=\"sections-products\"]/div/div[1]/div/a[5]/div, Path of Exile Offers",
            "//*[@id=\"sections-products\"]/div/div[1]/div/a[4]/div, Destiny 2 Offers",
            "//*[@id=\"sections-products\"]/div/div[1]/div/a[10]/div, New World Offers"
    })
    @ParameterizedTest(name = "Поиск {1} в Overgear")
    void csvSearchOvergearTest(String testData, String expectedResult) {
        Selenide.open("https://overgear.com/");
        $(byXpath(testData)).click();
        $("#sections-products").shouldHave(text(expectedResult));
        sleep(2000);
    }
}
