package ull.herramientas.opendatachartgenerator.salida;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import ull.herramientas.opendatachartgenerator.Dataset;
import ull.herramientas.opendatachartgenerator.Instancia;

/**
 * \class GenerarSalidaGraficoBarras
 * \brief clase encargarda de mostrar un gráfico de barras
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class GenerarSalidaGraficoBarras implements IGenerarSalida
{ // ATRIBUTOS
	private DefaultCategoryDataset mDatasetChar;
	private Dataset mDataset;
	private JFreeChart mSalida;

	/**
	 * \brief Constructor que recibe un dataset
	 * \param aDataset, dataset que contiene la información a representar.
	 */
	public GenerarSalidaGraficoBarras(Dataset aDataset)
	{
		mDataset = aDataset;
		configurarDatasetChart();
		salidaPDF();
		
	}
	/**
	 * \brief Método configurar el Dataset que se le pasará al gráfico.
	 */
	private void configurarDatasetChart()
	{
		/*Thread hilo= new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{*/
				mDatasetChar = new DefaultCategoryDataset();
				ArrayList<String> tBarrios= mDataset.getColumna(2);
				ArrayList<Instancia> tArrInstancias=mDataset.getRows();
				for (int i = 0; i < tBarrios.size(); i++)
				{
					Instancia t_instancia = tArrInstancias.get(i);
					mDatasetChar.addValue(Double.parseDouble(t_instancia.getValorItem(26)),mDataset.getNombreAtributo(26), tBarrios.get(i));//Hombres
					mDatasetChar.addValue(Double.parseDouble(t_instancia.getValorItem(48)),mDataset.getNombreAtributo(48), tBarrios.get(i));//Mujeres
				}
				/*mSalida.notify();
				
				}
		});
		hilo.start();*/
		
	}
	@Override
	public void salidaGrafica()
	{
		ChartFrame tGraficoChartFrame = new ChartFrame("Grafico de Barras", mSalida);
		
		tGraficoChartFrame.setVisible(true);
		tGraficoChartFrame.setSize(1300, 1000);
	}
	@Override
	public JFreeChart salidaPDF()
	{
		mSalida = ChartFactory.createBarChart(
				"Gráfico de Barras", "Barrios", "Residentes", mDatasetChar, PlotOrientation.VERTICAL, true, false, false
		);
		CategoryPlot tPlot = mSalida.getCategoryPlot();
		CategoryAxis txAxis= tPlot.getDomainAxis();
		txAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);///Cambia la orientación de las etiquetas
		return mSalida;
	}
}
