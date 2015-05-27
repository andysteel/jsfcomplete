package com.gmail.andersoninfonet.jsfcomplete.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.gmail.andersoninfonet.jsfcomplete.model.Grupo;

public class GrupoRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	public void insert(Grupo group){
		this.manager.persist(group);
	}

}
