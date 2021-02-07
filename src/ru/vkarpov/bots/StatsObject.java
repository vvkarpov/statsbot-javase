package ru.vkarpov.bots;

public class StatsObject {

    private int viewCount;
    private int clickCount;
    private int ctr;
    private int bounceRate;
    private int cost;
    private int cpc;
    private int balance; //не нашел как запрашивать у АПИ

    public StatsObject(int viewCount, int clickCount, int ctr, int refusing, int expense, int cpc, int balance) {
        this.viewCount = viewCount;
        this.clickCount = clickCount;
        this.ctr = ctr;
        this.bounceRate = refusing;
        this.cost = expense;
        this.cpc = cpc;
        this.balance = balance;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public int getCtr() {
        return ctr;
    }

    public void setCtr(int ctr) {
        this.ctr = ctr;
    }

    public int getRefusing() {
        return bounceRate;
    }

    public void setRefusing(int refusing) {
        this.bounceRate = refusing;
    }

    public int getExpense() {
        return cost;
    }

    public void setExpense(int expense) {
        this.cost = expense;
    }

    public int getCpc() {
        return cpc;
    }

    public void setCpc(int cpc) {
        this.cpc = cpc;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
