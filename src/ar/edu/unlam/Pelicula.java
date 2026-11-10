package ar.edu.unlam;

import enuns.TipoDeGenero;

public class Pelicula extends ProductoAudioVisual implements Descontable {
	private Integer duracionMinutos;

	public Pelicula(String codigo, String nombre, Double precioBase, TipoDeGenero genero) throws CodigoRepetidoException {
		super(codigo, nombre, precioBase, genero);
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(Integer duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	@Override
	public Double calcularPrecioAlquiler(Integer dias) {
		return getPrecioBase() * dias;
	}

	@Override
	public Double aplicarDescuento(Double porcentaje) {
		return getPrecioBase() * (1.0 - (porcentaje / 100.0));
	}
}