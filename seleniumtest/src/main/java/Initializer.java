//package br.org.catolicasc.test;
package org.openqa.selenium.example;

import jdk.jfr.events.ExceptionThrownEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initializer{
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.


            System.setProperty("webdriver.chrome.driver", "C:\\BATATA\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.get("http://www.catolicasc.org.br/");

            System.out.println("O título da página é: " + driver.getTitle());

            WebElement joi = driver.findElement(By.className("joi"));
            joi.click();

            WebElement fullName = driver.findElement(By.id("nome"));
            fullName.sendKeys("Teste de teste");

            WebElement phoneNumber = driver.findElement(By.className("phoneNumber"));
            phoneNumber.sendKeys("40028922");

            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("teste@catolicasc.org.br");

            WebElement selection = driver.findElement(By.id("catolica_tipo_de_ensino"));
            selection.sendKeys("1");

            WebElement item = driver.findElement(By.xpath("//div[@data-value='1']"));
            item.click();

            WebElement text = driver.findElement(By.name("cad_mensagem"));
            text.sendKeys("isso é um teste de teste pra enviar um texto para verificar se esse teste tá funcionando");


            WebElement send = driver.findElement(By.className("wpcf7-submit"));
            send.click();

            WebElement teste = driver.findElement(By.id("mensagem-contato"));

            while(teste.getText() == ""){
                System.out.println(teste.getText());
            }



        Thread.sleep(500000);

        //Close the browser
        driver.quit();


    }
}
