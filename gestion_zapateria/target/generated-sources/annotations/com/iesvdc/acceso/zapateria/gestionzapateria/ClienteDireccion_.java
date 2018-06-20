package com.iesvdc.acceso.zapateria.gestionzapateria;

import com.iesvdc.acceso.zapateria.gestionzapateria.Cliente;
import com.iesvdc.acceso.zapateria.gestionzapateria.CodPos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2018-06-15T14:08:18")
@StaticMetamodel(ClienteDireccion.class)
public class ClienteDireccion_ { 

    public static volatile SingularAttribute<ClienteDireccion, Integer> idDireccion;
    public static volatile SingularAttribute<ClienteDireccion, String> nombreVia;
    public static volatile SingularAttribute<ClienteDireccion, Cliente> idCliente;
    public static volatile SingularAttribute<ClienteDireccion, String> nombre;
    public static volatile SingularAttribute<ClienteDireccion, CodPos> cp;

}