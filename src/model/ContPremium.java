package model;

public class ContPremium extends Utilizator {
    private String cardBancar;
    private String dataExpirare;

    public ContPremium(String username, String cardBancar, String dataExpirare) {
        super(username, true); // true = este premium
        this.cardBancar = cardBancar;
        this.dataExpirare = dataExpirare;
    }

    public String getCardBancar() {
        return cardBancar;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    @Override
    public String toString() {
        return getUsername() + " (Premium cu card: " + cardBancar + ")";
    }
}
