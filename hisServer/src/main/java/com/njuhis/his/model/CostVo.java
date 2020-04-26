package com.njuhis.his.model;

public class CostVo {
    private double sum;
    private int count;
    private long begintime;
    private long endtime;
    public CostVo(){

    }

    public CostVo(double sum, int count, long begintime, long endtime) {

        this.sum = sum;
        this.count = count;
        this.begintime = begintime;
        this.endtime = endtime;
    }



    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getBegintime() {
        return begintime;
    }

    public void setBegintime(long begintime) {
        this.begintime = begintime;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }
}
