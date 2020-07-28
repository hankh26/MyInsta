package com.hh1995.myinsta;

public class HomeItem {
    String id;
    String msg;
    String file;

    int like;

    public HomeItem() {
    }

    public HomeItem(String id,  String msg, String file,int like) {
        this.id = id;
        this.msg = msg;
        this.file= file;
        this.like= like;
    }
}
