import java.io.Serializable;

@SuppressWarnings("serial")
public class Car implements Serializable {
	private int id;
	private String brand;
	private String model;
	private int year;
	private boolean isRented;
	private static boolean rented = false;

	public Car(int id, String brand, String model, int year) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.isRented = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean isRented() {
		return isRented;
	}
	
	public void setRented(boolean isRented) {
		this.isRented = isRented;
		if (isRented)
			rented = true;
	}
	
	public boolean beenRented() {
		return rented;
	}
	
	@Override
	public String toString() {
		return id + ": " + year + " " + brand + " " + model;
	}

}
