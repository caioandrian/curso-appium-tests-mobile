package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import page.MenuPage;
import page.SplashPage;
import suporte.BaseTest;

public class SplashTest extends BaseTest {

    private final MenuPage menu = new MenuPage();
    private final SplashPage pagina = new SplashPage();

    @Test
    public void deveAguardarSplashSumir(){
        //acessar meu splash
        menu.acessarSplash();

        //verificar que o splah esta sendo exibido
        pagina.isTelaSplashVisivel();

        //aguardar saida do splash
        pagina.aguardarSplashSumir();

        //verificar que o formulario esta aparecendo
        assertTrue(pagina.existeElementoPorTexto("Formulário"));
    }
}
