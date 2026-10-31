package ar.edu.unlam.test;

public class VideoJuego extends ProductoAudioVisual {

	
	
	
	
	public VideoJuego(String codigo, String titulo, Double precio) {
		super(codigo, titulo, precio);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	@Override
	public Boolean validarCodigo() throws CodigoInvalidoExeption {
			
			if(super.getCodigo().startsWith("V")&& super.getCodigo().endsWith("V")) {
				
				return true ;
			}
		
		throw new CodigoInvalidoExeption ("Codigo invalido");
	}

}
