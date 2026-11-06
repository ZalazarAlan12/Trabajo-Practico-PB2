package ar.edu.unlam;

import java.util.Objects;

public abstract class ProductoAudioVisual {

	private String codigo;
	private String titulo;
	private Double precioBase;
	private Integer stock;

	public ProductoAudioVisual(String codigo , String titulo ,Double precio ) {
			
	this.codigo = codigo ;
	this.titulo = titulo ;
	this.precioBase = precio ;
	this.stock = 0;
	
	}
	
	
	
	
	public Integer getStock() {
		return stock;
	}




	public void setStock(Integer stock) {
		this.stock = stock;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public Double getPrecioBase() {
		return precioBase;
	}

	


	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProductoAudioVisual))
			return false;
		ProductoAudioVisual other = (ProductoAudioVisual) obj;
		return Objects.equals(codigo, other.codigo);
	}




	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}
	
	public abstract Boolean validarCodigo() throws CodigoInvalidoException;




	public abstract double calcularPrecioAlquiler(Integer dias);



}