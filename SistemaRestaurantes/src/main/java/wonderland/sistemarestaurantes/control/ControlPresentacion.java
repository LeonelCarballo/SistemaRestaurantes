/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.control;

import java.util.Calendar;
import javax.swing.JLayeredPane;
import wonderland.sistemarestaurantes.Mesas;
import wonderland.sistemarestaurantes.VentanaPrincipal;
import wonderland.sistemarestaurantes.clientes.ListaClientes;
import wonderland.sistemarestaurantes.clientes.PerfilCliente;
import wonderland.sistemarestaurantes.clientes.RegistrarCliente;
import wonderland.sistemarestaurantes.comandas.ConfirmacionInicioComanda;
import wonderland.sistemarestaurantes.comandas.ResumenComanda;
import wonderland.sistemarestaurantes.comandas.SeleccionarProductosComanda;
import wonderland.sistemarestaurantes.comandas.VentanaInicioComanda;
import wonderland.sistemarestaurantes.ingredientes.AñadirStockIngrediente;
import wonderland.sistemarestaurantes.ingredientes.EditarNombreIngrediente;
import wonderland.sistemarestaurantes.ingredientes.ListaIngredientes;
import wonderland.sistemarestaurantes.ingredientes.NuevoIngrediente;
import wonderland.sistemarestaurantes.productos.EditarProducto;
import wonderland.sistemarestaurantes.productos.ListaProductos;
import wonderland.sistemarestaurantes.productos.NuevoProducto;
import wonderland.sistemarestaurantes.reportes.InicioReporte;
import wonderland.sistemarestaurantesnegocio.implementaciones.IngredientesBO;
import wonderland.sistemarestaurantespersistencia.daos.IngredientesDAO;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.UnidadMedida;
import wonderland.sistemarestaurantesdominio.dtos.NuevoIngredienteDTO;
import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;
import wonderland.sistemarestaurantesnegocio.implementaciones.ClientesBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.MesasBO;
import wonderland.sistemarestaurantesnegocio.implementaciones.ProductosBO;
import wonderland.sistemarestaurantespersistencia.daos.ClientesFrecuentesDAO;
import wonderland.sistemarestaurantespersistencia.daos.MesasDAO;
import wonderland.sistemarestaurantespersistencia.daos.ProductosDAO;

/**
 *
 * @author leoca
 */
public class ControlPresentacion {

    ClientesFrecuentesDAO clientesDAO = new ClientesFrecuentesDAO();
    ClientesBO clientesBO = new ClientesBO(clientesDAO);

    IngredientesDAO ingredientesDAO = new IngredientesDAO();
    IngredientesBO ingredientesBO = new IngredientesBO(ingredientesDAO);

    Mesa mesa = new Mesa();
    MesasDAO mesasDAO = new MesasDAO();
    MesasBO mesasBO = new MesasBO(mesasDAO);
    
    ProductosDAO productosDAO = new ProductosDAO();
    ProductosBO productosBO = new ProductosBO(productosDAO);

    private VentanaInicioComanda ventanaInicioComanda = new VentanaInicioComanda();

    public void mostrarVentanaPrincial() {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this);
        ventanaPrincipal.mostrar();
    }

    public void mostrarMesas() {
        Mesas mesas = new Mesas(this, mesasBO);
        mesas.mostrar();
    }

    public void mostrarListaClientes() {
        ListaClientes listaClientes = new ListaClientes(this, clientesBO);
        listaClientes.mostrar();
    }

    public void mostrarPerfilCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Error: Cliente es null en mostrarPerfilCliente");
            return;
        }

        System.out.println("Mostrando perfil de: " + cliente.getNombre());

        Long clienteId = cliente.getId();
        String nombreCliente = cliente.getNombre();
        String apellidoPaternoCliente = cliente.getApellidoPaterno();
        String apellidoMaternoCliente = cliente.getApellidoMaterno();
        String correoElectronicoCliente = cliente.getCorreoElectronico();
        String telefonoCliente = cliente.getTelefono();
        Calendar fechaRegistroCliente = cliente.getFechaRegistro();

        ClienteFrecuenteDTO clienteDTO = new ClienteFrecuenteDTO(clienteId, nombreCliente, apellidoPaternoCliente, apellidoMaternoCliente, correoElectronicoCliente, telefonoCliente, fechaRegistroCliente);
        PerfilCliente perfilCliente = new PerfilCliente(this, clientesBO, clienteDTO);
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

    public void mostrarResumenComanda(Mesa mesa) {
        ResumenComanda resumenComanda = new ResumenComanda(this);
        resumenComanda.mostrar();
    }

    public void mostrarSeleccionarProductosComanda(Mesa mesa) {
        SeleccionarProductosComanda seleccionarProducto = new SeleccionarProductosComanda(this);
        seleccionarProducto.mostrar();
    }

    public void mostrarConfirmacionInicioComanda(Mesa mesa, VentanaInicioComanda ventanaInicioComanda) {
        ConfirmacionInicioComanda confirmacionInicioComanda = new ConfirmacionInicioComanda(this, mesa, ventanaInicioComanda);

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
        ListaIngredientes listaIngredientes = new ListaIngredientes(this, ingredientesBO);
        listaIngredientes.mostrar();
    }

    public void mostrarNuevoIngrediente() {
        NuevoIngrediente nuevoIngrediente = new NuevoIngrediente(this, ingredientesBO);
        nuevoIngrediente.mostrar();
    }

    public void mostrarEditarProducto() {
        EditarProducto editarProducto = new EditarProducto(this);
        editarProducto.mostrar();
    }

    public void mostrarListaProductos() {
        ListaProductos listaProductos = new ListaProductos(this);
        listaProductos.mostrar();
    }

    public void mostrarNuevoProducto() {
        NuevoProducto nuevoProducto = new NuevoProducto(this, productosBO);
        nuevoProducto.mostrar();
    }

    public void mostrarIniciarReporte() {
        InicioReporte iniciarReporte = new InicioReporte(this);
        iniciarReporte.mostrar();
    }

}
