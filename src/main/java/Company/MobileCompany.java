package Company;

import java.util.ArrayList;

public class MobileCompany {
    ArrayList<Tariff> tariffs;

    public MobileCompany(ArrayList<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    public MobileCompany() {
        this.tariffs = new ArrayList<Tariff>();
    }

    public boolean deleteTariff(String name) {
        return false;
    }

    public boolean addTariff(Tariff tariff) {
        return false;
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
        return 0;
    }

    public ArrayList<Tariff> getSortedTariffs() {
        return tariffs;
    }

    public ArrayList<Tariff> getFilteredTariffs(){
        return tariffs;
    }

    public ArrayList<Tariff> getTariffs() {
        return tariffs;
    }
}
