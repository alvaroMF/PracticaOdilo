import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Stepdefs {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor executor;
    private final ElementosComunes elementosComunesPO;
    private final BusquedaProducto busquedaProductoPO;
    private final GuiaTallas guiaTallasPO;
    private final ValoracionProducto valoracionProductoPO;
    private final File file;

    public Stepdefs(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        executor = (JavascriptExecutor)driver;
        file = new File("src/test/resources/images/image.jpg");
        elementosComunesPO = new ElementosComunes(driver);
        busquedaProductoPO = new BusquedaProducto(driver);
        guiaTallasPO = new GuiaTallas(driver);
        valoracionProductoPO = new ValoracionProducto(driver);
    }

    @Before
    public void goToURL(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.adidas.es/");
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Given("Estando en la pagina inicial de Adidas")
    public void estandoEnLaPaginaInicialDeAdidas() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(elementosComunesPO.BTN_ACEPTAR_COOKIES));
        elementosComunesPO.BTN_ACEPTAR_COOKIES.click();
    }

    @When("Introducimos {string} en el campo de busqueda")
    public void introducimosEnElCampoDeBusqueda(String modelo) {
        busquedaProductoPO.INPUT_BUSCAR.clear();
        busquedaProductoPO.INPUT_BUSCAR.sendKeys(modelo);
    }

    @And("Pulsamos la tecla Intro")
    public void pulsamosLaTeclaIntro() {
        busquedaProductoPO.INPUT_BUSCAR.sendKeys(Keys.ENTER);
    }

    @Then("Se muestra la pantalla de busqueda")
    public void seMuestraLaPantallaDeBusqueda(){
        wait.until(ExpectedConditions.visibilityOf(busquedaProductoPO.TXT_RESULTADO_BUSQUEDA));
        Assert.assertEquals(busquedaProductoPO.TXT_RESULTADO_BUSQUEDA.getText(), "“ULTRABOOST 22”");
    }

    @When("Seleccionamos {string} en el filtro de Sexo")
    public void seleccionamosEnElFiltroDeSexo(String sexo) {
        busquedaProductoPO.BTN_MAS_FILTROS.click();
        busquedaProductoPO.FILTRO_SEXO.click();
        wait.until(ExpectedConditions.visibilityOf(busquedaProductoPO.seleccionarSexo(sexo)));
        busquedaProductoPO.seleccionarSexo(sexo).click();
    }


    @And("Si se muestra, cerrar PopUp de suscripcion")
    public void siSeMuestraCerrarPopUpDeSuscripcion() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(elementosComunesPO.BTN_CERRAR_POPUP));
        try{
            if(elementosComunesPO.BTN_CERRAR_POPUP.isDisplayed()){
                elementosComunesPO.BTN_CERRAR_POPUP.click();
            }
        }catch (Exception e){
            System.out.println(e);
        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        Thread.sleep(1000);
    }

    @And("Seleccionamos {string} en el filtro Deportes")
    public void seleccionamosEnElFiltroDeportes(String deporte) {
        busquedaProductoPO.FILTRO_DEPORTES.click();
//        Por algun motivo desconocido, esta espera no localiza el elemento y falla.
//        wait.until(ExpectedConditions.visibilityOf(busquedaProductoPO.seleccionarDeporte(deporte)));
        busquedaProductoPO.seleccionarDeporte(deporte).click();
    }

    @And("Seleccionamos {string} en el filtro Superficie")
    public void seleccionamosEnElFiltroSuperficie(String superficie) {
        busquedaProductoPO.FILTRO_SUPERFICIE.click();
        wait.until(ExpectedConditions.visibilityOf(busquedaProductoPO.seleccionarSuperficie(superficie)));
        busquedaProductoPO.seleccionarSuperficie(superficie).click();
    }

    @Then("Se muestran los resultados con los filtros indicados")
    public void seMuestranLosResultadosConLosFiltrosIndicados() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(busquedaProductoPO.comprobarFiltroSexo("Mujer")));
        wait.until(ExpectedConditions.visibilityOf(busquedaProductoPO.comprobarFiltroDeporte("Running")));
        wait.until(ExpectedConditions.visibilityOf(busquedaProductoPO.comprobarFiltroSuperficie("Carretera")));

        Assert.assertTrue(busquedaProductoPO.comprobarFiltroSexo("Mujer").isDisplayed());
        Assert.assertTrue(busquedaProductoPO.comprobarFiltroDeporte("Running").isDisplayed());
        Assert.assertTrue(busquedaProductoPO.comprobarFiltroSuperficie("Carretera").isDisplayed());
    }

    @When("Seleccionamos el tercer resultado")
    public void seleccionamosElTercerResultado() {
        busquedaProductoPO.TERCER_RESULTADO.click();
    }

    @Then("Se muestra el detalle del producto")
    public void seMuestraElDetalleDelProducto() {
        wait.until(ExpectedConditions.visibilityOf(guiaTallasPO.TXT_TALLAS_DISPONIBLES));
        Assert.assertEquals(guiaTallasPO.TXT_TALLAS_DISPONIBLES.getText(), "Tallas disponibles");
    }

    @When("Hacemos click en Guia de tallas")
    public void hacemosClickEnGuiaDeTallas() {
        guiaTallasPO.LNK_GUIA_TALLAS.click();
    }

    @Then("Se muestra la guia de tallas")
    public void seMuestraLaGuiaDeTallas() {
        wait.until(ExpectedConditions.visibilityOf(guiaTallasPO.TXT_GUIA_TALLAS));
        Assert.assertEquals(guiaTallasPO.TXT_GUIA_TALLAS.getText(), "GUÍA DE TALLAS PARA CALZADO DE HOMBRE Y MUJER");
    }

    @When("Hacemos click en Como saber tu talla")
    public void hacemosClickEnComoSaberTuTalla() {
        guiaTallasPO.LNK_COMO_SABER_TALLA.click();
    }

    @And("Hacemos click en Volver al principio")
    public void hacemosClickEnVolverAlPrincipio() {
        guiaTallasPO.LNK_VOLVER_PRINCIPIO.click();
    }

    @And("Hacemos click en Pulgadas")
    public void hacemosClickEnPulgadas() {
        guiaTallasPO.BTN_PULGADAS.click();
    }

    @Then("Se muestra la tabla en Pulgadas")
    public void seMuestraLaTablaEnPulgadas() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(guiaTallasPO.TXT_MEDIDA_PIE.getText(), "Medida del pie (INCH)");
    }

    @When("Hacemos click en CM")
    public void hacemosClickEnCM() {
        guiaTallasPO.BTN_CENTIMETROS.click();
    }

    @Then("Se muestra la tabla en Centimetros")
    public void seMuestraLaTablaEnCentimetros() {
        Assert.assertEquals(guiaTallasPO.TXT_MEDIDA_PIE.getText(), "Medida del pie");
    }

    @When("Hacemos click en X para cerrar el PopUp")
    public void hacemosClickEnXParaCerrarElPopUp() {elementosComunesPO.BTN_CERRAR_POPUP.click();
    }

    @And("Hacemos Scroll hasta Valoraciones y Reseñas")
    public void hacemosScrollHastaValoracionesYReseñas() {
        executor.executeScript("arguments[0].scrollIntoView();", valoracionProductoPO.TXT_VALORACIONES);
        // Ya que hay una barra superior, el elemento se oculta bajo ella por lo que hay que hacer algo de scroll hacia arriba
        executor.executeScript("window.scrollBy(0,-100)");
    }

    @Then("Se muestra el apartado Valoraciones y Reseñas")
    public void seMuestraElApartadoValoracionesYReseñas() {
        wait.until(ExpectedConditions.visibilityOf(valoracionProductoPO.TXT_VALORACIONES));
        Assert.assertTrue(valoracionProductoPO.TXT_VALORACIONES.isDisplayed());
    }

    @When("Hacemos click en Escribir una reseña")
    public void hacemosClickEnEscribirUnaReseña() {
        valoracionProductoPO.LNK_ESCRIBIR_RESENA.click();
    }

    @Then("Se muestra el formulario para escribir una reseña")
    public void seMuestraElFormularioParaEscribirUnaReseña() {
        wait.until(ExpectedConditions.visibilityOf(valoracionProductoPO.TXT_ESCRIBE_RESENA));
        Assert.assertEquals(valoracionProductoPO.TXT_ESCRIBE_RESENA.getText(), "ESCRIBE UNA RESEÑA");
    }

    @When("Indicamos {string} estrellas en Valoracion general")
    public void indicamosEstrellasEnValoracionGeneral(String valoracion) {
        valoracionProductoPO.seleccionarValoracionGeneral(valoracion).click();
    }

    @And("Indicamos {string} en Recomendacion del producto")
    public void indicamosEnRecomendacionDelProducto(String recomendado) {
        if(recomendado.equals("Si")){
            recomendado = "yes";
        }
        valoracionProductoPO.seleccionarRecomendacionProducto(recomendado).click();
    }

    @And("Introducimos {string} en el cuadro de texto de reseña")
    public void introducimosEnElCuadroDeTextoDeReseña(String opinion) {
        valoracionProductoPO.TXTAREA_OPINION.sendKeys(opinion);
    }

    @And("Introducimos {string} en el resumen de la reseña")
    public void introducimosEnElResumenDeLaReseña(String resumen) {
        valoracionProductoPO.INPUT_RESUMEN_RESENA.sendKeys(resumen);
    }

    @And("Indicamos la opcion numero {string} en Acorde con su talla")
    public void indicamosLaOpcionNumeroEnAcordeConSuTalla(String tallaAcorde) {
        valoracionProductoPO.seleccionarTallaAcorde(tallaAcorde).click();
    }

    @And("Indicamos la opcion numero {string} en Ancho adecuado de la horma")
    public void indicamosLaOpcionNumeroEnAnchoAdecuadoDeLaHorma(String anchoAdecuado) {
        valoracionProductoPO.seleccionarAnchoAdecuado(anchoAdecuado).click();
    }

    @And("Indicamos {string} estrellas en Valoracion de comodidad")
    public void indicamosEstrellasEnValoracionDeComodidad(String valoracion) {
        valoracionProductoPO.seleccionarComodidad(valoracion).click();
    }

    @And("Indicamos {string} estrellas en Valoracion de calidad")
    public void indicamosEstrellasEnValoracionDeCalidad(String valoracion) {
        valoracionProductoPO.seleccionarCalidad(valoracion).click();
    }

    @And("Subimos una imagen del producto")
    public void subimosUnaImagenDelProducto() {
        valoracionProductoPO.INPUT_CARGAR_IMAGEN.sendKeys(file.getAbsolutePath());
    }

    @Then("Comprobamos que la imagen se ha subido")
    public void comprobamosQueLaImagenSeHaSubido() {
        wait.until(ExpectedConditions.visibilityOf(valoracionProductoPO.TXT_TITULO_IMAGEN));
        Assert.assertEquals(valoracionProductoPO.TXT_TITULO_IMAGEN.getText(), "image.jpg");
    }

    @When("Introducimos {string} en el campo Apodo")
    public void introducimosEnElCampoApodo(String apodo) {
        valoracionProductoPO.INPUT_APODO.sendKeys(apodo);
    }

    @And("Hacemos click en Enviar Reseña")
    public void hacemosClickEnEnviarReseña() {
        valoracionProductoPO.BTN_ENVIAR_RESENA.click();
    }

    @Then("Devuelve un error ya que no hemos introducido el email")
    public void devuelveUnErrorYaQueNoHemosIntroducidoElEmail() {
        wait.until(ExpectedConditions.visibilityOf(valoracionProductoPO.TXT_ERROR_EMAIL));
        Assert.assertEquals(valoracionProductoPO.TXT_ERROR_EMAIL.getText(), "¡Espera! No puedes dejar en blanco este campo.");
    }


