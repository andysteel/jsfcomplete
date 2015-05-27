package com.gmail.andersoninfonet.jsfcomplete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.gmail.andersoninfonet.jsfcomplete.model.Usuario;
import com.gmail.andersoninfonet.jsfcomplete.repository.UsuarioRepository;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter{

	@Inject
	private UsuarioRepository usuRep;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		Usuario retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.usuRep.porId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		if (value != null) {
			return ((Usuario) value).getId().toString();
		}
		return "";
	}

}
