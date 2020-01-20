
public class OpenSport {

	public static void main(String[] args) {
	
		Cliente primerCliente = new Cliente(1, "alejandra", "ayosa", "aleayosa@unmail.com", "MiClave", 122355);
		Producto unProducto1 = new Producto("Adidas", "remera", 1232, 10.00, "remeras", 5);
		Producto unProducto2 = new Producto("Adidas", "short", 1233, 100.00, "remeras", 5);
		Producto unProducto3 = new Producto("Adidas", "calza", 1234, 105.00, "remeras", 5);
		Producto unProducto4 = new Producto("Adidas", "top", 1235, 80.00, "remeras", 5);
		Producto unProducto5 = new Producto("Adidas", "pelota", 1236, 200.00, "remeras", 5);
		
		primerCliente.iniciarSesion("aleayosa@mail.com", "MiClave");
		primerCliente.iniciarSesion("aleayosa@unmail.com", "MiClave");
		Carrito unCarrito = new Carrito(primerCliente);
		
		
		unCarrito.agregarUnProducto(unProducto1);
		unCarrito.agregarUnProducto(unProducto2);
		unCarrito.agregarUnProducto(unProducto3);
		unCarrito.agregarUnProducto(unProducto4);
		unCarrito.agregarUnProducto(unProducto5);
		
		System.out.println("Los productos del carrito de "+unCarrito.getUnCliente().getNombre()+" son: "+unCarrito.getListaDeProductos());
		
		
		System.out.println("El total de la compra es de "+unCarrito.iniciarCompra());
		
		Inventario elInventario = new Inventario("Inventario");
		Administrador elAdmin = new Administrador(12, "silvi", "pan", "unmail@mail.com", "nlasdnasld", elInventario);
		
		elAdmin.iniciarSesion("unmail@mail.com", "nlasdnasld");

		elInventario.agregarUnProducto(unProducto1);
		elInventario.agregarUnProducto(unProducto2);
		elInventario.agregarUnProducto(unProducto3);
		elInventario.agregarUnProducto(unProducto4);
		elInventario.agregarUnProducto(unProducto5);

		System.out.println("El stock actual es:" + elInventario.getStock());
		
		elAdmin.actualizarStock(2, unProducto1);
		System.out.println("El stock actual es:" + elInventario.getStock());
		
		elInventario.quitarUnProducto(unProducto5);
		
		elAdmin.actualizarStock(2, unProducto5);
		elAdmin.actualizarStock(-1, unProducto3);
		System.out.println("El stock actual es:" + elInventario.getStock());
	}

}
