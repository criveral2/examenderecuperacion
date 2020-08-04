package ec.ups.edu.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.ups.edu.ejb.TransaccionFacade;


@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class TransaccionBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EJB
	private TransaccionFacade transaccionFacade;

	public TransaccionBean() {
	
	}
	
	

}
