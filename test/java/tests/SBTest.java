package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import page.MenuPage;
import page.SBPage;
import suporte.BaseTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SBTest extends BaseTest {

    private final MenuPage menu = new MenuPage();
    private final SBPage pagina = new SBPage();

    @Before
    public void setUp(){
        menu.acessarSBNativo();

        //efetuar login
        pagina.digitarLogin("teste@c");
        pagina.digitarSenha("caio");
        pagina.fazerLogin();
    }

    @Test
    public void deveInserirConta(){
        //clicar em CONTAS
        pagina.contas();

        //preencher campo
        pagina.digitarNomeDaConta("conta criada na nuvem");

        assertTrue(pagina.isEnabled(By.xpath("//*[@text='SALVAR']")));

        //clicar salvar
        pagina.salvar();

        //validar mensagem recebida
        assertTrue(pagina.existeElementoPorTexto("Conta adicionada com sucesso"));
    }

    @Test
    public void deveExcluirConta(){
        //clicar na aba CONTAS
        pagina.contas();

        //clique longo na conta
        pagina.selecionarConta("fddf2");

        //verificar se botao EXCLUIR ficou habilitado
        assertTrue(pagina.isEnabled(By.xpath("//*[@text='EXCLUIR']")));

        //clicar em EXCLUIR
        esperar(1000);
        pagina.excluirConta();

        //validar mensagem recebida "Conta excluída com sucesso"
        assertTrue(pagina.existeElementoPorTexto("Conta excluída com sucesso"));
    }

    @Test
    public void deveIncluirEValidarMovimentacao(){
        //clicar na aba mov...
        pagina.movimentacoes();

        assertTrue(pagina.existeElementoPorTexto("Receita"));

        //switch pago ou pendente, default false
        pagina.alterarStatus();
        assertTrue(pagina.isCheckMarcado(By.xpath("//android.widget.Switch")));

        //selecionar data movimentacao
        pagina.selecionarDataMovimentacao();

        //selecionar data pagamento
        pagina.selecionarDataPagamento();

        pagina.salvar();
        assertTrue(pagina.existeElementoPorTexto("Descrição é um campo obrigatório"));

        //digitar Descricao
        pagina.escrever(By.xpath("//*[@text='Descrição']"), "prêmio da loteria");

        pagina.salvar();
        assertTrue(pagina.existeElementoPorTexto("Interessado é um campo obrigatório"));

        //digitar Interessado
        pagina.escrever(By.xpath("//*[@text='Interessado']"), "Eu mesmo");

        pagina.salvar();
        assertTrue(pagina.existeElementoPorTexto("Valor é um campo obrigatório"));

        //digitar Valor
        pagina.escrever(By.xpath("//*[@text='Valor']"), "2300,50");

        pagina.salvar();
        assertTrue(pagina.existeElementoPorTexto("Conta é um campo obrigatório"));

        //selecionar Conta
        pagina.selecionarContaMovimentacao("Conta Saldo 2020");

        //validar mensagem recebida
        pagina.salvar();
        assertTrue(pagina.existeElementoPorTexto("Movimentação cadastrada com sucesso"));

        pagina.home();

        //validar valor do saldo atualizado nessa conta
        esperar(1000);
        float saldoAntigo = pagina.obterSaldoDaConta("Conta Saldo 2020");
        //3555.07

        //atualizar saldos
        esperar(1000);
        pagina.scrollUpAfterElement("android.widget.HorizontalScrollView");

        //validar saldo atual
        esperar(3000);
        assertEquals(saldoAntigo + 2300.50, pagina.obterSaldoDaConta("Conta Saldo 2020"), 0.01);
    }

    @Test
    public void deveRealizarExcluicaoDaMovimentacao(){
        //clicar em resumo
        pagina.acessarMovimentacoes();

        //clicar em ATUALIZAR
        pagina.atualizarResumo();

        //identificar elemento e deslizar para esquerda
        //clicar em Del
        pagina.excluirMovimentacao("prêmio da loteria");

        //validar mensagem recebida
        assertTrue(pagina.existeElementoPorTexto("Movimentação removida com sucesso!"));

        pagina.home();

        //validar valor do saldo atualizado nessa conta
        esperar(1000);
        float saldoAntigo = pagina.obterSaldoDaConta("Conta Saldo 2020");
        //5855.57

        //atualizar saldos
        esperar(1000);
        pagina.scrollUpAfterElement("android.widget.HorizontalScrollView");

        //validar saldo atual
        esperar(3000);
        assertEquals(saldoAntigo - 2300.50, pagina.obterSaldoDaConta("Conta Saldo 2020"), 0.01);
    }
}
