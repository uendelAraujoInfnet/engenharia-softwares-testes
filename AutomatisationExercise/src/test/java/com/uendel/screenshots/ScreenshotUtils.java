package com.uendel.screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {

    public static void takeFullPageScreenshot(WebDriver driver, String filePath) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        saveFile(src, filePath);
    }

    public static void takeElementScreenshot(WebElement element, String filePath) {
        File src = element.getScreenshotAs(OutputType.FILE);
        saveFile(src, filePath);
    }

    private static void saveFile(File src, String filePath) {
        try {
            File dest = new File(filePath);
            dest.getParentFile().mkdirs(); // cria diretórios, se não existirem
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot salva em: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
