package guru.qa8.lesson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс с тестами, проверяющими 3 и 2")
public class SimpleTest {

    @Test
    @DisplayName("Тест на проверку 3<2")
    @Disabled
    void test1() {
        Assertions.assertTrue(3<2);
    }

    @Test
    @DisplayName("Тест на проверку 3<2")
    void test2() {
        Assertions.assertTrue(3>2);
    }
}
