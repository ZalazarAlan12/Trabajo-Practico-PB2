package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import enuns.TipoDeGenero;

import org.junit.Test;

public class VideoClubTest {
	private GestionVideoClub videoClub ;
	private ProductoAudioVisual productoUno;
	private ProductoAudioVisual productoDos;
	private ProductoAudioVisual productoTres;
	private Cliente clienteUno;
	private Cliente clienteDos;
	private Cliente clienteTres;
	@Before
	public void setUp() {
		videoClub = new GestionVideoClub() ;
		
		productoUno = new Pelicula("P-155-P" , "Trasformer", 20.0,  TipoDeGenero.ACCION);
		productoDos = new Serie ("S-266-S" , "Band of brother" , 25.0 , TipoDeGenero.ACCION);
		productoTres = new VideoJuego("V-977-V" , "Tekken 5" , 15.0  );
		
		clienteUno = new Cliente("Ruben", 45632145 );
		clienteDos = new Cliente("Maria", 45772145 );
		clienteTres = new Cliente("pedro", 40942145 );
			
		
	}
	
	/*Test 01*/
	
	
	@Test
	public void queSeRegistreUnaPeliculaEnElCatalogo() throws Exception {
		
	videoClub.registrarProdutoAudioVisual(productoUno);	
	
	Map<String, ProductoAudioVisual> catalogo = videoClub.getCatalogo() ;			
		
	assertEquals(1, catalogo.size());
	
	}
	
	/*Test 02*/
	/*se espera que lanze la exeption de codigo repetido*/
	
	@Test (expected = CodigoRepetidoException.class)
	public void queNoSeRegistreUnTituloConCodigoRepetido() throws Exception {
		
		ProductoAudioVisual nuevo = new Pelicula("P-155-P" , "DeadPool", 20.0,  TipoDeGenero.ACCION);
		
		
		
		videoClub.registrarProdutoAudioVisual(productoUno);
		
		videoClub.registrarProdutoAudioVisual(nuevo);
		
	}
	
	/*Test 03*/
	/*Se espera que lanze la exeption de codigo invalido*/
	
	@Test (expected = CodigoInvalidoException.class)
	public void queFalleAlRegistrarUnTituloConCodigoInvalido() throws Exception {
		
		ProductoAudioVisual nuevo = new Pelicula("S-155-P" , "DeadPool", 20.0,  TipoDeGenero.ACCION);
		
		videoClub.registrarProdutoAudioVisual(nuevo);
		
	}
	
	
	/*Test 04*/ 
	/*Lanza la exeption productoInexcistente*/
	
	
	@Test (expected = ProductoInexistenteException.class)
	public void  queFalleAlBuscarUnTituloInexistente() throws ProductoInexistenteException {
		
	ProductoAudioVisual encontrado = videoClub.buscarProductoAudioVisualPorTitulo("Dead Pool");
		
		
		
	}
	/*Test 05*/
	@Test
	public void queSeRegistreUnClienteYNoSeDupliquePorDni() {
		 
		Cliente nuevo = new Cliente("Maxi", 45632145 );
		
		Boolean seRegistro = videoClub.registrarCliente(clienteUno);
		
		
		assertTrue(seRegistro);
		
		seRegistro = videoClub.registrarCliente(nuevo);
		
		assertFalse(seRegistro);
		
	}
	/*Test 06*/
	@Test
	public void queFalleAlBuscarUnClienteInexistente() {
		
		
	}
	
	
	/*Test 07*/
	@Test
	public void queElPrecioDeAlquilerDependaDelTipoDeTitulo() {
		
		
		
	}
	
	/*Test 08*/
	@Test
	public void queSeRegistreUnAlquilerYSeDescuenteElStock() {
		
		
	}
	/*Test 09*/
	@Test
	public void  queFalleSiNoHayEjemplaresDisponibles() {
		
		
	}
	/*Test 10*/
	@Test
	public void  queFalleAlSuperarElLimiteDeAlquileresSegunElTipoDeSocio() {
		
	}
	/*Test 11*/
	@Test
	public void queLaDevolucionRepongaElStockYCalculeElRecargoPorDemora() {
		
	}
	/*Test 12*/
	@Test	
	public void queFalleAlDevolverUnAlquilerInexistenteOYaDevuelto() {
		
		
		
	}
	/*Test 13*/
	@Test	
	public void queLosClientesSeObtenganOrdenadosPorOrdenNatural() {
		
		
	}
	/*Test 14*/
	@Test	
	public void  queLosTitulosSeOrdenenPorPrecioDescendenteYLuegoPorNombre() {
		
		
	}
	/*Test 15*/
	@Test	
	public void  queSeApliqueDescuentoSoloALosTitulosDescontables() {
		
		
		
	}
	
	
	
}
