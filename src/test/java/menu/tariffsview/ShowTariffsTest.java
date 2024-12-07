package menu.tariffsview;

import Company.MobileCompany;
import Company.Tariff;
import menu.MenuItem;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class ShowTariffsTest {
    private MobileCompany company;
    private Scanner scanner;
    private MenuItem menuItem;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("Basic", 100, 500, 100, 20, 5));
        tariffs.add(new Tariff("Premium", 200, 1000, 200, 50, 10));
        company = new MobileCompany(tariffs);

        scanner = new Scanner(System.in);
        menuItem = new ShowTariffs(scanner, company);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputStream.reset();
    }

    @Test
    public void testExecute() {
        menuItem.execute();

        assertEquals("1. Тариф: \"Basic\", ціна: 100.00 грн, 500 хв., 100 смс., 20 клієнтів, 5 ГБ\n" +
                "2. Тариф: \"Premium\", ціна: 200.00 грн, 1000 хв., 200 смс., 50 клієнтів, 10 ГБ", outputStream.toString().trim());
    }
}