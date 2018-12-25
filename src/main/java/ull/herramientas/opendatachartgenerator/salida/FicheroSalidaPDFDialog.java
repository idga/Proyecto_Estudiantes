package ull.herramientas.opendatachartgenerator.salida;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
/**
 * \class FicheroSalidaPDFDialog 
 * \brief clase para seleccionar el nombre del fichero donde se va a guardar
 * Los gráficos se guardaran en el lugar indicado en el asistende.
 * 
 * \author Orlandy Ariel Sánchez Acosta
 * \author Joel Pérez Ramos
 * \author Mauricio José Orta Rodríguez
 * \author Ángel Rodríguez Negrin
 */
public class FicheroSalidaPDFDialog extends JDialog
{
	private JTextField m_jtfNombreDirectorio;
	private JButton m_btnExaminar;
	private JFileChooser m_fcExaminar;
	private String m_RutaDirectorio;
	private JButton m_btnAceptar;
	public FicheroSalidaPDFDialog(Frame ventana)
	{
		super(ventana,"Seleccionar directorio de salida",true);
		initComponent();
	}
	private  void initFormulario()
	{
		m_jtfNombreDirectorio = new JTextField();
		m_jtfNombreDirectorio.setVisible(true);
		m_jtfNombreDirectorio.setColumns(20);
		
		m_btnExaminar = new JButton("Examinar");
		m_btnExaminar.setVisible(true);
		m_btnExaminar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				m_fcExaminar = new JFileChooser();
				m_fcExaminar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);/// Se le indica de que solo se abrirá directorios
				int t_selecion =m_fcExaminar.showSaveDialog(getContentPane());
				//Cuando el usuario acepte
				if(t_selecion==JFileChooser.APPROVE_OPTION){

					//Se selecciona el fichero
					File fichero=m_fcExaminar.getSelectedFile();

					//Muestra el directorio de salida.
					m_jtfNombreDirectorio.setText(fichero.getAbsolutePath());
					m_RutaDirectorio = m_jtfNombreDirectorio.getText();
				}
			}
		});
		m_btnAceptar = new JButton("Aceptar");
		m_btnAceptar.setVisible(true);
		m_btnAceptar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}
	public String getRuta()
	{
		return m_RutaDirectorio;
	}
	private void initComponent()
	{
		initFormulario();
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setSize(450,200);
		
		add(m_jtfNombreDirectorio);
		add(m_btnExaminar);
		add(m_btnAceptar);
	}
}
