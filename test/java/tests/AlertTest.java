package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import page.AlertaPage;
import page.MenuPage;
import suporte.BaseTest;

public class AlertTest extends BaseTest {

    private final MenuPage menu = new MenuPage();
    private final AlertaPage pagina = new AlertaPage();

    @Before
    public void setUp(){
        //acessar meu alerta
        menu.acessarAlerta();
    }

    @Test
    public void deveConfirmarAlerta(){
        //clicar em alerta confirm
        pagina.clicarAlertaConfirm();

        //verificar os textos
        assertEquals("Info", pagina.obterTituloAlerta());
        assertEquals("Confirma a operação?", pagina.obterMensagemAlerta());

        //confirmar alerta
        pagina.confirmar();

        //verificar nova mensagem
        assertEquals("Confirmado", pagina.obterMensagemAlerta());

        //sair
        pagina.sair();
    }

    @Test
    public void deveClicarForaAlerta(){
        //pode clicar em qualquer lugar para fechar o alerta

        //clicar em alerta simples
        pagina.clicarAlertaSimples();

        //clicar fora da caixa nas coordenadas 110,150
        esperar(1000);
        pagina.clicarForaDaCaixa();

        //verificar que a mensagem nao existe mais
        assertFalse(pagina.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }



}
