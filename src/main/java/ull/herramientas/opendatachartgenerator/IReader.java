package ull.herramientas.opendatachartgenerator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * \class Clase abstracta para leer los distintos ficheros.
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public abstract class IReader {

	protected ArrayList<Instancia> instancias;
	protected String[] nombres_atributos;
	protected final Logger mlogConsola = Logger.getLogger(IReader.class.getName());

	public IReader() {
		this.instancias = new ArrayList<Instancia>();
	}

	/**
	 * \brief Método que lee todo el contenido de un flujo de entrada y extrae de él un array de instancias de datos
	 * \param is - flujo de entrada
	 * \return array de instancias de datos
	 * \throws IOException
	 */
	public abstract ArrayList<Instancia> leerTodo(InputStream is) throws IOException;

	/**
	 * \brief Metodo para leer por url
	 * \param url
	 * \return
	 * \throws MalformedURLException
	 * \throws IOException
	 */
	public ArrayList<Instancia> leerdeURL(String url) throws MalformedURLException, IOException {
		InputStream is = new URL(url).openStream();
		return leerTodo(is);
	}

	/**
	 * \brief Metodo para leer por fichero
	 * \param file
	 * \return
	 * \throws MalformedURLException
	 * \throws IOException
	 */
	public ArrayList<Instancia> leerdeFichero(String file) throws MalformedURLException, IOException {
		String url = new File(file).toURI().toURL().toString();
		return leerdeURL(url);
	}

	/**
	 * \brief Metodo para leer los datos desde una url
	 * \param direccion
	 * \return
	 * \throws MalformedURLException
	 * \throws IOException
	 */
	public ArrayList<Instancia> leerDatos(String direccion) throws MalformedURLException, IOException {
		if (isValidURL(direccion)) {
			return leerdeURL(direccion);
		} else {
			return leerdeFichero(direccion);
		}

	}

	/**
	 * \brief Metodo booleano que nos dice si la url esta correcta
	 * \param url
	 * \return
	 */
	public boolean isValidURL(String url) {
		URL u = null;
		try {
			u = new URL(url);
		}
		catch (MalformedURLException e) {
			mlogConsola.log(Level.INFO,"Error", e);
			return false;
		}

		try {
			u.toURI();
		} catch (URISyntaxException e) {
			mlogConsola.log(Level.INFO,"Error", e);
			return false;
		}

		return true;
	}

	/**
	 * \return the nombres_atributos;
	 */
	public String[] getNombres_atributos() {
		return nombres_atributos;
	}

	/**
	 * \param nombres_atributos the nombres_atributos to set
	 */
	public void setNombres_atributos(String[] nombres_atributos) {
		this.nombres_atributos = nombres_atributos;
	}
}
