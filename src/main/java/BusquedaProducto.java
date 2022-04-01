import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusquedaProducto {
    private static WebDriver driver;

    BusquedaProducto(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Campo búsqueda
     */
    @FindBy(xpath = "//input[@data-auto-id = 'searchinput']")
    public WebElement INPUT_BUSCAR;

    /**
     * Filtros de búsqueda
     */
    @FindBy(xpath = "//span[@title = 'Sexo'][@data-auto-id = 'plp-sidebar-filter-name']")
    public WebElement FILTRO_SEXO;

    @FindBy(xpath = "//span[@title = 'Deportes'][@data-auto-id = 'plp-sidebar-filter-name']")
    public WebElement FILTRO_DEPORTES;

    @FindBy(xpath = "//span[@title = 'Superficie'][@data-auto-id = 'plp-sidebar-filter-name']")
    public WebElement FILTRO_SUPERFICIE;

    @FindBy(xpath = "//span[@class = 'gl-label gl-label--l'][text() = 'más filtros']")
    public WebElement BTN_MAS_FILTROS;

    /**
     * Seleccion del tercer elemento de busqueda
     */
    @FindBy(xpath = "//div[@data-index = '2']")
    public WebElement TERCER_RESULTADO;

    /**
     * Seleccionar el valor del filtro Sexo
     * @param sexo
     */
    public WebElement seleccionarSexo(String sexo){
        return driver.findElement(By.xpath("//a[@title = '"+sexo+"']"));
    }

    /**
     * Seleccionar valor del filtro Deporte
     * @param deporte
     */
    public WebElement seleccionarDeporte(String deporte){
        return driver.findElement(By.xpath("//input[@title = '"+deporte+"']"));
    }

    /**
     * Seleccionar valor del filtro Superficie
     * @param superficie
     */
    public WebElement seleccionarSuperficie(String superficie){
        return driver.findElement(By.xpath("//a[@title = '"+superficie+"']"));
    }


    //////////////////////////////////////////////////////////
    ////// A S E R C I O N E S ///////////////////////////////
    //////////////////////////////////////////////////////////

    /**
     * Comprobar valor de la busqueda
     */
    @FindBy(xpath = "//h1[@data-auto-id = 'plp-header-bar-search-title']")
    public WebElement TXT_RESULTADO_BUSQUEDA;

    /**
     * Comprobar si el filtro Sexo se ha aplicado
     * @param sexo
     * @return
     */
    public WebElement comprobarFiltroSexo(String sexo){
        return driver.findElement(By.xpath("//span[@class = 'filter-value___jKvFY gl-body--s'][text() = '"+sexo+"']"));
    }

    /**
     * Comprobar si el filtro Deporte se ha aplicado
     * @param deporte
     * @return
     */
    public WebElement comprobarFiltroDeporte(String deporte){
        return driver.findElement(By.xpath("//span[@class = 'filter-value___jKvFY gl-body--s'][text() = '"+deporte+"']"));
    }

    /**
     * Comprobar si el filtro Superficie se ha aplicado
     * @param superficie
     * @return
     */
    public WebElement comprobarFiltroSuperficie(String superficie){
        return driver.findElement(By.xpath("//span[@class = 'filter-value___jKvFY gl-body--s'][text() = '"+superficie+"']"));
    }

}
