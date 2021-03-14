package ru.vkarpov.bots.model;

public class Stats {

    private String impressions;
    private String clicks;
    private String ctr;
    private String bounceRate;
    private String cost;
    private String avgCPC;

    public Stats(){}

    public void setImpressions(String impressions) {
        this.impressions = impressions;
    }

    public void setClicks(String clicks) {
        this.clicks = clicks;
    }

    public void setCtr(String ctr) {
        this.ctr = ctr;
    }

    public void setBounceRate(String bounceRate) {
        this.bounceRate = bounceRate;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setAvgCPC(String avgCPC) {
        this.avgCPC = avgCPC;
    }

    public String getImpressions() {
        return impressions;
    }

    public String getClicks() {
        return clicks;
    }

    public String getCtr() {
        return ctr;
    }

    public String getBounceRate() {
        return bounceRate;
    }

    public String getCost() {
        return cost;
    }

    public String getAvgCPC() {
        return avgCPC;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "impressions='" + impressions + '\'' +
                ", clicks='" + clicks + '\'' +
                ", ctr='" + ctr + '\'' +
                ", bounceRate='" + bounceRate + '\'' +
                ", cost='" + cost + '\'' +
                ", avgCPC='" + avgCPC + '\'' +
                '}';
    }
}