package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;
import static org.junit.Assert.assertTrue;


public class MyStoreStepdef {
    private WebDriver driver;

    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();

    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        inventorySteps(driver).navigateToCategory(categoria, subcategoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        inventorySteps(driver).addToCart(cantidad);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        boolean isPopupDisplayed = inventorySteps(driver).isProductAddedPopupDisplayed();
        assertTrue("El popup de confirmación no se muestra", isPopupDisplayed);
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        boolean isTotalCorrect = inventorySteps(driver).isTotalCalculatedCorrectly();
        assertTrue("El monto total no es correcto", isTotalCorrect);
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        inventorySteps(driver).finalizePurchase();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String title = inventorySteps(driver).getPageTitle();
        assertTrue("El título de la página del carrito no es correcto", title.contains("Carrito"));
        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        boolean isCartTotalCorrect = inventorySteps(driver).isCartTotalCorrect();
        assertTrue("El cálculo de precios en el carrito no es correcto", isCartTotalCorrect);
        screenShot();
    }
}
