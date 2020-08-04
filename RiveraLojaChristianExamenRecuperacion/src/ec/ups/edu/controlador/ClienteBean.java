package ec.ups.edu.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.ups.edu.ejb.ClienteFacade;
import ec.ups.edu.ejb.CuentaFacade;
import ec.ups.edu.ejb.TransaccionFacade;
import ec.ups.edu.modelo.Cliente;
import ec.ups.edu.modelo.Cuenta;
import ec.ups.edu.modelo.Transaccion;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ClienteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB 
	private ClienteFacade clienteFacde;
	
	@EJB
	private CuentaFacade cuentaFacade;
	
	@EJB
	private TransaccionFacade transaccionFacade;
	
	
	private String buscarCliente;
	
	private Cliente clienteEncontrado;
	
	private List<Cuenta> cuentasBancarias;
	
	private List<Cuenta> cuentasEncontradas;
	
	
	private List<Transaccion> transacciones;
	
	private int saldoActual;
	

	

	
	public ClienteBean() {
	
	}


	public String getBuscarCliente() {
		return buscarCliente;
	}


	public void setBuscarCliente(String buscarCliente) {
		this.buscarCliente = buscarCliente;
	}
	
	
	
	
	
	
	

	
	public Cliente getClienteEncontrado() {
		return clienteEncontrado;
	}


	public void setClienteEncontrado(Cliente clienteEncontrado) {
		this.clienteEncontrado = clienteEncontrado;
	}

	
	public List<Cuenta> getCuentasBancarias() {
		return cuentasBancarias;
	}


	public void setCuentasBancarias(List<Cuenta> cuentasBancarias) {
		this.cuentasBancarias = cuentasBancarias;
	}

	
	


	public int getSaldoActual() {
		return saldoActual;
	}


	public void setSaldoActual(int saldoActual) {
		this.saldoActual = saldoActual;
	}


	public List<Cuenta> getCuentasEncontradas() {
		return cuentasEncontradas;
	}

	public void setCuentasEncontradas(List<Cuenta> cuentasEncontradas) {
		this.cuentasEncontradas = cuentasEncontradas;
	}
	
	public void agregarList(Cuenta cu) {
		this.cuentasEncontradas.add(cu);
		
	}
	
	
	
	
	

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	/////////////////
	public String buscarCliente() {
		
		System.out.println("llego la cedula" + this.buscarCliente);
		
		List<Cliente> cli = null;
		
		try {
			
			cli = clienteFacde.buscarCliente(this.buscarCliente);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Encontro al Cliente");
		}
		
		for (Cliente cliente1 : cli) {
			this.clienteEncontrado = cliente1;
			
		}
		
		///////////////////
		
		List<Cuenta> cuentas = this.clienteEncontrado.getCuentas();
		
		this.cuentasEncontradas = cuentas;
	try {
		
		for (Cuenta cuenta2 : cuentas) {
			
			
			System.out.println(cuenta2.getCodigo());
			
			List<Transaccion> tran = cuenta2.getTransacciones();
			this.transacciones = transaccionFacade.findAll();
			for (Transaccion t : tran) {
				System.out.println("tipo de transaccion = " + t.getTipoTransaccion());
				int numEntero =0;
				int numEntero2 =0;
				int x = 0;
				int y = 0;
				if(t.getTipoTransaccion().equals("retiro")) {
					System.out.println("retiro");
					numEntero = Integer.parseInt(t.getDescripccion());
					System.out.println("Valor------" + numEntero);
					x=x+numEntero;
				}else if(t.getTipoTransaccion().equals("deposito")){
					numEntero2 =Integer.parseInt(t.getDescripccion());;
					System.out.println("Valor------" + numEntero2);
					y=y+numEntero2;
				}
				
				int resultado = x - y;
				System.out.println("Saldo actual = "+ resultado);
				this.saldoActual = resultado;
				
			}
			
			
		}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se encontraron las cuentas");
		}
	
	
	//////////////////////////////////

	
		
		
		return null;
	}
	
	

	
	
	
		
		
		

	
	
	
	
	

}
