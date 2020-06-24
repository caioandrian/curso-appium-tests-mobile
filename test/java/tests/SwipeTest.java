package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MenuPage;
import page.SwipeListPage;
import suporte.BaseTest;
import suporte.DriverFactory;

public class SwipeTest extends BaseTest {

    private final MenuPage menu = new MenuPage();

    private final SwipeListPage pagina = new SwipeListPage();

    @Test
    public void deveRealizarSwipe(){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

        //acessar menu swipe, é uma das ultimas opcoes do menu
        menu.acessarSwipe();

        //verificar se entrou na tela de swipe, texto "a esquerda"
        assertTrue(menu.existeElementoPorTexto("a esquerda"));

        // swipe para direita
        menu.swipeRight();

        //verificar texto "E veja se"
        assertTrue(menu.existeElementoPorTexto("E veja se"));

        //clicar no botão direita
        //!!!! atenção pois o simbolo é diferente do sinal de maior >
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text = '›']")));
        menu.clicarPorTexto("›");

        //verificar texto "Chegar até o fim!"
        assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

        // swipe esquerdo
        menu.swipeLeft();

        //clicar botao da esquerda
        //!!!! atenção pois o simbolo é diferente do sinal de menor <
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text = '‹']")));
        menu.clicarPorTexto("‹");

        //verificar texto "Chegar até o fim!"
        assertTrue(menu.existeElementoPorTexto("a esquerda"));
    }

    @Test
    public void desafioSwipe(){
        //clicar swipe list
        menu.acessarSwipeList();

        //opcao 1 para direita
        pagina.swipeElementRight("Opção 1");

        //clicar na opt 1+
        pagina.clicarBotaoMais();

        //verificar que a opt1 ficou com + na frente
        assertTrue(menu.existeElementoPorTexto("Opção 1 (+)"));

        //opcao 4 para direita
        pagina.swipeElementRight("Opção 4");

        //clicar na opt 4-
        menu.clicarPorTexto("(-)");

        //verificar que a opt4 ficou com - na frente
        assertTrue(menu.existeElementoPorTexto("Opção 4 (-)"));

        //resetar a opcao 6
        pagina.swipeElementLeft("Opção 6 (+)");

        //verificar que a opt4 ficou com - na frente
        assertTrue(menu.existeElementoPorTexto("Opção 6"));

    }
}
