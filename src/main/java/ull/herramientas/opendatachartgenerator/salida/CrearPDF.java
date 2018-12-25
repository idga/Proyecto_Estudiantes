package ull.herramientas.opendatachartgenerator.salida;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;
import java.util.logging.Logger;

import org.jfree.chart.JFreeChart;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.DefaultFontMapper;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
/**
 * \class CrearPDF
 * \brief Clase abstracta utilizada imprimir en un documento pdf
 * esta clase será común a todas las clases de crear, según el tipo 
 * imprimirá gráficos (de varios tipos) o texto.
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public abstract class CrearPDF
{
	private final Logger mlogConsola = Logger.getLogger(CrearPDF.class.getName()); /// Salida por consola.
	private int mAncho;
	private int mAlto;
	private Document mDocumento;
	private PdfWriter mEscribe;
	private String mNombreFichero;
	private String mDatos;
	private JFreeChart mGrafico;
	/**
	 * \brief Constructor que recibe los datos de configuración de lo que imprimirá
	 * \param aGrafico, Gráfico a imprimir en pdf (siendo null si no existe gráfico).
	 * \param aDatos, Datos a imprimir, en caso de no exista gráfico.
	 * \param aNombreFichero, Nombre del fichero con el que se guardará el pdf
	 * \param aAncho, ancho del documento.(este tamaño se configurará dentro del docuento, que este puede ser mas o menos grande que lo que indica el ancho)
	 * \param aAlto, alto del documento.(este tamaño se configurará dentro del docuento, que este puede ser mas o menos grande que lo que indica el alto)
	 * \param aVertical, indica la orientación en la que se imprimirá el documento
	 */
	public CrearPDF(JFreeChart aGrafico,String aDatos,String aNombreFichero, int aAncho, int aAlto, boolean aVertical)
	{
		mGrafico = aGrafico;
		mDatos = aDatos;
		mNombreFichero = aNombreFichero;
		mAncho = aAncho;
		mAlto = aAlto;
		initComponent(aVertical);
	}
	/**
	 * \brief Método que inicalizará los atributos que se necesiten.
	 * \param vertical, indica la orientación en la que se configurará el documento.
	 */
	private void initComponent(boolean vertical)
	{
		if(!vertical)
			mDocumento = new Document();
		else
			mDocumento = new Document(PageSize.A4.rotate());
		mEscribe = null;
	}
	/**
	 * \brief Método que escribe el dontenido en el documento pdf.
	 */
	public void escribirGraficoEnPDF()
	{
		try {
			mEscribe = PdfWriter.getInstance(mDocumento, new FileOutputStream(
					mNombreFichero));
			mDocumento.open();
			
			PdfContentByte contentByte = mEscribe.getDirectContent();
			PdfTemplate template = contentByte.createTemplate(mAncho, mAlto);
			contentByte.addTemplate(template, 0, 0);
			
			if(mGrafico != null)
			{
				Graphics2D graphics2d = template.createGraphics(mAncho, mAlto,
						new DefaultFontMapper());
				Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, mAncho, mAlto);
				mGrafico.draw(graphics2d, rectangle2d);
				graphics2d.dispose();
			}
			else
			{
				mDocumento.add(new Paragraph(mDatos));
			}
		} catch (Exception e) {
			mlogConsola.warning("Error:"+e);
		}
		mDocumento.close();
	}
}
