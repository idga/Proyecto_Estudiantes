package ull.herramientas.opendatachartgenerator.salida;

/**
 * \interface IGenerarSalida 
 * \brief interfaz para generar las salidas
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public interface IGenerarSalida
{
	/**
	 * \brief Método para generar la salida gráfica deseada.
	 * Este método se encargará de configurar la ventana en la que se 
	 * mostrará la representación gráfica selecionada.
	 */
	public void salidaGrafica();
	/**
	 * \brief Método que obtiene una salida
	 * \return, devuelve un objeto con los datos necesarios para imprimir en pdf
	 */
	public Object salidaPDF();
}
