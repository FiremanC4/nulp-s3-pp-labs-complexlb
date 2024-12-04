package menu.tariffsview;

import Company.MobileCompany;
import menu.MenuItem;

import java.util.Scanner;

public class ShowTariffs implements MenuItem {
    Scanner scan;
    MobileCompany company;
    public ShowTariffs(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {
        System.out.println(company.getAllTariffs());
    }

    @Override
    public String getName() {
        return "Показати всі тарифи";
    }
}