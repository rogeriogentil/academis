package org.academis.controller;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Rogerio J. Gentil <rogerio_gentil@yahoo.com.br>
 */
@ManagedBean
public class LoginManagedBean {

   private static final String PRINCIPAL = "principal";
   private static final String INDEX = "index";
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
      System.out.println(PRINCIPAL);
      return PRINCIPAL;
   }
   
   public String sair() {
      return INDEX;
   }
}
