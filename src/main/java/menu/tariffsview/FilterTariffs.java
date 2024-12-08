package menu.tariffsview;

import Company.MobileCompany;
import menu.MenuItem;

import java.util.Scanner;

public class FilterTariffs implements MenuItem {

    Scanner scan;
    MobileCompany company;
    public FilterTariffs(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {

    }


    @Override
    public String getName() {
        return "Фільтрувати тарифи";
    }
}
