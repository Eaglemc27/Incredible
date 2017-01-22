package com.yorel.incredible.core;

public class Config {
    public static String BASE_URL = System.getProperty("url", "http://localhost:8080/");
    //Available browsers: Chrome, Firefox, IE, Edge
    public static String BROWSER = System.getProperty("browser", "Chrome");

    public static long TIMEOUT = Long.parseLong(System.getProperty("timeout", "5000"));
    public static long POOLING_INTERVAL = Long.parseLong(System.getProperty("pooling.interval", "100"));
}
