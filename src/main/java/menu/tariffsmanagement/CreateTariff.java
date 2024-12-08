package menu.tariffsmanagement;

import Company.MobileCompany;
import menu.MenuItem;

import java.util.Scanner;

public class CreateTariff implements MenuItem {

    Scanner scan;
    MobileCompany company;
    public CreateTariff(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return "Створити тариф";
    }
}
