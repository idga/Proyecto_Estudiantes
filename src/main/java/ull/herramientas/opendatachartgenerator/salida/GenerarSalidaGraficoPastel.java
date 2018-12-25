package ull.herramientas.opendatachartgenerator.salida;

import java.text.DecimalFormat;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import ull.herramientas.opendatachartgenerator.Dataset;
import ull.herramientas.opendatachartgenerator.Instancia;
/**
 * \class GenerarSalidaGraficoPastel
 * \brief clase encargarda de mostrar un gráfico de pastel
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class GenerarSalidaGraficoPastel implements IGenerarSalida
{
	// ATRIBUTOS
	private DefaultPieDataset mDatasetChartPie;
	private JFreeChart mSalida;
	private Dataset mDataset;

	// CONSTRUCTOR/ES Y METODOS
	/**
	 * \brief Constructor que recibe un dataset
	 * \param aDataset, dataset que contiene la información a representar.
	 */
	public GenerarSalidaGraficoPastel(Dataset aDataset)
	{
		mDataset = aDataset;
		configurarDataSet();
		salidaPDF();
	}

	/**
	 * \brief Método configurar el DataSet
	 */
	private void configurarDataSet()
	{
		mDatasetChartPie = new DefaultPieDataset();

		ArrayList<String> tBarrios = mDataset.getColumna(2);
		double tTotalTurista=totalResidentes();
		ArrayList<Instancia> tArrInstancias = mDataset.getRows();
		for (int i = 0; i < tBarrios.size(); i++)
		{
			Instancia tInstancia = tArrInstancias.get(i);
			Double tTotalTuristasPorBarrio = Double.parseDouble(tInstancia.getValorItem(26))
					+ Double.parseDouble(tInstancia.getValorItem(48));
			Double tPorcentajePorBarrio = (tTotalTuristasPorBarrio * 100)/tTotalTurista;
			mDatasetChartPie.setValue(tBarrios.get(i), tPorcentajePorBarrio);
		}
	}
	/**
	 * \brief Método que calcula el total de residentes del dataset
	 * \return, el número de residentes
	 */
	private double totalResidentes()
	{
		ArrayList<Instancia> tArrInstancias = mDataset.getRows();
		double result = 0.0;
		for (int i = 0; i < tArrInstancias.size(); i++)
		{
			Instancia tInstancia = tArrInstancias.get(i);
			Double tTotalTuristasPorBarrio = Double.parseDouble(tInstancia.getValorItem(26))
					+ Double.parseDouble(tInstancia.getValorItem(48));
			result += tTotalTuristasPorBarrio;
		}
		
		return result;
	}
	@Override
	public void salidaGrafica()
	{
		// Mostrar Grafico
		ChartFrame tGraficoChartFrame = new ChartFrame("Pastel", mSalida);
		tGraficoChartFrame.setVisible(true);
		tGraficoChartFrame.setSize(1300, 1000);
	}

	@Override
	public JFreeChart salidaPDF()
	{
		mSalida = ChartFactory.createPieChart("Gráfico de Pastel", mDatasetChartPie, true, false, false);

		PiePlot tPlot = (PiePlot) mSalida.getPlot();/// añade el porcetaje a la  etiqueta
		tPlot.setSimpleLabels(true);
		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
				"{0}: ({2})", new DecimalFormat("0"), new DecimalFormat("0.0%")
		);/// Formatea el porcentaje
		tPlot.setLabelGenerator(gen);
		return mSalida;
	}

}
