/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author profesor
 */
@CrossOrigin
@RestController
@RequestMapping("/rest")
public class Controlador {
    
    // RepositorioClientes repositorioCliente;
    
    @Autowired
    RepositorioClientes repoClient;
    
    @Autowired
    RepositorioCodPos repoCodPos;
    
    @Autowired
    RepositorioDireccionCliente repoDirecCliente;
    
    @Autowired
    RepositorioProveedores repoProveedor;
    
    @Autowired
    RepositorioDireccionProveedor repoDirecProveedor;

   // Get All Clientes
    @GetMapping("/cliente")
    public List<Cliente> getAllAlumnos() {
        return repoClient.findAll();
    }
    
    
    // Get All Clientes
    @GetMapping("/codpos")
    public List<CodPos> getAllCodPos() {
        return repoCodPos.findAll();
    }
    
    
    // Get All Clientes
    @GetMapping("/direccionesClientes")
    public List<ClienteDireccion> getAllDireccionesClientes() {
        return repoDirecCliente.findAll();
    }
    
    // Get All Proveedores
    @GetMapping("/proveedores")
    public List<Proveedor> getAllProveedores() {
        return repoProveedor.findAll();
    }
    
    // Get All Direcciones Proveedores
    @GetMapping("/direccionesProveedores")
    public List<ProveedorDireccion> getAllDireccionesProveedores() {
        return repoDirecProveedor.findAll();
    }
    
   /*
    // Get All Notes
    @GetMapping("/cliente/{id}")
    public List<ClienteDireccion> getDireccions(Long id) {
        return repoClient.();
    }
   */    
}
