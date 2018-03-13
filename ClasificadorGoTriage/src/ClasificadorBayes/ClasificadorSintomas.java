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
			    	
			    	JOptionPane.showMessageDialog(null, "Dame m�s informaci�n porfavor");
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
				"acompa�ado de diaforesis\r\n" + 
				"n�useas dolor en\r\n" + 
				"miembro superior\r\n" + 
				"izquierdo disnea y\r\n" + 
				"angustia Dolor abdominal  vomito o\r\n" + 
				"diarrea con signos de\r\n" + 
				"deshidratacion Trauma abdominal cerrado\r\n" + 
				" dolor\r\n" + 
				"severo sangrado  signos\r\n" + 
				"de choque Enterorragia masiva \r\n" + 
				"Hematemesis masiva Ingesta de toxicos"
				+ "Dolor tor�cico irradiado a cuello o brazo,\r\n" + 
				"acompa�ado de diaforesis, disnea,\r\n" + 
				"n�useas o angustia.\r\n" + 
				"Ausencia de pulso.\r\n" + 
				"Cianosis Hipertensi�n o hipotensi�n severa Palpitaciones acompa�adas de pulso irregular diaforesis n�useas alteraci�n\r\n" + 
				"del estado de alerta o alteraci�n\r\n" + 
				"neurosensorial Hipertensi�n mayor de140/90 mmHg\r\n" + 
				"asociada a cefalea alteraci�n\r\n" + 
				"neurosensorial alteraci�n del estado de\r\n" + 
				"alerta dolor tor�cico o epistaxis Lesi�n penetrante en t�rax Exposici�n el�ctrica con pulso irregular Lesi�n penetrante en vasos\r\n" + 
				"sangu�neos Taquicardia o bradicardia Paciente en choque Dolor tor�cico con antecedente de\r\n" + 
				"enfermedad coronaria Dolor tor�cico acompa�ado de pulsos\r\n" + 
				"asim�tricos.\r\n" + 
				"Dolor tor�cico no irradiado sin disnea o\r\n" + 
				"pulso irregular, sin cambios en el color\r\n" + 
				"de la piel o diaforesis Lipotimia en paciente con marcapasos Sangrado activo y signos de choque"
				+ "Disnea s�bita posterior a\r\n" + 
				"inhalaci�n de sustancias\r\n" + 
				"qu�micas\r\n" + 
				" Quemadura de la v�a a�rea\r\n" + 
				"Disnea de inicio s�bito\r\n" + 
				" Disnea acompa�ada de\r\n" + 
				"cianosis sibilancias audibles\r\n" + 
				" Disnea con tirajes\r\n" + 
				"supraclaviculares\r\n" + 
				"intercostales aleteo nasal o estridor Hemoptisis masiva Trauma penetrante en t�rax Apnea Obstrucci�n de la v�a a�rea cuerpo extra�o, tap�n de\r\n" + 
				"moco trauma facial\r\n" + 
				"inmersi�nTrauma cerrado de t�rax\r\n" + 
				"acompa�ado de dolor tor�cico\r\n" + 
				"disnea s�bita o respiraci�n\r\n" + 
				"asim�trica.  ");
		haz.entrenarPII("PrioridadII", "Enterorragia moderada\r\n"
				+ "" + 
				" Sangrado rectal sin otro\r\n" + 
				"compromiso Lesi�n abdominal reciente\r\n" + 
				"sin dolor severo sangrado o choque\r\n" + 
				"Dolor abdominal intermitente\r\n" + 
				"v�mito diarrea\r\n" + 
				"deshidrataci�n leve Imposibilidad para tragar sin\r\n" + 
				"dificultad para respirar Dolor abdominal en mujer\r\n" + 
				"sexualmente activa Dolor abdominal, sangrado\r\n" + 
				"vaginal y fiebre Dolor abdominal localizado,\r\n" + 
				"constante o intermitente\r\n" + 
				"tolerable por el paciente");
		haz.entrenarPIII("PrioridadIII"," V�mito sin sangre Diarrea sin compromiso\r\n" + 
				"del estado general del\r\n" + 
				"paciente Flatulencia N�useas Estre�imiento Eructos Regurgitaci�n Pirosis Anorexia Hiporexia C�lico menstrual");
		
		
		
		String sintomas=JOptionPane.showInputDialog("Introduce los sintomas");
		
				haz.adivina(sintomas);


		
	}



}
