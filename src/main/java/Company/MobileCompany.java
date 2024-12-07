package Company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;

public class MobileCompany {
    ArrayList<Tariff> tariffs;
    private static final Logger logger = LogManager.getLogger(MobileCompany.class);


    public MobileCompany(ArrayList<Tariff> tariffs) {
        this.tariffs = tariffs;
        logger.debug("initialized MobileCompany with tariffs:\n{}", getAllTariffs());
    }

    public MobileCompany() {
        this.tariffs = new ArrayList<Tariff>();
        logger.debug("initialized MobileCompany with no tariffs");
    }

    public boolean deleteTariff(String name) {
        logger.debug("Trying to delete tariff \"{}\"", name);
        return tariffs.removeIf(tariff -> tariff.getName().equals(name));
    }

    public boolean addTariff(Tariff tariff) {
        logger.debug("Trying to add tariff: {}", tariff);
        for(Tariff tariff1: tariffs)
            if (tariff1.getName().equals(tariff.getName())) {
                logger.debug("Failed to add tariff. Tariff with same name exist: {}", tariff.getName());
                return false;
            }
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
        logger.debug("Starting filtering with provided parameters: {} {}, {} {}, {} {}, {} {}",
                minMonthlyFee, maxMonthlyFee,
                minMinutes   , maxMinutes   ,
                minSms       , maxSms       ,
                minInternetGB, maxInternetGB
                );
        ArrayList<Tariff> filteredTariffs = new ArrayList<Tariff>();
        if (
             minMonthlyFee == -1 && maxMonthlyFee == -1
          && minMinutes    == -1 && maxMinutes    == -1
          && minSms        == -1 && maxSms        == -1
          && minInternetGB == -1 && maxInternetGB == -1
            ) {
            return filteredTariffs;
        }

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

    public ArrayList<Tariff> getTariffs() {
        return tariffs;
    }
}
