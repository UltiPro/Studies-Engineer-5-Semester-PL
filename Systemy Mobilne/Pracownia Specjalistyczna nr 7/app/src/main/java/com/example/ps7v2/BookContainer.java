package com.example.ps7v2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookContainer {
    @SerializedName("docs")
    private List<Book> bookList;

    public List<Book> getBookList(){
        return bookList;
    }
    void setBookList(List<Book> bookList){
        this.bookList = bookList;
    }
}
