public class Car {

	private String name;
	private double pricePerDay;
	private boolean isRented = false;

	public Car(String name, double pricePerDay) {
		this.name = name;
		this.pricePerDay = pricePerDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePerHour() {
		return pricePerDay;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerDay = pricePerHour;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	@Override
	public String toString() {
		return "Carro [nome=" + name + ", precoPorDia=" + pricePerDay + "]";
	}

	public boolean rentCar(String customerName, double currentBalance, int days) {

		double price = this.pricePerDay * days;

		if (currentBalance >= price) {
			setRented(true);
			return true;
		} else {
			return false;
		}

	}

}
