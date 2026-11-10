package ar.edu.unlam;

import java.time.LocalDate;
import java.util.Objects;

import enuns.TipoSocio;

public class Cliente implements Comparable<Cliente> {
	private String nombre;
	private Integer dni;
	private TipoSocio tipo;

	public Cliente(String nombre, Integer dni, TipoSocio tipo) {
		this.nombre = nombre;
		this.dni = dni;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public TipoSocio getTipo() {
		return tipo;
	}

	public void setTipo(TipoSocio tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Cliente o) {
		// Orden natural: nombre asc y, a igual nombre, dni asc
		int comparacionNombre = this.nombre.compareTo(o.getNombre());
		if (comparacionNombre == 0) {
			return this.dni.compareTo(o.getDni());
		}
		return comparacionNombre;

	}

	@Override
	public int hashCode() {
		return Objects.hash(dni); // Cliente por dni
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni); // Cliente por dni
	}
}