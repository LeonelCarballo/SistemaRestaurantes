/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.control;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import wonderland.sistemarestaurantes.IniciarSesion;
import wonderland.sistemarestaurantes.Mesas;
import wonderland.sistemarestaurantes.VentanaPrincipal;
import wonderland.sistemarestaurantes.clientes.ListaClientes;
import wonderland.sistemarestaurantes.clientes.PerfilCliente;
import wonderland.sistemarestaurantes.clientes.RegistrarCliente;
import wonderland.sistemarestaurantes.comandas.AsociarCliente;
import wonderland.sistemarestaurantes.comandas.ConfirmacionInicioComanda;
import wonderland.sistemarestaurantes.comandas.ResumenComanda;
import wonderland.sistemarestaurantes.comandas.SeleccionarProductosComanda;
import wonderland.sistemarestaurantes.comandas.VentanaInicioComanda;
import wonderland.sistemarestaurantes.ingredientes.AñadirStockIngrediente;
import wonderland.sistemarestaurantes.ingredientes.EditarNombreIngrediente;
import wonderland.sistemarestaurantes.ingredientes.ListaIngredientes;
import wonderland.sistemarestaurantes.ingredientes.NuevoIngrediente;
import wonderland.sistemarestaurantes.productos.*;
import wonderland.sistemarestaurantes.productos.EditarProducto;
import wonderland.sistemarestaurantes.productos.ListaProductos;
import wonderland.sistemarestaurantes.productos.NuevoProducto;
import wonderland.sistemarestaurantes.reportes.DetalleReporteCliente;
import wonderland.sistemarestaurantes.reportes.InicioReporte;
import wonderland.sistemarestaurantes.reportes.ReportesClientes;
import wonderland.sistemarestaurantes.reportes.ReportesComandas;
import wonderland.sistemarestaurantesnegocio.implementaciones.IngredientesBO;
import wonderland.sistemarestaurantespersistencia.daos.IngredientesDAO;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.UnidadMedida;
import wonderland.sistemarestaurantesdominio.dtos.NuevoIngredienteDTO;
import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.DetalleComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.IngredienteProductoDTO;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;
import wonderland.sistemarestaurantesnegocio.IEmpleadosBO;
import wonderland.sistemarestaurantesnegocio.IDetallesComandasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantesnegocio.implementaciones.ClientesBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.ComandasBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.DetallesComandasBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.EmpleadosBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.IngredientesProductosBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.MesasBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.ProductosBO;
import wonderland.sistemarestaurantespersistencia.daos.ClientesFrecuentesDAO;
import wonderland.sistemarestaurantespersistencia.daos.ComandasDAO;
import wonderland.sistemarestaurantespersistencia.daos.DetallesComandasDAO;
import wonderland.sistemarestaurantespersistencia.daos.EmpleadosDAO;
import wonderland.sistemarestaurantespersistencia.daos.IngredienteProductoDAO;
import wonderland.sistemarestaurantespersistencia.daos.MesasDAO;
import wonderland.sistemarestaurantespersistencia.daos.ProductosDAO;

/**
 *
 * @author leoca
 */
public class ControlPresentacion {
    
    DetallesComandasDAO detallesComandasDAO = new DetallesComandasDAO();
    DetallesComandasBO detallesComandasBO = new DetallesComandasBO(detallesComandasDAO);
    
    ComandasDAO comandasDAO = new ComandasDAO();
    ComandasBO comandasBO = new ComandasBO(comandasDAO);
    
    ClientesFrecuentesDAO clientesDAO = new ClientesFrecuentesDAO();
    ClientesBO clientesBO = new ClientesBO(clientesDAO);

    IngredientesDAO ingredientesDAO = new IngredientesDAO();
    IngredientesBO ingredientesBO = new IngredientesBO(ingredientesDAO);
    
    private IDetallesComandasBO detallesComandasBO1;

    Mesa mesa = new Mesa();
    MesasDAO mesasDAO = new MesasDAO();
    MesasBO mesasBO = new MesasBO(mesasDAO);
    
