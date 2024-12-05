package Company;

public class Tariff {
    String name;
    double monthlyFee; // in hrn
    int minutes;
    int sms;
    double internetGB = 0;
    int clientsCount = 0;

    public String toString(){
        String res = "Тариф: \"" + name
                   + "\", ціна: " + monthlyFee + " грн, "
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

    public Tariff(String name, double monthlyFee, int minutes, int sms, int clientsCount, double internetGB) {
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

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getClientsCount() {
        return clientsCount;
    }

    public void setClientsCount(int clientsCount) {
        this.clientsCount = clientsCount;
    }

    public double getInternetGB() {
        return internetGB;
    }

    public void setInternetGB(double internetGB) {
        this.internetGB = internetGB;
    }
}
