# Selenium teste

Um projeto criado para matéria de teste de software. Este projeto visa utilizar da API Selenium Webdriver em java e fazer um teste totalmente automatizado em um site. O site utilizado como objetivo de teste foi o da própria instituição: [Católica de Santa Catarina](http://www.catolicasc.org.br/)

# Dependências
Para poder utilizar deste programa de teste feito deve-se possuir conexão a internet e o driver do navegador baixado e específicado o caminho no código.
Neste exemplo foi utilizado do Google Chrome porém existe a possiblidade de utilizar em qualquer navegado.
Para baixar o driver do google acesse: http://chromedriver.chromium.org/downloads
Para especificar o caminho altere a variável pathToDriver:
```
// Configura o caminho para o driver desejado
String pathToDriver = "Caminho para o seu driver";
```

# Rodando
Após baixar e configurar as dependências basta rodar o programa que ele irá fazer um teste de envio de formulário no site e retornar se foi possível enviar ou não.
