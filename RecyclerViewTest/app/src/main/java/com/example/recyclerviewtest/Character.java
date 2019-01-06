package com.example.recyclerviewtest;

public class Character {
    private String characterName;
    private int characterImage;

    public Character(String characterName, int characterImage) {
        this.characterImage = characterImage;
        this.characterName = characterName;
    }

    public String getName() {
        return this.characterName;
    }

    public int getImage() {
        return this.characterImage;
    }
}
