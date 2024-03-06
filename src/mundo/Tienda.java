/**productos
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Guía 2 - Actividad 2
 * Ejercicio: tienda
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package mundo;

/**
 * Tienda que maneja 4 producto.
 */
public class Tienda {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto 1 de la tienda.
     */
    private Producto producto1;

    /**
     * Producto 2 de la tienda.
     */
    private Producto producto2;

    /**
     * Producto 3 de la tienda.
     */
    private Producto producto3;

    /**
     * Producto 4 de la tienda.
     */
    private Producto producto4;

    /**
     * Dinero total recibido por las ventas.
     */
    private double dineroEnCaja;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la tienda con sus 4 productos. <br>
     * <b> post: </b> El dinero en caja fue inicializado en 0.<br>
     * Los 4 productos fueron inicializados con los siguientes valores: <br>
     * Producto 1 - Tipo: PAPELERIA, Nombre: Lápiz, Valor unitario: 550.0, Cantidad en bodega: 18, Cantidad mínima: 5, Imagen: lapiz.png. <br>
     * Producto 2 - Tipo: DROGUERIA, Nombre: Aspirina, Valor unitario: 109.5, Cantidad en bodega: 25, Cantidad mínima: 8, Imagen: aspirina.png. <br>
     * Producto 3 - Tipo: PAPELERIA, Nombre: Borrador, Valor unitario: 207.3, Cantidad en bodega: 30, Cantidad mínima: 10, Imagen: borrador.png. <br>
     * Producto 4 - Tipo: SUPERMERCADO, Nombre: Pan, Valor unitario: 150.0, Cantidad en bodega: 15, Cantidad mínima: 20, Imagen: pan.png. <br>
     */
    public Tienda() {
        producto1 = new Producto("papeleria", "Lapiz", 550.0, 18, 5, "lapiz.png");
        producto2 = new Producto("drogueria", "Aspirina", 109.5, 25, 8, "aspirina.png");
        producto3 = new Producto("papeleria", "Borrador", 207.3, 30, 10, "borrador.png");
        producto4 = new Producto("supermercado", "Pan", 150.0, 15, 20, "pan.png");
        dineroEnCaja = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el producto 1.
     *
     * @return Producto 1 de la tienda.
     */
    public Producto darPrimerProducto() {
        return producto1;
    }

    /**
     * Retorna el producto 2.
     *
     * @return Producto 2 de la tienda.
     */
    public Producto darSegundoProducto() {
        return producto2;
    }

    /**
     * Retorna el producto 3.
     *
     * @return Producto 3 de la tienda.
     */
    public Producto darTercerProducto() {
        return producto3;
    }

    /**
     * Retorna el producto 4.
     *
     * @return Producto 4 de la tienda.
     */
    public Producto darCuartoProducto() {
        return producto4;
    }

    /**
     * Retorna el dinero en caja.
     *
     * @return Dinero en caja.
     */
    public double darDineroEnCaja() {
        return dineroEnCaja;
    }

    /**
     * Retorna el producto con el nombre dado por parámetro.
     *
     * @param pNombre Nombre del producto buscado. pNombre != null && pNombre != "".
     * @return Producto con el nombre dado por parámetro, null si no lo encuentra.
     */
    public Producto darProducto(String pNombre) {
        Producto buscado = null;

        if (pNombre != null && !pNombre.isEmpty()) {
            if (pNombre.equals(producto1.darNombre())) {
                buscado = producto1;
            } else if (pNombre.equals(producto2.darNombre())) {
                buscado = producto2;
            } else if (pNombre.equals(producto3.darNombre())) {
                buscado = producto3;
            } else if (pNombre.equals(producto4.darNombre())) {
                buscado = producto4;
            }
        }
        return buscado;
            
    }

    /**
     * Retorna el promedio de las ventas.
     *
     * @return Dinero promedio obtenido por unidad de producto vendida.
     */
    public double darPromedioVentas() {
        double respuesta = 0.0;
        double totalVentas = 0.0;
        int totalUnidadesVendidas = 0;
      
        // Sumar las ventas de cada producto
        totalVentas += producto1.darValorUnitario() * producto1.darCantidadUnidadesVendidas();
        totalVentas += producto2.darValorUnitario() * producto2.darCantidadUnidadesVendidas();
        totalVentas += producto3.darValorUnitario() * producto3.darCantidadUnidadesVendidas();
        totalVentas += producto4.darValorUnitario() * producto4.darCantidadUnidadesVendidas();
    
        // Sumar las unidades vendidas de cada producto
        totalUnidadesVendidas += producto1.darCantidadUnidadesVendidas();
        totalUnidadesVendidas += producto2.darCantidadUnidadesVendidas();
        totalUnidadesVendidas += producto3.darCantidadUnidadesVendidas();
        totalUnidadesVendidas += producto4.darCantidadUnidadesVendidas();
    
        // Si se han vendido productos, calcular el promedio
        if (totalUnidadesVendidas > 0) {
            respuesta = totalVentas / totalUnidadesVendidas;
        }
    
        return respuesta;
    }

    /**
     * Retorna el producto con más unidades vendidas.
     *
     * @return Producto con más unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
    public Producto darProductoMasVendido() {
        Producto masVendido = null;


        // Si algún producto tiene unidades vendidas
        if (producto1.darCantidadUnidadesVendidas() > 0 ||
            producto2.darCantidadUnidadesVendidas() > 0 ||
            producto3.darCantidadUnidadesVendidas() > 0 ||
            producto4.darCantidadUnidadesVendidas() > 0) {

        // Inicializar el producto más vendido con el primero
        masVendido = producto1;

        // Comparar las unidades vendidas con los demás productos
            if (producto2.darCantidadUnidadesVendidas() > masVendido.darCantidadUnidadesVendidas()) {
                masVendido = producto2;
            }
            if (producto3.darCantidadUnidadesVendidas() > masVendido.darCantidadUnidadesVendidas()) {
                masVendido = producto3;
            }
            if (producto4.darCantidadUnidadesVendidas() > masVendido.darCantidadUnidadesVendidas()) {
            masVendido = producto4;
            }
        }
        return masVendido;
    }

    /**
     * Retorna el producto con menos unidades vendidas.
     *
     * @return Producto con menos unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
    public Producto darProductoMenosVendido() {
        Producto menosVendido = null;

        // Si algún producto tiene unidades vendidas
        if (producto1.darCantidadUnidadesVendidas() > 0 ||
            producto2.darCantidadUnidadesVendidas() > 0 ||
            producto3.darCantidadUnidadesVendidas() > 0 ||
            producto4.darCantidadUnidadesVendidas() > 0) {

        // Inicializar el producto menos vendido con el primero
        menosVendido = producto1;

        // Comparar las unidades vendidas con los demás productos
        if (producto2.darCantidadUnidadesVendidas() < menosVendido.darCantidadUnidadesVendidas()) {
            menosVendido = producto2;
            }
        if (producto3.darCantidadUnidadesVendidas() < menosVendido.darCantidadUnidadesVendidas()) {
            menosVendido = producto3;
            }
        if (producto4.darCantidadUnidadesVendidas() < menosVendido.darCantidadUnidadesVendidas()) {
            menosVendido = producto4;
            }
        }
        return menosVendido;
    }

    /**
     * Vende una cantidad de unidades de producto de la tienda, dado su nombre por parámetro. <br>
     * <b>post: </b> Disminuyó la cantidad de unidades del producto dado
     * y se actualizó el dinero de la caja a partir de la cantidad real vendida multiplicada
     * por el precio final (con IVA) del producto vendido..
     *
     * @param pNombreProducto Nombre del producto a vender.
     * @param pCantidad       Cantidad de unidades del producto a vender. pCantidad > 0.
     * @return Cantidad que fue efectivamente vendida.
     */
    public int venderProducto(String pNombreProducto, int pCantidad) {
        int cantidadVendida = 0;

        
        Producto producto = darProducto(pNombreProducto);

    if (producto != null) {
        if (pCantidad <= producto.darCantidadBodega()) {
            cantidadVendida = pCantidad;
            producto.vender(pCantidad);
            dineroEnCaja += cantidadVendida * producto.calcularPrecioFinal();
        } else {
            cantidadVendida = producto.darCantidadBodega();
            producto.vender(producto.darCantidadBodega());
            dineroEnCaja += cantidadVendida * producto.calcularPrecioFinal();
        }
    }
        return cantidadVendida;
    }

    /**
     * Abastece un producto dado su nombre, con la cantidad de unidades dadas. <br>
     * <b>post: </b> Aumentó la cantidad de unidades en bodega del producto dado.
     *
     * @param pNombreProducto Nombre del producto a abastecer.
     * @param pCantidad       La cantidad de unidades a abastecer. cantidad >= 0.
     * @return Retorna true si se pudo efectuar el abastecimiento, false en caso contrario.
     */
    public boolean abastecerProducto(String pNombreProducto, int pCantidad) {
        boolean abastece = false;

        
        Producto producto = darProducto(pNombreProducto);

    if (producto != null) {
        producto.abastecer(pCantidad);
        abastece = true;
    }
        return abastece;
    }

    /**
     * Cambia el producto que tiene el nombre actual con los nuevos valores dados por parámetro. <br>
     * <b>post: </b> El nombre, tipo, valor unitario, cantidad en bodega y cantidad mínima fueron cambiados con los valores dados por parámetro.
     *
     * @param pNombreActual   Nombre actual del producto.
     * @param pNombreNuevo    Nuevo nombre del producto.
     * @param pTipo           Tipo del producto.
     * @param pValorUnitario  Valor unitario del producto
     * @param pCantidadBodega Cantidad en bodega del producto.
     * @param pCantidadMinima Cantidad mínima en bodega para hacer un pedido del producto.
     * @param pRutaImagen     Ruta de la imagen del producto.
     * @return Retorna true si cambió la información del producto,
     * Retorna false si ya existìa un producto con el nuevo nombre.
     */
    public boolean cambiarProducto(String pNombreActual, String pNombreNuevo, String pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen) {
        boolean cambio = false;
        Producto producto = darProducto(pNombreActual);
//por corregir
        // Si el producto existe y el nuevo nombre no está en uso
        if (producto != null && !Producto(pNombreNuevo)) {
            producto.cambiarNombre(pNombreNuevo);
            producto.cambiarTipo(pTipo);
            producto.cambiarValorUnitario(pValorUnitario);
            producto.cambiarCantidadBodega(pCantidadBodega);
            producto.cambiarCantidadMinima(pCantidadMinima);
            producto.cambiarRutaImagen(pRutaImagen);
    cambio = true;
        }

        return cambio;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Obtiene la cantidad de producto que tienen un precio inferior al promedio de los precios
     */
    public int metodo1() {
        int cantidadProducto = 0;
        double promedioPrecio = darPromedioPrecios();

        // Recorrer los productos y contar los que son más baratos que el promedio
        for (Producto producto : listaProductos) {
            if (producto.darValorUnitario() < promedioPrecio) {
                cantidadProductosBaratos++;
                }
            }

        return cantidadProductosBaratos;;
        }


    /**
     * Obtiene el nombre del producto más barato de la tienda
     */
    public String metodo2() {
        
        String nombreProductoMasBarato = "";
        double precioMinimo = Double.MAX_VALUE;
    
        // Recorrer los productos y encontrar el más barato
        for (Producto producto : listaProductos) {
            if (producto.darValorUnitario() < precioMinimo) {
            precioMinimo = producto.darValorUnitario();
            nombreProductoMasBarato = producto.darNombre();
            }
        }
    
        return nombreProductoMasBarato;
    }
}