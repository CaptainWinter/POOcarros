public class Stats {

	public static int menu(RentalAgency rentalAgency) {

		System.out.println("Por favor selecione uma estatisca a mostrar:\n");

		System.out.println("1- Ramificacao com mais clientes\n" + "2- Cliente com mais carros alugados\n"
				+ "3- Carro mais alugado\n" + "4- Saldo medio dos clientes\n" + "5- Preco medio de aluguer por dia\n"
				+ "6- Sair\n");

		int option = Ler.umInt();

		switch (option) {
		case 1:
			if (branchWithMostCustomers(rentalAgency) != null) {
				System.out.println("Ramificacao com mais clientes: " + branchWithMostCustomers(rentalAgency).getName());
			} else {
				System.out.println("Ha uma ou mais ramificações com o maior numero de clientes");
			}
			return 0;
		case 2:
			if (customerWithMostCars(rentalAgency) != null) {
				System.out.println("Cliente com mais carros alugados: " + customerWithMostCars(rentalAgency).getName());
			} else {
				System.out.println("Ha um ou mais clientes com o maior numero de carros");
			}
			return 0;
		case 3:
			if (mostRentedCar(rentalAgency) != null) {
				System.out.println("Carro mais alugado: " + mostRentedCar(rentalAgency).getName());
			} else {
				System.out.println("Ha um ou mais carros com o maior numero de vezes alugado");
			}
			return 0;
		case 4:
			if (averageCustomerBalance(rentalAgency) >= 0) {
				System.out.println("Saldo medio dos clientes: " + averageCustomerBalance(rentalAgency));
			} else {
				System.out.println("Ocorreu um erro.");
			}
			return 0;
		case 5:
			if (averageRentalPrice(rentalAgency) >= 0) {
				System.out.println("Preco medio de aluguer por dia: " + averageRentalPrice(rentalAgency));
			} else {
				System.out.println("Ocorreu um erro.");
			}
			return 0;
		case 6:
			System.out.println("Sessao fechada com sucesso!");
			return -1;
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}

	}

	public static Branch branchWithMostCustomers(RentalAgency rentalAgency) {

		if (rentalAgency.getBranches().size() == 0)
			return null;

		int index = 0;
		int maxCustomers = 0;
		boolean twoBranchesWithTheMostCustomers = false;

		for (int i = 0; i < rentalAgency.getBranches().size(); i++) {

			Branch branch = rentalAgency.getBranches().get(i);

			if (branch.getCustomers().size() > maxCustomers)
				index = i;

			twoBranchesWithTheMostCustomers = (branch.getCustomers().size() == maxCustomers) ? true : false;

		}

		return (twoBranchesWithTheMostCustomers) ? null : rentalAgency.getBranches().get(index);

	}

	public static Customer customerWithMostCars(RentalAgency rentalAgency) {

		if (rentalAgency.getBranches().size() == 0)
			return null;

		int branchIndex = 0;
		int customerIndex = 0;
		int maxCars = 0;
		boolean twoCustomersWithTheMostCars = false;

		for (int i = 0; i < rentalAgency.getBranches().size(); i++) {

			Branch branch = rentalAgency.getBranches().get(i);

			for (int j = 0; j < branch.getCustomers().size(); j++) {

				Customer customer = branch.getCustomers().get(j);

				if (customer.getCars().size() > maxCars) {
					branchIndex = i;
					customerIndex = j;
				}

				twoCustomersWithTheMostCars = (customer.getCars().size() == maxCars) ? true : false;

			}

		}

		return (twoCustomersWithTheMostCars) ? null
				: rentalAgency.getBranches().get(branchIndex).getCustomers().get(customerIndex);

	}

	public static Car mostRentedCar(RentalAgency rentalAgency) {

		if (rentalAgency.getBranches().size() == 0)
			return null;

		int branchIndex = 0;
		int customerIndex = 0;
		int carIndex = 0;
		int maxRented = 0;
		boolean twoCarsMaxRented = false;

		for (int i = 0; i < rentalAgency.getBranches().size(); i++) {

			Branch branch = rentalAgency.getBranches().get(i);

			for (int j = 0; j < branch.getCustomers().size(); j++) {

				Customer customer = branch.getCustomers().get(j);

				for (int k = 0; k < customer.getCars().size(); k++) {

					int check = 0;

					Car car = customer.getCars().get(k);

					for (int l = 0; l < customer.getCars().size() - (k + 1); l++) {

						if (car.getName().equals(customer.getCars().get(l).getName()))
							check++;

					}

					for (int l = k + 1; l < customer.getCars().size(); l++) {

						if (car.getName().equals(customer.getCars().get(l).getName()))
							check++;

					}

					if (check > maxRented) {
						maxRented = check;
						branchIndex = i;
						carIndex = j;
						carIndex = k;
					}

					twoCarsMaxRented = (check == maxRented) ? true : false;

				}

			}

		}

		return (twoCarsMaxRented) ? null
				: rentalAgency.getBranches().get(branchIndex).getCustomers().get(customerIndex).getCars().get(carIndex);

	}

	public static double averageCustomerBalance(RentalAgency rentalAgency) {

		if (rentalAgency.getBranches().size() == 0)
			return -1;

		double sum = 0;
		int size = 0;

		for (int i = 0; i < rentalAgency.getBranches().size(); i++) {

			Branch branch = rentalAgency.getBranches().get(i);
			size = branch.getCustomers().size();

			for (int j = 0; j < branch.getCustomers().size(); j++) {

				Customer customer = branch.getCustomers().get(j);
				sum += customer.getInitialBalance();

			}

		}

		return sum / size;

	}

	public static double averageRentalPrice(RentalAgency rentalAgency) {

		if (rentalAgency.getBranches().size() == 0)
			return -1;

		double sum = 0;
		int size = 0;

		for (int i = 0; i < rentalAgency.getBranches().size(); i++) {

			Branch branch = rentalAgency.getBranches().get(i);

			for (int j = 0; j < branch.getCustomers().size(); j++) {

				Customer customer = branch.getCustomers().get(j);
				size = customer.getCars().size();

				for (int k = 0; k < customer.getCars().size(); k++) {

					Car car = customer.getCars().get(k);

					sum += car.getPricePerHour();

				}

			}

		}

		return sum / size;

	}

}
