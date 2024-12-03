package Company;

import java.util.ArrayList;
import java.util.Comparator;

public class MobileCompany {
    ArrayList<Tariff> tariffs;

    public MobileCompany(ArrayList<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    public MobileCompany() {
        this.tariffs = new ArrayList<Tariff>();
    }

    public boolean deleteTariff(String name) {
        return tariffs.removeIf(tariff -> tariff.getName().equals(name));
    }

    public boolean addTariff(Tariff tariff) {
        return tariffs.add(tariff);
    }

    public String getAllTariffs() {
        String res = "";
        for (int i = 0; i < tariffs.size(); i++) {
            res += i + ". " + tariffs.get(i) + "\n";
        }
        return res;
    }

    public int getClientCount() {
        int res = 0;
        for (Tariff tariff : tariffs) {
            res += tariff.getClientsCount();
        }
        return res;
    }

    public ArrayList<Tariff> getSortedTariffs() {
        // Clone the original list to avoid modifying it
        ArrayList<Tariff> sortedTariffs = (ArrayList<Tariff>) tariffs.clone();

        // Sort the cloned list by a specific attribute (e.g., cost)
        sortedTariffs.sort(Comparator.comparingDouble(Tariff::getMonthlyFee));

        // Print the sorted tariffs
        for (int i = 0; i < sortedTariffs.size(); i++) {
            System.out.println(i + ". " + sortedTariffs.get(i));
        }

        return sortedTariffs;
    }

    public static void main(String[] args) {
        MobileCompany mobComp = new MobileCompany();
        mobComp.addTariff(new Tariff("a", 12, 50, 20));
        mobComp.addTariff(new Tariff("b", 46, 50, 20));
        mobComp.addTariff(new Tariff("c", 1, 50, 20));

        mobComp.getSortedTariffs();
    }

}
