package tests;

import io.appium.java_client.MobileBy;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.FormularioPage;
import page.MenuPage;
import suporte.BaseTest;
import suporte.DriverFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FormularioTest extends BaseTest {

    private final MenuPage menu = new MenuPage();
    private final FormularioPage pagina = new FormularioPage();

    @Before
    public void setUp() {
        //AndroidDriver<MobileElement> aplicativo = DriverFactory.getDriver();

        //Selecionar a opcao formulario
        menu.acessarFormulario();

        //aplicativo.findElement(By.xpath("//*[@text='Formulário']")).click();

        /*List<MobileElement> elementosEncontrados = aplicativo.findElements(By.className("android.widget.TextView"));
        for (MobileElement elemento: elementosEncontrados) {
            System.out.println(elemento.getText());
        }
        elementosEncontrados.get(1).click();*/
    }

    @Test
    public void devePreencherCampoTexto() {
        //xpath em navegador //tag[@atributo='valor']
        //xpath em mobile fica assim //class[@atributo='']

        //Escrever nome
        pagina.escreverNome("Caio");

        //validar nome escrito
        assertEquals("Caio", pagina.obterNome());
    }

    @Test
    public void deveInteragirComCombo() {
        //xpath em navegador //tag[@atributo='valor']
        //xpath em mobile fica assim //class[@atributo='']

        //clicar e selecionar a opção do Combo
        pagina.selecionarCombo("Nintendo Switch");

        //validar a opcao selecionada
        assertEquals("Nintendo Switch", pagina.obterValorDoCombo());
    }

    @Test
    public void deveInteragirComCheckBox() {
        //verificar status dos elementos

        //status do checked deve vir como desmarcado
        assertFalse(pagina.isCheckMarcado());

        //status do switch deve vir como marcado
        assertTrue(pagina.isSwitchMarcado());

        //clicar nos elementos
        pagina.clicarNoCheckBox();
        pagina.clicarNoSwitch();

        //verificar estados alterados
        assertTrue(pagina.isCheckMarcado());
        assertFalse(pagina.isSwitchMarcado());
    }

    @Test
    public void deveRealizarCadastro() {
        //preencher campos
        pagina.escreverNome("Caio");
        pagina.selecionarCombo("PS4");

        //salvar
        pagina.salvar();

        //validar campos
        assertEquals("Nome: Caio", pagina.obterNomeCadastrado());
        assertEquals("Console: ps4", pagina.obterConsoleCadastrado());
        assertTrue(pagina.obterSwitchCadastrado().endsWith("On"));
        assertTrue(pagina.obterCheckBoxCadastrado().endsWith("Desabilitado"));
    }

    @Test
    public void deveRealizarCadastroDemorado() {
        //preencher campos
        pagina.escreverNome("Caio");

        //Para mostra como a espera implícita funciona
        DriverFactory.getDriver().manage()
                .timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        //salvar
        pagina.salvarDemorado();

        //Não é recomendado usar essa espera explicita de 3000 milisegundos = 3seg
        //esperar(3000);

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text = 'Nome: Caio']")));

        //validar campos
        assertEquals("Nome: Caio", pagina.obterNomeCadastrado());
    }

    @Test
    public void deveAlterarData(){
        //clicar no texto com a data
        pagina.clicarPorTexto("01/01/2000");
        pagina.clicarPorTexto("20");

        //formularioPage.clicarPorTexto("OK");
        pagina.clicar(By.id("android:id/button1"));

        assertTrue(pagina.existeElementoPorTexto("20/2/2000"));
    }

    @Test
    public void deveAlterarHorario(){
        //clicar no texto com a data
        pagina.clicarPorTexto("06:00");

        //selecionar horas
        pagina.clicar(MobileBy.AccessibilityId("22"));

        //selecionar minutos
        pagina.clicar(MobileBy.AccessibilityId("30"));

        pagina.clicarPorTexto("OK");

        assertTrue(pagina.existeElementoPorTexto("22:30"));
    }

    @Test
    public void deveInteragirComSeekBar(){
        //clicar no seekbar
        pagina.clicarNoSeekBar(0.86);

        //salvar
        pagina.salvar();

        //validar valor
        assertEquals("Slider: 86", pagina.obterSliderCadastrado());
    }
}

