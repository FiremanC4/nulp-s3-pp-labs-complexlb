package menu.tariffsview;

import Company.MobileCompany;
import Company.Tariff;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class CountUsersTest {
    private MobileCompany company;
    private Scanner scanner;
    private CountUsers countUsers;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("Basic", 100, 500, 100, 20, 5));
        tariffs.add(new Tariff("Premium", 200, 1000, 200, 50, 10));
        company = new MobileCompany(tariffs);

        scanner = new Scanner(System.in);
        countUsers = new CountUsers(scanner, company);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        outputStream.reset();

    }

    @Test
    public void testExecute() {
        countUsers.execute();

        assertEquals("Загальна кількість користувачів усіх тарифів: 70", outputStream.toString().trim());
    }

    @Test
    public void testExecuteWithNoUsers() {
        company = new MobileCompany(new ArrayList<>());
        countUsers = new CountUsers(scanner, company);

        countUsers.execute();

        String expectedOutput = "Загальна кількість користувачів усіх тарифів: 0";
        assertEquals("Загальна кількість користувачів усіх тарифів: 0", outputStream.toString().trim());
    }

}
