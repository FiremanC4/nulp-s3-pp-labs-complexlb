package menu.tariffsview;

import Company.MobileCompany;
import Company.Tariff;
import menu.MenuItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class FilterTariffs implements MenuItem {
    private static final Logger logger = LogManager.getLogger(ShowTariffs.class);

    Scanner scan;
    MobileCompany company;
    public FilterTariffs(Scanner scan, MobileCompany company) {
        this.scan = scan;
        this.company = company;
    }

    @Override
    public void execute() {
        logger.debug("Started to filter tariffs");
        System.out.println("Параметри для фільтрації:");
        System.out.println("1. Місячна плата");
        System.out.println("2. Кількість хвилин");
        System.out.println("3. Кількість SMS");
        System.out.println("4. Кількість ГБ Інтернету");
        System.out.println("Введіть номери параметрів через пробіл, які ви хочете використовувати для фільтрації (наприклад: 1 3):");

        String textFilters = scan.nextLine();
        logger.debug("Selected filters: {}", textFilters);
        String[] filters = textFilters.split(" ");
        for (int i = 0; i < filters.length; i++) {
            filters[i] = filters[i].trim();
        }

        float minMonthlyFee = -1, maxMonthlyFee = -1;
        int minMinutes = -1, maxMinutes = -1;
        int minSms = -1, maxSms = -1;
        float minInternetGB = -1, maxInternetGB = -1;

        System.out.println("По черзі вводьте діапазони в форматі \"мін макс\", -1 для пропуску (наприклад: 200 -1) ");
        for (String filter : filters) {
            switch (filter.trim()) {
                case "1":
                    System.out.println("Місячної плати:");
                    String[] feeRange = scan.nextLine().split(" ");
                    minMonthlyFee = Float.parseFloat(feeRange[0]);
                    maxMonthlyFee = Float.parseFloat(feeRange[1]);
                    logger.debug("Selected fee in range from {} to {}", minMonthlyFee, maxMonthlyFee);
                    break;
                case "2":
                    System.out.println("Кількості хвилин:");
                    String[] minuteRange = scan.nextLine().split(" ");
                    minMinutes = Integer.parseInt(minuteRange[0]);
                    maxMinutes = Integer.parseInt(minuteRange[1]);
                    logger.debug("Selected minutes in range from {} to {}", minMinutes, maxMinutes);
                    break;
                case "3":
                    System.out.println("Кількості SMS:");
                    String[] smsRange = scan.nextLine().split(" ");
                    minSms = Integer.parseInt(smsRange[0]);
                    maxSms = Integer.parseInt(smsRange[1]);
                    logger.debug("Selected sms in range from {} to {}", minSms, maxSms);
                    break;
                case "4":
                    System.out.println("Кількості ГБ Інтернету:");
                    String[] internetRange = scan.nextLine().split(" ");
                    minInternetGB = Float.parseFloat(internetRange[0]);
                    maxInternetGB = Float.parseFloat(internetRange[1]);
                    logger.debug("Selected GB in range from {} to {}", minInternetGB, maxInternetGB);
                    break;
                default:
                    System.out.println("Неправильний номер параметра: " + filter.trim());
                    logger.debug("Incorrect parameter: {}", filter.trim());
            }
        }

        ArrayList<Tariff> filteredTariffs = company.getFilteredTariffs(
                minMonthlyFee, maxMonthlyFee,
                minMinutes   , maxMinutes   ,
                minSms       , maxSms       ,
                minInternetGB, maxInternetGB
                );

        if (filteredTariffs.isEmpty()) {
            System.out.println("Жоден тариф не відповідає заданим параметрам.");
            logger.warn("No tariff with selected filters");
        } else {
            String filteredTariffsString = MobileCompany.getTariffsString(filteredTariffs);
            logger.info("Filtered tariffs:\n{}\n", filteredTariffsString);
            System.out.println(filteredTariffsString);
        }
    }


    @Override
    public String getName() {
        return "Фільтрувати тарифи";
    }
}
