package com.uendel.prestashop;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Set;

public class CookieUtils {
    private static final String COOKIE_FILE = "cookies.txt";

    public static void saveCookies(WebDriver driver) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COOKIE_FILE))) {
            for (Cookie cookie : driver.manage().getCookies()) {
                writer.write(cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" +
                        cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadCookies(WebDriver driver) {
        File file = new File(COOKIE_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                String value = parts[1];
                String domain = parts[2];
                String path = parts[3];
                String expiry = parts[4];
                boolean isSecure = Boolean.parseBoolean(parts[5]);

                Cookie cookie = new Cookie.Builder(name, value)
                        .domain(domain)
                        .path(path)
                        .isSecure(isSecure)
                        .build();

                driver.manage().addCookie(cookie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
