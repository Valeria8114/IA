package ClasificadorBayes;

public class TablaHash {

  
   private static class ListaEnlazada {
      String llave;
      double valor;
      ListaEnlazada siguiente;  //puntero al siguiente nodo de la lista
   }

   private ListaEnlazada[] tabla;  // Tabla hash representada como un arreglo de lista enlazada

   private int cuenta;  

 
   public TablaHash() {
      tabla = new ListaEnlazada[64];
   }

   public TablaHash(int tamañoInicial) {
      if (tamañoInicial <= 0)
         throw new IllegalArgumentException("Favor de ingresar un numero mayor a 0");
      tabla = new ListaEnlazada[tamañoInicial];
   }

 
   void imprimir() {
      System.out.println();
      for (int i = 0; i < tabla.length; i++) {
            
         System.out.print(i + ":");
         ListaEnlazada lista = tabla[i]; 
         while (lista != null) {
            System.out.print("  (" + lista.llave + "," + lista.valor + ")");
            lista = lista.siguiente;
         }
         System.out.println();
      }
   } 

   public void insertar(String llave, double prob) {
      
      assert llave != null : "La llave no debe ser null";
      
      int espacio = hash(llave); 
      
      ListaEnlazada lista = tabla[espacio]; 
      while (lista != null) {
            //Busca si existe la llave en los nodos
         if (lista.llave.equals(llave))
            break;
         lista = lista.siguiente;
      }
      if (lista != null) {
         lista.valor = prob;
      }
      else {
            
         if (cuenta >= 0.75*tabla.length) {
              //si comienza a llenarse, se incrementa
            agrandar();
            espacio = hash(llave);  
         }
         ListaEnlazada nuevoNodo = new ListaEnlazada();
         nuevoNodo.llave = llave;
         nuevoNodo.valor = prob;
         nuevoNodo.siguiente = tabla[espacio];
         tabla[espacio] =nuevoNodo;
         cuenta++; 
      }
   }

   

  
   public boolean encontrado(String key) {
	      
	      int espacio = hash(key); 
	      
	      ListaEnlazada list = tabla[espacio]; 
	      while (list != null) {
	            
	         if (list.llave.equals(key))
	            return true;
	         list = list.siguiente;  
	      }
	      
	    
	      return false;  
	   }
   
  
   public double obtenerValor(String key) {
	      
	      int espacio = hash(key); 
	      
	      ListaEnlazada lista = tabla[espacio]; 
	      while (lista != null) {
	            
	         if (lista.llave.equals(key))
	            return lista.valor;
	         lista = lista.siguiente;  
	      }
	      
	    
	      return 0;
	   }



   
  
   public int tamaño() {
      return cuenta;
   }


   
   private int hash(Object key) {
      return (Math.abs(key.hashCode())) % tabla.length;
   }

  
   private void agrandar() {
      ListaEnlazada[] nuevaTabla = new ListaEnlazada[tabla.length*2];
      for (int i = 0; i < tabla.length; i++) {
             
    	  ListaEnlazada lista = tabla[i]; // For traversing linked list number i.
         while (lista != null) {
               
        	 ListaEnlazada siguiente = lista.siguiente;  
            int hash = (Math.abs(lista.llave.hashCode())) % nuevaTabla.length;
              
            lista.siguiente = nuevaTabla[hash];
            nuevaTabla[hash] = lista;
            lista = siguiente;  
         }
      }
      tabla = nuevaTabla; 
   } 

} 