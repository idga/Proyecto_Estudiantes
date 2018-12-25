package ull.herramientas.opendatachartgenerator.salida;

import org.jfree.chart.JFreeChart;

/**
 * \class CrearPDFPastel
 * \brief Clase que crea y configura un documento pdf 
 * para imprirmir los datos del gráfico de pastel
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class CrearPDFPastel extends CrearPDF
{
	public CrearPDFPastel(JFreeChart aGrafico, String aNombreFichero)
	{
		super(aGrafico, "", aNombreFichero, 500, 870, false);
	}
}
