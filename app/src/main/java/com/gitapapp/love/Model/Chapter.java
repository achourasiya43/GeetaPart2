package com.gitapapp.love.Model;

public class Chapter {
    String text, sanskrit;

    public Chapter(){}

    public Chapter(String text, String sanskrit) {
        this.text = text;
        this.sanskrit = sanskrit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSanskrit() {
        return sanskrit;
    }
}
