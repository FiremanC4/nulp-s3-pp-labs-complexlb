package menu.tariffsview;

import Company.MobileCompany;
import Company.Tariff;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

public class SortTariffsTest {
    private MobileCompany company;
    private SortTariffs sortTariffs;
    private Scanner scanner;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("Premium", 200, 1000, 200));
        tariffs.add(new Tariff("Basic", 100, 500, 100));
        tariffs.add(new Tariff("Standard", 150, 750, 150));
        company = new MobileCompany(tariffs);

        scanner = new Scanner(System.in);

        sortTariffs = new SortTariffs(scanner, company);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testExecuteSortsTariffs() {
        sortTariffs.execute();

        String output = outputStream.toString().trim();

        String expectedOutput =
                "1. Тариф: \"Basic\", ціна: 100.00 грн, 500 хв., 100 смс.\n" +
                        "2. Тариф: \"Standard\", ціна: 150.00 грн, 750 хв., 150 смс.\n" +
                        "3. Тариф: \"Premium\", ціна: 200.00 грн, 1000 хв., 200 смс.";

        assertTrue("Output should match the sorted tariffs", output.contains(expectedOutput));
    }

    @Test
    public void testExecuteWithNoTariffs() {
        company = new MobileCompany(new ArrayList<>());
        sortTariffs = new SortTariffs(scanner, company);

        outputStream.reset();

        sortTariffs.execute();

        String output = outputStream.toString().trim();
        assertTrue("Expected output to be empty for no tariffs", output.isEmpty());
    }
}
