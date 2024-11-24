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

    boolean deleteTariff(String name) {
        int idx = -1;
        for (int i = 0; i < tariffs.size(); i++) {
            if (tariffs.get(i).getName().equals(name)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return false;
        }
        tariffs.remove(idx);
        return true;
    }


}
