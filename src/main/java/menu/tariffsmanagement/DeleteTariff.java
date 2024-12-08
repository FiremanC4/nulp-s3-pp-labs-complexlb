package menu.tariffsmanagement;

import Company.MobileCompany;
import menu.MenuItem;

import java.util.Scanner;

public class DeleteTariff implements MenuItem {

    Scanner scan;
    MobileCompany company;
    public DeleteTariff(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {

    }


    @Override
    public String getName() {
        return "Видалити тариф";
    }
}
