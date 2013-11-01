import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JScrollPane;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Interfaz extends JFrame
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Metodo> metodos;
	private ArrayList<StringBuffer> definicionMetodos;
	private javax.swing.JMenuItem menuAbrir;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenu menuArchivo;
    private javax.swing.JFileChooser fileChooser;
	private javax.swing.JButton btnMostrarInforme;
	private javax.swing.JComboBox comboBox;
	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JTextArea textArea;
	private javax.swing.JLabel lblMtodos;
	private javax.swing.JLabel lblDatosDelArchivo;
	private javax.swing.JLabel lblPorcComentadas;
	private javax.swing.JLabel labelPorcComentadas;
	private javax.swing.JLabel lblLineasDeCdigo;
	private JLabel jLReslincodsincomMet;
	private JLabel jLReslincodcomMet;
	private JLabel jLReslincodMet;
	private JLabel jLPorcResMet;
	private JLabel jLlineassincomMet;
	private JLabel jLlineascomMet;
	private JLabel jLlineasdecodMet;
	private JLabel jLabel1;
	private javax.swing.JLabel labelCodigo;
	private javax.swing.JLabel lblLineasComentadas;
	private javax.swing.JLabel labelComentadas;
	private javax.swing.JLabel lblLineasSinComentar;
	private javax.swing.JLabel labelSinComentar;
	private javax.swing.JLabel lblMtodoSeleccionado;
	private javax.swing.JLabel labelMetodo;
	private javax.swing.JLabel lblComplejidadCiclomtica;
	private javax.swing.JLabel labelCC;
	private javax.swing.JLabel lblFanin;
	private javax.swing.JLabel labelFanIn;
	private javax.swing.JLabel lblFanout;
	private javax.swing.JLabel labelFanOut;	
	private String path = "";
	
	public Interfaz()
	{		
		super();
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			setTitle("Herramienta de Gesti\u00F3n de Testing");
			getContentPane().setLayout(null);			
						
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 55, 21);
			getContentPane().add(menuBar);
			
			menuArchivo = new JMenu(" Archivo");
			menuArchivo.setHorizontalAlignment(SwingConstants.CENTER);
			menuBar.add(menuArchivo);
			
			menuAbrir = new JMenuItem("Abrir");
			menuAbrir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent  evt) {
					  try {
							abrirArchivoMenuItemActionPerformed(evt);
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			});
			menuArchivo.add(menuAbrir);
	        			
			fileChooser = new JFileChooser();
	        fileChooser.setFileFilter(new MiFiltroAMedida() );
	        fileChooser.setName("fileChooser");
			
			comboBox = new JComboBox();
			comboBox.setBounds(80, 420, 134, 20);
			getContentPane().add(comboBox);
			
			lblMtodos = new JLabel("M\u00E9todos:");
			lblMtodos.setBounds(10, 423, 60, 14);
			getContentPane().add(lblMtodos);
			
			lblDatosDelArchivo = new JLabel("Datos del Archivo:");
			lblDatosDelArchivo.setBounds(10, 266, 110, 14);
			getContentPane().add(lblDatosDelArchivo);
			
			lblPorcComentadas = new JLabel("Lineas Comentadas: %");
			lblPorcComentadas.setBounds(10, 291, 130, 14);
			getContentPane().add(lblPorcComentadas);
			
			labelPorcComentadas = new JLabel("<total>");
			labelPorcComentadas.setBounds(145, 291, 38, 14);
			getContentPane().add(labelPorcComentadas);
			labelPorcComentadas.setVisible(false);
			
			lblLineasDeCdigo = new JLabel("Lineas de C\u00F3digo:");
			lblLineasDeCdigo.setBounds(10, 316, 110, 14);
			getContentPane().add(lblLineasDeCdigo);
			
			labelCodigo = new JLabel("<codg>");
			labelCodigo.setBounds(133, 316, 46, 14);
			getContentPane().add(labelCodigo);
			labelCodigo.setVisible(false);
			
			lblLineasComentadas = new JLabel("Lineas Comentadas:");
			lblLineasComentadas.setBounds(10, 340, 127, 14);
			getContentPane().add(lblLineasComentadas);
			
			labelComentadas = new JLabel("<coment>");
			labelComentadas.setBounds(133, 340, 67, 14);
			getContentPane().add(labelComentadas);
			labelComentadas.setVisible(false);
			
			lblLineasSinComentar = new JLabel("Lineas sin Comentar:");
			lblLineasSinComentar.setBounds(10, 362, 127, 14);
			getContentPane().add(lblLineasSinComentar);
			
			labelSinComentar = new JLabel("<sincom>");
			labelSinComentar.setBounds(133, 362, 67, 14);
			getContentPane().add(labelSinComentar);
			labelSinComentar.setVisible(false);
			
			lblMtodoSeleccionado = new JLabel("M\u00E9todo Seleccionado:");
			lblMtodoSeleccionado.setBounds(261, 266, 350, 14);
			getContentPane().add(lblMtodoSeleccionado);
			lblMtodoSeleccionado.setVisible(false);
					
			labelMetodo = new JLabel("<metodo>");
			labelMetodo.setBounds(419, 266, 140, 14);
			getContentPane().add(labelMetodo);
			labelMetodo.setVisible(false);
			
			lblComplejidadCiclomtica = new JLabel("Complejidad Ciclom\u00E1tica:");
			lblComplejidadCiclomtica.setBounds(261, 316, 145, 14);
			getContentPane().add(lblComplejidadCiclomtica);
			lblComplejidadCiclomtica.setVisible(false);
			
			labelCC = new JLabel("<cc>");
			labelCC.setBounds(418, 316, 46, 14);
			getContentPane().add(labelCC);
			labelCC.setVisible(false);
			
			lblFanin = new JLabel("Fan-in:");
			lblFanin.setBounds(261, 340, 46, 14);
			getContentPane().add(lblFanin);
			lblFanin.setVisible(false);
			
			labelFanIn = new JLabel("<fin>");
			labelFanIn.setBounds(418, 340, 46, 14);
			getContentPane().add(labelFanIn);
			labelFanIn.setVisible(false);
			
			lblFanout = new JLabel("Fan-out:");
			lblFanout.setBounds(261, 362, 46, 14);
			getContentPane().add(lblFanout);
			lblFanout.setVisible(false);
			
			labelFanOut = new JLabel("<fout>");
			labelFanOut.setBounds(418, 362, 46, 14);
			getContentPane().add(labelFanOut);
			labelFanOut.setVisible(false);
			
			btnMostrarInforme = new JButton("Mostrar Informe");
			btnMostrarInforme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
							JButtonInformeItemActionPerformed(evt);
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			});
			btnMostrarInforme.setBounds(230, 419, 145, 23);
			getContentPane().add(btnMostrarInforme);
			
		    scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 32, 617, 217);
			getContentPane().add(scrollPane);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Lineas Comentadas: %");
				jLabel1.setBounds(464, 291, 130, 14);
				jLabel1.setVisible(false);
			}
			{
				jLlineasdecodMet = new JLabel();
				getContentPane().add(jLlineasdecodMet);
				jLlineasdecodMet.setText("Lineas de C\u00F3digo:");
				jLlineasdecodMet.setBounds(464, 316, 110, 14);
				jLlineasdecodMet.setVisible(false);
			}
			{
				jLlineascomMet = new JLabel();
				getContentPane().add(jLlineascomMet);
				jLlineascomMet.setText("Lineas Comentadas:");
				jLlineascomMet.setBounds(464, 340, 127, 14);
				jLlineascomMet.setVisible(false);
			}
			{
				jLlineassincomMet = new JLabel();
				getContentPane().add(jLlineassincomMet);
				jLlineassincomMet.setText("Lineas sin Comentar:");
				jLlineassincomMet.setBounds(464, 362, 127, 14);
				jLlineassincomMet.setVisible(false);
			}
			{
				jLPorcResMet = new JLabel();
				getContentPane().add(jLPorcResMet);
				jLPorcResMet.setText("<total>");
				jLPorcResMet.setVisible(true);
				jLPorcResMet.setBounds(611, 291, 38, 14);
				jLPorcResMet.setVisible(false);
			}
			{
				jLReslincodMet = new JLabel();
				getContentPane().add(jLReslincodMet);
				jLReslincodMet.setVisible(true);
				jLReslincodMet.setBounds(611, 315, 46, 16);
				jLReslincodMet.setText("0");
				jLReslincodMet.setVisible(false);
			}
			{
				jLReslincodcomMet = new JLabel();
				getContentPane().add(jLReslincodcomMet);
				jLReslincodcomMet.setVisible(true);
				jLReslincodcomMet.setBounds(611, 336, 46, 14);
				jLReslincodcomMet.setText("0");
				jLReslincodcomMet.setVisible(false);
			}
			{
				jLReslincodsincomMet = new JLabel();
				getContentPane().add(jLReslincodsincomMet);
				jLReslincodsincomMet.setVisible(true);
				jLReslincodsincomMet.setBounds(611, 362, 46, 14);
				jLReslincodsincomMet.setText("0");
				jLReslincodsincomMet.setVisible(false);
			}

			textArea = new JTextArea();
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
						
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;		
			this.setSize(700, 500);
			this.setVisible(true);		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		this.setVisible(true);		
	}
	
	//Accion que ejecuta cada vez que se apreta el botón de Informe
	public void JButtonInformeItemActionPerformed(ActionEvent evt)throws IOException
	{	
		String linea = new String();
		String metodoSeleccionado = (comboBox.getSelectedItem()).toString(); //Se obtiene el metodo seleccionado del comboBox
		Metodo metodo = new Metodo();
		StringBuffer aux = new StringBuffer();
		String nl = System.getProperty("line.separator");
		
		metodo.nombre = metodoSeleccionado;
		int i = metodos.indexOf(metodo); //Se obtiene el índice del metodo seleccionado dentro del ArrayList de metodos
			
		textArea.setText("");
	
		BufferedReader br = new BufferedReader(new FileReader(path));
		if(metodos.get(i).fanIn == -1 && metodos.get(i).fanOut == -1) //Si el fanIn y el fanOut tienen -1 quiere decir que no fue calculado ese metodo
		{
			metodos.get(i).fanIn = 0;
			metodos.get(i).fanOut = 0;
			linea = br.readLine();
			while(linea != null)
			{	   
				//Si la linea contiene el nombre del metodo(i) con parentesis
				if(linea.contains(metodos.get(i).nombre + "(") || linea.contains(metodos.get(i).nombre + " ("))
				{					
					//Si contiene public o private, para evitar que sea una llamada al metodo
					if(linea.contains("public ") || linea.contains("private "))
					{
						//Si no contiene ; para evitar que sea la declaracion del metodo
						if(!linea.contains(";"))
						{	
							int llaves = -1;
							//Para saber cuando finaliza el metodo, un contador de llaves
							if(!linea.contains("{"))
							{								
								aux.append(linea + nl);
								textArea.append(linea + "\n");
								linea = br.readLine();
							}				
							//Cuando llaves vuelva a ser 0 va a haber terminado el metodo
							while(linea != null && llaves != 0)
							{	//Cuento lineas por metodo
								//Si la linea no es vacia o no es igual a una tabulacion
								   if(!linea.isEmpty() && !linea.equalsIgnoreCase("\t"))
								   {
									   metodos.get(i).cantLineasTotales++;
									   if(linea.startsWith("//")) //Si es una linea solo de comentarios
										   metodos.get(i).cantComentarios++;
									   else if(linea.contains("//")) //Si es una linea de comentarios y codigo
									   {
										   metodos.get(i).cantCodigo++;
										   metodos.get(i).cantComentarios++;
									   }
									   else 
										   //Es solo codigo
										   metodos.get(i).cantCodigo++;
								
								   }	
								if(llaves == -1)
									llaves = 0;
								//Si la linea contiene { o } incrementa o decrementa el contador de llaves
								if(linea.contains("{") && !linea.contains("\"{\"") && !linea.contains("'{'"))
									llaves++;						
								if(linea.contains("}") && !linea.contains("\"}\"") && !linea.contains("'}'"))
									llaves--;
								//Por cada linea se fija si dentro de ese metodo hay llamadas a otros metodos o a si mismo para incrementar el fanIn y fanOut
								for(int j = 0; j < metodos.size(); j++)
									if(linea.contains(metodos.get(j).nombre + "(") || linea.contains(metodos.get(j).nombre + " ("))
									{
										if(metodos.get(i).nombre.equals(metodos.get(j).nombre))
											metodos.get(i).fanIn++;
										metodos.get(i).fanOut++;
									}
								//Si la linea contiene una palabra reservada de estructura de decision, se incrementa el numero ciclomatico
								if(linea.contains("for(") || linea.contains("for (")
									|| linea.contains("while(") || linea.contains("while (")
									|| linea.contains("if(") || linea.contains("if (")
									|| linea.contains("\tcase ") || linea.contains("default:"))
								{
									metodos.get(i).nroCiclomatico++;
									String textoBuscado=new String();
									String auxiliar= new String();
								//En la estructura de decision, cuenta la cantidad de condiciones que tene la misma para incrementar el numero ciclomatico
									if(linea.contains("&&")){
										textoBuscado="&&";
									     auxiliar=linea;
									     while (auxiliar.indexOf(textoBuscado) > -1) {
									    	 metodos.get(i).nroCiclomatico++;	
									    	 auxiliar = auxiliar.substring(auxiliar.indexOf(
									    			 	textoBuscado)+textoBuscado.length(),auxiliar.length());
									      
									     }
									}
									if(linea.contains("||")){
										 textoBuscado="||";
										 auxiliar=linea;
										 while (auxiliar.indexOf(textoBuscado) > -1) {
											 metodos.get(i).nroCiclomatico++;
										     auxiliar = auxiliar.substring(auxiliar.indexOf(
										    		 	textoBuscado)+textoBuscado.length(),auxiliar.length());
										      	
										 }
									}
								}
								//Se appendea la linea a aux para que despues pueda ser appendeada sin tener que recorrer de vuelta el archivo
								aux.append(linea);
								aux.append(nl);
								textArea.append(linea + "\n");
								linea = br.readLine();
							}
						}
					}
					else
						//Es una llamada al metodo, se incrementa el fanIn
						metodos.get(i).fanIn++;
				}
				linea = br.readLine();
			}
			//Se agrega al ArrayList de StringBuffer definicionMetodos la definicion aux
			definicionMetodos.add(aux);
			//En el ArrayList de metodos, se le pone al metodo llamado el indice de donde quedo su definicion en definicionMetodos
			metodos.get(i).definicion = definicionMetodos.indexOf(aux);
			br.close();
		}
		else
			//Ya se habia informado, se appendea la definicion correspondiente obteniendo el indice definicion del metodo seleccionado
			textArea.append(definicionMetodos.get(metodos.get(i).definicion).toString());
		//Se setean todos los labels con los textos y la visibilidad correspondiente
		labelMetodo.setText(metodos.get(i).nombre + " ()");
		labelCC.setText((metodos.get(i).nroCiclomatico).toString());
		labelFanIn.setText((metodos.get(i).fanIn).toString());
		labelFanOut.setText((metodos.get(i).fanOut).toString());
		double porcentajemet = ((double) metodos.get(i).cantComentarios / metodos.get(i).cantCodigo) * 100.0;
		jLPorcResMet.setText(String.format("%.2f", porcentajemet));
		jLReslincodMet.setText(metodos.get(i).cantCodigo.toString());
		jLReslincodcomMet.setText(metodos.get(i).cantComentarios.toString());
		Integer cantSinComentarMet = metodos.get(i).cantLineasTotales - metodos.get(i).cantComentarios;
		jLReslincodsincomMet.setText(cantSinComentarMet.toString());
		jLPorcResMet.setVisible(true);
		jLReslincodMet.setVisible(true);
		jLReslincodcomMet.setVisible(true);
		jLReslincodsincomMet.setVisible(true);

		jLlineassincomMet.setVisible(true);
		jLlineascomMet.setVisible(true);
		jLlineasdecodMet.setVisible(true);
		jLabel1.setVisible(true);
		labelMetodo.setVisible(true);
		labelCC.setVisible(true);
		labelFanIn.setVisible(true);
		labelFanOut.setVisible(true);
		lblMtodoSeleccionado.setVisible(true);
		lblComplejidadCiclomtica.setVisible(true);
		lblFanout.setVisible(true);
		lblFanin.setVisible(true);		
	}
	
	//Metodo que calcula el indice a partir de donde cortar la linea para extraer el nombre del metodo
	private static int indiceMetodo(String linea, int i) 
	{
		while(i > 0 && linea.charAt(i) != ' ')
			i--;
		return i + 1;
	}

	//Metodo que calcula el indice a partir de donde cortar la linea para extraer el nombre de la clase
	private static int indiceClase(String linea, int i) 
	{
		while(i < linea.length())
		{
			if(linea.charAt(i) == '{' || linea.charAt(i) == ' ')
				return i;
			i++;
		}
		return linea.length();
	}
	
	//Accion que ejecuta cada vez que se apreta el botón de abrir archivo
	private void abrirArchivoMenuItemActionPerformed(java.awt.event.ActionEvent evt) throws IOException 
	{
        int dev = fileChooser.showOpenDialog(Interfaz.this); //Se muestra el dialogo para abrir el archivo
        BufferedReader br = null;    
        String linea = new String();
		metodos = new ArrayList<Metodo>();
		definicionMetodos = new ArrayList<StringBuffer>();	
        Integer cantLineasTotales = 0;
        Integer cantComentarios = 0;
 	   	Integer cantCodigo = 0;
 	   	this.textArea.setText("");
 	   	this.comboBox.removeAllItems();
        if(dev == JFileChooser.APPROVE_OPTION) //Si se abrio el archivo
        {
           File archivo = fileChooser.getSelectedFile(); //Se obtiene el archivo seleccionado
           try 
           {
        	   path = archivo.getAbsolutePath(); //Y su path correspondiente
        	   br = new BufferedReader(new FileReader(path)); //Para abrirlo y comenzar a leerlo
        	   String nombreClase = new String();
			   linea = br.readLine();
			   while (linea != null)
			   {
				   //Si la linea no es vacia o no es igual a una tabulacion
				   if(!linea.isEmpty() && !linea.equalsIgnoreCase("\t"))
				   {
					   cantLineasTotales++;
					   if(linea.startsWith("//")) //Si es una linea solo de comentarios
						   cantComentarios++;
					   else if(linea.contains("//")) //Si es una linea de comentarios y codigo
					   {
						   cantCodigo++;
						   cantComentarios++;
					   }
					   else 
						   //Es solo codigo
						   cantCodigo++;	
					   //Si la linea contiene public o private y no contiene una palabra reservada de estructura de decision
					   if((linea.contains("public ") || linea.contains("private ")) && !(linea.contains("for(") || linea.contains("for (")
								|| linea.contains("while(") || linea.contains("while (")
								|| linea.contains("if(") || linea.contains("if (")
								|| linea.contains("\tcase ") || linea.contains("default:")))
					   {
						   int indicePalabra = 0;
						   //Si es una clase se extrae su nombre
						   if((indicePalabra = linea.indexOf("class ")) > -1)
							   nombreClase = linea.substring(indicePalabra + 6, indiceClase(linea, indicePalabra + 6));
						   //Sino, puede ser un metodo o un constructor
						   else if((indicePalabra = linea.indexOf("(")) > -1)
						   {
							   Metodo metodo = new Metodo();
							   //Se extrae el nombre del metodo
							   if(linea.charAt(indicePalabra - 1) == ' ')
								   metodo.nombre = linea.substring(indiceMetodo(linea, indicePalabra - 2), indicePalabra - 1);
							   else
								   metodo.nombre = linea.substring(indiceMetodo(linea, indicePalabra), indicePalabra);
							   //Si no contiene el nombre de la clase, entonces es un metodo
							   if(!metodo.nombre.equals(nombreClase))
							   {
								   //Si no se encuentra en la lista de metodos (puede que se haya levantado una declaracion)
								   if(!metodos.contains(metodo))
								   {
									   //Se agrega el metodo a la lista y tambien al comboBox
									   metodos.add(metodo);
									   this.comboBox.addItem(metodo.nombre);
									}
							   }
						   }
					   }
				   }	
				   this.textArea.append(linea); 
				   this.textArea.append("\n");   
				   linea = br.readLine();
			   }
			   br.close();
           }
           catch (FileNotFoundException e) 
           {
        	   textArea.setText("No se pudo abrir el archivo");
           }
        }        
        double porcentaje = ((double)cantComentarios / cantCodigo) * 100.0;
		labelPorcComentadas.setText(String.format("%.2f", porcentaje));
		labelCodigo.setText(cantCodigo.toString());
		labelComentadas.setText(cantComentarios.toString());
		Integer cantSinComentar = cantLineasTotales - cantComentarios;
		labelSinComentar.setText(cantSinComentar.toString());		
		labelPorcComentadas.setVisible(true);
		labelCodigo.setVisible(true);
		labelComentadas.setVisible(true);
		labelSinComentar.setVisible(true);	
	}
	
	public static void main(String [] args) throws IOException
	{
		new Interfaz();	    	
	}
        
	class MiFiltroAMedida extends javax.swing.filechooser.FileFilter 
	{
		public boolean accept (File file) 
		{
			return file.isDirectory() || file.getAbsolutePath().endsWith(".java");         
		}
		@Override
		public String getDescription() 
		{
			return "Documentos *.java";
	    }
	}
}