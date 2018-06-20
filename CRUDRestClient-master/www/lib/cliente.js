/*jslint browser:true, devel:true, white:true, vars:true */
/*global $:false, intel:false */
// variables para el jslint

/**
* Creamos el objeto alumno y todos sus métodos.
*/
$.cliente={};
// Configuración del HOST y URL del servicio
$.cliente.HOST = 'http://localhost:8080/rest/';
// $.alumno.URL = '/GA-JPA/webresources/com.iesvdc.acceso.entidades.alumno';
$.cliente.URL = 'cliente/';


/**
    Esta función hace la llamada REST al servidor y crea la tabla con todos los alumnos.
*/
$.cliente.ClienteReadREST = function() {
    // con esta función jQuery hacemos la petición GET que hace el findAll()
    $.ajax({
        url: this.HOST+this.URL,
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        success: function (json) {
            $('#r_cliente').empty();
            $('#r_cliente').append('<h3>Listado de Clientes</h3>');
            var table = $('<table />').addClass('table table-stripped');

            table.append($('<thead />').append($('<tr />').append('<th>id</th>', '<th>nombre</th>', '<th>apellidos</th>')));
            var tbody = $('<tbody />');
            for (var clave in json) {
                tbody.append($('<tr />').append('<td>' + json[clave].id + '</td>',
                            '<td>' + json[clave].nombre + '</td>', '<td>' + json[clave].apellidos + '</td>'));
            }
            table.append(tbody);

            $('#r_cliente').append( $('<div />').append(table) );
            $('tr:odd').css('background','#CCCCCC');
        },
        error: function (xhr, status) {
             $.cliente.error('Imposible leer cliente','Compruebe su conexión e inténtelo de nuevo más tarde');
        }
    });
};

/**
    Esta función carga los datos del formulario y los envía vía POST al servicio REST
*/
$.cliente.ClienteCreateREST = function(){
    // Leemos los datos del formulario pidiendo a jQuery que nos de el valor de cada input.
    var datos = {
        'nombre' : $("#c_cl_nombre").val(),
        'apellido': $("#c_cl_apellidos").val()
    };
    
    // comprobamos que en el formulario haya datos...
    if ( datos.nombre.length>2 && datos.apellido.length>2 ) {
        $.ajax({
            url: $.cliente.HOST+$.cliente.URL,
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            data: JSON.stringify(datos),
            success: function(result,status,jqXHR ) {
               // probamos que se ha actualizado cargando de nuevo la lista -no es necesario-
                $.cliente.ClienteReadREST();
            },
            error: function(jqXHR, textStatus, errorThrown){
                $.cliente.error('Error: Cliente Create','No ha sido posible crear el cliente. Compruebe su conexión makina.');
            }
        });
        
        // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
        $.afui.clearHistory();
        // cargamos el panel con id r_alumno.
        $.afui.loadContent("#r_cliente",false,false,"up");
    }
};



/**
    Función para la gestión de errores y mensajes al usuario
*/
$.cliente.error = function(title, msg){
    $('#err_cliente').empty();
    $('#err_cliente').append('<h3>'+title+'</h3>');
    $('#err_cliente').append('<p>'+msg+'</p>');
    // esto es para que no vaya hacia atrás (que no salga el icono volver atrás en la barra de menú) 
    $.afui.clearHistory();
    // cargamos el panel con id r_alumno.
    $.afui.loadContent("#err_cliente",false,false,"up");};
