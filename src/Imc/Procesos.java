package Imc;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procesos {

	ArrayList<String> listaNombres;
	ArrayList<Double> listaPesos;
	ArrayList<Double> listaAlturas;
	ArrayList<String> resultados;
	int cont = 0;
	String nombreIngresar = "";
	Boolean validar = true;
	int pos = 0;

	public Procesos() {

		this.listaNombres = new ArrayList<String>();
		this.listaPesos = new ArrayList<Double>();
		this.listaAlturas = new ArrayList<Double>();
		this.resultados = new ArrayList<String>();
	}

	public void iniciar() {
		String menu = "IMC\n";
		menu += "1. Ingresar persona \n";
		menu += "2. Imprimir personas\n";
		menu += "3. imprimir imc \n";
		menu += " 4. buscar persona \n";
		menu += "5. eliminar persona \n";
		menu += "6. actualizar   \n";
		menu += "7. Limpiar \n";
		menu += "8. Salir \n";
		menu += "Ingrese una opcion valida: ";
		int opc = 0;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarMenu(opc);
		} while (opc != 8);
	}

	public void validarMenu(int opc) {
		switch (opc) {
		case 1:
			ingresarPersona();
			break;
		case 2:
			imprimir();
			break;
		case 3:
			imprimirimc();
			break;

		case 4:
			buscarNombre();
			break;
		case 5:
			eliminar();

			break;
		case 6:
			actualizar();
			break;
		case 7:
			limpiar();
			break;
		case 8:
			System.out.println("Salir");
			break;
		default:
			System.out.println("Ingrese una opcion valida");
			break;
		}
	}

	private void limpiar() {
		listaNombres.clear();

	}
	
	

	private void actualizar() {
		// Procesos ex = new Procesos();
		nombreIngresar = JOptionPane.showInputDialog("Ingrese el nombre ");
		if (existe() == true) {
			String input = JOptionPane.showInputDialog("INGRESE EL NOMBRE");
			listaNombres.set(pos, input);
			System.out.println("se actualizo");
		} else {
			System.out.println("no se encuentra");
		}
	}

	private void buscarNombre() {
		String nombresIngresar = JOptionPane.showInputDialog("Ingrese el nombre ");

		if (listaNombres.contains(nombresIngresar)) {
			for (int i = 0; i < listaNombres.size(); i++) {
				if (listaNombres.get(i).equalsIgnoreCase(nombresIngresar)) {
					System.out.println("______");
					System.out.println(listaNombres.get(i) + " esta registrada");

				} else if (cont == 0) {
					System.out.println("La persona " + nombresIngresar + " no fue registrada");
				}
			}
		}
	}

	private void imprimirimc() {

		String mensaje = "";
		for (int i = 0; i < listaNombres.size(); i++) {
			double imc = listaPesos.get(i) / (listaAlturas.get(i) * listaAlturas.get(i));
			if (imc < 18) {
				resultados.add("Anorexia");
				mensaje = "Anorexia";
			} else if (imc >= 18 && imc < 20) {
				resultados.add("Delgadez");
				mensaje = "Delgadez";
			} else if (imc >= 20 && imc < 27) {
				resultados.add("Normalidad");
				mensaje = "Normalidad";
			} else if (imc >= 27 && imc < 30) {
				resultados.add("Obesidad 1");
				mensaje = "Obesidad 1";
			} else if (imc >= 30 && imc < 35) {
				resultados.add("Obesidad grado 2");
				mensaje = "Obesidad grado 2";
			} else if (imc >= 35 && imc < 40) {
				resultados.add("Obesidad grado 3");
				mensaje = "Obesidad grado 3";
			} else if (imc >= 40) {
				resultados.add("Obesidad morbida");
				mensaje = "Obesidad morbida";
			}
			System.out.println("_______");
			System.out.println("su imc es de " + imc);
			System.out.println("su imc esta en un rango de " + mensaje);
		}
	}

	public boolean existe() {

		for (int i = 0; i < listaNombres.size(); i++) {

			if (listaNombres.get(i).equalsIgnoreCase(nombreIngresar)) {
				pos = i;
				cont++;
				return validar = true;
			} else if (cont == 0) {
				System.out.println("La persona " + nombreIngresar + " no fue registrada");
				return validar = false;
			}
		}
		return validar;
	}

	private void eliminar() {
		nombreIngresar = JOptionPane.showInputDialog("Ingrese el nombre ");
		for (int i = 0; i < listaNombres.size(); i++) {
			if (existe() == true) {
				listaNombres.remove(listaNombres.get(i));
			} else {
				System.out.println("no se encuentra");
			}
		}

	}

	private void imprimir() {
		for (int i = 0; i < listaNombres.size(); i++) {
			System.out.println("la persona " + listaNombres.get(i) + " su peso es " + listaPesos.get(i)
					+ " su altura es " + listaAlturas.get(i));

		}

	}

	private void ingresarPersona() {

		int resp = 0;
		do {

			listaNombres.add(JOptionPane.showInputDialog("Ingrese el nombre: "));
			listaPesos.add(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso: ")));
			listaAlturas.add(Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura: ")));
			resp = Integer.parseInt(JOptionPane.showInputDialog("ingrese 1 para ingresar mas "));

		} while (resp == 1);
	}

}