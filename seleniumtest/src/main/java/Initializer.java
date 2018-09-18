//package br.org.catolicasc.test;
package org.openqa.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Initializer{

    public static void main(String[] args) {

        // Configura o caminho para o driver desejado
        String pathToDriver = "C:\\Users\\esdra\\Downloads\\chromedriver.exe";

        // Configura o driver a ser usado, no caso do google chrome
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        // Cria nova instância do chrome
        WebDriver driver = new ChromeDriver();

        // Aponta para o site que ele deve acessar
        driver.get("http://www.catolicasc.org.br/");

        // Diz qual o título da página
        System.out.println("O título da página é: " + driver.getTitle());

        // Novo elemento para o campus de jaraguá, e depois clicar nele
        WebElement joi = driver.findElement(By.className("joi"));
        joi.click();

        // Novo elemento para o campo que preenche o nome e depois preenche-lo
        WebElement fullName = driver.findElement(By.id("nome"));
        fullName.sendKeys("Teste de teste");

        // Novo elemento para o número de telefone e preenche-lo
        WebElement phoneNumber = driver.findElement(By.className("phoneNumber"));
        phoneNumber.sendKeys("40028922");

        // Novo elemento para o email e preenche-lo
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("teste@catolicasc.org.br");

        // Novo elemento para selecionar o tipo do curso
        WebElement selection = driver.findElement(By.id("catolica_tipo_de_ensino"));

        // Nova instância utilizada para simular um hover sobre o elemento
        Actions builder = new Actions(driver);
        try {
            builder.moveToElement(selection).build().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        // Novo elemento para selecionar o curso
        WebElement item = driver.findElement(By.xpath("//div[@data-value='1']"));
        item.click();

        try { // Remove hover do tipo de interesse
            builder.moveToElement(email).build().perform();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e);
            driver.quit();
            return ;
        }

        // Novo elemento para mensagem a ser mandada
        WebElement text = driver.findElement(By.name("cad_mensagem"));
        text.sendKeys("isso é um teste de teste pra enviar um texto para verificar se esse teste tá funcionando");

        // Novo elemento para envio do formulário
        WebElement send = driver.findElement(By.className("wpcf7-submit"));
        send.click();

        try {
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.id("mensagem-contato")).getText().length() != 0;
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement callback = driver.findElement(By.id("mensagem-contato"));;
        String callbackText = callback.getText();

        if (callbackText.equals("Seus dados foram enviados!")) {
            System.out.println("Os dados foram enviados com sucesso!");
        } else {
            throw new java.lang.RuntimeException("Erro ao finalizar formulário.");
        }

        // Fecha o drivers
        driver.quit();
    }
}
