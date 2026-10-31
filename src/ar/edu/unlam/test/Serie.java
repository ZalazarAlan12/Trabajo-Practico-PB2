package ar.edu.unlam.test;

import enuns.TipoDeGenero;

public class Serie extends ProductoAudioVisual {

	private TipoDeGenero genero;

	public Serie(String codigo, String titulo, Double precio , TipoDeGenero genero) {
		super(codigo, titulo, precio);
		
		this.genero = genero ;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean validarCodigo() throws CodigoInvalidoExeption {
	
		
		if(super.getCodigo().startsWith("S")&& super.getCodigo().endsWith("S")) {
			
			return true ;
		}
	
	throw new CodigoInvalidoExeption ("Codigo invalido");
	}

		
	
	}

	


