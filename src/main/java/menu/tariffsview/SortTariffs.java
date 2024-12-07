package menu.tariffsview;

import Company.MobileCompany;
import menu.MenuItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class SortTariffs implements MenuItem {
    private static final Logger logger = LogManager.getLogger(SortTariffs.class);

    Scanner scan;
    MobileCompany company;
    public SortTariffs(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {
        String res = MobileCompany.getTariffsString(company.getSortedTariffs());
        logger.info("Sorted all tariffs:\n{}\n", res);
        System.out.println(res);
    }

    @Override
    public String getName() {
        return "Посортувати тарифи";
    }
}