    ProductosDAO productosDAO = new ProductosDAO();
    ProductosBO productosBO = new ProductosBO(productosDAO);
    
    EmpleadosDAO empleadosDAO = new EmpleadosDAO();
    EmpleadosBO empleadosBO = new EmpleadosBO(empleadosDAO);
    
    IngredienteProductoDAO ingredienteProductoDAO = new IngredienteProductoDAO();
    IngredientesProductosBO ingredientesProductosBO = new IngredientesProductosBO(ingredienteProductoDAO);
    
    DetalleComandaDTO detalleComandaDTO = new DetalleComandaDTO();
    
    ClienteFrecuenteDTO clienteFrecuenteDTO = new ClienteFrecuenteDTO();
    
    private List<ProductoSeleccionadoDTO> productosSeleccionados;

    private VentanaInicioComanda ventanaInicioComanda = new VentanaInicioComanda();
    
    Long idRolEmpleado;

    public void iniciarFlujo(Long idRolEmpleado){
        this.idRolEmpleado = idRolEmpleado;
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this,idRolEmpleado);
        ventanaPrincipal.mostrar();
    }
    
    public void mostrarVentanaPrincipal() {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this,idRolEmpleado);
        ventanaPrincipal.mostrar();
    }

    public void mostrarMesas() {
        Mesas mesas = new Mesas(this, mesasBO);
        mesas.mostrar();
    }

    public void mostrarListaClientes() {
        ListaClientes listaClientes = new ListaClientes(this, clientesBO, idRolEmpleado);
        listaClientes.mostrar();
    }

    public void mostrarPerfilCliente(Cliente cliente, ClienteFrecuenteDTO clienteFrecuenteDTO) {
        ClienteFrecuenteDTO datosCompletos = prepararDatosCliente(cliente, clienteFrecuenteDTO);

        PerfilCliente perfilCliente = new PerfilCliente(this, clientesBO, datosCompletos);
        perfilCliente.mostrar();
    }

    public void mostrarEditarNombreIngrediente(Ingrediente ingrediente) {
        if (ingrediente == null) {
            System.out.println("Error: El ingrediente es nulo en mostrarIngrediente");
            return;
        }

        Long IdIngrediente = ingrediente.getId();
        String nombreIngrediente = ingrediente.getNombre();
        float StockIngrediente = ingrediente.getStock();
        UnidadMedida UnidadIngrediente = ingrediente.getUnidadMedida();

        NuevoIngredienteDTO ingredienteDTO = new NuevoIngredienteDTO(IdIngrediente, nombreIngrediente, StockIngrediente, UnidadIngrediente);
        EditarNombreIngrediente editarNombre = new EditarNombreIngrediente(this, ingredientesBO, ingredienteDTO);
        editarNombre.mostrar();
    }

    public void mostrarAñadirStockIngrediente(Ingrediente ingrediente) {
        if (ingrediente == null) {
            System.out.println("Error: El ingrediente es nulo en mostrarIngrediente");
            return;
        }

        Long IdIngrediente = ingrediente.getId();
        String nombreIngrediente = ingrediente.getNombre();
        float StockIngrediente = ingrediente.getStock();
        UnidadMedida UnidadIngrediente = ingrediente.getUnidadMedida();

        NuevoIngredienteDTO ingredienteDTO = new NuevoIngredienteDTO(IdIngrediente, nombreIngrediente, StockIngrediente, UnidadIngrediente);
        AñadirStockIngrediente añadirStock = new AñadirStockIngrediente(this, ingredientesBO, ingredienteDTO);
        añadirStock.mostrar();
    }

    public void mostrarRegistrarCliente() {
        RegistrarCliente registrarCliente = new RegistrarCliente(this, clientesBO);
        registrarCliente.mostrar();
    }

    public void mostrarResumenComanda(List<ProductoSeleccionadoDTO> productosSeleccionados, ComandaDTO comandaDTO, boolean esComandaNueva) {
        ResumenComanda resumenComanda = new ResumenComanda(this, productosSeleccionados, comandaDTO, detallesComandasBO, esComandaNueva, comandasBO, mesa, mesasBO);
        resumenComanda.mostrar();
    }
    
    public void mostrarResumenComandaMesaReservada(Mesa mesa, VentanaInicioComanda ventana, boolean esComandaNueva){
        try {
            ComandaDTO comandaDTO = comandasBO.obtenerComandaActivaPorMesa(mesa.getId());

            if (comandaDTO != null) {
                List<ProductoSeleccionadoDTO> productosSeleccionados = detallesComandasBO.obtenerDetalleComandaPorComanda(comandaDTO);

                productosSeleccionados.forEach(detalle -> System.out.println("ID Producto: " + detalle.getIdProducto()));

                ResumenComanda resumenComanda = new ResumenComanda(this, productosSeleccionados, comandaDTO, detallesComandasBO, false, comandasBO, mesa, mesasBO);
                resumenComanda.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una comanda activa para esta mesa.");
            }

        } catch (NegocioException ex) {
            Logger.getLogger(ControlPresentacion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al cargar la comanda: " + ex.getMessage());
        }
    }

    public void mostrarSeleccionarProductosComanda(Mesa mesa, ComandaDTO comandaDTO, boolean esComandaNueva, List<ProductoSeleccionadoDTO> productosSeleccionados) {
        SeleccionarProductosComanda ventana = new SeleccionarProductosComanda(this, mesa, comandaDTO, productosBO, detallesComandasBO, detalleComandaDTO, 
                esComandaNueva, productosSeleccionados);
        ventana.mostrar(); 
    }


    public void mostrarConfirmacionInicioComanda(Mesa mesa, VentanaInicioComanda ventanaInicioComanda) {
        ConfirmacionInicioComanda confirmacionInicioComanda = new ConfirmacionInicioComanda(this, mesa, ventanaInicioComanda, comandasBO, mesasBO);

        confirmacionInicioComanda.setBounds(0, 0,
                ventanaInicioComanda.getWidth(),
                ventanaInicioComanda.getHeight()
        );

        ventanaInicioComanda.getLayeredPane().add(confirmacionInicioComanda, JLayeredPane.MODAL_LAYER);

        confirmacionInicioComanda.setVisible(true);
        ventanaInicioComanda.revalidate();
        ventanaInicioComanda.repaint();
    }

    public void mostrarVentanaInicioComanda() {
        VentanaInicioComanda ventanaInicioComanda = new VentanaInicioComanda(this, mesasBO);
        ventanaInicioComanda.mostrar();
    }

    public void mostrarListaIngredientes() {
        ListaIngredientes listaIngredientes = new ListaIngredientes(this, ingredientesBO, idRolEmpleado);
        listaIngredientes.mostrar();
    }

    public void mostrarNuevoIngrediente() {
        NuevoIngrediente nuevoIngrediente = new NuevoIngrediente(this, ingredientesBO);
        nuevoIngrediente.mostrar();
    }

    public void mostrarEditarProducto(Producto producto) {
        EditarProducto editarProducto = new EditarProducto(
                this,
                productosBO,
                ingredientesBO, 
                ingredientesProductosBO,
                producto
        );
        editarProducto.mostrar();
    }

    public void mostrarListaProductos() {
        ListaProductos listaProductos = new ListaProductos(this, productosBO, idRolEmpleado);
        listaProductos.mostrar();
        listaProductos.mostrarProductos();
    }

    public void mostrarNuevoProducto() {
        NuevoProducto nuevo = new NuevoProducto(this, productosBO, ingredientesBO, ingredientesProductosBO);
        nuevo.mostrar();
    }

    public void mostrarIniciarReporte() {
        InicioReporte iniciarReporte = new InicioReporte(this);
        iniciarReporte.mostrar();
    }

    public void mostrarAgregarIngrediente(Long idProducto, NuevoProducto padre, List<IngredienteProductoDTO> seleccionados) {
        AgregarIngrediente agregar = new AgregarIngrediente(idProducto, ingredientesBO, ingredientesProductosBO, padre, seleccionados);
        agregar.setVisible(true);
    }
    
    public void mostrarAsociarCliente(ComandaDTO comandaDTO) {
        AsociarCliente asociarCliente = new AsociarCliente(this, clientesBO, comandasBO, comandaDTO);
        asociarCliente.setVisible(true);
    }
    
    public void mostrarEditarComanda(Mesa mesa, ComandaDTO comandaDTO, boolean esComandaNueva){
        
        SeleccionarProductosComanda seleccionar = new SeleccionarProductosComanda(this, mesa, comandaDTO, productosBO, detallesComandasBO, detalleComandaDTO, esComandaNueva, productosSeleccionados);
        
        List<ProductoSeleccionadoDTO> productosSeleccionados = comandaDTO.getProductosSeleccionados(); 
        
        if (productosSeleccionados != null) {
            for (ProductoSeleccionadoDTO productoSeleccionado : productosSeleccionados) {
                seleccionar.agregarProductoDesdeDTO(productoSeleccionado); 
                }
        }

        seleccionar.mostrar();
        
    }
    
    public void mostrarReporteComanda(){
        ReportesComandas reportesComandas = new ReportesComandas(this, comandasBO,detallesComandasBO);
        reportesComandas.setVisible(true);
    }
    
    public void mostrarInicioSesion(){
        IniciarSesion iniciarSesion = new IniciarSesion(this, empleadosBO);
        iniciarSesion.mostrar();
    }
    public void mostrarReporteCliente(){
        ReportesClientes reportesClientes = new ReportesClientes(this, clientesBO);
        reportesClientes.setVisible(true);
    }
    
    public void mostrarDetalleReporteCliente(Cliente cliente, ClienteFrecuenteDTO dto) {
        ClienteFrecuenteDTO datosCompletos = prepararDatosCliente(cliente, dto);

        if (datosCompletos != null) {
            try {
                Calendar ultimaVisita = clientesBO.obtenerUltimaVisita(cliente.getId());
                datosCompletos.setUltimaVisita(ultimaVisita);  

            } catch (NegocioException ex) {
                Logger.getLogger(ControlPresentacion.class.getName()).log(Level.SEVERE, null, ex);
                datosCompletos.setUltimaVisita(null);  
            }

            DetalleReporteCliente reporte = new DetalleReporteCliente(this, clientesBO, datosCompletos);
            reporte.mostrar();
        }
    }
    
    private ClienteFrecuenteDTO prepararDatosCliente(Cliente cliente, ClienteFrecuenteDTO clienteFrecuenteDTO) {
        if (cliente == null) {
            System.out.println("Error: Cliente es null");
            return null;
        }

        if (clienteFrecuenteDTO == null) {
            clienteFrecuenteDTO = new ClienteFrecuenteDTO();
        }

        clienteFrecuenteDTO.setId(cliente.getId());
        clienteFrecuenteDTO.setNombre(cliente.getNombre());
        clienteFrecuenteDTO.setApellidoPaterno(cliente.getApellidoPaterno());
        clienteFrecuenteDTO.setApellidoMaterno(cliente.getApellidoMaterno());
        clienteFrecuenteDTO.setCorreoElectronico(cliente.getCorreoElectronico());
        clienteFrecuenteDTO.setTelefono(cliente.getTelefono());
        clienteFrecuenteDTO.setFechaRegistro(cliente.getFechaRegistro());

        if (clienteFrecuenteDTO.getVisitas() == 0 || 
            clienteFrecuenteDTO.getGastoTotal() == 0 || 
            clienteFrecuenteDTO.getPuntosFidelidad() == 0) {

            ClienteFrecuenteDTO datosFidelidad = null;
            try {
                datosFidelidad = clientesBO.obtenerDatosFidelidad(cliente.getId());
            } catch (NegocioException ex) {
                Logger.getLogger(ControlPresentacion.class.getName()).log(Level.SEVERE, null, ex);
            }

            clienteFrecuenteDTO.setVisitas(datosFidelidad.getVisitas());
            clienteFrecuenteDTO.setGastoTotal(datosFidelidad.getGastoTotal());
            clienteFrecuenteDTO.setPuntosFidelidad(datosFidelidad.getPuntosFidelidad());
        }

        return clienteFrecuenteDTO;
    }


}
