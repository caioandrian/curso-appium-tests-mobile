package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.DriverFactory;

import java.util.Set;

public class WebViewPage extends BasePage{

    public void entrarContextoWeb(){
        //chrome versao 69.0.34.97.100
        //chrome drive versao 2.43 ao 2.44

        // Navigate to a portion of your app where a web view is active
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),300);
        By webView = By.className("android.webkit.WebView");
        wait.until(ExpectedConditions.visibilityOfElementLocated(webView));

        // Call getContext() method which will returns a list of contexts we can access, like 'NATIVE_APP' or 'WEBVIEW_1'
        Set<String> availableContexts = DriverFactory.getDriver().getContextHandles();
        System.out.println("quantidade de contexts = "+ availableContexts.size());

        for(String context : availableContexts) {
            if(context.contains("WEBVIEW_com")){
                System.out.println("Nome do Contexto: " + context);

                DriverFactory.getDriver().context(context);
                break;
            }
        }
    }

    public void setEmail(String valor){
        WebElement campo = DriverFactory.getDriver().findElement(By.id("email"));

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(campo));

        campo.sendKeys(valor);
        //DriverFactory.getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys(valor);
    }

    public void setPassword(String valor){
        WebElement campo = DriverFactory.getDriver().findElement(By.id("senha"));

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(campo));

        campo.sendKeys(valor);
    }

    public void botaoEntrar(){
        clicar(By.xpath("//button[@type='submit']"));
    }

    public String getMessage(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public void sairContextoWeb() {
        DriverFactory.getDriver().context("NATIVE_APP");
    }
}
