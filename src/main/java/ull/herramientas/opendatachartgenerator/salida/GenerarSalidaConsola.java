package ull.herramientas.opendatachartgenerator.salida;

import java.util.ArrayList;
import java.util.logging.Logger;

import ull.herramientas.opendatachartgenerator.Dataset;
import ull.herramientas.opendatachartgenerator.Instancia;
/**
 * 
 * \class GenerarSalidaConsola
 * \brief clase encargarda de mostrar un informe de los turistas
 * este informe se mostrará por la consola, en ella mostrará
 * tuplas con la información barrio, numero de mujeres, numero de hombres
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class GenerarSalidaConsola implements IGenerarSalida
{
	private Dataset mDataset;
	private String mSalida;
	private final Logger mlogConsola = Logger.getLogger(GenerarSalidaConsola.class.getName()); /// Salida por consola.
	/**
	 * \brief Constructor que recibe un dataset
	 * \param aDataset, dataset que contiene la información a representar.
	 */
	public GenerarSalidaConsola(Dataset aDataset)
	{
		mDataset = aDataset;
		mSalida = "BARRIOS \t\t\tNºMujeres \t\tNºHombres\n";
		configurarSalida();
	}
	/**
	 * \brielf método que configura el texto que para su posterior representación.
	 */
	private void configurarSalida()
	{
		ArrayList<String> tBarrios= mDataset.getColumna(2);
		
		for (int i = 0; i < tBarrios.size(); i++)
		{
			ArrayList<Instancia> tArrInstancias=mDataset.getRows();
			
				mSalida+=tBarrios.get(i)+"\t\t\t"+tArrInstancias.get(i).getValorItem(48)+"\t\t"+tArrInstancias.get(i).getValorItem(26)+"\n";
		}
	}
	@Override
	public void salidaGrafica()
	{
		//System.out.println(mSalida);
		mlogConsola.info(mSalida);
	}
	@Override
	public  String salidaPDF()
	{
		return mSalida;
	}

}
