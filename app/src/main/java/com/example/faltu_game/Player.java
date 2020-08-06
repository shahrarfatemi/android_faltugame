package com.example.faltu_game;

public class Player {
    public void setName(String name) {
        this.name = name;
    }

    public Player() {
    }

    String name;
    int score;
    int highScore;

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public Player(String name, int score, int highScore) {
        this.name = name;
        this.score = score;
        this.highScore = highScore;
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
