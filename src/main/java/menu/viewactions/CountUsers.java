package menu.viewactions;

import Company.MobileCompany;
import menu.MenuItem;

import java.util.Scanner;

public class CountUsers implements MenuItem {
    Scanner scan;
    MobileCompany company;
    public CountUsers(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return "Порахувати користувачів";
    }
}
