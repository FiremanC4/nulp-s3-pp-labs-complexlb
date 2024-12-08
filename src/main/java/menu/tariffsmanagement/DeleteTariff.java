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
        System.out.println("Введіть назву тарифу, який ви хочете видалити:");
        String name = scan.nextLine();

        // Attempt to delete the tariff
        if (company.deleteTariff(name)) {
            System.out.println("Тариф \"" + name + "\" успішно видалено.");
        } else {
            System.out.println("Тариф \"" + name + "\" не знайдено.");
        }
    }


    @Override
    public String getName() {
        return "Видалити тариф";
    }
}
