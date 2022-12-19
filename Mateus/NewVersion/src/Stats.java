import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Stats {

	public static String mostRentedCar(ArrayList<Car> cars) {

		String mostRentedCar = "Nenhum carro alugado";
		HashMap<String, Integer> carCountMap = new HashMap<>();
		int frequency = 1;

		for (Car car : cars) {

			String carName = car.getBrand() + " " + car.getModel();

			if (carCountMap.containsKey(carName))
				carCountMap.put(carName, carCountMap.get(carName) + 1);
			else
				carCountMap.put(carName, 1);

		}

		Set<Entry<String, Integer>> entrySet = carCountMap.entrySet();

		for (Entry<String, Integer> entry : entrySet) {

			if (entry.getValue() > frequency) {
				mostRentedCar = entry.getKey();
				frequency = entry.getValue();
			}

		}

		return mostRentedCar;

	}

	public static String mostPopularAddress(ArrayList<Customer> customers) {

		String mostPopularAddress = "Sem registo";
		HashMap<String, Integer> addressCountMap = new HashMap<>();
		int frequency = 1;

		for (Customer customer : customers) {

			String customerAddress = customer.getAddress();

			if (addressCountMap.containsKey(customerAddress))
				addressCountMap.put(customerAddress, addressCountMap.get(customerAddress) + 1);
			else
				addressCountMap.put(customerAddress, 1);

		}

		Set<Entry<String, Integer>> entrySet = addressCountMap.entrySet();

		for (Entry<String, Integer> entry : entrySet) {

			if (entry.getValue() > frequency) {
				mostPopularAddress = entry.getKey();
				frequency = entry.getValue();
			}

		}

		return mostPopularAddress;

	}

	public static double averageRentalDuration(ArrayList<Rental> rentals) {

		if (rentals.size() == 0)
			return 0;

		long totalDuration = 0;

		for (Rental rental : rentals) {
			long duration = rental.getEndDate().getTime() - rental.getStartDate().getTime();
			totalDuration += duration;
		}

		long averageDuration = totalDuration / rentals.size();
		double seconds = averageDuration / 1000;

		return seconds;

	}

}
