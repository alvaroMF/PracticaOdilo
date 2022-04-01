import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementosComunes {
    private static WebDriver driver;

    ElementosComunes(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Cerrar cualquier PopUp
     */
    @FindBy(xpath = "//button[@class = 'gl-modal__close']")
    public WebElement BTN_CERRAR_POPUP;

    /**
     * Aceptar Cookies
     */
    @FindBy(xpath = "//button[@data-auto-id = 'glass-gdpr-default-consent-accept-button']")
    public WebElement BTN_ACEPTAR_COOKIES;

}
