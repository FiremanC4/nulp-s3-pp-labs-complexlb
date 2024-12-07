import Company.MobileCompany;
import Company.Tariff;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainTest {
    private MobileCompany company;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        company = new MobileCompany();
        company.addTariff(new Tariff("Basic", 50, 50, 5));
        company.addTariff(new Tariff("Business", 400, 3000, 50, 40, 30));

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testCreateTariff() {

        String userInput = "2\nSuper\n200\n100\n20\n15\n350\n0\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        new Main(scanner, company);

        String output = outputStream.toString();
        assertTrue(output, output.contains("Новий тариф успішно додано"));
        assertTrue(output, output.contains("Super"));
    }

    @Test
    public void testDeleteTariff() {

        String userInput = "3\nBasic\n0\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        new Main(scanner, company);

        String output = outputStream.toString();
        assertTrue(output, output.contains("Тариф \"Basic\" успішно видалено."));
    }

    @Test
    public void testFilterTariffs() {

        String userInput = "5\n1\n50 200\n0\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        new Main(scanner, company);

        String output = outputStream.toString();
        assertTrue(output, output.contains("Basic"));
        assertFalse(output, output.contains("Business"));
    }

    @Test
    public void testSortTariffs() {

        String userInput = "4\n0\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        new Main(scanner, company);

        String output = outputStream.toString();
        assertTrue(output, output.contains("Basic"));
        assertTrue(output, output.contains("Business"));
    }

    @Test
    public void testCountUsers() {

        String userInput = "6\n0\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        new Main(scanner, company);

        String output = outputStream.toString();
        assertTrue(output, output.contains("Загальна кількість користувачів"));
    }

    @Test
    public void testOutOfRangeInput() {

        String userInput = "500\n0\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        new Main(scanner, company);

        String output = outputStream.toString();
        assertTrue(output, output.contains("Неправильний формат!"));
    }

    @Test
    public void testInvalidInput() {

        String userInput = "abc\n0\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        new Main(scanner, company);

        String output = outputStream.toString();
        assertTrue(output, output.contains("Неправильний формат!"));
    }
}
