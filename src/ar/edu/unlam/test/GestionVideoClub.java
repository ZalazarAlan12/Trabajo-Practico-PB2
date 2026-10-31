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




	public Boolean registrarProdutoAudioVisual(ProductoAudioVisual producto) throws CodigoInvalidoExeption {
		
					
			if(producto.validarCodigo()) {
				
			 catalogo.put(producto.getCodigo(), producto);
			    return true ;
			}
		
				
		
		
		return null;
	}




}
