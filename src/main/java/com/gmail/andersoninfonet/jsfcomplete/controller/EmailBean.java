package com.gmail.andersoninfonet.jsfcomplete.controller;

import java.io.Serializable;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.Email;

import com.gmail.andersoninfonet.jsfcomplete.util.email.EmailFactory;
import com.gmail.andersoninfonet.jsfcomplete.util.jsf.FacesUtil;

@Named(value="emailBean")
@RequestScoped
public class EmailBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmailFactory emailFactory;
	
	@Email(message="Deve ser um email válido !")
	private String destinatario;
	private String assunto;
	private String mensagem;
	
	public void envia(){
		
		if(emailFactory.enviaEmail(destinatario, assunto, mensagem) == true){
			destinatario = null;
			assunto = null;
			mensagem = null;
			FacesUtil.addInfoMessage("Email enviado com sucesso !");
		}
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
