package ec.ups.edu.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.ups.edu.ejb.TransaccionFacade;
import ec.ups.edu.modelo.Transaccion;



public class TransaccionRest {
	
	@Path("/transaccion")
	public class PacienteRest {
	    
	    @EJB
	    private TransaccionFacade transaccionesFacade;

	    
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response get() {
	        
	        System.out.println("Entrando al metodo get del productos");
	        Jsonb jsonb = JsonbBuilder.create();
	        
	        List<Transaccion> libro = transaccionesFacade.findAll();
	        return Response.ok(jsonb.toJson(libro)).header("Access-Control-Allow-Origin", "*").build();
	         
	    }

}
}
