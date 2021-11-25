package dataFactory;

import pojo.UsuarioPojo;

public class UsuarioDataFactory {
    public static UsuarioPojo criarUsuarioComEmailIgualA(String email){
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setNome("Caio");
        usuario.setEmail(email);
        usuario.setPassword("caio@123");
        usuario.setAdministrador("true");
        return usuario;
    }

}