//    @And("Seleccionamos la talla {string}")
//    public void seleccionamosLaTalla(String talla) {
//        pageObject.seleccionarTalla(talla).click();
//    }
//
//    @And("Hacemos click en Añadir al carrito")
//    public void hacemosClickEnAñadirAlCarrito(){
//        pageObject.BTN_AGREGAR_CARRITO.click();
//    }
//
//    @Then("Se muestra un PopUp indicando que se ha añadido al carrito")
//    public void seMuestraUnPopUpIndicandoQueSeHaAñadidoAlCarrito() {
//        wait.until(ExpectedConditions.visibilityOf(pageObject.TXT_AGREGADO_CARRITO));
//        Assert.assertEquals("¡Añadido al carrito correctamente!", pageObject.TXT_AGREGADO_CARRITO.getText());
//    }
//
//    @When("Hacemos click en Ver Carrito")
//    public void hacemosClickEnVerCarrito() {
//        pageObject.BTN_VER_CARRITO.click();
//    }
//
//    @Then("Se muestra la pantalla Tu carrito")
//    public void seMuestraLaPantallaTuCarrito() {
//        wait.until(ExpectedConditions.visibilityOf(pageObject.TXT_TU_CARRITO));
//        Assert.assertEquals("Tu carrito", pageObject.TXT_TU_CARRITO.getText());
//    }
//
//    //Se ha cambiado ¿Puedo devolver mi pedido? por la siguiente acción debido a un cambio en la Web
//    @When("Hacemos click en sesenta dias de devolucion y cambio")
//    public void hacemosClickEnSesentaDiasDeDevolucionYCambio() {
//        pageObject.LNK_DEVOLUCIONES_CAMBIO.click();
//    }
//
//    @Then("Se abre el PopUp Devoluciones y Reembolsos")
//    public void seAbreElPopUpDevolucionesYReembolsos() {
//        wait.until(ExpectedConditions.visibilityOf(pageObject.TXT_DEVOLUCIONES_REEMBOLSO));
//        Assert.assertEquals("60 días* de devolución y cambio gratuito", pageObject.TXT_DEVOLUCIONES_REEMBOLSO.getText());
//    }
//
//    @When("Hacemos click en la X àra cerrar el PopUp")
//    public void hacemosClickEnLaXÀraCerrarElPopUp() {
//        pageObject.BTN_CERRAR_POPUP.click();
//    }
//
//    @And("Hacemos click en Continuar")
//    public void hacemosClickEnContinuar() {
//        pageObject.BTN_CONTINUAR.click();
//    }
//
//    @Then("Se muestra el formulario de compra")
//    public void seMuestraElFormularioDeCompra() {
//        wait.until(ExpectedConditions.visibilityOf(pageObject.TXT_INFORMACION_ENTREGA));
//        Assert.assertEquals("Información de entrega", pageObject.TXT_INFORMACION_ENTREGA.getText());
//    }
//
//    @When("Introducimos {string} en el campo Nombre")
//    public void introducimosEnElCampoNombre(String nombre) {
//        pageObject.INPUT_NOMBRE.sendKeys(nombre);
//    }
//
//    @And("Introducimos {string} en el campo Apellidos")
//    public void introducimosEnElCampoApellidos(String apellidos) {
//        pageObject.INPUT_APELLIDOS.sendKeys(apellidos);
//    }
//
//    @And("Introducimos {string} en el campo Calle")
//    public void introducimosEnElCampoCalle(String direccion) {
//        pageObject.INPUT_DIRECCION.sendKeys(direccion);
//    }
//
//    @And("Introducimos {string} en el campo Codigo postal")
//    public void introducimosEnElCampoCodigoPostal(String codigoPostal) {
//        pageObject.INPUT_CODIGO_POSTAL.sendKeys(codigoPostal);
//    }
//
//    @And("Introducimos {string} en el campo Barcelona")
//    public void introducimosEnElCampoBarcelona(String ciudad) {
//        pageObject.INPUT_CIUDAD.sendKeys(ciudad);
//    }
//
//    @And("Hacemos click en Revisar y Pagar")
//    public void hacemosClickEnRevisarYPagar() {
//        pageObject.BTN_REVISAR_PAGAR.click();
//    }
//
//    @Then("Se muestra un mensaje de error indicando que es obligatorio el email")
//    public void seMuestraUnMensajeDeErrorIndicandoQueEsObligatorioElEmail() {
//        wait.until(ExpectedConditions.visibilityOf(pageObject.TXT_ERROR_EMAIL));
//        Assert.assertEquals("Introduce tu dirección de correo electrónico.", pageObject.TXT_ERROR_EMAIL.getText());
//    }

}
