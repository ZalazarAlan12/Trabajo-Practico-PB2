package ar.edu.unlam.test;

import static org.junit.Assert.assertTrue;

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
		
	
		
		
	}
	
	/*Test 01*/
	
	
	@Test
	public void queSeRegistreUnaPeliculaEnElCatalogo() throws CodigoInvalidoExeption {
		
		
	Boolean seRegistro = videoClub.registrarProdutoAudioVisual(productoUno);	
		
	assertTrue(seRegistro);
		
	}
	
	/*Test 02*/
	
	@Test 
	public void queNoSeRegistreUnTituloConCodigoRepetido() {
		
		
		
	}
	
	/*Test 03*/
	@Test
	public void queFalleAlRegistrarUnTituloConCodigoInvalido() {
		
		
	}
	
	
	/*Test 04*/
	@Test
	public void  queFalleAlBuscarUnTituloInexistente() {
		
		
	}
	/*Test 05*/
	@Test
	public void queSeRegistreUnClienteYNoSeDupliquePorDni() {
		
		
		
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
