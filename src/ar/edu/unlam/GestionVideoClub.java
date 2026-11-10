package ar.edu.unlam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class GestionVideoClub {

	private Map<String, ProductoAudioVisual> catalogo;
	private HashMap<Integer, Cliente> clientes;
	private List<Alquiler> alquileres;

	public GestionVideoClub() {
		this.catalogo = new HashMap<>();
		this.clientes = new HashMap<>();
		this.alquileres = new ArrayList<>();

	}

	public void registrarProdutoAudioVisual(ProductoAudioVisual producto)
			throws CodigoInvalidoException, CodigoRepetidoException {
		validarProducto(producto);

		catalogo.put(producto.getCodigo(), producto);

	}

	public void registrarAlquiler(Cliente clienteUno, ProductoAudioVisual productoUno, LocalDate fecha,
			Integer diasPactados) throws TituloNoDisponibleException, LimiteAlquileresException {
		if (productoUno.getStock().equals(0)) {
			throw new TituloNoDisponibleException("No hay ejemplares disponibles");
		}

		Integer alquileresActivos = limiteAlquileresActivos(clienteUno);
		Integer limitePermitido = clienteUno.getTipo().getLimiteAlquileres();

		if (alquileresActivos >= limitePermitido) {
			throw new LimiteAlquileresException("El  cliente supero el limite de alquileres");
		}

		productoUno.setStock(productoUno.getStock() - 1);

		Alquiler nuevoAlquiler = new Alquiler(clienteUno, productoUno, fecha, diasPactados);

		alquileres.add(nuevoAlquiler);
	}

	public Double devolverTitulo(Integer dni, String codigo, LocalDate fechaDevolucion)
			throws devolucionInvalidaException {

		Alquiler alquilerEncontrado = null;

		for (Alquiler alquiler : alquileres) {
			if (alquiler.getCliente().getDni().equals(dni) && alquiler.getProducto().getCodigo().equals(codigo)
					&& !alquiler.isDevuelto()) {
				alquilerEncontrado = alquiler;
				break;
			}
		}

		if (alquilerEncontrado == null) {
			throw new devolucionInvalidaException("No existe un alquiler activo para este cliente y titulo");
		}

		LocalDate fechaInicio = alquilerEncontrado.getFecha();
		Integer diasPactados = alquilerEncontrado.getDias();
		LocalDate fechaLimite = fechaInicio.plusDays(diasPactados);

		long diasDeDemora = ChronoUnit.DAYS.between(fechaLimite, fechaDevolucion);
		Double recargo = 0.0;

		if (diasDeDemora > 0) {
			Double precioBase = alquilerEncontrado.getProducto().getPrecioBase();
			recargo = diasDeDemora * (precioBase * 0.5);
		}

		ProductoAudioVisual producto = alquilerEncontrado.getProducto();

		producto.setStock(producto.getStock() + 1);

		alquilerEncontrado.setDevuelto(true);

		return recargo;

	}

	private Integer limiteAlquileresActivos(Cliente cliente) {
		Integer activos = 0;

		for (Alquiler alquiler : alquileres) {
			if (alquiler.getCliente().getDni().equals(cliente.getDni()) && !alquiler.isDevuelto()) {
				activos++;
			}

		}
		return activos;
	}

	public void registrarCliente(Cliente clienteUno) throws ClienteNoEncontradoException {
		// Un HashMap busca por la Clave (el DNI)
		if (clientes.containsKey(clienteUno.getDni())) {
			throw new ClienteNoEncontradoException("no se encontro cliente");
		}
		// Si no se lanza la excepción (es decir, el DNI es nuevo), lo agregamos al mapa
		// usando put
		clientes.put(clienteUno.getDni(), clienteUno);
	}

	private void validarProducto(ProductoAudioVisual producto) throws CodigoInvalidoException, CodigoRepetidoException {

		String codigo = producto.getCodigo();

		if (codigo == null || (!codigo.startsWith("P") && !codigo.startsWith("S")) && !codigo.startsWith("V")) {
			throw new CodigoInvalidoException("codigo invalido");
		}

		if (catalogo.containsKey(codigo)) {
			throw new CodigoRepetidoException("codigo repetido");
		}
	}

	public ProductoAudioVisual buscarProductoAudioVisualPorTitulo(String titulo) throws ProductoInexistenteException {
		for (Map.Entry<String, ProductoAudioVisual> entry : this.catalogo.entrySet()) {
			ProductoAudioVisual valor = entry.getValue();

			if (valor.getNombre().trim().toLowerCase().equals(titulo.trim().toLowerCase())) {
				return valor;
			}
		}
		throw new ProductoInexistenteException("Producto no encontrado");
	}

	public Cliente buscarCliente(Integer dni) throws ClienteNoEncontradoException {
		if (!clientes.containsKey(dni)) {
			throw new ClienteNoEncontradoException("El cliente no fue encontrado");
		}
		return clientes.get(dni);
	}

	public List<Cliente> obtenerClientesOrdenados() {
		// TODO Auto-generated method stub
		TreeSet<Cliente> ordenado = new TreeSet<>(this.clientes.values());

		return new ArrayList<>(ordenado);
	}

	public List<ProductoAudioVisual> ordenarPorPrecioYNombre() {
		// TODO Auto-generated method stub
		TreeSet<ProductoAudioVisual> ordenado = new TreeSet<>(new OrdenarPorPrecioYnombre());

		ordenado.addAll(catalogo.values());
		return new ArrayList<>(ordenado);
	}

	public Map<String, ProductoAudioVisual> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Map<String, ProductoAudioVisual> catalogo) {
		this.catalogo = catalogo;
	}

	public HashMap<Integer, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashMap<Integer, Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

}
