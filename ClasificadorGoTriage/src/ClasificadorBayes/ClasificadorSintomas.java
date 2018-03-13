package ClasificadorBayes;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ClasificadorSintomas {

	double prob;
	TablaHash prioridadI=new TablaHash(5);
	TablaHash prioridadII=new TablaHash(5);
	TablaHash prioridadIII=new TablaHash(5);
	
	int contador=0;
	

	
	public int entrenarPI(String clave,String frase) {
		
	    StringTokenizer tokens = new StringTokenizer(frase);
	    int  numPD=tokens.countTokens();
	    float prob=1/numPD;
	    System.out.println(prob);
	    while (tokens.hasMoreTokens()) {
	        //System.out.println(st.nextToken());
	    
	    	System.out.println(prob);
	    
	    	prioridadI.insertar(tokens.nextToken(), 0.50);
	    	prioridadI.imprimir();
	 
	    }
	      return numPD;
	      
        }
	public int entrenarPII(String clave,String frase) {
		
	    StringTokenizer tokens = new StringTokenizer(frase);
	    int  numPD=tokens.countTokens();
	    while (tokens.hasMoreTokens()) {
	        //System.out.println(st.nextToken());
	    
	    	System.out.println(prob);
	    
	        prioridadII.insertar(tokens.nextToken(), 0.50);
	        prioridadII.imprimir();

	      
	    }
	    return numPD;
	    
        }
	
	public int entrenarPIII(String clave,String frase) {
		
	    StringTokenizer tokens = new StringTokenizer(frase);
	    int  numPD=tokens.countTokens();
	    while (tokens.hasMoreTokens()) {
	        //System.out.println(st.nextToken());
	    
	    	System.out.println(prob);
	    
	        prioridadIII.insertar(tokens.nextToken(), 0.50);
	        prioridadIII.imprimir();

	      
	    }
	    return numPD;
	    
        }
	
/*	public void obtenOcurrencias(String cadena) {
		 
		  
		    String token;
		   
		
		    int contador = 0;

		    while (cadena.indexOf(token) > -1) {
		      cadena= cadena.substring(cadena.indexOf(
		    		  token)+token.length(),cadena.length());
		      contador++; 
		    }

		    System.out.println (contador);

		
	}
*/
		
	public double calcularFRPI(String cadena) {
		double frecuenciaF;
		int contadorF=0;
	
		
	    StringTokenizer tokens = new StringTokenizer(cadena);
		
	    while (tokens.hasMoreTokens()) {
	        //System.out.println(st.nextToken());
	      if(prioridadI.encontrado(tokens.nextToken())) {
	    	 contadorF++; 
	      }
	   
	    }
	    frecuenciaF=(0.5*contadorF/2)/2;
	   
	    
	    System.out.println(frecuenciaF);
	 
	    
	    return frecuenciaF;
	    
	   
	    }
	    
		
		public void adivina(String cadena) {
			 if(calcularFRII(cadena)==calcularFRPI(cadena)) {    	
			    	
			    	JOptionPane.showMessageDialog(null, "Dame más información porfavor");
			    }
			    else  if(calcularFRPI(cadena) > calcularFRII(cadena) && calcularFRPI(cadena) > calcularFRII(cadena)) {
			    	JOptionPane.showMessageDialog(null, "Urgencia de prioridad I"); }
			    	
			    else  if(calcularFRII(cadena) > calcularFRPI(cadena) && calcularFRII(cadena) > calcularFRIII(cadena)) {
			    	JOptionPane.showMessageDialog(null, "Urgencia de prioridad II"); }
			    
			    else {
			    		JOptionPane.showMessageDialog(null,"Urgencia de prioridad III");
			    	}
			
		}
		
		
	
		
	
	
	
	public double calcularFRII(String cadena) {
		double frecuencia;
		int contador=0;
		
	    StringTokenizer tokens = new StringTokenizer(cadena);
		
	    while (tokens.hasMoreTokens()) {
	        //System.out.println(st.nextToken());
	      if(prioridadII.encontrado(tokens.nextToken())) {
	    	 contador++; 
	      }
	      
	    }
	    
	    frecuencia=(0.5*contador/2)/2;
	    
	    System.out.println(frecuencia);
		
		
		return frecuencia;
		
	}
	
	public double calcularFRIII(String cadena) {
		double frecuencia;
		int contador=0;
		
	    StringTokenizer tokens = new StringTokenizer(cadena);
		
	    while (tokens.hasMoreTokens()) {
	        //System.out.println(st.nextToken());
	      if(prioridadIII.encontrado(tokens.nextToken())) {
	    	 contador++; 
	      }
	      
	    }
	    
	    frecuencia=(0.25*contador/4)/4;
	    
	    System.out.println(frecuencia);
		
		
		return frecuencia;
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClasificadorSintomas haz= new ClasificadorSintomas();
		haz.entrenarPI("PrioridadI", "  Dolor abdominal severo\r\n" + 
				"constanteTrauma abdominal\r\n" + 
				"penetrante Parto en curso Retraso con sangrado\r\n" + 
				"vaginal y dolor abdominal\r\n" + 
				"severo Dolor abdominal\r\n" + 
				"acompañado de diaforesis\r\n" + 
				"náuseas dolor en\r\n" + 
				"miembro superior\r\n" + 
				"izquierdo disnea y\r\n" + 
				"angustia Dolor abdominal  vomito o\r\n" + 
				"diarrea con signos de\r\n" + 
				"deshidratacion Trauma abdominal cerrado\r\n" + 
				" dolor\r\n" + 
				"severo sangrado  signos\r\n" + 
				"de choque Enterorragia masiva \r\n" + 
				"Hematemesis masiva Ingesta de toxicos"
				+ "Dolor torácico irradiado a cuello o brazo,\r\n" + 
				"acompañado de diaforesis, disnea,\r\n" + 
				"náuseas o angustia.\r\n" + 
				"Ausencia de pulso.\r\n" + 
				"Cianosis Hipertensión o hipotensión severa Palpitaciones acompañadas de pulso irregular diaforesis náuseas alteración\r\n" + 
				"del estado de alerta o alteración\r\n" + 
				"neurosensorial Hipertensión mayor de140/90 mmHg\r\n" + 
				"asociada a cefalea alteración\r\n" + 
				"neurosensorial alteración del estado de\r\n" + 
				"alerta dolor torácico o epistaxis Lesión penetrante en tórax Exposición eléctrica con pulso irregular Lesión penetrante en vasos\r\n" + 
				"sanguíneos Taquicardia o bradicardia Paciente en choque Dolor torácico con antecedente de\r\n" + 
				"enfermedad coronaria Dolor torácico acompañado de pulsos\r\n" + 
				"asimétricos.\r\n" + 
				"Dolor torácico no irradiado sin disnea o\r\n" + 
				"pulso irregular, sin cambios en el color\r\n" + 
				"de la piel o diaforesis Lipotimia en paciente con marcapasos Sangrado activo y signos de choque"
				+ "Disnea súbita posterior a\r\n" + 
				"inhalación de sustancias\r\n" + 
				"químicas\r\n" + 
				" Quemadura de la vía aérea\r\n" + 
				"Disnea de inicio súbito\r\n" + 
				" Disnea acompañada de\r\n" + 
				"cianosis sibilancias audibles\r\n" + 
				" Disnea con tirajes\r\n" + 
				"supraclaviculares\r\n" + 
				"intercostales aleteo nasal o estridor Hemoptisis masiva Trauma penetrante en tórax Apnea Obstrucción de la vía aérea cuerpo extraño, tapón de\r\n" + 
				"moco trauma facial\r\n" + 
				"inmersiónTrauma cerrado de tórax\r\n" + 
				"acompañado de dolor torácico\r\n" + 
				"disnea súbita o respiración\r\n" + 
				"asimétrica.  ");
		haz.entrenarPII("PrioridadII", "Enterorragia moderada\r\n"
				+ "" + 
				" Sangrado rectal sin otro\r\n" + 
				"compromiso Lesión abdominal reciente\r\n" + 
				"sin dolor severo sangrado o choque\r\n" + 
				"Dolor abdominal intermitente\r\n" + 
				"vómito diarrea\r\n" + 
				"deshidratación leve Imposibilidad para tragar sin\r\n" + 
				"dificultad para respirar Dolor abdominal en mujer\r\n" + 
				"sexualmente activa Dolor abdominal, sangrado\r\n" + 
				"vaginal y fiebre Dolor abdominal localizado,\r\n" + 
				"constante o intermitente\r\n" + 
				"tolerable por el paciente");
		haz.entrenarPIII("PrioridadIII"," Vómito sin sangre Diarrea sin compromiso\r\n" + 
				"del estado general del\r\n" + 
				"paciente Flatulencia Náuseas Estreñimiento Eructos Regurgitación Pirosis Anorexia Hiporexia Cólico menstrual");
		
		
		
		String sintomas=JOptionPane.showInputDialog("Introduce los sintomas");
		
				haz.adivina(sintomas);


		
	}



}
