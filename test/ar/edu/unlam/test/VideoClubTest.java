package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.junit.Before;

import enuns.TipoDeGenero;
import enuns.TipoSocio;

import org.junit.Test;

import ar.edu.unlam.Cliente;
import ar.edu.unlam.ClienteNoEncontradoException;
import ar.edu.unlam.CodigoInvalidoException;
import ar.edu.unlam.CodigoRepetidoException;
import ar.edu.unlam.Descontable;
import ar.edu.unlam.GestionVideoClub;
import ar.edu.unlam.LimiteAlquileresException;
import ar.edu.unlam.Pelicula;
import ar.edu.unlam.ProductoAudioVisual;
import ar.edu.unlam.ProductoInexistenteException;
import ar.edu.unlam.Serie;
import ar.edu.unlam.TituloNoDisponibleException;
import ar.edu.unlam.VideoJuego;
import ar.edu.unlam.devolucionInvalidaException;

public class VideoClubTest {
	private GestionVideoClub videoClub;
	private ProductoAudioVisual productoUno;
	private ProductoAudioVisual productoDos;
	private ProductoAudioVisual productoTres;
	private Cliente clienteUno;
	private Cliente clienteDos;
	private Cliente clienteTres;
	@Before
	public void setUp() throws CodigoRepetidoException {
		videoClub = new GestionVideoClub();
		
		
		productoUno = new Pelicula("P-155-P", "Trasformer", 1000.0, TipoDeGenero.ACCION);
		
		productoDos = new Serie("S-266-S", "Band of brother", 800.0, TipoDeGenero.ACCION);
		productoTres = new VideoJuego("V-977-V", "Tekken 5", 700.0, TipoDeGenero.TERROR);
		
		clienteUno = new Cliente("Ruben", 45632145, TipoSocio.ESTANDAR);
		clienteDos = new Cliente("Maria", 45772145, TipoSocio.PREMIUM);
		clienteTres = new Cliente("pedro", 40942145, TipoSocio.PREMIUM);
		
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
		
		ProductoAudioVisual nuevo = new Pelicula("XSSS", "DeadPool", 1000.0, TipoDeGenero.ACCION);
		
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
	public void queSeRegistreUnClienteYNoSeDupliquePorDni() throws ClienteNoEncontradoException {
		 videoClub.registrarCliente(clienteUno);
		 
		 assertEquals(1, videoClub.getClientes().size());
		
	}
	/*Test 06*/
	@Test (expected = ClienteNoEncontradoException.class)
	public void queFalleAlBuscarUnClienteInexistente()  throws ClienteNoEncontradoException{
		
		videoClub.buscarCliente(11111111);
		
	}
	
	
	/*Test 07*/
	@Test
	public void queElPrecioDeAlquilerDependaDelTipoDeTitulo() {
		
		assertEquals(2000.0, productoUno.calcularPrecioAlquiler(2), 0.01);
		assertEquals(2500.0, productoDos.calcularPrecioAlquiler(3), 0.01);
		assertEquals(1900.0, productoTres.calcularPrecioAlquiler(2), 0.01);
		
	}
	
	/*Test 08*/
	@Test
	public void queSeRegistreUnAlquilerYSeDescuenteElStock() throws Exception {
		videoClub.registrarProdutoAudioVisual(productoUno);
		videoClub.registrarCliente(clienteUno);
		
		productoUno.setStock(5);
		
		videoClub.registrarAlquiler(clienteUno, productoUno,LocalDate.now(),2);
	
		assertEquals(4, productoUno.getStock(),0.0);
		assertEquals(1, videoClub.getAlquileres().size());
		
	}
	/*Test 09*/
	@Test (expected = TituloNoDisponibleException.class)
	public void  queFalleSiNoHayEjemplaresDisponibles() throws Exception {
		videoClub.registrarProdutoAudioVisual(productoUno);
		videoClub.registrarCliente(clienteUno);
		videoClub.registrarCliente(clienteDos);
		
		productoUno.setStock(1);
		
		videoClub.registrarAlquiler(clienteUno, productoUno,LocalDate.now(),2);
	
		videoClub.registrarAlquiler(clienteDos, productoUno,LocalDate.now(),2);
		
	}
	/*Test 10*/
	@Test(expected = LimiteAlquileresException.class)
	public void  queFalleAlSuperarElLimiteDeAlquileresSegunElTipoDeSocio() throws Exception {
		videoClub.registrarProdutoAudioVisual(productoDos);
		videoClub.registrarProdutoAudioVisual(productoUno);
		videoClub.registrarProdutoAudioVisual(productoTres);
 
		videoClub.registrarCliente(clienteUno);
		productoUno.setStock(1);
		productoDos.setStock(1);
		productoTres.setStock(1);
 
		videoClub.registrarAlquiler(clienteUno, productoUno,LocalDate.now(), 2);
		videoClub.registrarAlquiler(clienteUno, productoDos,LocalDate.now(), 2);
		videoClub.registrarAlquiler(clienteUno, productoTres,LocalDate.now(), 2);
	}
 
	/* Test 11 */
	@Test
	public void queLaDevolucionRepongaElStockYCalculeElRecargoPorDemora() throws Exception{
		videoClub.registrarCliente(clienteUno);
		videoClub.registrarProdutoAudioVisual(productoUno);
		productoUno.setStock(1);
  
		Integer diasPactados = 3;
		LocalDate fechaAlquilada = LocalDate.now().minusDays(5);
		videoClub.registrarAlquiler(clienteUno, productoUno, fechaAlquilada, diasPactados);
		
		LocalDate fechaDevolucion = LocalDate.now();
		
		Double recargo = videoClub.devolverTitulo(clienteUno.getDni(), productoUno.getCodigo(), fechaDevolucion);
		assertEquals(1, (int) productoUno.getStock());
		assertEquals(1000.0, recargo, 0.01);
	}
 
	/*Test 12*/ 
	@Test(expected = devolucionInvalidaException.class)	
	public void queFalleAlDevolverUnAlquilerInexistenteOYaDevuelto() throws Exception{
		videoClub.registrarProdutoAudioVisual(productoUno);
		videoClub.registrarCliente(clienteUno);
		
		productoUno.setStock(1);
		videoClub.registrarAlquiler(clienteUno, productoUno,LocalDate.now(),2);
		
		videoClub.devolverTitulo(clienteUno.getDni(), productoUno.getCodigo(), LocalDate.now());
		
		videoClub.devolverTitulo(clienteUno.getDni(), productoUno.getCodigo(), LocalDate.now());
		
		
	}
	/*Test 13*/
	@Test	
	public void queLosClientesSeObtenganOrdenadosPorOrdenNatural() throws ClienteNoEncontradoException {
		Cliente c1 = new Cliente("Ruben", 30000000, TipoSocio.ESTANDAR);
	    Cliente c2 = new Cliente("Ana", 20000000, TipoSocio.PREMIUM);
	    Cliente c3 = new Cliente("Ana", 10000000, TipoSocio.ESTANDAR); // Mismo nombre que c2, menor DNI

	    videoClub.registrarCliente(c1);
	    videoClub.registrarCliente(c2);
	    videoClub.registrarCliente(c3);

	    // 2. When (Pedimos la lista ordenada)
	    List<Cliente> listaOrdenada = videoClub.obtenerClientesOrdenados();

	    // 3. Then (Verificamos el orden en cada índice)
	    // Posición 0 -> Ana (DNI 10000000)
	    // Posición 1 -> Ana (DNI 20000000)
	    // Posición 2 -> Ruben (DNI 30000000)
	    assertEquals(c3, listaOrdenada.get(0));
	    assertEquals(c2, listaOrdenada.get(1));
	    assertEquals(c1, listaOrdenada.get(2));

	}
	/*Test 14*/
	@Test	
	public void  queLosTitulosSeOrdenenPorPrecioDescendenteYLuegoPorNombre() throws CodigoInvalidoException, CodigoRepetidoException {
		ProductoAudioVisual produc1 = new Pelicula("P-100-P", "Matrix", 1500.0, TipoDeGenero.ACCION);
		ProductoAudioVisual produc2 = new Pelicula("P-200-P", "Avatar", 900.0, TipoDeGenero.ACCION);
		ProductoAudioVisual produc3 = new Pelicula("P-300-P", "Batman", 800.0, TipoDeGenero.ACCION);

		videoClub.registrarProdutoAudioVisual(produc1);
		videoClub.registrarProdutoAudioVisual(produc2);
		videoClub.registrarProdutoAudioVisual(produc3);
		
		List<ProductoAudioVisual> ordenado = videoClub.ordenarPorPrecioYNombre();
		
		assertEquals(produc1, ordenado.get(0));
		assertEquals(produc2, ordenado.get(1));
		assertEquals(produc3, ordenado.get(2));

		
	}
	/*Test 15*/
	@Test	
	public void  queSeApliqueDescuentoSoloALosTitulosDescontables() throws CodigoRepetidoException, CodigoInvalidoException {
		ProductoAudioVisual produc1 = new Pelicula("P-100-P", "Matrix", 1500.0, TipoDeGenero.ACCION);
		ProductoAudioVisual videoJuego = new VideoJuego("V-977-V", "Tekken 5", 1500.0, TipoDeGenero.TERROR);
		 
		videoClub.registrarProdutoAudioVisual(produc1);
		videoClub.registrarProdutoAudioVisual(videoJuego);
		
		Descontable tituloDescontable = (Descontable) produc1;
	    Double precioPeliculaConDescuento = tituloDescontable.aplicarDescuento(20.0); // 20% de descuento

	    // 3. Then (Verificación)
	    // Película con 20% de descuento: $1000.0 * 0.80 = $800.0
	    assertEquals(1200.0, precioPeliculaConDescuento, 0.01);
	    
	    // El videojuego (al no ser Descontable) conserva su precio base original de $1500.0
	    assertEquals(1500.0, videoJuego.getPrecioBase(), 0.01);
		
	}
	
	
	
}
