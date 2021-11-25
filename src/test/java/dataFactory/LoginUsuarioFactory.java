package dataFactory;

import pojo.UsuarioPojo;

public class LoginUsuarioFactory {
    public static UsuarioPojo criarLoginUsuarioComEmailIgualA(){
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setEmail("kenia@teste.com.br");
        usuario.setPassword("teste123");
        return usuario;
    }

    public static UsuarioPojo criarLoginUsuarioComEmailIgualDivergente(String email){
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setEmail(email);
        usuario.setPassword("teste123");
        return usuario;
    }

}

