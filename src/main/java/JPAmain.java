import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gmail.andersoninfonet.jsfcomplete.model.Grupo;
import com.gmail.andersoninfonet.jsfcomplete.model.Usuario;
import com.gmail.andersoninfonet.jsfcomplete.repository.GrupoRepository;
import com.gmail.andersoninfonet.jsfcomplete.repository.UsuarioRepository;


public class JPAmain {

	public static void main(String[] args) {
		
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("JsfcompletePU");
		EntityManager manager = factory.createEntityManager();
		
		List<Grupo> lista = new ArrayList<Grupo>();
		
		/*UsuarioRepository userRep = new UsuarioRepository();
		GrupoRepository grpRep = new GrupoRepository();
		
		Grupo grupo1 = new Grupo();
		grupo1.setNome("ADMINISTRADOR");
		grupo1.setDescricao("alto previlegio");
		
		Grupo grupo2 = new Grupo();
		grupo2.setNome("USUARIO");
		grupo2.setDescricao("baixo previlegio");*/
		
		manager.getTransaction().begin();
		System.out.println("inicio persistir ....");
		
		//grpRep.insert(grupo1);
		//grpRep.insert(grupo2);
		//manager.persist(grupo1);
		//manager.persist(grupo2);
		
		Grupo grupo3 = new Grupo();
		grupo3 = manager.find(Grupo.class, 51L);
		System.out.println("Grupo: "+grupo3.getId());
		
		lista.add(grupo3);
		
		
		Usuario user = new Usuario();
		user.setEmail("lucianadias@gmail.com");
		user.setNome("Luciana Dias");
		user.setSenha("123456");
		user.setGrupos(lista);
		
		//userRep.insert(user);
		manager.persist(user);
		
		manager.getTransaction().commit();

		System.out.println("USUARIO ID: "+user.getId());
		System.out.println("FIM !!!");
		
		manager.close();
		factory.close();
	}

}
