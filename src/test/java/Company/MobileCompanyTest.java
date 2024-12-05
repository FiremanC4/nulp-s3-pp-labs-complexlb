package Company;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
//import org.mockito.Mockito;


public class MobileCompanyTest {
    private MobileCompany company;
    private Tariff testtariff;
    private String stringResult;
    private boolean booleanResult;
    private int intResult;

    @Before
    public void setUp() {
        company = new MobileCompany();
    }

    @Test
    public void testDeleteTariff() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 1, 1, 1));
        tariffs.add(new Tariff("b", 1, 1, 1));
        company = new MobileCompany(tariffs);

        booleanResult = company.deleteTariff("a");
        stringResult = company.getAllTariffs();

        assertTrue(booleanResult);
        assertEquals("1. Тариф: \"b\", ціна: 1.0 грн, 1 хв., 1 смс.\n", stringResult);
    }

    @Test
    public void testDeleteNotExistingTariff() {
        booleanResult = company.deleteTariff("a");
        stringResult = company.getAllTariffs();

        assertFalse(booleanResult);
        assertEquals("", stringResult);
    }

    @Test
    public void testAddTariff() {
        testtariff = new Tariff("lol", 1_999_999.99, 60, 20);

        booleanResult = company.addTariff(testtariff);
        stringResult = company.getAllTariffs();

        assertTrue(booleanResult);
        assertEquals("1. Тариф: \"lol\", ціна: 1999999.99 грн, 60 хв., 20 смс.\n", stringResult);
    }

    @Test
    public void testAddExistingTariff() {
        testtariff = new Tariff("lol", 1_999_999.99, 60, 20);

        booleanResult = company.addTariff(testtariff);
        assertTrue(booleanResult);

        booleanResult = company.addTariff(testtariff);
        stringResult = company.getAllTariffs();

        assertFalse(booleanResult);
        assertEquals("1. Тариф: \"lol\", ціна: 1999999.99 грн, 60 хв., 20 смс.\n", stringResult);
    }

    @Test
    public void testAddLongTariff() {
        testtariff = new Tariff("lol", 1_999_999.99, 60, 20, 1, 1);

        booleanResult = company.addTariff(testtariff);
        stringResult = company.getAllTariffs();

        assertTrue(booleanResult);
        assertEquals("1. Тариф: \"lol\", ціна: 1999999.99 грн, 60 хв., 20 смс., 1 клієнтів, 1.0 ГБ\n", stringResult);

    }

    @Test
    public void testGetAllTariffsEmpty() {
        stringResult = company.getAllTariffs();
        assertEquals("", stringResult);

    }

    @Test
    public void testGetAllTariffs() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 1, 1, 1));
        tariffs.add(new Tariff("b", 1, 1, 1));
        company = new MobileCompany(tariffs);

        stringResult = company.getAllTariffs();

        assertEquals("1. Тариф: \"a\", ціна: 1.0 грн, 1 хв., 1 смс.\n2. Тариф: \"b\", ціна: 1.0 грн, 1 хв., 1 смс.\n", stringResult);

    }

    @Test
    public void testGetTariffsString() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 1, 1, 1));
        tariffs.add(new Tariff("b", 1, 1, 1));

        stringResult = MobileCompany.getTariffsString(tariffs);

        assertEquals("1. Тариф: \"a\", ціна: 1.0 грн, 1 хв., 1 смс.\n2. Тариф: \"b\", ціна: 1.0 грн, 1 хв., 1 смс.\n", stringResult);
    }
    @Test
    public void testGetTariffsStringEmpty() {
        ArrayList<Tariff> tariffs = new ArrayList<>();

        stringResult = MobileCompany.getTariffsString(tariffs);

        assertEquals("", stringResult);
    }

    @Test
    public void testGetClientCount() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 1, 1, 1, 25, 4));
        tariffs.add(new Tariff("b", 1, 1, 1, 20, 4));

        company = new MobileCompany(tariffs);
        intResult = company.getClientCount();

        assertEquals(45, intResult);

    }

    @Test
    public void testGetSortedTariffs() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 10, 1, 1));
        tariffs.add(new Tariff("b", 1, 1, 1));
        company = new MobileCompany(tariffs);

        stringResult = company.getAllTariffs();
        assertEquals("1. Тариф: \"a\", ціна: 10.0 грн, 1 хв., 1 смс.\n2. Тариф: \"b\", ціна: 1.0 грн, 1 хв., 1 смс.\n", stringResult);

        stringResult = MobileCompany.getTariffsString(company.getSortedTariffs());
        assertEquals("1. Тариф: \"b\", ціна: 1.0 грн, 1 хв., 1 смс.\n2. Тариф: \"a\", ціна: 10.0 грн, 1 хв., 1 смс.\n", stringResult);
    }

    @Test
    public void testFilterByMonthlyFee() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 10, 100, 50, 10, 5.0f));
        tariffs.add(new Tariff("b", 20, 200, 100, 20, 10.0f));
        tariffs.add(new Tariff("c", 30, 300, 150, 30, 15.0f));
        company = new MobileCompany(tariffs);

        ArrayList<Tariff> result = company.getFilteredTariffs(15, 25, -1, -1, -1, -1, -1, -1);
        assertEquals(1, result.size());
        assertEquals("b", result.get(0).getName());
    }

    @Test
    public void testFilterByMinutes() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 10, 100, 50, 10, 5.0f));
        tariffs.add(new Tariff("b", 20, 200, 100, 20, 10.0f));
        tariffs.add(new Tariff("c", 30, 300, 150, 30, 15.0f));
        company = new MobileCompany(tariffs);

        ArrayList<Tariff> result = company.getFilteredTariffs(-1, -1, 150, 250, -1, -1, -1, -1);
        assertEquals(1, result.size());
        assertEquals("b", result.get(0).getName());
    }

    @Test
    public void testFilterBySms() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 10, 100, 50, 10, 5.0f));
        tariffs.add(new Tariff("b", 20, 200, 100, 20, 10.0f));
        tariffs.add(new Tariff("c", 30, 300, 150, 30, 15.0f));
        company = new MobileCompany(tariffs);

        ArrayList<Tariff> result = company.getFilteredTariffs(-1, -1, -1, -1, 75, 125, -1, -1);
        assertEquals(1, result.size());
        assertEquals("b", result.get(0).getName());
    }

    @Test
    public void testFilterByInternet() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 10, 100, 50, 10, 5.0f));
        tariffs.add(new Tariff("b", 20, 200, 100, 20, 10.0f));
        tariffs.add(new Tariff("c", 30, 300, 150, 30, 15.0f));
        company = new MobileCompany(tariffs);

        ArrayList<Tariff> result = company.getFilteredTariffs(-1, -1, -1, -1, -1, -1, 8.0f, 12.0f);
        assertEquals(1, result.size());
        assertEquals("b", result.get(0).getName());
    }

    @Test
    public void testFilterByCombinedParameters() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 10, 100, 50, 10, 5.0f));
        tariffs.add(new Tariff("b", 20, 200, 100, 20, 10.0f));
        tariffs.add(new Tariff("c", 30, 300, 150, 30, 15.0f));
        company = new MobileCompany(tariffs);

        ArrayList<Tariff> result = company.getFilteredTariffs(10, 30, 100, 300, 50, 150, 5.0f, 15.0f);
        assertEquals(3, result.size());
        assertEquals("a", result.get(0).getName());
        assertEquals("b", result.get(1).getName());
        assertEquals("c", result.get(2).getName());
    }

    @Test
    public void testFilterNoMatches() {
        ArrayList<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new Tariff("a", 10, 100, 50, 10, 5.0f));
        tariffs.add(new Tariff("b", 20, 200, 100, 20, 10.0f));
        tariffs.add(new Tariff("c", 30, 300, 150, 30, 15.0f));
        company = new MobileCompany(tariffs);

        ArrayList<Tariff> result = company.getFilteredTariffs(40, 50, -1, -1, -1, -1, -1, -1);
        assertEquals(0, result.size());
    }

}