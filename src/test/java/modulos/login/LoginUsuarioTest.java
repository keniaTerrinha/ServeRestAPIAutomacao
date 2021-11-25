package modulos.login;

import dataFactory.LoginUsuarioFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginUsuarioTest {

    private String token;


    @BeforeEach
    //rodar antes de cada teste
    public void  beforeEach() {
        //Configurando os dados da API REST
        baseURI = "https://serverest.dev";


    }

    @Test
    @DisplayName( "validar login")
    public void  testValidalogin(){


        //obter token usuário
        this.token = given()
                .contentType(ContentType.JSON)
                .body(LoginUsuarioFactory.criarLoginUsuarioComEmailIgualA())
                .when()
                .post("/login")
                .then()
                .extract()
                .path("authorization");
        System.out.println( token);

    }

    @Test
    @DisplayName( "validar login")
    public void  testValidaloginInvalido(){

      given()
                .contentType(ContentType.JSON)
                .body(LoginUsuarioFactory.criarLoginUsuarioComEmailIgualDivergente("test@teste.com.br"))
      .when()
                .post("/login")

      .then()
                .assertThat()
                .body("message", equalTo("Email e/ou senha inválidos"))
                .statusCode(401);


    }


}


