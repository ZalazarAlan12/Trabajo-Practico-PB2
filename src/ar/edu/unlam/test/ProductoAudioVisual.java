package ar.edu.unlam.test;

public abstract class ProductoAudioVisual {

	private String codigo;
	private String titulo;
	private Double precioBase;

	public ProductoAudioVisual(String codigo , String titulo ,Double precio ) {
			
	this.codigo = codigo ;
	this.titulo = titulo ;
	this.precioBase = precio ;
	
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




	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}
	
	public abstract Boolean validarCodigo() throws CodigoInvalidoExeption;



}