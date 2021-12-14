package com.example.scrimishcardgame;

public class Card {

    String name;
    int value;
    int picture;

    public Card() {

    }

    public Card(String name, int value, int picture) {
        this.name = name;
        this.value = value;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
