/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.control;

import wonderland.sistemarestaurantes.Mesas;
import wonderland.sistemarestaurantes.VentanaPrincipal;
import wonderland.sistemarestaurantes.clientes.ListaClientes;
import wonderland.sistemarestaurantes.clientes.PerfilCliente;
import wonderland.sistemarestaurantes.clientes.RegistrarCliente;
import wonderland.sistemarestaurantes.comandas.ResumenComanda;
import wonderland.sistemarestaurantes.comandas.SeleccionarMesaComanda;
import wonderland.sistemarestaurantes.comandas.SeleccionarProductosComanda;
import wonderland.sistemarestaurantes.comandas.VentanaInicioComanda;
import wonderland.sistemarestaurantes.ingredientes.ListaIngredientes;
import wonderland.sistemarestaurantes.ingredientes.NuevoIngrediente;
import wonderland.sistemarestaurantes.productos.EditarProducto;
import wonderland.sistemarestaurantes.productos.ListaProductos;
import wonderland.sistemarestaurantes.productos.NuevoProducto;
import wonderland.sistemarestaurantes.reportes.IniciarReporte;
import wonderland.sistemarestaurantesnegocio.implementaciones.ClientesBO;
import wonderland.sistemarestaurantespersistencia.daos.ClientesDAO;

/**
 *
 * @author leoca
 */
public class ControlPresentacion {
  
    ClientesDAO clientesDAO = new ClientesDAO();
    ClientesBO clientesBO = new ClientesBO(clientesDAO);
    
    public void mostrarVentanaPrincial(){
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this);
        ventanaPrincipal.mostrar();
    }
    
    public void mostrarMesas(){
        Mesas mesas = new Mesas(this);
        mesas.mostrar();
    }
    
    public void mostrarListaClientes(){
        ListaClientes listaClientes = new ListaClientes(this, clientesBO);
        listaClientes.mostrar();
    }
    
    public void mostrarPerfilCliente(){
        PerfilCliente perfilCliente = new PerfilCliente(this, clientesBO);
        perfilCliente.mostrar();
    }
    
    public void mostrarRegistrarCliente(){
        RegistrarCliente registrarCliente = new RegistrarCliente(this, clientesBO);
        registrarCliente.mostrar();
    }
    
    public void mostrarResumenComanda(){
        ResumenComanda resumenComanda = new ResumenComanda(this);
        resumenComanda.mostrar();
    }
    
    public void mostrarSeleccionarMesaComanda(){
        SeleccionarMesaComanda seleccionarMesa = new SeleccionarMesaComanda(this);
        seleccionarMesa.mostrar();
    }
    
    public void mostrarSeleccionarProductosComanda(){
        SeleccionarProductosComanda seleccionarProducto = new SeleccionarProductosComanda(this);
        seleccionarProducto.mostrar();
    }
    
    public void mostrarVentanaInicioComanda(){
        VentanaInicioComanda ventanaInicioComanda = new VentanaInicioComanda(this);
        ventanaInicioComanda.mostrar();
    }
    
    public void mostrarListaIngredientes(){
        ListaIngredientes listaIngredientes = new ListaIngredientes(this);
        listaIngredientes.mostrar();
    }
    
    public void mostrarNuevoIngrediente(){
        NuevoIngrediente nuevoIngrediente = new NuevoIngrediente(this);
        nuevoIngrediente.mostrar();
    }
    
    public void mostrarEditarProducto(){
        EditarProducto editarProducto = new EditarProducto(this);
        editarProducto.mostrar();
    }
    
    public void mostrarListaProductos(){
        ListaProductos listaProductos = new ListaProductos(this);
        listaProductos.mostrar();
    }
    
    public void mostrarNuevoProducto(){
        NuevoProducto nuevoProducto = new NuevoProducto(this);
        nuevoProducto.mostrar();
    }
    
    public void mostrarIniciarReporte(){
        IniciarReporte iniciarReporte = new IniciarReporte(this);
        iniciarReporte.mostrar();
    }
    
}
