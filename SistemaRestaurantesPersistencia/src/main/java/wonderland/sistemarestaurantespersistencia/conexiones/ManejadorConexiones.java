/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantespersistencia.conexiones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * La clase ManejadorConexiones es la responsable de gestionar la conexion
 * con la base de datos a traves de la creacion de un EntityManager
 * 
 * Se hace diferencia entre el modo prueba y cuando se ejecute la aplicacion como
 * se haria normalmente, cambiando la base de datos a utilizar, la de pruebas o la
 * de la aplicacion
 */
public class ManejadorConexiones {
    
    public static boolean isTestMode = false;

    public static EntityManager getEntityManager() {
        
//        EntityManagerFactory emFactory;
//        if (isTestMode) {
//            emFactory = Persistence.createEntityManagerFactory("com.mycompany_SistemaRestaurantesPersistencia_jar_1.0PUTEST");
//        } else {
//            emFactory = Persistence.createEntityManagerFactory("com.mycompany_SistemaRestaurantesPersistencia_jar_1.0PUTEST");
//        }
//
//        EntityManager entityManager = emFactory.createEntityManager();
//        return entityManager;
        
        EntityManagerFactory emFactory;
        emFactory = Persistence.createEntityManagerFactory("com.mycompany_SistemaRestaurantesPersistencia_jar_1.0PU");
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;

    }
}
