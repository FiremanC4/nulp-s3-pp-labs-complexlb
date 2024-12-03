package Company;

public class Tariff {
    String name;
    float monthlyFee; // in hrn
    int minutes;
    int sms;
    float internetGB = 0;
    int clientsCount = 0;

    public String toString(){
        String res = "Тариф: \"" + name
                   + "\", ціна: " + monthlyFee
                   + " грн, : " + minutes
                   + " хв., " + sms
                   + " смс.";
        if (clientsCount != 0) {
            res += ", " + clientsCount + " клієнтів";
        }
        if (internetGB != 0) {
            res += ", " + internetGB + " ГБ";
        }
        return res;
    }

    public Tariff(String name, float monthlyFee, int minutes, int sms) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.minutes = minutes;
        this.sms = sms;
    }

    public Tariff(String name, float monthlyFee, int minutes, int sms, int clientsCount, float internetGB, int minutesAbroad, float discount) {
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

    public float getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(float monthlyFee) {
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

    public float getInternetGB() {
        return internetGB;
    }

    public void setInternetGB(float internetGB) {
        this.internetGB = internetGB;
    }
}
