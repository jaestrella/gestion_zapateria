package com.iesvdc.acceso.zapateria.gestionzapateria;

import com.iesvdc.acceso.zapateria.gestionzapateria.ClienteDireccion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2018-06-15T14:08:18")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> apellidos;
    public static volatile ListAttribute<Cliente, ClienteDireccion> clienteDireccionList;
    public static volatile SingularAttribute<Cliente, Integer> id;
    public static volatile SingularAttribute<Cliente, String> nombre;
    public static volatile SingularAttribute<Cliente, Integer> dni;

}