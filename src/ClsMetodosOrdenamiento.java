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
	 int[]original;
	long duracion;//Sera la variable que guarde la cantidad de segundos en las que se realizo el metodo
	long inicio;
	long fin;
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
		
		 inicio=System.currentTimeMillis();
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
		 fin=System.currentTimeMillis();
		duracion=fin-inicio;//Convierte la duracion del algoritmo que es devuelta en milisegundos a segundos.
		return arr;
	}
	
	public int[] seleccion(int []arr)
	{
		int menor=-1;
		int aux1=0;
		 inicio=System.currentTimeMillis();
		for (int i = 0; i < arr.length; i++) 
		{
			
			for (int j = arr.length-1; j>i; j--)
			{
				menor=arr[i];
				if(menor>arr[j])
				{
					aux1=arr[j];
					arr[j]=menor;
					menor=aux1;
					arr[i]=menor;
				}
			}
			
		}
		 fin=System.currentTimeMillis();
		duracion=fin-inicio;
		return arr;
	}
	
	/**
	 * Metodo que ordena un arreglo de numeros enteros<br>utilizando el metodo de insercion directa.
	 * @param arr es el arreglo que se debe ordenar
	 * @return arreglo ordenado.
	 */
	public int[] insercionDirecta(int[] arr)
	{
		int aux=-1;
		int j=-1;
		inicio=System.currentTimeMillis();
		for(int i=1; i<arr.length;i++)
		{
			aux=arr[i];
			j=i-1;
			while(j>=0 && aux<arr[j])
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=aux;
		}
		fin=System.currentTimeMillis();
		duracion=fin-inicio;
		return arr;
	}
	
	/**
	 * Metodo que ordena un arreglo de numeros enteros implementando el metodo shellSort.
	 * @param arr es el arreglo que se quiere ordenar.
	 * @return arreglo ordenado
	 */
	public  int[] shellSort(int[] arr)
	{
		int k, j, aux;
		int i = 1;
		inicio=System.currentTimeMillis();
		while (i <= arr.length) 
		{
			i = i * 2 + 1;
		}
		while (i > 0)
		{
			for (j = i; j < arr.length; j++)
			{
				aux = arr[j];
				k = j;

				while (k > i - 1 && arr[k - i] >= aux)
				{
					arr[k] = arr[k - i];
					k -= i;
				}
				arr[k] = aux;
			}
			i = (i - 1) / 2;

		}
		fin=System.currentTimeMillis();
		duracion=fin-inicio;
		return arr;
	}
	
	
	public DefaultListModel imprimir(int[] arr)
	{
		DefaultListModel listaDatos=new DefaultListModel<>();
		for (int i = 0; i < arr.length; i++) 
		{
			listaDatos.addElement(arr[i]);
		}
		return listaDatos;
	}
	
	public double getDuracion()
	{
		return duracion;
	}
}
