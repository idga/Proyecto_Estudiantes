package ull.herramientas.opendatachartgenerator.salida;

import org.jfree.chart.JFreeChart;
/**
 * \class CrearPDFBarras
 * \brief Clase que crea y configura un documento pdf 
 * para imprirmir los datos del gráfico de barras
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class CrearPDFBarras extends CrearPDF
{
	/**
	 * \brief Constructor
	 * \param a_grafico, gráfico para imprimir en pdf
	 * \param a_nombreFichero, ruta del archivo donde se guardará
	 */
	public CrearPDFBarras(JFreeChart aGrafico, String aNombreFichero)
	{
		super(aGrafico, "", aNombreFichero, 870, 500, true);
	}
}
