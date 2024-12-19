package com.nttdata.page;

import org.openqa.selenium.By;

public class MyStorePage {
    //Localizadores de elementos
    public static By iniciarSesion = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a");
    public static By email = By.xpath("//*[@id=\"field-email\"]");
    public static By password = By.xpath("//*[@id=\"field-password\"]");
    public static By loginButton = By.xpath("//*[@id=\"submit-login\"]");

    public static By categoryClothes = By.xpath("//*[@id=\"category-3\"]/a");
    public static By subCategoryMen = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");

    public static By selectProduct = By.xpath(" //*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a");
    public static By quantityInput = By.xpath("//*[@id=\"quantity_wanted\"]");
    public static By addCartButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button\n");






}
