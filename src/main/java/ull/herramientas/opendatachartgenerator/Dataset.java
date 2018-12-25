package ull.herramientas.opendatachartgenerator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 * \class Clase que representa a un conjunto de datos
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class Dataset {
	private IReader reader;
	private ArrayList<Instancia> rows;
	private String[] columnas;

	/**
	 * \brief Constructor del dataset
	 * \param url - URL del dataset a procesar
	 * \param mode - Formato del dataset a procesar
	 * \throws MalformedURLException
	 * \throws IOException
	 */
	public Dataset(String url, int mode) throws MalformedURLException, IOException
	{
		if (mode == 0)
			this.reader =  new Readercsv();
		if (mode == 1)
			this.reader =  new Readerxls();
		this.rows = new ArrayList<Instancia>();
		this.rows = reader.leerdeURL(url);
		this.columnas = reader.getNombres_atributos();
	}

	/**
	 * \return el lector de conjuntos de datos
	 */
	public IReader getReader() {
		return reader;
	}

	/**
	 * \param reader - el lector de conjuntos de datos a asignar
	 */
	public void setReader(IReader reader) {
		this.reader = reader;
	}

	/**
	 * \return las filas del conjunto de datos
	 */
	public ArrayList<Instancia> getRows() {
		return rows;
	}

	/**
	 * \param rows - las filas del conjunto de datos a asignar
	 */
	public void setRows(ArrayList<Instancia> rows) {
		this.rows = rows;
	}

	/**
	 * \return los nombres de las columnas del conjunto de datos
	 */
	public String[] getColumnas() {
		return columnas;
	}

	/**
	 * \param columnas - los nombres de las columnas del conjunto de datos a asignar
	 */
	public void setColumnas(String[] columnas) {
		this.columnas = columnas;
	}

	/**
	 * \return el número de filas del conjunto de datos
	 */
	public int size()
	{
		return rows.size();
	}

	/**
	 * \brief Retorna una instancia del conjunto de datos guardada en el índice i de su array de filas.
	 * \param i - Índice de array de filas.
	 * \return
	 */
	public ArrayList<Atributo> getInstancia(int i)
	{
		return rows.get(i).getInst();
	}

	/**
	 * \brief Retorna el número de atributos del conjunto de datos
	 * \return
	 */
	public int numero_de_atributos()
	{
		return columnas.length;
	}

	/**
	 * \brief Retorna el nombre del atributo de la columna i del conjunto de datos
	 * \param i - índice de columna de conjunto de datos
	 * \return nombre del atributo de columna i de conjunto de datos
	 */
	public String getNombreAtributo(int i)
	{
		return columnas[i];
	}

	/**
	 * \brief Devuelve la lista de valores pertenecientes a una columna del conjunto de datos
	 * \param index - índice de columna del conjunto de datos
	 * \return lista de valores de columna index del conjunto de datos
	 */
	public ArrayList<String> getColumna(int index){
		ArrayList<String> aux=new ArrayList<String>();
		for(int i=0; i<rows.size(); i++){
			aux.add(rows.get(i).getValorItem(index));
		}
		return aux;
	}
}
