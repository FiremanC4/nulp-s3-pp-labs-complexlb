package menu.tariffsview;

import Company.MobileCompany;
import Company.Tariff;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilterTariffsTest {
    private MobileCompany company;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("Basic", 99.99f, 100, 50, 0, 10));
        tariffs.add(new Tariff("Premium", 199.99f, 500, 200, 0, 50));
        tariffs.add(new Tariff("Standard", 149.99f, 300, 100, 0, 30));
        company = new MobileCompany(tariffs);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private void simulateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testFilterByMonthlyFee() {
        simulateInput("1\n100 150\n");

        FilterTariffs filterTariffs = new FilterTariffs(new Scanner(System.in), company);
        filterTariffs.execute();

        String output = outputStream.toString().trim();
        assertTrue(output, output.contains("Standard"));
        assertFalse(output, output.contains("Basic"));
        assertFalse(output, output.contains("Premium"));
    }

    @Test
    public void testFilterByMinutes() {
        simulateInput("2\n200 400\n");

        FilterTariffs filterTariffs = new FilterTariffs(new Scanner(System.in), company);
        filterTariffs.execute();

        String output = outputStream.toString().trim();
        assertTrue(output, output.contains("Standard"));
        assertFalse(output, output.contains("Basic"));
        assertFalse(output, output.contains("Premium"));
    }

    @Test
    public void testFilterBySms() {
        simulateInput("3\n-1 100\n");

        FilterTariffs filterTariffs = new FilterTariffs(new Scanner(System.in), company);
        filterTariffs.execute();

        String output = outputStream.toString().trim();
        assertTrue(output, output.contains("Basic"));
        assertFalse(output, output.contains("Premium"));
        assertTrue(output, output.contains("Standard"));
    }
    @Test
    public void testFilterByGb() {
        simulateInput("4\n20 -1\n");

        FilterTariffs filterTariffs = new FilterTariffs(new Scanner(System.in), company);
        filterTariffs.execute();

        String output = outputStream.toString().trim();
        assertFalse(output, output.contains("Basic"));
        assertTrue(output, output.contains("Premium"));
        assertTrue(output, output.contains("Standard"));
    }

    @Test
    public void testFilterByMultipleCriteria() {
        simulateInput("1 2\n100 200\n100 500\n");

        FilterTariffs filterTariffs = new FilterTariffs(new Scanner(System.in), company);
        filterTariffs.execute();

        String output = outputStream.toString().trim();
        assertFalse(output, output.contains("Basic"));
        assertTrue(output, output.contains("Premium"));
        assertTrue(output, output.contains("Standard"));
    }

    @Test
    public void testFilterNoResults() {
        simulateInput("1\n300 400\n");

        FilterTariffs filterTariffs = new FilterTariffs(new Scanner(System.in), company);
        filterTariffs.execute();

        String output = outputStream.toString().trim();
        assertTrue(output, output.contains("Жоден тариф не відповідає заданим параметрам."));
    }

    @Test
    public void testInvalidFilterInput() {
        simulateInput("5\n");

        FilterTariffs filterTariffs = new FilterTariffs(new Scanner(System.in), company);
        filterTariffs.execute();

        String output = outputStream.toString().trim();
        assertTrue(output, output.contains("Неправильний номер параметра"));
    }
}
