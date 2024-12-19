package com.nttdata.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;
    private static Scenario scenario;

    /**
     * Retorna el driver actual.
     * @return WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("El WebDriver no está inicializado. Asegúrate de llamar a setUp() antes de usarlo.");
        }
        return driver;
    }

    /**
     * Configuración inicial del escenario.
     * @param scenario Instancia de Scenario para asociar evidencias.
     */
    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        DriverManager.scenario = scenario;
    }

    /**
     * Inicializa el WebDriver antes de cada escenario.
     */
    @Before(order = 0)
    public void setUp() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Toma un screenshot y lo adjunta al reporte del escenario.
     */
    public static void screenShot() {
        if (driver == null || scenario == null) {
            throw new IllegalStateException("El WebDriver o el Scenario no están inicializados.");
        }
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(evidencia, "image/png", "evidencia");
    }

    /**
     * Cierra el WebDriver después de cada escenario.
     */
    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
