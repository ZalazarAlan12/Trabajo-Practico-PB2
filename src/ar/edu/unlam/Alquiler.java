package ar.edu.unlam;

import java.time.LocalDate;

public class Alquiler {
	private Cliente cliente;
	private ProductoAudioVisual producto;
	private LocalDate fecha;
	private Integer dias;
	private Boolean devuelto;

	public Alquiler(Cliente cliente, ProductoAudioVisual producto, LocalDate fecha, Integer dias) {
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha;
		this.dias = dias;
		this.devuelto = false;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public ProductoAudioVisual getProducto() {
		return producto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public int getDias() {
		return dias;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(Boolean devuelto) {
		this.devuelto = devuelto;
	}
}