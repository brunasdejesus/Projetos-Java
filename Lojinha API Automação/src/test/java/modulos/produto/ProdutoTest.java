package modulos.produto;



import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.ComponentePojo;
import pojo.ProdutoPojo;
import pojo.UsuarioPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



@DisplayName("Testes de API Rest do modulo de Produto")

public class ProdutoTest {
    private String token;

    @BeforeEach
    public void beforeEach(){
        // Configurando os dados da API Rest da Lojinha
        baseURI = "http://165.227.93.41";
        basePath = "/lojinha";



        // Obter o Token do Usuário Admin
         this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.criarUsuarioAdministrador())
            .when()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token");

    }

    @Test
    @DisplayName("Validar que o valor 0.00 é proibido")
    public void testValidarLimitesProibidosValorProduto(){


        // Tentar inserir um produto com o valor 0.00 e validar que a mensagem de erro foi apresentada e o
        // Status code retornado foi 422

        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(0.00))
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);




    }
    @Test
    @DisplayName("Validar que o valor 7500 é proibido")
    public void testValidarLimitesProibidosValormaiorquesetemilProduto() {


        // Tentar inserir um produto com o valor maior do que 7000 e validar que a mensagem de erro foi apresentada e o
        // Status code retornado foi 422
        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(7500))
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);
    }


}
