package menu.tariffsmanagement;

import Company.MobileCompany;
import menu.MenuItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DeleteTariff implements MenuItem {
    private static final Logger logger = LogManager.getLogger(DeleteTariff.class);

    Scanner scan;
    MobileCompany company;
    public DeleteTariff(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {
        logger.debug("Started to deleting tariff");
        System.out.println("Введіть назву тарифу, який ви хочете видалити:");
        String name = scan.nextLine();

        // Attempt to delete the tariff
        if (company.deleteTariff(name)) {
            logger.info("deleted tariff: {}", name);
            System.out.println("Тариф \"" + name + "\" успішно видалено.");
        } else {
            logger.error("failed to delete tariff: {}", name);
            System.out.println("Тариф \"" + name + "\" не знайдено.");
        }
    }


    @Override
    public String getName() {
        return "Видалити тариф";
    }
}
