package menu.tariffsview;

import Company.MobileCompany;
import menu.MenuItem;

import java.util.Scanner;

public class SortTariffs implements MenuItem {
    Scanner scan;
    MobileCompany company;
    public SortTariffs(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {
        System.out.println(MobileCompany.getTariffsString(company.getSortedTariffs()));
    }

    @Override
    public String getName() {
        return "Посортувати тарифи";
    }
}
