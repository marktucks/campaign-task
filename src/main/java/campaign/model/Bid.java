package campaign.model;

import java.io.Serializable;

public class Bid implements Serializable {

    private static final long serialVersionUID=2L;

    private Campaign campaign;
    private float winningPrice;
    private String currency;

    public Bid() {
    }

    public Bid(float winningPrice, String currency) {
        this.winningPrice = winningPrice;
        this.currency = currency;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public float getWinningPrice() {
        return winningPrice;
    }

    public void setWinningPrice(float winningPrice) {
        this.winningPrice = winningPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
