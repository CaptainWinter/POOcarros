public class Main {

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {

		// Directories
		// Mateus Aleixo - "C:\Users\mateu\OneDrive\Ambiente de Trabalho\POO"

		String mateusDir = "C:\\Users\\mateu\\OneDrive\\Ambiente de Trabalho\\POO";
		String duarteDir = "";
		String pedroDir = "";
		String manuelDir = "";

		String carsFile = mateusDir + "\\cars.dat";
		String customersFile = mateusDir + "customers.dat";
		String rentalsFile = mateusDir + "\\rentals.dat";

		CarRental carRental = new CarRental(carsFile, customersFile, rentalsFile);

		carRental.loadData();

		while (true) {

			int option = carRental.showMainMenu();

			if (option == 1) {
				carRental.manageCars();
			} else if (option == 2) {
				carRental.manageCustomers();
			} else if (option == 3) {
				carRental.manageRentals();
			} else if (option == 4) {
				carRental.showStatistics();
			} else if (option == 5) {
				break;
			} else {
				System.out.println("Opcao invalida");
			}

		}

	}

}
