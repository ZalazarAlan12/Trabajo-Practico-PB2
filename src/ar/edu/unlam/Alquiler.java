package ar.edu.unlam;

import java.time.LocalDate;

public class Alquiler {
	
	private Integer  id ;
	private Cliente cliente ;
	private LocalDate fechaDeEntrega ;
	private LocalDate fechaDeFinalizacion ;
	private ProductoAudioVisual producto ;
	
	
	public Alquiler (Integer id  , Cliente cliente , LocalDate entrega , ProductoAudioVisual producto) {
		
		this.id = id ;
		this.cliente = cliente ;
		this.fechaDeEntrega = entrega ; 
		this.producto = producto ;
		this.fechaDeFinalizacion = null ;
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public LocalDate getFechaDeEntrega() {
		return fechaDeEntrega;
	}


	public void setFechaDeEntrega(LocalDate fechaDeEntrega) {
		this.fechaDeEntrega = fechaDeEntrega;
	}


	public LocalDate getFechaDeFinalizacion() {
		return fechaDeFinalizacion;
	}


	public void setFechaDeFinalizacion(LocalDate fechaDeFinalizacion) {
		this.fechaDeFinalizacion = fechaDeFinalizacion;
	}


	public ProductoAudioVisual getProducto() {
		return producto;
	}


	public void setProducto(ProductoAudioVisual producto) {
		this.producto = producto;
	}
	
	
	
	
}
