package ar.edu.unlam;

import java.util.Objects;

import enuns.TipoDeGenero;

public abstract class ProductoAudioVisual implements Alquilable {

	private String codigo;
	private String nombre;
	private Double precioBase;
	private Integer stock;
	private TipoDeGenero genero;
 
	public ProductoAudioVisual(String codigo, String nombre, Double precioBase, TipoDeGenero genero) throws CodigoRepetidoException {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.genero = genero;
		this.stock = 0;

	}
 
	private void validarCodigo(String codigo) throws CodigoRepetidoException {
		if (codigo == null || (!codigo.startsWith("P") && !codigo.startsWith("S") && !codigo.startsWith("V"))) {
			throw new CodigoRepetidoException("El código debe comenzar con P, S o V");
		}
	}
 
	public String getCodigo() {

		return codigo;

	}
 
	public String getNombre() {

		return nombre;

	}
 
	public Double getPrecioBase() {

		return precioBase;

	}
 
	public void setPrecioBase(Double precioBase) {

		this.precioBase = precioBase;

	}
 
	public Integer getStock() {

		return stock;

	}
 
	public void setStock(Integer stock) {

		this.stock = stock;

	}
 
	public TipoDeGenero getGenero() {

		return genero;

	}
 
	@Override

	public int hashCode() {

		return Objects.hash(codigo);

	}
 
	@Override

	public boolean equals(Object obj) {

		if (this == obj) return true;

		if (obj == null || getClass() != obj.getClass()) return false;

		ProductoAudioVisual other = (ProductoAudioVisual) obj;

		return Objects.equals(codigo, other.codigo);

	}

}
 