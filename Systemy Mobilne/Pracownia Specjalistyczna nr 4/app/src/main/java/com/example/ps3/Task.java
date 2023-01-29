package com.example.ps3;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID id;
    private  String name;
    private Date date;
    private boolean done;
    private Category category;

    public Task(){
        id = UUID.randomUUID();
        date = new Date();
        done = false;
        name = "";
        category = Category.Home;
    }

    public boolean isDone(){
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public UUID getId(){
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) { this.date = date; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }
}
