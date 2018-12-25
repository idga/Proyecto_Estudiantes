package ull.herramientas.opendatachartgenerator;

import java.util.ArrayList;

/**
 * \class Instancia \brief Clase que almacenará las distintas instancias del dataset.
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class Instancia {
	/**
	 * \brief ArrayList de tipo Atributo
	 */
	private ArrayList<Atributo> inst;

	/**
	 * \brief Constructor que almacenará la instancia
	 */
	public Instancia() {
		super();
		this.inst = new ArrayList<Atributo>();
	}

	/**
	 * \brief Constructor que almacenará un conjunto de datos 
	 * \param atributos
	 */
	public Instancia(Atributo[] atributos) {
		this.inst = new ArrayList<Atributo>();
		for (int i = 0; i < atributos.length; i++)
			inst.add(atributos[i]);
	}

	/**
	 * \brief Metodo que retorna la instancia 
	 * \return
	 */
	public ArrayList<Atributo> getInst() {
		return inst;
	}

	/**
	 * \brief Metodo que modifica la instancia 
	 * \param inst
	 */
	public void setInst_(ArrayList<Atributo> inst) {
		this.inst = inst;
	}

	/**
	 * \brief Metodo que añade un atributo a la instancia 
	 * \param a
	 */
	public void addAtributo(Atributo a) {
		inst.add(a);
	}

	/**
	 * \brief Metodo que borra un atributo de la instancia 
	 * \param a
	 */
	public void removeAtributo(Atributo a) {
		inst.remove(a);
	}

	/**
	 * \brief Metodo que retorna el valor de una posicion de la instancia 
	 * \param pos 
	 * \return
	 */
	public String getValorItem(int pos) {
		return inst.get(pos).getValor();
	}

	/**
	 * \brief Metodo que modifica el valor de una posicion de la instancia
	 * \param pos 
	 * \param val
	 */
	public void setValorItem(int pos, String val) {
		inst.get(pos).setValor(val);
	}

	/**
	 * \brief Metodo que retorna el id de una posicion de la instancia 
	 * \param pos 
	 * \return
	 */
	public String getIdItem(int pos) {
		return inst.get(pos).getId();
	}

	/**
	 * \brief Metodo que modifica el id de una posicion de la instancia 
	 * \param pos
	 * \param i
	 */
	public void setIdItem(int pos, String i) {
		inst.get(pos).setId(i);
	}

	/**
	 * \brief Metodo que retorna el tamaño 
	 * \return
	 */
	public int size() {
		return inst.size();
	}
}
