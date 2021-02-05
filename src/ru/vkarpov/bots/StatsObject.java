package ru.vkarpov.bots;

public class StatsObject {

    private int viewCount;
    private int clickCount;
    private int ctr;
    private int refusing;
    private int expense;
    private int cpc;
    private int balance;

    public StatsObject(int viewCount, int clickCount, int ctr, int refusing, int expense, int cpc, int balance) {
        this.viewCount = viewCount;
        this.clickCount = clickCount;
        this.ctr = ctr;
        this.refusing = refusing;
        this.expense = expense;
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
        return refusing;
    }

    public void setRefusing(int refusing) {
        this.refusing = refusing;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
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
