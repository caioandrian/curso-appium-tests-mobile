package tests;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;
import page.MenuPage;
import page.WebViewPage;
import suporte.BaseTest;

public class WebViewTest extends BaseTest {

    private final MenuPage menu = new MenuPage();
    private final WebViewPage pagina = new WebViewPage();

    //EM APLICACOES HIBRIDAS!!!!

    @Test
    public void deveFazerLogin(){
        //acessar o menu
        menu.acessarSBHibrido();

        //esperar(3000);
        pagina.entrarContextoWeb();

        //preencher email
        esperar(1000);
        pagina.setEmail("teste@c");

        //preencher senha
        pagina.setPassword("caio");

        //entrar
        pagina.botaoEntrar();

        //verificar
        esperar(500);
        assertEquals("Bem vindo, caio!", pagina.getMessage());
    }


    @After
    public void tearDown(){
        // precisamos adicionar um método a ser executado
        // após o teste para que ele saia do contexto Web
        // e volte para o contexto nativo, dessa forma
        // ele continuará executando
        // tod o código que criamos antes, inclusive no BaseTest,
        // como @after e @afterClass. Caso contrário ele não irá encerrar
        // o teste mobile.
        pagina.sairContextoWeb();
    }
}
