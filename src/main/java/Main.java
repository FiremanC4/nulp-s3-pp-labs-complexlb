import Company.MobileCompany;
import menu.MenuItem;
import menu.tariffsmanagement.CreateTariff;
import menu.tariffsmanagement.DeleteTariff;
import menu.tariffsview.CountUsers;
import menu.tariffsview.FilterTariffs;
import menu.tariffsview.ShowTariffs;
import menu.tariffsview.SortTariffs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MobileCompany company = new MobileCompany();
        new Main(scan, company);
    }

    public Main(Scanner scan, MobileCompany company) {
        Map<Integer, MenuItem> MenuMap = new LinkedHashMap<>();
        MenuMap.put(1, new ShowTariffs(scan, company));
        MenuMap.put(2, new CreateTariff(scan, company));
        MenuMap.put(3, new DeleteTariff(scan, company));
        MenuMap.put(4, new SortTariffs(scan, company));
        MenuMap.put(5, new FilterTariffs(scan, company));
        MenuMap.put(6, new CountUsers(scan, company));


        while (true){
            showMenu(MenuMap);
            try {
                int choice = Integer.parseInt(scan.nextLine());

                if (choice == 0) {
                    break;
                }

                MenuItem command = MenuMap.get(choice);
                if (command != null) {
                    command.execute();
                    continue;
                }
            } catch (NumberFormatException _) {}
            System.out.println("Неправильний формат!");

        }

    }

    private static void showMenu(Map<Integer, MenuItem> MenuMap) {
        System.out.println("\nМеню:");
        for (Map.Entry<Integer, MenuItem> entry : MenuMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
        System.out.println("0: Вихід");
        System.out.print("Виберіть дію: ");
    }
}
