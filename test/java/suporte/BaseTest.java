package suporte;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;

public class BaseTest {
    @Rule
    public TestName testName = new TestName();

    // Tirando screenshot no momento do erro
    public void gerarScreenshot(){
        String dataHora = Generator.dataHoraParaArquivo();

        String screenshotArquivo = "screenshots/"
                +  testName.getMethodName() + "_" + dataHora +".png";

        Screenshot.tirar(DriverFactory.getDriver(), screenshotArquivo);
    }

    //Não é recomendado usar essa espera explicita
    public void esperar(long tempo){
        try {
            Thread.sleep(tempo);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void finalizarClasseDeTeste() {
        DriverFactory.killDriver();
    }

    @After
    public void tearDown() {
        //DriverFactory.killDriver();

        gerarScreenshot();

        DriverFactory.getDriver().resetApp();
    }

}
