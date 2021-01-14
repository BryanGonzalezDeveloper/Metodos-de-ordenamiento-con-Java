import java.util.Random;

import javax.swing.DefaultListModel;
/**
 * Clase que permitira el ordenamiento de arreglos de tipo entero<br> mediante los metodos de ordenamiento mas comunes
 * ,asi como de los mas eficientes.
 * @author Bryan Enrique Gonzalez Zambrano.
 * @version 1.0
 * @since 14 de enero de 2021
 */
public class ClsMetodosOrdenamiento 
{
	
	 int[] datos;//Sera el arreglo utilizado en los metodos de ordenamiento
	long duracion;//Sera la variable que guarde la cantidad de segundos en las que se realizo el metodo
	
	/**
	 * Metodo que permite establecer el tamaño del arreglo.
	 * @param cantidad es la cantidad de elementos que tendra el arreglo.
	 */
	public void generarDatos(int cantidad)
	{
		datos=new int [cantidad];
	}
	
	
	/**
	 * LLena un arreglo con elementos aleatorios.
	 * @return arreglo cargado con numeros aleatorios.
	 */
	public int[] llenarArreglo()
	{
		Random alea=new Random();
		for (int i = 0; i < datos.length; i++)
			datos[i]=alea.nextInt(100000);
		return datos;
	}
	/**
	 * Metodo que realiza la ordenacion de un arreglo<br>en orden ascendente aplicando el metodo de la burbuja.
	 * @param arr es el arreglo que se tiene que ordenar.
	 * @return arreglo ordenado
	 */
	public int[] burbuja(int []arr)
	{
		long inicio=System.currentTimeMillis();
		for (int i = arr.length-1; i>=0; i--) 
		{
			for (int j = 0; j<i ; j++) 
			{
				if(arr[j]>arr[j+1])
				{
					int aux=arr[j];
					
					arr[j]=arr[j+1];
					arr[j+1]=aux;
				}
			}
		}
		long fin=System.currentTimeMillis();
		duracion=fin-inicio;//Convierte la duracion del algoritmo que es devuelta en milisegundos a segundos.
		return arr;
	}
	public DefaultListModel imprimir()
	{
		DefaultListModel listaDatos=new DefaultListModel<>();
		for (int i = 0; i < datos.length; i++) 
		{
			listaDatos.addElement(datos[i]);
		}
		return listaDatos;
	}
	
	public double getDuracion()
	{
		return duracion;
	}
}
