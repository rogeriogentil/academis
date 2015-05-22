package org.academis.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Rogerio J. Gentil <rogerio_gentil@yahoo.com.br>
 */
@ManagedBean(name = "loginManagedBean")
@RequestScoped
public class LoginManagedBean {

   private static final String PRINCIPAL = "principal";
   private String usuario;
   private String senha;

   public LoginManagedBean() {
   }
   
   public String getUsuario() {
      return usuario;
   }

   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }

   public String getSenha() {
      return senha;
   }

   public void setSenha(String senha) {
      this.senha = senha;
   }

   public String entrar() {
      return PRINCIPAL;
   }
}
