package page;

public class MenuPage extends BasePage{

    public void acessarFormulario(){
        clicarPorTexto("Formulário");
    }

    public void acessarSplash(){
        clicarPorTexto("Splash");
    }

    public void acessarAlerta(){
        clicarPorTexto("Alertas");
    }

    public void acessarAbas(){
        clicarPorTexto("Abas");
    }

    public void acessarAccordion(){
        clicarPorTexto("Accordion");
    }

    public void acessarCliques(){
        clicarPorTexto("Cliques");
    }

    public void acessarOpcaoBemEscondida() {
        scrollDown();
        clicarPorTexto("Opção bem escondida");
    }

    public void acessarSwipe(){
        scrollDown();
        clicarPorTexto("Swipe");
    }

    public void acessarSwipeList(){
        scrollDown();
        clicarPorTexto("Swipe List");
    }

    public void acessarDragAndDrop(){
        scrollDown();
        clicarPorTexto("Drag and drop");
    }

    public void acessarSBHibrido(){
        clicarPorTexto("SeuBarriga Híbrido");
    }

    public void acessarSBNativo(){
        clicarPorTexto("SeuBarriga Nativo");
    }
}
