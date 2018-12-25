package ull.herramientas.opendatachartgenerator;

/**
 * \class Atributo \brief Clase que crea los atributos
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class Atributo {
	private String valor;
	private String id;

	/**
	 * \brief Constructor de la clase Atributo
	 */
	public Atributo() {
		super();
	}

	/**
	 * \brief Constructor por lo que le pasa un id y un valor nulo en la tabla
	 * \param id
	 */
	public Atributo(String id) {
		super();
		this.valor = "";
		this.id = id;
	}

	/**
	 * \brief Constructor por lo que se le pasa un id y un valor \param valor
	 * \param id
	 */
	public Atributo(String valor, String id) {
		super();
		this.valor = valor;
		this.id = id;
	}

	/**
	 * \brief Metodo que retorna el valor del atributos \return
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * \brief Metodo que modifica el valor del atributo \param valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * \brief Metodo que retorna el id \return
	 */
	public String getId() {
		return id;
	}

	/**
	 * \brief Metodo que modifica el id \param id
	 */
	public void setId(String id) {
		this.id = id;
	}
}
