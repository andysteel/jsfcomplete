package com.gmail.andersoninfonet.jsfcomplete.controller;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value="temaEscolhidoBean")
@SessionScoped
public class TemaEscolhidoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String tema = "bootstrap";//padrão

	public String getTema() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		if(params.containsKey("tema")){
			tema = params.get("tema");
		}
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
