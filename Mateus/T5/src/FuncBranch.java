import java.io.*;
import java.util.ArrayList;

public class FuncBranch {

	public static boolean insertBranch(ArrayList<Branch> branches, String branchName) {

		int checker = 0;

		for (int i = 0; i < branches.size(); i++) {
			if (!branches.get(i).getName().equals(branchName))
				checker++;
		}

		if (checker == branches.size()) {
			Branch branch = new Branch(branchName);
			branches.add(branch);
			updateFile(branches);
			return true;
		}

		return false;

	}

	public static boolean insertCustomer(ArrayList<Branch> branches, String branchName, String customerName,
			double initialAmount) {

		ArrayList<Boolean> checker = new ArrayList<>();

		for (int i = 0; i < branches.get(i).getCustomers().size(); i++) {

			if (branches.get(i).getName().equals(customerName)) {

				ArrayList<Customer> customers = branches.get(i).getCustomers();

				for (int j = 0; j < customers.size(); j++) {

					checker.add(i, (!customers.get(j).getName().equals(customerName)) ? true : false);

				}

			}

			if (checker.get(i)) {
				branches.get(i).newCustomer(customerName, initialAmount);
				updateFile(branches);
			}

		}

		return false;

	}

	public static boolean insertCar(ArrayList<Branch> branches, String branchName, String customerName, String carName,
			double pricePerDay) {

		ArrayList<Boolean> checker = new ArrayList<>();

		for (int i = 0; i < branches.size(); i++) {

			if (branches.get(i).getName().equals(customerName)) {

				ArrayList<Customer> customers = branches.get(i).getCustomers();

				for (int j = 0; j < customers.size(); j++) {

					if (customers.get(j).getName().equals(carName)) {

						ArrayList<Car> cars = customers.get(j).getCars();

						for (int k = 0; k < cars.size(); k++) {
							checker.add(i, (!cars.get(k).getName().equals(carName)) ? true : false);
						}

					}

					if (checker.get(j)) {
						customers.get(j).newCar(carName, pricePerDay);
						updateFile(branches);
					}

				}

			}

		}

		return false;

	}

	public static void deleteBranch(ArrayList<Branch> branches, String branchName) {

		for (int i = 0; i < branches.size(); i++) {
			if (branches.get(i).getName().equals(branchName))
				branches.remove(i);
		}

		updateFile(branches);

	}

	public static void deleteCustomer(ArrayList<Branch> branches, String branchName, String customerName) {

		for (int i = 0; i < branches.size(); i++) {

			if (branches.get(i).getName().equals(branchName)) {

				for (int j = 0; j < branches.get(i).getCustomers().size(); j++) {
					branches.get(i).getCustomers().remove(j);
				}

			}

		}

		updateFile(branches);

	}

	public static void deleteCar(ArrayList<Branch> branches, String branchName, String customerName, String carName) {

		for (int i = 0; i < branches.size(); i++) {

			if (branches.get(i).getName().equals(branchName)) {

				Branch branch = branches.get(i);

				for (int j = 0; j < branches.get(i).getCustomers().size(); j++) {

					Customer customer = branch.getCustomers().get(j);

					for (int k = 0; k < customer.getCars().size(); k++) {

						Car checkedCar = customer.getCars().get(k);

						if (checkedCar.getName().equals(carName))
							customer.getCars().remove(checkedCar);

					}

				}

			}

		}

		updateFile(branches);

	}

	public static void updateFile(ArrayList<Branch> branches) {
		try (ObjectOutputStream os = new ObjectOutputStream(
				new FileOutputStream("C:\\Users\\mateu\\OneDrive\\Ambiente de Trabalho\\branches.dat"))) { // MUDAR A DIR AQUI
			os.writeObject(branches);
			os.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
