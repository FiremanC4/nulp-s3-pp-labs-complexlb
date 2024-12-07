package menu.tariffsview;

import Company.MobileCompany;
import menu.MenuItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ShowTariffs implements MenuItem {
    private static final Logger logger = LogManager.getLogger(ShowTariffs.class);

    Scanner scan;
    MobileCompany company;
    public ShowTariffs(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {
        logger.info("Shown all tariffs:\n{}\n", company.getAllTariffs());
        System.out.println(company.getAllTariffs());
    }

    @Override
    public String getName() {
        return "Показати всі тарифи";
    }
}