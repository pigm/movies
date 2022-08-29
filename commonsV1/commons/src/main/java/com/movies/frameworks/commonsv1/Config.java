package com.movies.frameworks.commonsv1;

public class Config {
    private static Config instance;
    private static String baseUrl;

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        Config.baseUrl = baseUrl;
    }

    public static Config init() {
        if (instance == null)
            instance = new Config();
        return instance;
    }
}