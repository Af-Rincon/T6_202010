package controller;

import java.util.Iterator;
import java.util.Scanner;

import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
											
					break;
				case 2:
					view.printMessage("Digite el objectID del comparendo que desea buscar");
					String id = lector.next();
					view.printMessage(modelo.consultarPorID(id).datosCluster3());
					break;
				case 3:
					view.printMessage("Digite el primer objectID");
					String lo = lector.next();
					view.printMessage("Digite el segundo objectID");
					String hi = lector.next();
					Iterator<Comparendo> valores = modelo.consultarRangoID(lo, hi);
					while(valores.hasNext())
					{
						Comparendo c = valores.next();
						view.printMessage(c.datosCluster3());
						c = valores.next();
					}
				break;
				
			

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
