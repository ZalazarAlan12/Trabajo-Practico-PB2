package ar.edu.unlam;

import java.util.Comparator;

public class OrdenarPorPrecioYnombre implements Comparator<ProductoAudioVisual>{

	@Override
	public int compare(ProductoAudioVisual o1, ProductoAudioVisual o2) {
		// TODO Auto-generated method stub
		int porPrecio = o2.getPrecioBase().compareTo(o1.getPrecioBase());
		
		if (porPrecio == 0) {
			return o2.getNombre().compareTo(o1.getNombre());
		}
		return porPrecio;
	}

}
