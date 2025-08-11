### Descargar Apache Tomcat ###
- Extraer en el proyecto

### Creamos el proyecto Maven Web Application ###
-server tomcat y detecta Java EE
-- Locate del server descargado

### Trabajamos con JSP para ello creamos un nuevo index.jsp

### IMPORTANTE revisar las versiones de Maven necesarias 

================================================================================

### Etiquetas relevantes en JSP
<% -- -- %> esto es un comentario

<% @ page language= 'java' contentTYpe='text/html' %> directivas o atributos de configuracon JSP
<%    %> inclusión de sentencias 
<% = %> mostrar resultado de una expresion
<%! %> declaración de variables métodos de instancia

===============================================================================

### Servlet (intermediario
- Es una clase especial de Java que se utiliza como punto intermedio entre una página JSP y el servidor web donde está alojada la lógica de una app
- Un servlet se encarga de recibir peticiones o analizar request desde un cliente, tratarlas y analizar si es necesario realizar alguna solicitud en particular o brindar una determinada respuesta o response
- Para poder tratar cada una de las peticiones, utiliza una serie de métodos donde dependiendo del verbo por el cual se reciba la petición (GET, POST, PUT, DELETE, PATCH).

-doGet()
-doPOST()

### En Source Packages agregaremos un paquete para Servlets por cada clase java que tenemos en nuestro modelo de datos tendremos un servlet


### Recordar actualizar el mvaven war plugin
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-war-plugin</artifactId>
    <version>3.4.0</version>
</plugin>

### sourcepackages 
vamos a crear un nuevo paquete con servletsç
por cada clase en nuestro modelo de datos vamos a tener un servlet

