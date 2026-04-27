package org.example.warehouse;

public class DataVectorStats {

    private final int min;
    private final int max;
    private final int sum;

    public DataVectorStats(int min, int max, int sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }

    public int getSum(){
        return sum;
    }

    @Override
    public String toString(){
        return "Stats:\nMin: " + min + "\nMax: " + max + "\nSum: " + sum;
    }
}
