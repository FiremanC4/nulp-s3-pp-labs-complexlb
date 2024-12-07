package menu.tariffsmanagement;

import Company.MobileCompany;
import Company.Tariff;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteTariffTest {
    private MobileCompany company;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("Basic", 99.99f, 100, 50));
        tariffs.add(new Tariff("Premium", 199.99f, 500, 200));
        company = new MobileCompany(tariffs);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private void simulateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testDeleteExistingTariff() {
        simulateInput("Basic\n");

        DeleteTariff deleteTariff = new DeleteTariff(new Scanner(System.in), company);
        deleteTariff.execute();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Тариф \"Basic\" успішно видалено."));

        ArrayList<Tariff> tariffs = company.getTariffs();
        assertEquals(1, tariffs.size());
        assertEquals("Premium", tariffs.get(0).getName());
    }

    @Test
    public void testDeleteNonExistingTariff() {
        simulateInput("NonExistent\n");

        DeleteTariff deleteTariff = new DeleteTariff(new Scanner(System.in), company);
        deleteTariff.execute();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Тариф \"NonExistent\" не знайдено."));

        ArrayList<Tariff> tariffs = company.getTariffs();
        assertEquals(2, tariffs.size());
        assertEquals("Basic", tariffs.get(0).getName());
        assertEquals("Premium", tariffs.get(1).getName());
    }
}
