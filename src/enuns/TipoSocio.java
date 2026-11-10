package enuns;

public enum TipoSocio {
ESTANDAR(2),
PREMIUM(4);
	
	private final Integer limiteAlquileres;
	 
	TipoSocio(Integer limiteAlquileres) {
		this.limiteAlquileres = limiteAlquileres;
	}
 
	public Integer getLimiteAlquileres() {
		return limiteAlquileres;
	}
}
