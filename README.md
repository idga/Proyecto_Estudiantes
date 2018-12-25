# Proyecto de la asignatura Laboratorio de Desarrollo y Herramientas.

Dado que necesitamos generar gráficos utilizaremos la herramienta denomina [JFreeChart](http://www.jfree.org/jfreechart/).
JFreeChart es un marco de software open source para el lenguaje de programación Java, el cual permite la creación de gráficos complejos de forma simple.

JFreeChart trabaja con GNU Classpath, una implementación en software libre de la norma estándar de biblioteca de clases para el lenguaje de programación Java.
JFreeChart es compatible con una serie de gráficas diferentes, incluyendo cuadros combinados. Estos gráficos son:
   * Gráficos XY.
   * Gráfico circular.
   * Diagrama de Gantt.
   * Gráficos de barras (Histogramas).
   * Single valued (Termómetro, brújula, indicador de velocidad).

### Para el uso la librería, se utiliza (mediante [Maven](https://maven.apache.org/))
```xml
<!-- https://mvnrepository.com/artifact/org.jfree/jfreechart -->
		<dependency>
			<groupId>org.jfree</groupId>
			<artifactId>jfreechart</artifactId>
			<version>1.0.14</version>
		</dependency>
```

### Inicialmente se da divido en tres grandes módulos de desarrollo.

**Entradas**
  * Vamos a desarrollar una aplicación que tendrá datos de entrada Datos Abiertos (Open Data), tales que los formatos de dichos ficheros van a ser:
  	*  “.ASCII”
  	*  “.cvs”
  	*  “.xls”.

**Proceso**
   * Normalizar y formalizar los datos a un formato comprensible para JFreeChart.
   * Gestión del procesamiento de la salida.

**Salidas**
   * Gestiona la salida dando la posibilidad de mostrar la información en distintos formatos al usuario, como son:
   	* Diagrama de barras
   	* Diagrama de pastel
   	* Información mediante la consola
   	* Imprimir en pdf (imprime la opción elegida de las anteriores)

Para la gestión de la documentación se hace uso de la herramienta [Doxygen](http://www.stack.nl/~dimitri/doxygen/)

