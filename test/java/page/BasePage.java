package page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.DriverFactory;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public void escrever(By by, String texto){
        //Escrever nome
        //pegamos o id (resource-id) utilizando um metodo especialmente criado para o Mobile disponivel no Appium
        //chamado MobileBy.AcessebilityId() com pelo elemento com content-desc= 'nome'
        DriverFactory.getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){
        return DriverFactory.getDriver().findElement(by).getText();
    }

    public void selecionarCombo(By by, String texto){
        DriverFactory.getDriver().findElement(by).click();
        clicarPorTexto(texto);
    }

    public void clicar(By by){
        DriverFactory.getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String valor){
        clicar(By.xpath("//*[@text='"+ valor +"']"));
    }

    public boolean isCheckMarcado(By by){
        return DriverFactory.getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String texto){
        List<MobileElement> elementos = DriverFactory.getDriver().findElements(By.xpath("//*[@text= '"+ texto +"']"));
        return elementos.size() > 0;
    }

    public boolean isEnabled(By by){
        return DriverFactory.getDriver().findElement(by).getAttribute("enabled").equals("true");
    }

    public void tap(int x, int y){
        new TouchAction<>(DriverFactory.getDriver()).tap(PointOption.point(x, y)).perform();
    }

    public void cliqueLongoPorElemento(By by){
        MobileElement mobileElemento = DriverFactory.getDriver()
                .findElement(by);

        new TouchAction<>(DriverFactory.getDriver())
                .longPress(ElementOption.element(mobileElemento)).perform();
    }

    public void scrollAfterElement(String nomedaclasse, double inicio, double fim){
        //Esperamos no maximo 10 segundos ate que a tela esteja carregada.
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(nomedaclasse)));

        MobileElement elemento = DriverFactory.getDriver().findElement(By.className(nomedaclasse));

        //comecar a arrastar a tela depois do elemento definido
        int delta = elemento.getSize().height;

        Dimension size = DriverFactory.getDriver().manage().window().getSize();
        int x = size.width/2;

        int start_y = (int) (size.height * inicio) + delta;
        //System.out.println(start_y);

        int end_y = (int) (size.height * fim);

        //arrastar a tela do meio para a parte superior da tela.
        //segurar um pouco a tela
        //ação de mover para o fim da tela (o mais importante)
        //soltar a tela.
        new TouchAction<>(DriverFactory.getDriver()).press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x, end_y))
                .release().perform();
    }

    //tela subindo!!
    public void scrollDownAfterElement(String elemento){
        scrollAfterElement(elemento, 0.9,0.1);
    }

    //tela descendo / atualizar!!
    public void scrollUpAfterElement(String elemento){
        scrollAfterElement(elemento,0.1,0.9);
    }

    public void scroll(double inicio, double fim){
        //Esperamos no maximo 10 segundos ate que a tela esteja carregada.
        MobileElement elemento = DriverFactory.getDriver().findElement(By.xpath("//android.widget.ScrollView"));

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(elemento));

        Dimension size = DriverFactory.getDriver().manage().window().getSize();
        int x = size.width/2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        new TouchAction<>(DriverFactory.getDriver()).press(PointOption.point(x, start_y))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
        .moveTo(PointOption.point(x, end_y))
                .release().perform();
    }

    //tela subindo!!
    public void scrollDown(){
        scroll(0.9, 0.1);
    }

    //tela descendo / atualizar!!
    public void scrollUp(){
        scroll(0.1, 0.9);
    }

    public void swipe(double inicio, double fim){
        Dimension size = DriverFactory.getDriver().manage().window().getSize();
        int y = size.height/2;

        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        new TouchAction<>(DriverFactory.getDriver()).press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x,y))
                .release().perform();
    }

    public void swipeRight(){
        swipe(0.9,0.1);
    }

    public void swipeLeft(){
        swipe(0.1,0.9);
    }

    public void swipeElement(MobileElement element, double inicio, double fim){
        //Esperamos no maximo 10 segundos ate que a tela esteja carregada.
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));

        Dimension ElementSize = element.getSize();

        int y = element.getLocation().y + (ElementSize.height / 2);

        int start_x = (int) (ElementSize.width * inicio);
        int end_x = (int) (ElementSize.width * fim);

        new TouchAction<>(DriverFactory.getDriver()).press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x,y))
                .release().perform();
    }

    public String obterTituloAlerta(){
        //resouce-id
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta(){
        //resouce-id
        return obterTexto(By.id("android:id/message"));
    }
}
