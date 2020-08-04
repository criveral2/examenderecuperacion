package ec.ups.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.modelo.Transaccion;

@Stateless
public class TransaccionFacade extends AbstractFacade<Transaccion> {
	
	@PersistenceContext(unitName = "RiveraLojaChristianExamenRecuperacion")
	private EntityManager em1;

	public TransaccionFacade() {
		super(Transaccion.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em1;
	}

}
