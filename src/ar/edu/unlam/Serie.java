package ar.edu.unlam;

import enuns.TipoDeGenero;

public class Serie extends ProductoAudioVisual {
	private Integer temporadas;

	public Serie(String codigo, String nombre, Double precioBase, TipoDeGenero genero) throws CodigoRepetidoException {
		super(codigo, nombre, precioBase, genero);
		this.temporadas = 1;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(Integer temporadas) {
		this.temporadas = temporadas;
	}

	@Override
	public Double calcularPrecioAlquiler(Integer dias) {
		return (getPrecioBase() * dias) + (100.0 * temporadas);
	}




	
}