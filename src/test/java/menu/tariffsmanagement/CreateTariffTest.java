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

public class CreateTariffTest {
    private MobileCompany company;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        company = new MobileCompany(new ArrayList<>());
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private void simulateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testCreateTariffSuccess() {
        simulateInput("SuperPlan\n199.99\n500\n100\n20\n50\n");

        CreateTariff createTariff = new CreateTariff(new Scanner(System.in), company);
        createTariff.execute();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Новий тариф успішно додано:"));
        System.out.println(output);
        assertTrue(output, output.contains("Тариф: \"SuperPlan\", ціна: 199.99 грн, 500 хв., 100 смс., 50 клієнтів, 20 ГБ"));

        ArrayList<Tariff> tariffs = company.getTariffs();
        assertEquals(1, tariffs.size());
        Tariff addedTariff = tariffs.get(0);
        assertEquals("SuperPlan", addedTariff.getName());
        assertEquals(199.99f, addedTariff.getMonthlyFee(), 0.0);
        assertEquals(500, addedTariff.getMinutes());
        assertEquals(100, addedTariff.getSms());
        assertEquals(20f, addedTariff.getInternetGB(), 0.0);
        assertEquals(50, addedTariff.getClientsCount());
    }

    @Test
    public void testCreateTariffFailureDuplicate() {
        company.addTariff(new Tariff("SuperPlan", 199.99, 500, 100, 50, 20));

        simulateInput("SuperPlan\n199.99\n500\n100\n20\n50\n");

        CreateTariff createTariff = new CreateTariff(new Scanner(System.in), company);
        createTariff.execute();

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Не вдалося додати тариф."));

        ArrayList<Tariff> tariffs = company.getTariffs();
        assertEquals(1, tariffs.size());
    }
}
