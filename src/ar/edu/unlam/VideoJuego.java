package ar.edu.unlam;

import enuns.TipoDeGenero;

public class VideoJuego extends ProductoAudioVisual implements Descontable {
	private String plataforma;

	public VideoJuego(String codigo, String nombre, Double precioBase, TipoDeGenero genero)
			throws CodigoRepetidoException {
		super(codigo, nombre, precioBase, genero);
		// TODO Auto-generated constructor stub
	}


	

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	@Override
	public Double calcularPrecioAlquiler(Integer dias) {
		return (getPrecioBase() * dias) + 500.0;
	}

	public Double aplicarDescuento(Double porcentaje) {
		return getPrecioBase() * (1.0 - (porcentaje / 100.0));
	}
}