public class Main {

	static RentalAgency rentalAgency = new RentalAgency("RentalCarsByGroup11");

	public static void main(String[] args) {

		final String peugeot = "Peugeot Auto S. Salvador";

		rentalAgency.addBranch(peugeot);

		final String customer1 = "Antonio Goncalves";
		final String customer2 = "Mateus Aleixo";
		final String customer3 = "Isabel Santos";

		rentalAgency.addCustomer(peugeot, customer1, 1350);
		rentalAgency.addCustomer(peugeot, customer2, 810);
		rentalAgency.addCustomer(peugeot, customer3, 1565);

		final String car1 = "Aircross";
		final String car2 = "Boxer";
		final String car3 = "Astra";

		rentalAgency.addCar(peugeot, customer1, car1, 155);
		rentalAgency.addCar(peugeot, customer2, car2, 130);
		rentalAgency.addCar(peugeot, customer3, car3, 160);

		rentalAgency.addCustomerTransaction(peugeot, customer1, car1, 570);
		rentalAgency.addCustomerTransaction(peugeot, customer1, car1, 155);

		System.out.println("Seja bem-vindo, por favor selecione uma opcao:");

		boolean run = true;

		while (run) {

			System.out.println();
			int opcion = menu();
			String branchName, customerName, carName;
			int customerInitialAmount;

			switch (opcion) {
			case 1:
				branchName = askBranchName();
				if (!rentalAgency.addBranch(branchName))
					System.out.println("Ramificacao ja existente");
				break;
			case 2:
				availableBranches();
				branchName = askBranchName();
				customerName = askCustomerName();
				customerInitialAmount = askCustomerInitialAmount();
				if (!rentalAgency.addCustomer(branchName, customerName, customerInitialAmount))
					System.out.println("Cliente ja existente");
				break;
			case 3:
				availableBranches();
				branchName = askBranchName();
				availableCustomers(rentalAgency.findBranch(branchName));
				customerName = askCustomerName();
				carName = askCarName();
				customerInitialAmount = askCustomerInitialAmount();
				if (!rentalAgency.addCar(branchName, customerName, carName, customerInitialAmount))
					System.out.println("Carro sem cliente valido ou carro ja existente");
				break;
			case 4:
				availableBranches();
				branchName = askBranchName();
				rentalAgency.listCustomers(branchName);
				break;
			case 5:
				if(Stats.menu(rentalAgency) < 0)
					run = false;				
				break;
			case 6:
				System.out.println("Sessao fechada com sucesso!");
				run = false;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}

		}

	}

	public static int menu() {

		System.out.println("1- Criar uma ramificacao\n" + "2- Criar um cliente\n" + "3- Criar um carro\n"
				+ "4- Consultar ramificacoes, clientes e carros\n" + "5- Estatisticas\n" + "6- Sair\n");

		int input = Ler.umInt();

		return input;

	}

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

	public static void availableBranches() {
		System.out.println("\n*** Ramificoes Disponiveis: ***");
		System.out.println(rentalAgency.getBranches().toString() + "\n");
	}

	public static void availableCustomers(Branch branch) {
		System.out.println("\n*** Clientes Disponiveis: ***");
		System.out.println(branch.getCustomers().toString() + "\n");
	}

}