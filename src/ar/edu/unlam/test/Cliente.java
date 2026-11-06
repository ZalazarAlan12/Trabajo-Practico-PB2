package ar.edu.unlam.test;

import java.util.Objects;

public class Cliente {
	
private Integer numeroCliente ; 	
private String nombre;
private Integer dni;

public Cliente (String nombre,  Integer dni) {
	
	this.nombre = nombre ;
	this.dni = dni ;
	this.numeroCliente = null ;	
}



@Override
public int hashCode() {
	return Objects.hash(dni);
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
	return Objects.equals(dni, other.dni);
}



public Integer getNumeroCliente() {
	return numeroCliente;
}



public void setNumeroCliente(Integer numeroCliente) {
	this.numeroCliente = numeroCliente;
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
	
}
