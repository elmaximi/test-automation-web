package com.nttdata.steps;

import com.nttdata.page.InventoryPage;
import com.nttdata.page.MyStorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventorySteps {

    private WebDriver driver;

    //constructor
    public InventorySteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Obtener el título de la pantalla de productos
     * @return el valor del título de la pantalla de productos
     */
    public String getTitle() {
        return this.driver.findElement(InventoryPage.productsTitle).getText();
    }

    /**
     * Retorna la cantidad de items
     * @return la cantidad de items
     */
    public int getItemSize() {
        List<WebElement> items = this.driver.findElements(InventoryPage.itemsCards);
        return items.size();
    }

    /**
     * Navegar a una categoría y subcategoría específica.
     * @param categoria Nombre de la categoría.
     * @param subcategoria Nombre de la subcategoría.
     */
    public void navigateToCategory(String categoria, String subcategoria) {
        driver.findElement(MyStorePage.categoryClothes).click();
        driver.findElement(MyStorePage.subCategoryMen).click();
    }

    /**
     * Agregar una cantidad específica del primer producto al carrito.
     * @param cantidad Número de unidades a agregar.
     */
    public void addToCart(int cantidad) {
        driver.findElement(MyStorePage.selectProduct).click();
        WebElement quantityInput = driver.findElement(MyStorePage.quantityInput);
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(cantidad));
        driver.findElement(MyStorePage.addCartButton).click();
    }

    /**
     * Verifica si el popup de confirmación del producto agregado es visible.
     * @return true si el popup está visible, false en caso contrario.
     */
    public boolean isProductAddedPopupDisplayed() {
        WebElement popup = driver.findElement(By.id("cart-popup"));
        return popup.isDisplayed() && popup.getText().contains("Producto agregado");
    }

    /**
     * Verifica si el monto total del popup está calculado correctamente.
     * @return true si el monto total es mayor a 0, false en caso contrario.
     */
    public boolean isTotalCalculatedCorrectly() {
        WebElement totalElement = driver.findElement(By.id("totalPrice"));
        String totalText = totalElement.getText().replace("$", "");
        double total = Double.parseDouble(totalText);
        return total > 0;
    }

    /**
     * Finaliza la compra haciendo clic en el botón de checkout.
     */
    public void finalizePurchase() {
        driver.findElement(By.id("checkoutButton")).click();
    }

    /**
     * Retorna el título de la página actual.
     * @return Título de la página.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Verifica si el cálculo total en el carrito es correcto.
     * @return true si el total es mayor a 0, false en caso contrario.
     */
    public boolean isCartTotalCorrect() {
        WebElement cartTotal = driver.findElement(By.id("cart-total"));
        String cartTotalText = cartTotal.getText().replace("$", "");
        double total = Double.parseDouble(cartTotalText);
        return total > 0;
    }
}
