import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValoracionProducto {
    private static WebDriver driver;

    ValoracionProducto(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Valoraciones y Reseñas
     */
    @FindBy(xpath = "//button[@data-auto-id = 'ratings-stack-write-review']")
    public WebElement LNK_ESCRIBIR_RESENA;

    @FindBy(id = "reviewtext")
    public WebElement TXTAREA_OPINION;

    @FindBy(id = "title")
    public WebElement INPUT_RESUMEN_RESENA;

    @FindBy(xpath = "//input[@data-auto-id = 'photo-upload']")
    public WebElement INPUT_CARGAR_IMAGEN;

    @FindBy(id = "usernickname")
    public WebElement INPUT_APODO;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement BTN_ENVIAR_RESENA;

    /**
     * Seleccionar una valoración general
     * @param valoracion
     * @return
     */
    public WebElement seleccionarValoracionGeneral(String valoracion){
        return driver.findElement(By.xpath("//div[@data-auto-id = 'overall']/label[@for = 'star-overall-"+valoracion+"']"));
    }

    /**
     * Seleccionar recomendacion del producto
     * @param recomendado
     * @return
     */
    public WebElement seleccionarRecomendacionProducto(String recomendado){
        return driver.findElement(By.xpath("//input[@class = 'gl-radio-input__input'][@value = '"+recomendado+"']/.."));
    }

    public WebElement seleccionarTallaAcorde(String tallaAcorde){
        return driver.findElement(By.xpath("//div[@data-auto-id = 'rating_Size']/div/label/input[@value = '"+tallaAcorde+"']/.."));
    }

    public WebElement seleccionarAnchoAdecuado(String anchoAdecuado){
        return driver.findElement(By.xpath("//div[@data-auto-id = 'rating_Width']/div/label/input[@value = '"+anchoAdecuado+"']/.."));
    }

    public WebElement seleccionarComodidad(String valoracion){
        return driver.findElement(By.xpath("//label[@for = 'star-rating_Comfort-"+valoracion+"']"));
    }

    public WebElement seleccionarCalidad(String valoracion){
        return driver.findElement(By.xpath("//label[@for = 'star-rating_Quality-"+valoracion+"']"));
    }



    //////////////////////////////////////////////////////////
    ////// A S E R C I O N E S ///////////////////////////////
    //////////////////////////////////////////////////////////

    @FindBy(xpath = "//h1[@class = 'gl-heading gl-heading--m']")
    public WebElement TXT_ESCRIBE_RESENA;

    @FindBy(xpath = "//div[@data-auto-id = 'ratings-reviews']/h5")
    public WebElement TXT_VALORACIONES;

    @FindBy(xpath = "//li[@class = 'gl-file-uploader__list-item']/span")
    public WebElement TXT_TITULO_IMAGEN;

    @FindBy(xpath = "//div[@class = 'gl-form-hint gl-form-hint--error']")
    public WebElement TXT_ERROR_EMAIL;



}
