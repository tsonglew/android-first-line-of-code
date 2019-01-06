package com.example.uibestpractice;

public class Msg {

    static final int TYPE_RECEIVED = 0;

    static final int TYPE_SENT = 1;

    private String content;

    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public boolean sent() {
        return type == TYPE_SENT;
    }
}
