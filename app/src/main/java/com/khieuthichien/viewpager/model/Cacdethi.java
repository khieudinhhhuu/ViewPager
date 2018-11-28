package com.khieuthichien.viewpager.model;

public class Cacdethi {
    private String tencacdethi;
    private int anhcacdethi;

    public Cacdethi(String tencacdethi, int anhcacdethi) {
        this.tencacdethi = tencacdethi;
        this.anhcacdethi = anhcacdethi;
    }

    public Cacdethi() {
    }

    public String getTencacdethi() {
        return tencacdethi;
    }

    public void setTencacdethi(String tencacdethi) {
        this.tencacdethi = tencacdethi;
    }

    public int getAnhcacdethi() {
        return anhcacdethi;
    }

    public void setAnhcacdethi(int anhcacdethi) {
        this.anhcacdethi = anhcacdethi;
    }
}
