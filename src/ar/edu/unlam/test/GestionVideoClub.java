package ar.edu.unlam.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GestionVideoClub {

	private Map <String , ProductoAudioVisual> catalogo ;
	private HashSet<Cliente> clientes ;
	
	public GestionVideoClub () {
		
		this.catalogo = new HashMap<String, ProductoAudioVisual>();
		this.clientes = new HashSet<Cliente>();
		
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




}
