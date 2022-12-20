import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CarRental {
	// ArrayLists to store the data of the car rental agency
	private ArrayList<Car> cars = new ArrayList<>();
	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Rental> rentals = new ArrayList<>();

	// Maps to store the data
	private Map<Integer, Car> carsMap = new HashMap<>();
	private Map<Integer, Customer> customersMap = new HashMap<>();
	private Map<Integer, Rental> rentalsMap = new HashMap<>();

	// File names to store the data
	private static String CARS_FILE = "cars.dat";
	private static String CUSTOMERS_FILE = "customers.dat";
	private static String RENTALS_FILE = "rentals.dat";

	public CarRental(String carsFile, String customersFile, String rentalsFile) {
		CARS_FILE = carsFile;
		CUSTOMERS_FILE = customersFile;
		RENTALS_FILE = rentalsFile;
	}

	// Loads the data from the files
	@SuppressWarnings({ "unchecked" })
	public void loadData() {

		try {
			FileInputStream inputStream = new FileInputStream(CARS_FILE);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			cars = (ArrayList<Car>) objectInputStream.readObject();
			objectInputStream.close();
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Ficheiro de carros vazio");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			FileInputStream inputStream = new FileInputStream(CUSTOMERS_FILE);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			customers = (ArrayList<Customer>) objectInputStream.readObject();
			objectInputStream.close();
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Ficheiro de clientes vazio");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			FileInputStream inputStream = new FileInputStream(RENTALS_FILE);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			rentals = (ArrayList<Rental>) objectInputStream.readObject();
			objectInputStream.close();
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Ficheiro de alugueres vazio\n");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			if (car != null)
				this.carsMap.putIfAbsent(car.getId(), car);
		}
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
			if (customer != null)
				this.customersMap.putIfAbsent(customer.getId(), customer);
		}
		for (int i = 0; i < rentals.size(); i++) {
			Rental rental = rentals.get(i);
			if (rental != null)
				this.rentalsMap.putIfAbsent(rental.getId(), rental);
		}

	}

	// Saves the data to the files
	public void updateFile() {

		int index = 0;

		for (int key : carsMap.keySet()) {
			cars.add(index, carsMap.get(key));
			index++;
		}
		index = 0;
		for (int key : customersMap.keySet()) {
			customers.add(index, customersMap.get(key));
			index++;
		}
		index = 0;
		for (int key : rentalsMap.keySet()) {
			rentals.add(index, rentalsMap.get(key));
			index++;
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(CARS_FILE);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(cars);
			objectOutputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(CUSTOMERS_FILE);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(customers);
			objectOutputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(RENTALS_FILE);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(rentals);
			objectOutputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	// Shows the main menu and returns the selected option
	public int showMainMenu() {
		System.out.println("Agencia de aluguer de carros");
		System.out.println("1. Gerir carros");
		System.out.println("2. Gerir clientes");
		System.out.println("3. Gerir alugueres");
		System.out.println("4. Estatisticas");
		System.out.println("5. Sair");
		System.out.print("Seleciona uma opcao: ");
		int option = Ler.umInt();
		return option;
	}

	// Allows the user to manage the cars
	public void manageCars() {
		while (true) {
			System.out.println("\nAgencia de aluguer de carros - Gerir carros");
			System.out.println("1. Criar carro");
			System.out.println("2. Ver carros");
			System.out.println("3. Atualizar carro");
			System.out.println("4. Eliminar carro");
			System.out.println("5. Voltar atras");
			System.out.print("Seleciona uma opcao: ");
			int option = Ler.umInt();

			if (option == 1) {
				// Create car
				System.out.print("Digite o id: ");
				int id = Ler.umInt();

				if (carsMap.keySet().contains(id)) {
					System.out.println("Id ja existente\n");
					break;
				}

				System.out.print("Digite a marca: ");
				String brand = Ler.umaString();
				System.out.print("Digite o modelo: ");
				String model = Ler.umaString();
				System.out.print("Digite o ano: ");
				int year = Ler.umInt();

				Car car = new Car(id, brand, model, year);
				carsMap.put(id, car);

				updateFile();

			} else if (option == 2) {
				// View cars
				System.out.println("Carros:");
				for (Car car : carsMap.values()) {
					System.out.println(car);
				}
			} else if (option == 3) {
				// Update car
				System.out.print("Digite o id: ");
				int id = Ler.umInt();
				Car car = carsMap.get(id);
				if (car != null) {
					System.out.print("Digite a marca (" + car.getBrand() + "): ");
					String brand = Ler.umaString();
					if (!brand.equals("")) {
						car.setBrand(brand);
					}

					System.out.print("Digite o modelo (" + car.getModel() + "): ");
					String model = Ler.umaString();
					if (!model.equals("")) {
						car.setModel(model);
					}

					System.out.print("Digite o ano (" + car.getYear() + "): ");
					int year = Ler.umInt();
					if (year != 0) {
						car.setYear(year);
					}

					updateFile();
				} else {
					System.out.println("Carro nao encontrado");
				}
			} else if (option == 4) {
				// Delete car
				System.out.print("Digite o id: ");
				int id = Ler.umInt();
				Car car = carsMap.get(id);
				if (car != null) {
					carsMap.remove(id);

					updateFile();
				} else {
					System.out.println("Carro nao encontrado");
				}
			} else if (option == 5) {
				// Back
				System.out.println("\n");
				break;
			} else {
				System.out.println("Opcao invalida");
			}
		}
	}

	// Allows the user to manage the customers
	public void manageCustomers() {
		while (true) {
			System.out.println("\nAgencia de aluguer de carros - Gerir clientes");
			System.out.println("1. Criar cliente");
			System.out.println("2. Ver clientes");
			System.out.println("3. Atualizar cliente");
			System.out.println("4. Eliminar cliente");
			System.out.println("5. Voltar atras");
			System.out.print("Seleciona uma opcao: ");
			int option = Ler.umInt();

			if (option == 1) {
				// Create customer
				System.out.print("Digite o id: ");
				int id = Ler.umInt();
				System.out.print("Digite o nome: ");
				String name = Ler.umaString();
				System.out.print("Digite o endereco: ");
				String address = Ler.umaString();
				System.out.print("Digite o numero de telefone: ");
				String phone = Ler.umaString();

				Customer customer = new Customer(id, name, address, phone);
				customersMap.put(id, customer);

				updateFile();

			} else if (option == 2) {
				// View customers
				System.out.println("Clientes:");
				for (Customer customer : customersMap.values()) {
					System.out.println(customer);
				}
			} else if (option == 3) {
				// Update customer
				System.out.print("Digite o id: ");
				int id = Ler.umInt();
				Customer customer = customersMap.get(id);
				if (customer != null) {
					System.out.print("Digite o nome (" + customer.getName() + "): ");
					String name = Ler.umaString();
					if (!name.equals("")) {
						customer.setName(name);
					}

					System.out.print("Digite o endereco (" + customer.getAddress() + "): ");
					String address = Ler.umaString();
					if (!address.equals("")) {
						customer.setAddress(address);
					}

					System.out.print("Digite o numero de telefone (" + customer.getPhone() + "): ");
					String phone = Ler.umaString();
					if (!phone.equals("")) {
						customer.setPhone(phone);
					}

					updateFile();

				} else {
					System.out.println("Cliente nao encontrado");
				}
			} else if (option == 4) {
				// Delete customer
				System.out.print("Digite o id: ");
				int id = Ler.umInt();
				Customer customer = customersMap.get(id);
				if (customer != null) {
					customersMap.remove(id);
					updateFile();
				} else {
					System.out.println("Cliente nao encontrado");
				}
			} else if (option == 5) {
				// Back
				System.out.println("\n");
				break;
			} else {
				System.out.println("Opcao invalida");
			}

		}

	}

	// Allows the user to manage the rentals
	public void manageRentals() {
		while (true) {
			System.out.println("\nAgencia de aluguer de carros - Gerir alugueres");
			System.out.println("1. Alugar carro");
			System.out.println("2. Devolver carro");
			System.out.println("3. Ver alugueres");
			System.out.println("4. Voltar atras");
			System.out.print("Seleciona uma opcao: ");
			int option = Ler.umInt();

			if (option == 1) {
				// Rent car
				System.out.print("Digite o id: ");
				int id = Ler.umInt();

				if (rentalsMap.get(id) != null) {
					System.out.println("Id indisponivel\n");
					break;
				}

				System.out.print("Digite o id de cliente: ");
				String customerId = Ler.umaString();

				if (customersMap.get(Integer.parseInt(customerId)) == null) {
					System.out.println("Cliente nao encontrado\n");
					break;
				}

				System.out.print("Digite o id de carro: ");
				String carId = Ler.umaString();

				if (carsMap.get(Integer.parseInt(carId)) == null) {
					System.out.println("Carro nao encontrado\n");
					break;
				}

				Rental rental = new Rental(id, customerId, carId);
				carsMap.get(Integer.parseInt(carId)).setRented(true);
				rentalsMap.put(id, rental);

				updateFile();

			} else if (option == 2) {
				// Return car
				int checker = 0;
				for (Car car : carsMap.values()) {
					if (!car.isRented())
						checker++;
				}

				if (checker == carsMap.size()) {
					System.out.println("Sem carros por devolver\n");
					break;				
				}

				System.out.print("Digite o id: ");
				int id = Ler.umInt();
				Rental rental = rentalsMap.get(id);
				if (rental != null) {
					rental.setEndDate(new Date());
					carsMap.get(Integer.parseInt(rental.getCarId())).setRented(false);
					updateFile();
				} else {
					System.out.println("Aluguer nao encontrado");
				}
			} else if (option == 3) {
				// View rentals
				System.out.println("Alugueres:");
				for (Rental rental : rentalsMap.values()) {
					System.out.println(rental);
				}
			} else if (option == 4) {
				// Back
				System.out.println("\n");
				break;
			} else {
				System.out.println("Opcao invalida");
			}

		}

	}

	// Displays statistics about the operation
	public void showStatistics() {
		int totalCars = carsMap.size();
		int totalCustomers = customersMap.size();
		int totalRentals = rentalsMap.size();
		int availableCars = 0;

		for (Car car : carsMap.values()) {
			if (!car.isRented()) {
				availableCars++;
			}
		}

		System.out.println("\nAgencia de aluguer de carros - Estatisticas");
		System.out.println("Total de carros: " + totalCars);
		System.out.println("Total de clientes: " + totalCustomers);
		System.out.println("Total de alugueres: " + totalRentals);
		System.out.println("Carros disponiveis: " + availableCars);
		System.out.println("Carro mais alugado: " + Stats.mostRentedCar(cars));
		System.out.println("Endereco mais popular: " + Stats.mostPopularAddress(customers));
		System.out.println("Tempo medio de aluguer: " + Stats.averageRentalDuration(rentals));
		System.out.println("\n");
	}

}
