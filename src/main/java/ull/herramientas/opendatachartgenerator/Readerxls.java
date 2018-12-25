package ull.herramientas.opendatachartgenerator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * \class Clase Readerxls que lee ficheros de formato xls (Excel hasta la version 2007)
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class Readerxls extends IReader {

	public Readerxls() {
		super();
	}

	@Override
	public ArrayList<Instancia> leerTodo(InputStream is) throws IOException {
		/**
		 * \brief Inicializamos dos arraylists que nos serviran para almacenar la informacion del dataset
		 */
		ArrayList<String> names=new ArrayList<String>();
		ArrayList<String> values=new ArrayList<String>();

		/**
		 * \brief Ademas de una variable que indicara si la columna que estamos recorriendo es la primera o no
		 */
		int i = 0;

		/**
		 * \brief Utilizaremos una variable workbook especial para leer el fichero excel
		 */
		HSSFWorkbook workbook = new HSSFWorkbook(is);

		HSSFSheet sheet = workbook.getSheetAt(0);
		/**
		 * \brief Comenzamos a recorrer el fichero por filas (instancias)
		 */
		Iterator<Row> rowIterator = sheet.iterator();
		String[]valores=null;
		Row row;

		while (rowIterator.hasNext()) {

			row = rowIterator.next();

			/**
			 * \brief Y dentro de cada fila recorremos cada celda, la cual almacena un atributo de la instancia
			 */
			Iterator<Cell> cellIterator = row.cellIterator();

			Cell celda;

			/**
			 * \brief Si la fila que recorremos es la primera, almacenaremos los nombres de los atributos en el arraylist names
			 */
			if (i == 0) {
				while (cellIterator.hasNext()) {
					celda = cellIterator.next();
					names.add(celda.getStringCellValue());
				}
				i++;
				/**
				 * \brief Pasamos los datos almacenados a un array de string para utilizarlo posteriormente
				 */
				nombres_atributos= new String[names.size()];
				for(int index=0;index<names.size();index++){
					nombres_atributos[index]=names.get(index);
				}

			/**
			 * \brief En caso contrario se almacenaran los atributos en el arraylist values
			 */
			}else{
				while (cellIterator.hasNext()) {
					celda=cellIterator.next();
					if(celda.getCellType()==Cell.CELL_TYPE_NUMERIC){
						values.add(String.valueOf(celda.getNumericCellValue()));
					}else
						values.add(celda.getStringCellValue());
				}

				/**
				 * \brief Pasamos los datos almacenados a un array de string para utilizarlo posteriormente
				 */
				valores=new String[values.size()];

				for(int index3=0;index3<values.size();index3++){
					valores[index3]=values.get(index3);
				}

				/**
				 *  Los arrays de strings se utilizan entonces para generar los vectores de atributos que crearan las instancias del dataset
				 */
				Atributo[] atr = new Atributo[nombres_atributos.length];
				for (int k = 0; k < nombres_atributos.length; k++) {
					atr[k] = new Atributo(valores[k], nombres_atributos[k]);
			}
				instancias.add(new Instancia(atr));
				values.clear();
			}
		}

		try {
			workbook.close();
		} catch (IOException e) {
			mlogConsola.log(Level.INFO,"Error", e);
		}
		return instancias;
	}
}
