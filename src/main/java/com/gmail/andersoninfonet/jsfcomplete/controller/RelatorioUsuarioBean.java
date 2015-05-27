package com.gmail.andersoninfonet.jsfcomplete.controller;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.gmail.andersoninfonet.jsfcomplete.util.jsf.FacesUtil;
import com.gmail.andersoninfonet.jsfcomplete.util.report.ExecutorRelatorio;

@Named(value="relatorioUsuarioBean")
@RequestScoped
public class RelatorioUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private HttpServletResponse response;

	@Inject
	private EntityManager manager;
	
	public void emitir() {
		Map<String, Object> parametros = new HashMap<>();
		
		String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/classes/relatorios/Leaf_Red.jasper");
		
		ExecutorRelatorio executor = new ExecutorRelatorio(path,
				this.response, parametros, "Usuarios ativos.pdf");
		
		Session session = manager.unwrap(Session.class);
		session.doWork(executor);
		
		if (executor.isRelatorioGerado()) {
			facesContext.responseComplete();
		} else {
			FacesUtil.addErrorMessage("A execução do relatório não retornou dados.");
		}
	}
}
