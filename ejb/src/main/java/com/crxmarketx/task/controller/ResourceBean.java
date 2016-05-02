package com.crxmarketx.task.controller;


import javax.ejb.Stateless;

/**
 * Created by Roman on 02.05.2016.
 */
@Stateless
public class ResourceBean implements Resource {


    public Integer postArray(String json) {
        System.out.println(json);
        return 5;
    }

    public String getBook(String isbn) {
        return "Book";
    }

}
