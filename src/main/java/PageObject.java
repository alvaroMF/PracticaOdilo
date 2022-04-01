import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    private static WebDriver driver;

    PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

//    @FindBy(xpath = "//button[@data-auto-id = 'add-to-bag']")
//    public WebElement BTN_AGREGAR_CARRITO;

//    /**
//     * CARRITO
//     */
//    @FindBy(xpath = "//a[@data-auto-id = 'view-bag-desktop']")
//    public WebElement BTN_VER_CARRITO;
//
//    @FindBy(xpath = "//div[@data-auto-id = 'cart-usp-icon-usp-delivery']")
//    public WebElement LNK_DEVOLUCIONES_CAMBIO;
//
//    @FindBy(xpath = "//button[@data-auto-id = 'glass-checkout-button-right-side']")
//    public WebElement BTN_CONTINUAR;

//    /**
//     * Formulario de compra
//     */
//    @FindBy(id = "shippingAddress-firstName")
//    public WebElement INPUT_NOMBRE;
//
//    @FindBy(id = "shippingAddress-lastName")
//    public WebElement INPUT_APELLIDOS;
//
//    @FindBy(id = "shippingAddress-address1")
//    public WebElement INPUT_DIRECCION;
//
//    @FindBy(id = "shippingAddress-zipcode")
//    public WebElement INPUT_CODIGO_POSTAL;
//
//    @FindBy(id = "shippingAddress-city")
//    public WebElement INPUT_CIUDAD;
//
//    @FindBy(xpath = "//button[@data-auto-id = 'review-and-pay-button']")
//    public WebElement BTN_REVISAR_PAGAR;
//

    //    @FindBy(xpath = "//h5[@data-auto-id = 'added-to-bag-modal-title']")
//    public WebElement TXT_AGREGADO_CARRITO;
//
//    @FindBy(xpath = "//h3[@data-auto-id = 'glass-cart-title']")
//    public WebElement TXT_TU_CARRITO;
//
//    @FindBy(xpath = "//h5[@class = 'gl-heading gl-heading--no-margin gl-modal__title gl-modal__title--with-spacing-right gl-heading--m']")
//    public WebElement TXT_DEVOLUCIONES_REEMBOLSO;
//
//    @FindBy(xpath = "//h4[@data-auto-id = 'shippingAddress-heading']")
//    public WebElement TXT_INFORMACION_ENTREGA;
//
//    @FindBy(xpath = "//div[@class = 'gl-form-hint gl-form-hint--error']")
//    public WebElement TXT_ERROR_EMAIL;

    //    /**
//     * Seleccionar talla
//     * @param talla
//     * @return
//     */
//    public WebElement seleccionarTalla(String talla){
//        return driver.findElement(By.xpath("//button[@class = 'gl-label size___TqqSo']/span[text() = '"+talla+"']"));
//    }

}


