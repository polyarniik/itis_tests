package ru.itis.safiullin.miniplan.hw6.settings;

public class Settings {
    String email;
    String password;
    String baseUrl;

    public Settings() {
    }

    public Settings(String email, String password, String baseUrl) {
        this.email = email;
        this.password = password;
        this.baseUrl = baseUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
