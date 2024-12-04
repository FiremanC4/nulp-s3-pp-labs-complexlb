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
        for(Tariff tariff1: tariffs)
            if (tariff1.getName().equals(tariff.getName()))
                return false;
        return tariffs.add(tariff);
    }

    public String getAllTariffs() {
        return getTariffsString(tariffs);
    }

    public static String getTariffsString(ArrayList<Tariff> tariffs) {
        String res = "";
        for (int i = 0; i < tariffs.size(); i++) {
            res += i+1 + ". " + tariffs.get(i) + "\n";
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
        ArrayList<Tariff> sortedTariffs = (ArrayList<Tariff>) tariffs.clone();
        sortedTariffs.sort(Comparator.comparingDouble(Tariff::getMonthlyFee));
        return sortedTariffs;
    }

    public ArrayList<Tariff> getFilteredTariffs(
            float minMonthlyFee, float maxMonthlyFee,
            int   minMinutes   , int   maxMinutes   ,
            int   minSms       , int   maxSms       ,
            float minInternetGB, float maxInternetGB
            ) {
        ArrayList<Tariff> filteredTariffs = new ArrayList<Tariff>();

        for (Tariff tariff : tariffs) {
            if ((minMonthlyFee == -1 || tariff.getMonthlyFee() >= minMonthlyFee) &&
                    (maxMonthlyFee == -1 || tariff.getMonthlyFee() <= maxMonthlyFee) &&
                    (minMinutes == -1 || tariff.getMinutes() >= minMinutes) &&
                    (maxMinutes == -1 || tariff.getMinutes() <= maxMinutes) &&
                    (minSms == -1 || tariff.getSms() >= minSms) &&
                    (maxSms == -1 || tariff.getSms() <= maxSms) &&
                    (minInternetGB == -1 || tariff.getInternetGB() >= minInternetGB) &&
                    (maxInternetGB == -1 || tariff.getInternetGB() <= maxInternetGB)) {
                filteredTariffs.add(tariff);
            }
        }
        return filteredTariffs;
    }

    public static void main(String[] args) {
        MobileCompany mobComp = new MobileCompany();
        mobComp.addTariff(new Tariff("a", 12, 50, 20));
        mobComp.addTariff(new Tariff("b", 46, 5, 20));
        mobComp.addTariff(new Tariff("c", 1, 50, 20));

        mobComp.getSortedTariffs();
    }

}
