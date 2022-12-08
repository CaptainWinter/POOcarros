import java.io.*;
import java.util.ArrayList;

public class Main {

	static RentalAgency rentalAgency = new RentalAgency("RentalCarsByGroup11");

	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) {

		/*
		 * Exemplo
		 * 
		 * final String peugeot = "Peugeot Auto S. Salvador";
		 * 
		 * //rentalAgency.addBranch(peugeot);
		 * 
		 * //final String customer1 = "Antonio Goncalves"; final String customer2 =
		 * "Mateus Aleixo"; final String customer3 = "Isabel Santos";
		 * 
		 * rentalAgency.addCustomer(peugeot, customer1, 1350);
		 * rentalAgency.addCustomer(peugeot, customer2, 810);
		 * rentalAgency.addCustomer(peugeot, customer3, 1565);
		 * 
		 * final String car1 = "Aircross"; final String car2 = "Boxer"; final String
		 * car3 = "Astra";
		 * 
		 * rentalAgency.addCar(peugeot, customer1, car1, 155);
		 * rentalAgency.addCar(peugeot, customer2, car2, 130);
		 * rentalAgency.addCar(peugeot, customer3, car3, 160);
		 * 
		 * rentalAgency.addCustomerTransaction(peugeot, customer1, car1, 570);
		 * rentalAgency.addCustomerTransaction(peugeot, customer1, car1, 155);
		 */

		ArrayList<Branch> myBranches = new ArrayList<Branch>();

		try {
			ObjectInputStream is = new ObjectInputStream(
					new FileInputStream("C:\\Users\\mateu\\OneDrive\\Ambiente de Trabalho\\branches.dat")); // MUDAR A DIR AQUI
					//new FileInputStream("path\\to\\Duarte\\branches.dat"));
					//new FileInputStream("path\\to\\Pedro\\branches.dat"));
					//new FileInputStream("/home/TheCaptain/branches.dat")); // nota: estou a usar / em vez de \\ pq o Linux funciona assim
			myBranches = (ArrayList<Branch>) is.readObject();
		} catch (IOException e) {
			System.out.println("Ficheiro vazio.\n");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < rentalAgency.getBranches().size(); i++) {
			rentalAgency.addBranch(myBranches.get(i).getName());
		}

		System.out.println("Seja bem-vindo, por favor selecione uma opcao:");

		boolean run = true;

		while (run) {

			System.out.println();
			int option = Menu.menu();
			String branchName;

			switch (option) {
			case 1, 2:
				boolean stop = false;
				while (!stop) {
					stop = UpdateData.update(rentalAgency, myBranches, (option == 1) ? true : false);
				}
				break;
			case 3:
				if (myBranches.size() == 0)
					break;

				branchName = RequestData.askBranchName();
				rentalAgency.listCustomers(branchName);
				break;
			case 4:
				System.out.println(myBranches);
				break;
			case 5:
				if (Stats.menu(rentalAgency) < 0)
					run = false;
				break;
			case 6:
				System.out.println("Sessao fechada com sucesso!");
				run = false;
				break;
			default:
				System.out.println("Valor ilegal tente novamente:\n");
				break;
			}

		}

	}

}
