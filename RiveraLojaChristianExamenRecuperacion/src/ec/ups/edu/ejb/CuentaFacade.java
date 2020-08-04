package ec.ups.edu.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.ups.edu.modelo.Cuenta;

@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> {
	
	@PersistenceContext(unitName = "RiveraLojaChristianExamenRecuperacion")
	private EntityManager em1;

	public CuentaFacade() {
		super(Cuenta.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em1;
	}
	
	public List<Cuenta> buscarCliente(String cuenta) {
		String qu = "SELECT c FROM Cliente c WHERE c.cedula = '"+cuenta+"'";
		System.out.println("query-----------"+qu);
		List<Cuenta> query =  em1.createQuery(qu).getResultList();
		System.out.println("------Entro al query 2------");
		
		for (Cuenta facturaCabecera : query) {
			System.out.println(facturaCabecera.getCodigo());	
		}
		return query;
	}
	

}
