# Java SOAP Webservice

Crud de serviços com persistência em banco de dados.

___

## Pré-requisitos

* Eclipse Oxygen ou superior
* JDK 8
* Wildfly 10.x ou superior
* PostgreSQL 9.6.x ou superior
* SoapUI 5.3.0 ou superior

### Informações para criação do Banco de Dados PostgreSQL

* **Name:** ntconsultwsdb
* **Port:** 5432
* **User:** postgres
* **Password:** admin

**OBS:** Para utilizar outro Banco de Dados será necessário ajustar as configurações no arquivo **persistence.xml** que se encontra no projeto.

### Criacao da tabela e registros iniciais para testes

```sql
CREATE TABLE CLIENTE (
    ID            INTEGER PRIMARY KEY NOT NULL,
    DES_NOME      VARCHAR(40) NOT NULL,
    NUM_CPF_CNPJ  VARCHAR(16) NOT NULL,
    DT_NASCIMENTO TIMESTAMP,
	VLR_COMPRA    REAL,
	FLG_ATIVO     VARCHAR(1) DEFAULT '0'
);

INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (1, 'Cliente Um', '11111111111', TIMESTAMP '2012-01-05 13:15:10', 20.50, '1');
INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (2, 'Cliente Dois', '44444444444444', TIMESTAMP '2013-02-10 15:20:20', 35.32, '1');
INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (3, 'Cliente Tres', '22222222222', TIMESTAMP '2014-03-15 17:25:30', 50.75, '0');
INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (4, 'Cliente Quatro', '55555555555555', TIMESTAMP '2015-04-20 19:30:40', 90.38, '0');
INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (5, 'Cliente Cinco', '33333333333', TIMESTAMP '2016-05-25 21:35:50', 120.12, '1');
INSERT INTO CLIENTE (ID, DES_NOME, NUM_CPF_CNPJ, DT_NASCIMENTO, VLR_COMPRA, FLG_ATIVO)
VALUES (6, 'Cliente Seis', '66666666666666', TIMESTAMP '2017-06-30 23:40:58', 200.87, '1');
COMMIT;
```

### Criação de datasourse no Wildfly

* **Type:** Non-XA
* **Name:** ntconsultDS
* **JNDI:** java:/ntconsultDS

**OBS:** Será necessário incluir o [Driver JDBC do PostgreSQL](http://central.maven.org/maven2/org/postgresql/postgresql/9.4-1200-jdbc41/postgresql-9.4-1200-jdbc41.jar) no **Wildfly** e para criar o **datasource** utilizando o mesmo. Seguir o [exemplo](https://horochovec.com.br/configurando-um-datasource-do-postgresql-no-wildfly-973558fc155).
___

## Informações para testes do serviço

* URL Servico: http://localhost:8080/ntconsultws/ClienteService/ClienteService?wsdl

**OBS:** Lembrando que **localhost** é o domínio ao qual esse serviço pertence e **8080** é a porta de acesso. O domínio e porta devem ser ajustados conforme ambiente instalado.

### Exemplo de Request SoapUI BUSCAR
```html
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.ntconsultws.com.br">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:buscar>
         <!--Optional:-->
         <inBusca>
            <!--Optional:-->
            <nome>Cliente Dois</nome>
            <!--Optional:-->
            <numCpfCnpj>44444444444444</numCpfCnpj>
            <!--Optional:-->
            <dtNascimento>2013-02-10T15:20:20</dtNascimento>
            <!--Optional:-->
            <flgAtivo>1</flgAtivo>
         </inBusca>
      </ser:buscar>
   </soapenv:Body>
</soapenv:Envelope>
```

### Exemplo de Request SoapUI SALVAR
```html
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.ntconsultws.com.br">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:salvar>
         <!--Optional:-->
         <inSalva>
            <nome>Teste Salvar</nome>
            <numCpfCnpj>0234567890</numCpfCnpj>
            <!--Optional:-->
            <dtNascimento>2013-02-10T15:20:20</dtNascimento>
            <!--Optional:-->
            <vlrCompra>6.50</vlrCompra>
            <!--Optional:-->
            <flgAtivo>1</flgAtivo>
         </inSalva>
      </ser:salvar>
   </soapenv:Body>
</soapenv:Envelope>
```

### Exemplo de Request SoapUI REMOVER
```html
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service.ntconsultws.com.br">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:remover>
         <!--Optional:-->
         <inRemove>
            <!--Optional:-->
            <id>7</id>
            <!--Optional:-->
            <nome>Teste Salvar</nome>
            <!--Optional:-->
            <numCpfCnpj>0234567890</numCpfCnpj>
            <!--Optional:-->
            <dtNascimento>2013-02-10T15:20:20</dtNascimento>
            <!--Optional:-->
            <flgAtivo>1</flgAtivo>
         </inRemove>
      </ser:remover>
   </soapenv:Body>
</soapenv:Envelope>
```

**IMPORTANTE:** Para as operações que utilizam os filtros **id** e **dtNascimento**: caso não queira uliliza-los nos testes das operações dos serviços, é necessário remove-los do **request** para não retonar erro (limitações da ferramenta).
