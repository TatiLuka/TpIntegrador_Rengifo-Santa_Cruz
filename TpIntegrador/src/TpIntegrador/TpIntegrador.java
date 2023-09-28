package TpIntegrador;

import java.util.Scanner;

import java.util.InputMismatchException;

public class TpIntegrador {

	public static void main(String[] args) {
		boolean[][] asientosOcupados = new boolean[3][4];

		Scanner scanner = new Scanner(System.in);

		System.out.println("Bienvenido al boletero del microcine!");

		int ingresosTotales = 0;

		while (true) {

			try {
				System.out.print("Ingrese la fila (A, B o C) o 'q' para salir: ");
				String fila1 = scanner.next().toUpperCase();

				if (fila1.equals("Q")) {
					break;
				}
				
				

				if (!fila1.equals("A") && !fila1.equals("B") && !fila1.equals("C")) {
					throw new InputMismatchException("Fila no valida. Por favor, ingrese A, B o C.");
				}

				System.out.print("Ingrese el numero de asiento (1-4): ");
				int numeroAsiento = scanner.nextInt() - 1;

				if (numeroAsiento < 0 || numeroAsiento > 3) {
					throw new InputMismatchException("Numero de asiento no valido. Debe ser entre 1 y 4.");
				}

				int fila2;

				switch (fila1) {
				case "A":
					fila2 = 0;
					break;
				case "B":
					fila2 = 1;
					break;
				case "C":
					fila2 = 2;
					break;
				default:
					fila2 = -1;

				}
				while (asientosOcupados[fila2][numeroAsiento]) {
					System.out.println("El asiento esta ocupado. Por favor, elija otro.");
					System.out.print("Ingrese la fila (A, B o C) o 'q' para salir: ");
					fila1 = scanner.next().toUpperCase();

					if (fila1.equals("Q")) {
						break;
					}

					System.out.print("Ingrese el numero de asiento (1-4): ");
					numeroAsiento = scanner.nextInt() - 1;

					switch (fila1) {
					case "A":
						fila2 = 0;
						break;
					case "B":
						fila2 = 1;
						break;
					case "C":
						fila2 = 2;
						break;
					}
				}

				asientosOcupados[fila2][numeroAsiento] = true;

				int costo;
				switch (fila1) {
				case "A":
					costo = 500;
					break;
				case "B":
					costo = 700;
					break;
				case "C":
					costo = 1000;
					break;
				default:
					costo = 0;
				}

				ingresosTotales += costo;

				System.out.println("Asiento reservado con exito!");
				System.out.println("El costo del asiento es: $" + costo);

				boolean filaLlena = true;
				for (int i = 0; i < 4; i++) {
					if (!asientosOcupados[fila2][i]) {
						filaLlena = false;
						break;
					}
				}
				if (filaLlena) {
					System.out.println("La fila " + fila1 + " esta llena.");
				}

				boolean salaLlena = true;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 4; j++) {
						if (!asientosOcupados[i][j]) {
							salaLlena = false;
							break;
						}
					}
				}
				if (salaLlena) {
					System.out.println("Sala llena");
				}
			}

			catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("Error "+e.getMessage());

			}
		}

		System.out.println("Ingresos totales: $" + ingresosTotales);
		System.out.println("Gracias por utilizar el boletero del microcine.");
	}
}
