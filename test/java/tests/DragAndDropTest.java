package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import page.DragAndDropPage;
import page.MenuPage;
import suporte.BaseTest;

public class DragAndDropTest extends BaseTest {

    private final MenuPage menu = new MenuPage();
    private final DragAndDropPage pagina = new DragAndDropPage();

    private final String[] estadoInicial = new String[]{
            "Esta",
            "é uma lista",
            "Drag em Drop!",
            "Faça um clique longo,",
            "e arraste para",
            "qualquer local desejado."};

    private final String[] estadoIntermediario = new String[]{
            "é uma lista",
            "Drag em Drop!",
            "Faça um clique longo,",
            "e arraste para",
            "Esta",
            "qualquer local desejado."};

    private final String[] estadoFinal = new String[]{
            "Faça um clique longo,",
            "é uma lista",
            "Drag em Drop!",
            "e arraste para",
            "Esta",
            "qualquer local desejado."};

    @Test
    public void deveEfeturarDragAndDrop(){
        //acessar menu
        menu.acessarDragAndDrop();

        //verificar estado inicial
        esperar(1000);
        assertArrayEquals(estadoInicial, pagina.obterLista());

        //arrastar "Esta" para "e arraste para"
        pagina.arrastar("Esta", "e arraste para");

        //verificar estado intermediario
        esperar(1000);
        assertArrayEquals(estadoIntermediario, pagina.obterLista());

        //arrastar "Faça um clique longo," para "é uma lista"
        pagina.arrastar("Faça um clique longo,", "é uma lista");

        //verificar estado final
        esperar(1000);
        assertArrayEquals(estadoFinal, pagina.obterLista());
    }
}
