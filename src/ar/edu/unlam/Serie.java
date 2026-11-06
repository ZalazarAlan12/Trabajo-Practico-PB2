package ar.edu.unlam;

import enuns.TipoDeGenero;

public class Serie extends ProductoAudioVisual {

	private TipoDeGenero genero;

	public Serie(String codigo, String titulo, Double precio , TipoDeGenero genero) {
		super(codigo, titulo, precio);
		
		this.genero = genero ;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean validarCodigo() throws CodigoInvalidoException {
	
		
		if(super.getCodigo().startsWith("S")&& super.getCodigo().endsWith("S")) {
			
			return true ;
		}
	
	throw new CodigoInvalidoException ("Codigo invalido");
	}

	@Override
	public double calcularPrecioAlquiler(Integer dias) {
		return (getPrecioBase() * dias) + 10.0;
	}

		
	
	}

	


