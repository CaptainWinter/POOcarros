import java.util.ArrayList;

public class RequestData {

	public static String askBranchName() {
		System.out.println("\nDigite um nome para uma ramificacao:");
		return Ler.umaString();
	}

	public static String askCustomerName() {
		System.out.println("\nDigite um nome para um cliente:");
		return Ler.umaString();
	}

	public static int askCustomerInitialAmount() {
		System.out.println("\nDigite o saldo do cliente:");
		return Ler.umInt();
	}

	public static String askCarName() {
		System.out.println("\nDigite um nome para um carro:");
		return Ler.umaString();
	}

	public static double askCarPricePerDay() {
		System.out.println("\nDigite o preco por dia do carro:");
		return Ler.umDouble();
	}

	public static boolean availableBranches(ArrayList<Branch> myBranches) {
		if (myBranches.size() != 0) {
			System.out.println("\n*** Ramificoes Existentes: ***");
			System.out.println(myBranches.toString() + "\n");
			return true;
		} else {
			System.out.println("Sem ramificacoes disponiveis");
			return false;
		}
	}

	public static boolean availableCustomers(Branch branch) {
		if (branch.getCustomers().size() != 0) {
			System.out.println("\n*** Clientes Existentes: ***");
			System.out.println(branch.getCustomers().toString() + "\n");
			return true;
		} else {
			System.out.println("Sem clientes disponiveis");
			return false;
		}
	}
	
	public static boolean availableCars(Customer customer) {
		if (customer.getCars().size() != 0) {
			System.out.println("\n*** Carros Existentes: ***");
			System.out.println(customer.getCars().toString() + "\n");
			return true;
		} else {
			System.out.println("Sem carros disponiveis");
			return false;
		}
	}

	public static boolean containsBranch(RentalAgency rentalAgency, String branchName) {

		for (int i = 0; i < rentalAgency.getBranches().size(); i++) {

			if (rentalAgency.getBranches().get(i).getName().equals(branchName))
				return true;
			
		}
		
		return false;

	}

	public static boolean containsCustomer(RentalAgency rentalAgency, String customerName) {

		for (int i = 0; i < rentalAgency.getBranches().size(); i++) {

			Branch branch = rentalAgency.getBranches().get(i);

			for (int j = 0; j < branch.getCustomers().size(); j++) {

				Customer checkedCustomer = branch.getCustomers().get(j);

				if (checkedCustomer.getName().equals(customerName))
					return true;

			}

		}

		return false;

	}

	public static boolean containsCar(RentalAgency rentalAgency, String carName) {

		for (int i = 0; i < rentalAgency.getBranches().size(); i++) {

			Branch branch = rentalAgency.getBranches().get(i);

			for (int j = 0; j < branch.getCustomers().size(); j++) {

				Customer customer = branch.getCustomers().get(j);

				for (int k = 0; k < customer.getCars().size(); k++) {

					Car checkedCar = customer.getCars().get(k);

					if (checkedCar.getName().equals(carName))
						return true;

				}

			}

		}

		return false;

	}

}
