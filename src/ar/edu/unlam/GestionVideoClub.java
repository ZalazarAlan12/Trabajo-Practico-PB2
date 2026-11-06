package ar.edu.unlam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GestionVideoClub {

	private Map <String , ProductoAudioVisual> catalogo ;
	private HashSet<Cliente> clientes ;
	private List<Alquiler> alquileres;
	
	public GestionVideoClub () {
		
		this.catalogo = new HashMap<String, ProductoAudioVisual>();
		this.clientes = new HashSet<Cliente>();
		this.alquileres = new ArrayList<>();
		
	}
	
	
	
	
	public Map<String, ProductoAudioVisual> getCatalogo() {
		return catalogo;
	}




	public void setCatalogo(Map<String, ProductoAudioVisual> catalogo) {
		this.catalogo = catalogo;
	}







	public HashSet<Cliente> getClientes() {
		return clientes;
	}




	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}




	public void registrarProdutoAudioVisual(ProductoAudioVisual producto) throws Exception{
			
		
			validarProducto(producto);		
			
			catalogo.put(producto.getCodigo(), producto);
			  	
		
			
			
			
			
	}




	private Boolean validarProducto(ProductoAudioVisual producto) throws CodigoInvalidoException, CodigoRepetidoException {
		
		if(producto.validarCodigo() && catalogo.containsKey(producto.getCodigo())) {
			
			throw new CodigoRepetidoException ("El codigo ya existe");
		}
		
		return true ;

	}




	public ProductoAudioVisual buscarProductoAudioVisualPorTitulo(String titulo) throws ProductoInexistenteException {
	
		
		for (Map.Entry<String, ProductoAudioVisual> entry : this.catalogo.entrySet()) {
			String key = entry.getKey();
			ProductoAudioVisual val = entry.getValue();
			
			if(val.getTitulo().trim().toLowerCase().equals(titulo.trim().toLowerCase())) {
				
				return val;
				
			}
			
		}
		
			throw new ProductoInexistenteException("Producto no encontrado");
	}




	public Boolean registrarCliente(Cliente clienteUno) {
		
		
		
		return clientes.add(clienteUno);
	}




	public Cliente buscarCliente(Integer dni) throws ClienteNoEncontradoException{
		throw new ClienteNoEncontradoException("El cliente no fue encontrado");
		
	}




	public Boolean registrarAlquiler(Cliente clienteUno, ProductoAudioVisual productoUno) throws TituloNoDisponibleException{
	    if (productoUno.getStock() <= 0) {
	        throw new TituloNoDisponibleException("No hay ejemplares disponibles");
	    }
	    
	    productoUno.setStock(productoUno.getStock() - 1);
	    
	    Alquiler nuevoAlquiler = new Alquiler(1, clienteUno, LocalDate.now(), productoUno);
	    
	    return this.alquileres.add(nuevoAlquiler);
	}




}
