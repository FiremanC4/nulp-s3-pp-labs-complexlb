package menu.tariffsmanagement;

import Company.MobileCompany;
import Company.Tariff;
import menu.MenuItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CreateTariff implements MenuItem {
    private static final Logger logger = LogManager.getLogger(CreateTariff.class);

    Scanner scan;
    MobileCompany company;
    public CreateTariff(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {
        logger.debug("Started to creating tariff");
        System.out.println("Створення нового тарифу");
        System.out.println("Назва тарифу:");
        String name = scan.nextLine();

        System.out.println("Місячна плата (грн):");
        double monthlyFee = Float.parseFloat(scan.nextLine());

        System.out.println("Кількість хвилин:");
        int minutes = Integer.parseInt(scan.nextLine());

        System.out.println("Кількість SMS:");
        int sms = Integer.parseInt(scan.nextLine());

        System.out.println("Кількість ГБ Інтернету (0, якщо немає):");
        int internetGB = Integer.parseInt(scan.nextLine());

        System.out.println("Кількість клієнтів (0, якщо немає):");
        int clientsCount = Integer.parseInt(scan.nextLine());

        Tariff newTariff = new Tariff(name, monthlyFee, minutes, sms, clientsCount, internetGB);

        if (company.addTariff(newTariff)) {
            logger.info("added new tariff: {}", newTariff);
            System.out.println("Новий тариф успішно додано:");
            System.out.println(newTariff);
        } else {
            logger.error("Failed to added new tariff: {}", newTariff);
            System.out.println("Не вдалося додати тариф.");
        }
    }

    @Override
    public String getName() {
        return "Створити тариф";
    }
}
