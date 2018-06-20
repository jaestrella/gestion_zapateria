/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iesvdc.acceso.zapateria.gestionzapateria;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matinal
 */
@Entity
@Table(name = "proveedor_direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProveedorDireccion.findAll", query = "SELECT p FROM ProveedorDireccion p"),
    @NamedQuery(name = "ProveedorDireccion.findByNombre", query = "SELECT p FROM ProveedorDireccion p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProveedorDireccion.findByIdDireccion", query = "SELECT p FROM ProveedorDireccion p WHERE p.idDireccion = :idDireccion"),
    @NamedQuery(name = "ProveedorDireccion.findByIdProveedor", query = "SELECT p FROM ProveedorDireccion p WHERE p.idProveedor = :idProveedor"),
    @NamedQuery(name = "ProveedorDireccion.findByNombreVia", query = "SELECT p FROM ProveedorDireccion p WHERE p.nombreVia = :nombreVia"),
    @NamedQuery(name = "ProveedorDireccion.findByCp", query = "SELECT p FROM ProveedorDireccion p WHERE p.cp = :cp")})
public class ProveedorDireccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 100)
    private String nombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion", nullable = false)
    private Integer idDireccion;
    
    @Basic(optional = false)
    @Column(name = "nombre_via", nullable = false, length = 150)
    private String nombreVia;
    
    
    @JoinColumn(name = "cp", referencedColumnName = "cp", nullable = false)
    @ManyToOne(optional = false)
    @JsonManagedReference
    private CodPos cp;
    
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Proveedor idProveedor;

    public ProveedorDireccion() {
    }

    public ProveedorDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public ProveedorDireccion(Integer idDireccion, String nombreVia) {
        this.idDireccion = idDireccion;
        this.nombreVia = nombreVia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public CodPos getCp() {
        return cp;
    }

    public void setCp(CodPos cp) {
        this.cp = cp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorDireccion)) {
            return false;
        }
        ProveedorDireccion other = (ProveedorDireccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iesvdc.acceso.zapateria.gestionzapateria.ProveedorDireccion[ idDireccion=" + idDireccion + " ]";
    }
    
}
