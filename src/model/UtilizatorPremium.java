package model;

public class UtilizatorPremium extends Utilizator {
    private String cardBancar;
    private String dataExpirare;

    public UtilizatorPremium(String username, String cardBancar, String dataExpirare) {
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
