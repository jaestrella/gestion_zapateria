# Proyecto Zapateria

Prueba de concepto para demostrar cómo crear con anotaciones @Autowiring
un servicio REST con Spring e Hibernate.

También veremos cómo solucionar el problema que el JSON generado sea 
recursivo (entidades que referencian a entidades).
<div>
<h1>Paso 1: Crear la Base de Datos</h1>

Instalamos MySQL o MariaDB como servicios o bien usamos un contenedor docker.

Creamos la BBDD "zapateria" desde línea de comandos, desde el IDE o desde PHPmyadmin.
</div>
<div>
<h1>Paso 2: Conectar desde NetBeans o STS a la BBDD (crear la conexión)</h1>

Con Netbeans, pestaña "Servicios", botón derecho en "Databases" y creamos una nueva conexión.

Si usamos MariaDB, tendremos que descargarnos el Conector Java desde su Web.

En cadena de conexión ponemos: jdbc:mariadb://localhost:3306/database para forzar el driver MariaDB.

Una vez conectados, creamos las tablas e introducimos los datos:
</div>

<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/Captura%20de%20pantalla%20de%202018-06-19%2011-55-16.png"></img>

Diagrama ER que seguimos.

<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/Captura%20de%20pantalla%20de%202018-06-19%2012-09-04.png"></img>

Tenemos que estar conectados a la base de datos para poder generar las clases entidad.

<h1>Paso 3: Creamos el proyecto</h1>
configuramos la conexión modificando "src/main/resources/application.properties" con nuestro usuario y contraseña:
<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/properties.png"></img>
<b>Creando el proyecto desde cero:</b>

Visitar la página Spring Initializr y creamos un proyecto.
<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/spring.png"></img>

<h1>Paso 4: Generar las entidades nuevas desde la BBDD</h1>

Botón derecho en el proyecto, "new" -> "Entities from Database":
<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/Captura%20de%20pantalla%20de%202018-06-14%2014-26-36.png"></img>
Tenemos que estar conectados a la base de datos para poder generar las clases entidad.
<h1>Paso 5: Modificar las clases entidad para evitar referencias recursivas en JSON</h1>

Modificando la aplicación Spring: para conseguir que se genere JSON donde unas entidades aniden a otras, tenemos que añadir @EnableJpaRepositories(considerNestedRepositories = true) a nuestra aplicación.

<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/gzapp.png"></img>

<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/codpos1.png"></img>

<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/codpos2.png"></img>

<h1>Paso 6: Crear las interfaces de los distintos repositorios</h1>

Para cada uno de nuestras clases entidad, tenemos que generar las interfaces para los repositorios así:

<b>Fichero RepositorioProveedores.java</b>

<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/repositorioProveedor.png"></img>

Gracias al "autowiring" de Spring, automáticamente estarán disponibles las consultas predefidas en Cliente (findById, findAll, findByNombre, findByApellidos....):

<b>Fichero Proveedor.java</b>

<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/ficheroproveedor.png"></img>

<h1>Paso 7: Crear el controlador</h1>
Implementamos los verbos HTTP: GET Y POST

<img src="https://github.com/jaestrella/gestion_zapateria/blob/master/doc/controlador.png"></img>

<h1>Paso 8: Probar el servicio</h1>

Desde un navegador:

http://localhost:8080/rest/proveedores

Desde línea de comandos, usando los tests (cambiamos al directorio del proyecto y escribimos):

$ mvn -Dtest=GestionZapateriaApplicationTests test
Desde línea de comandos

curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' -i http://localhost:8080/rest/cliente --data '{ "nombre":"Juanito", "apellidos":"Valderrama", "dni":11335577, "clienteDireccionList":[] }'

<h1>Paso 9: Crear el cliente Web que conecte al servicio</h1>

HTML5+JS+jQuery

