package com.example.ps7v2;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    @SerializedName("title")
    private String title;
    @SerializedName("author_name")
    private List<String> authors;
    @SerializedName("cover_i")
    private String cover;
    @SerializedName("number_of_pages_median")
    private String numberOfPages;
    @SerializedName("language")
    private List<String> languages;
    @SerializedName("time")
    private List<String> times;

    public String getTitle(){
        return this.title;
    }
    void setTitle(String title){
        this.title = title;
    }

    public List<String> getAuthors(){
        return this.authors;
    }
    void setAuthors(List<String> authors){
        this.authors = authors;
    }

    public String getCover(){
        return this.cover;
    }
    void setCover(String cover){
        this.cover = cover;
    }

    public String getNumberOfPages(){
        return this.numberOfPages;
    }
    void setNumberOfPages(String numberOfPages){
        this.numberOfPages = numberOfPages;
    }

    public List<String> getLanguages() {
        return languages;
    }
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getTimes() {
        return times;
    }
    public void setTimes(List<String> times) {
        this.times = times;
    }
}
