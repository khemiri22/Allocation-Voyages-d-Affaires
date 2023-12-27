package com.example.demo.Entities;

public class Agent {
    private String Username;
    private String Password;
    private String Type;

    public Agent(String username, String password, String type) {
        Username = username;
        Password = password;
        Type = type;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}
