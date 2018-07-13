package com.example.uorszula.popularmovie;

public class Movie {
    private String imageMv;
    private String title;
    private String dataRelease;
    private String rate;

    public Movie(String imageMv, String title, String dataRelease, String rate){
        this.imageMv = imageMv;
        this.title = title;
        this.dataRelease = dataRelease;
        this.rate = rate;
    }

    public Movie(){}

    public String getDataRelease() {
        return dataRelease;
    }

    public String getRate() {
        return rate;
    }

    public String getTitle() {
        return title;
    }

    public String getImageMv() {
        return imageMv;
    }

    public void setDataRelease(String dataRelease) {
        this.dataRelease = dataRelease;
    }

    public void setImageMv(String imageMv) {
        this.imageMv = imageMv;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
