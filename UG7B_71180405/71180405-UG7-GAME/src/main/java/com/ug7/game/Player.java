package com.ug7.game;

public class Player {
    private String username, password;
    private int level = 1;

    public Player(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void levelUp() {
        this.level += 1;
    }

    public int getLevel() {
        return level;
    }
}