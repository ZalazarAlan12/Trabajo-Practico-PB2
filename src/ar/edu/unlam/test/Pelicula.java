package ar.edu.unlam.test;

import enuns.TipoDeGenero;

public class Pelicula extends ProductoAudioVisual{

	private TipoDeGenero genero;

	public Pelicula(String codigo, String titulo, Double precio, TipoDeGenero genero) {
		super(codigo, titulo, precio);
		
		this.genero = genero ;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean validarCodigo() throws CodigoInvalidoExeption {
		if(super.getCodigo().startsWith("P")&& super.getCodigo().endsWith("P")) {
			
			return true ;
		}
	
	throw new CodigoInvalidoExeption ("Codigo invalido");
}



}
