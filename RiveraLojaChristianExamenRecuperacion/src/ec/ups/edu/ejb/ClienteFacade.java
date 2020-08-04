package ec.ups.edu.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.Cliente;


@Stateless
public class ClienteFacade extends AbstractFacade<Cliente>{
	

	@PersistenceContext(unitName = "RiveraLojaChristianExamenRecuperacion")
	private EntityManager em1;
	
	public ClienteFacade() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em1;
	}
	
	public List<Cliente> buscarCliente(String cedula) {
		String qu = "SELECT c FROM Cliente c WHERE c.cedula = '"+cedula+"'";
		System.out.println("query-----------"+qu);
		List<Cliente> query =  em1.createQuery(qu).getResultList();
		System.out.println("------Entro al query 2------");
		
		for (Cliente facturaCabecera : query) {
			System.out.println(facturaCabecera.getCedula());	
		}
		return query;
	}


}
