import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.time.Duration;

class OmegaTest {

    private Omega omega;

    @BeforeEach
    void initializeProcessor() {
        omega = new Omega();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("_-_-_-_-_-_-_-");
    }

    @Test
    @DisplayName("Тест поиска слова с максимальным количеством букв 'и'")
    void findWordWithMostLettersI_ShouldReturnWordWithMostI_WhenInputContainsI() {
        String result = omega.findWordWithMostLettersI("Иииии иван инна икс");
        assertEquals("Иииии", result, "Должно найти 'Иииии'");
        System.out.println("Тест пройден");
    }

    @Disabled("Тест временно отключён")
    @Test
    @DisplayName("Тест поиска максимальной суммы диагоналей матрицы")
    void calculateMaxDiagonalSum_ShouldReturnMaxDiagonalSum_WhenMatrixIsGiven() {
        int[][] matrix = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};
        assertEquals(150, omega.calculateMaxDiagonalSum(matrix));
        assertTimeout(Duration.ofMillis(120), () -> {
            omega.calculateMaxDiagonalSum(matrix);
        });
        System.out.println("Тест пройден");
    }

    @ParameterizedTest
    @CsvSource({
            "hello world, HW",
            "java programming, JP",
            "unit test, UT",
            "system design, SD"
    })
    @DisplayName("Тест извлечения заглавных инициалов из строки")
    void getUpperCaseInitials_ShouldReturnUpperCaseInitials_WhenInputHasWords(String inputText, String expectedInitials) {
        assertEquals(expectedInitials, omega.getUpperCaseInitials(inputText));
        System.out.println("Тест пройден");
    }

    @Test
    @DisplayName("Тест обработки null в методе getUpperCaseInitials")
    void getUpperCaseInitials_ShouldThrowException_WhenInputIsNull() {
        assertThrows(NullPointerException.class, () -> {
            omega.getUpperCaseInitials(null);
        });
    }
}