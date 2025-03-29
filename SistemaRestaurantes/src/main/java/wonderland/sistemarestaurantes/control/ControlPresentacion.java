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

/**
 *
 * @author leoca
 */
public class ControlPresentacion {
    
    public void mostrarPantallaPrincial(){
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.mostrar();
    }
    
    public void mostrarMesas(){
        Mesas mesas = new Mesas();
        mesas.mostrar();
    }
    
    public void mostrarListaClientes(){
        ListaClientes listaClientes = new ListaClientes();
        listaClientes.mostrar();
    }
    
    public void mostrarPerfilCliente(){
        PerfilCliente perfilCliente = new PerfilCliente();
        perfilCliente.mostrar();
    }
    
    public void mostrarRegistrarCliente(){
        RegistrarCliente registrarCliente = new RegistrarCliente();
        registrarCliente.mostrar();
    }
    
    public void mostrarResumenComanda(){
        ResumenComanda resumenComanda = new ResumenComanda();
        resumenComanda.mostrar();
    }
    
    public void mostrarSeleccionarMesaComanda(){
        SeleccionarMesaComanda seleccionarMesa = new SeleccionarMesaComanda();
        seleccionarMesa.mostrar();
    }
    
    public void mostrarSeleccionarProductosComanda(){
        SeleccionarProductosComanda seleccionarProducto = new SeleccionarProductosComanda();
        seleccionarProducto.mostrar();
    }
    
    public void mostrarVentanaInicioComanda(){
        VentanaInicioComanda ventanaInicioComanda = new VentanaInicioComanda();
        ventanaInicioComanda.mostrar();
    }
    
    public void mostrarListaIngredientes(){
        ListaIngredientes listaIngredientes = new ListaIngredientes();
        listaIngredientes.mostrar();
    }
    
    public void mostrarNuevoIngrediente(){
        NuevoIngrediente nuevoIngrediente = new NuevoIngrediente();
        nuevoIngrediente.mostrar();
    }
    
    public void mostrarEditarProducto(){
        EditarProducto editarProducto = new EditarProducto();
        editarProducto.mostrar();
    }
    
    public void mostrarListaProductos(){
        ListaProductos listaProductos = new ListaProductos();
        listaProductos.mostrar();
    }
    
    public void mostrarNuevoProducto(){
        NuevoProducto nuevoProducto = new NuevoProducto();
        nuevoProducto.mostrar();
    }
    
}
