package Company;

public class Tariff {
    String name;
    double monthlyFee; // in hrn
    int minutes;
    int sms;
    int internetGB = 0;
    int clientsCount = 0;

    public String toString() {
        String res = "Тариф: \"" + name
                   + "\", ціна: " + String.format("%.2f", monthlyFee) + " грн, "
                   + minutes + " хв., "
                   + sms + " смс.";
        if (clientsCount != 0) {
            res += ", " + clientsCount + " клієнтів";
        }
        if (internetGB != 0) {
            res += ", " + internetGB + " ГБ";
        }
        return res;
    }

    public Tariff(String name, double monthlyFee, int minutes, int sms) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.minutes = minutes;
        this.sms = sms;
    }

    public Tariff(String name, double monthlyFee, int minutes, int sms, int clientsCount, int internetGB) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.minutes = minutes;
        this.sms = sms;
        this.clientsCount = clientsCount;
        this.internetGB = internetGB;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSms() {
        return sms;
    }

    public int getClientsCount() {
        return clientsCount;
    }

    public int getInternetGB() {
        return internetGB;
    }

}