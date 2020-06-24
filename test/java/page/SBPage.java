package page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import suporte.DriverFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SBPage extends BasePage{

    public void digitarLogin(String valor){
        escrever(By.xpath("//*[@text='Nome']"), valor);
    }

    public void digitarSenha(String valor){
        escrever(By.xpath("//*[@text='Senha']"), valor);
    }

    public void fazerLogin(){
        clicarPorTexto("ENTRAR");
    }

    public void contas(){
        clicarPorTexto("CONTAS");
    }

    public void home(){
        clicarPorTexto("HOME");
    }

    public void movimentacoes(){
        //clicarPorTexto("MOV...");

        List<MobileElement> menuSuperior = DriverFactory.getDriver().findElements(By.xpath("(//android.widget.HorizontalScrollView//android.view.ViewGroup/child::android.view.ViewGroup)/.."));
        //System.out.println(menuSuperior.size());
        menuSuperior.get(3).click();
    }

    public void acessarMovimentacoes(){
        clicarPorTexto("RESUMO");
    }

    public void digitarNomeDaConta(String nome){
        escrever(By.xpath("//android.widget.EditText[@text='Conta']"), nome);
    }

    public void salvar(){
        clicarPorTexto("SALVAR");
    }

    public void selecionarConta(String valor){
        cliqueLongoPorElemento(By.xpath("//*[@text='" + valor + "']"));
    }

    public void excluirConta(){
        clicarPorTexto("EXCLUIR");
    }

    public void alterarStatus(){
        clicar(By.xpath("//android.widget.Switch"));
    }

    public void selecionarDataMovimentacao(){
        Date dataAtual = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
        System.out.println(formatador.format(dataAtual));

        clicarPorTexto(formatador.format(dataAtual));

        //mês passado
        clicar(By.id("android:id/prev"));

        //dia 17
        clicar(By.xpath("//android.view.View[@text='17']"));

        clicarPorTexto("OK");
    }

    public void selecionarDataPagamento(){
        Date dataAtual = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));

        Calendar data = Calendar.getInstance();

        clicarPorTexto(formatador.format(dataAtual));

        //dia 25
        clicar(By.xpath("//android.view.View[@text='25']"));

        clicarPorTexto("OK");
    }

    public void selecionarContaMovimentacao(String valor){
        selecionarCombo(By.xpath("//android.widget.TextView[@text='Selecione uma conta...']"), valor);
    }

    public void atualizarResumo() {
        clicarPorTexto("ATUALIZAR");
    }

    public void excluirMovimentacao(String palavrachave){
        MobileElement elemento = DriverFactory.getDriver()
                .findElement(By.xpath("//android.widget.TextView[@text='"+ palavrachave +"']/../.."));

        swipeElement(elemento, 0.9,0.5);

        if (existeElementoPorTexto("Del")){
            clicarPorTexto("Del");
        }
    }

    public float obterSaldoDaConta(String conta){
        float valorSaldo = Float.parseFloat(
                obterTexto(By.xpath("//android.widget.TextView[@text='"
                        + conta +"']//following::android.widget.TextView")));

        //System.out.println(valorSaldo);
        return valorSaldo;
    }
}
