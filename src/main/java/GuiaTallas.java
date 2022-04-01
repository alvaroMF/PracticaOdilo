import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuiaTallas {
    private static WebDriver driver;

    GuiaTallas(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Guia de tallas
     */
    @FindBy(xpath = "//a[@data-auto-id = 'size-chart-link']")
    public WebElement LNK_GUIA_TALLAS;

    @FindBy(xpath = "//div[@class = 'header_links___21q0Q gl-vspace-bpall-medium']/div/a")
    public WebElement LNK_COMO_SABER_TALLA;

    @FindBy(xpath = "//a[@class = 'gl-link back-to-top___1X59z']")
    public WebElement LNK_VOLVER_PRINCIPIO;

    /**
     * Cambiar tabla entre pulgadas y centrímetros
     */
    @FindBy(xpath = "//button[@title = 'Pulgadas']")
    public WebElement BTN_PULGADAS;

    @FindBy(xpath = "//button[@title = 'cm']")
    public WebElement BTN_CENTIMETROS;

    //////////////////////////////////////////////////////////
    ////// A S E R C I O N E S ///////////////////////////////
    //////////////////////////////////////////////////////////
    @FindBy(xpath = "//div[@class = 'heading-container___3N-Lp']/h5")
    public WebElement TXT_TALLAS_DISPONIBLES;

    @FindBy(xpath = "//h5[@class = 'gl-heading gl-heading--m gl-heading--no-margin']")
    public WebElement TXT_GUIA_TALLAS;

    @FindBy(xpath = "//div[@class = 'gl-table__cell-inner'][contains(text(), 'Medida del pie')]")
    public WebElement TXT_MEDIDA_PIE;


}
