package modulos.usuarios;
import dataFactory.LoginUsuarioFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.UsuarioPojo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do modulo Usuários")
public class UsuariosTest {
    private String token;
    private String _idUsuario;

    @BeforeEach
    //rodar antes de cada teste
    public void  beforeEach() {
        //Configurando os dados da API REST
        baseURI = "https://serverest.dev";


    }


    @Test
    @DisplayName("Validar Cadastro valido de ususário (Status code:201)")
    public void testValidarCadastroUsuarioSucesso(){



        given()
                    .contentType(ContentType.JSON)
                    .body(UsuarioDataFactory.criarUsuarioComEmailIgualA("hoje@teste.com.br"))
        .when()
                    .post("/usuarios")

        .then()

                    .assertThat()
                        .body("message", equalTo("Cadastro realizado com sucesso"))
                        .statusCode(201);



        }


    @Test
    @DisplayName("Validar Cadastro de usuario já existente (status code: 400)")
    public void testValidarCadastroUsuarioExistente(){

        given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.criarUsuarioComEmailIgualA("testehoje@teste.com.br"))
                .when()
                .post("/usuarios")

                .then()

                .assertThat()
                .body("message", equalTo("Este email já está sendo usado"))
                .statusCode(400);



    }


    @Test
    @DisplayName("Validar consulta de um cadstro pelo ID")
    public void testValidarConsultaCadastroIDSucesso() {


        given()
                .contentType(ContentType.JSON)
        .when()
                .get("/usuarios/Dc77dOv9l6ZxYj3N")

        .then()

                .assertThat()

               .body("_id", equalTo("Dc77dOv9l6ZxYj3N"))

                .statusCode(200);


    }

        @Test
        @DisplayName("Validar Lista cadastro")
        public void testValidarListaCadastroSucesso(){


            given()
                    .contentType(ContentType.JSON)
            .when()
                    .get("/usuarios?nome=Caio")

            .then()


                    .assertThat()
                    .body("usuarios.nome", equalTo("<[Caio, Caio, Caio]>"))

                    .statusCode(200);

        }


}
