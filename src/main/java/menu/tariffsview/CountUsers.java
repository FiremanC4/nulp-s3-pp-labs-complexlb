package menu.tariffsview;

import Company.MobileCompany;
import menu.MenuItem;
import menu.tariffsmanagement.DeleteTariff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CountUsers implements MenuItem {
    private static final Logger logger = LogManager.getLogger(CountUsers.class);

    Scanner scan;
    MobileCompany company;
    public CountUsers(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {
        int totalUsers = company.getClientCount();
        logger.info("Counted users count: {}", totalUsers);
        System.out.println("Загальна кількість користувачів усіх тарифів: " + totalUsers);
    }

    @Override
    public String getName() {
        return "Порахувати користувачів";
    }
}
