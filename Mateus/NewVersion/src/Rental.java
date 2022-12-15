import java.util.Date;

public class Rental {
	private int id;
	private String carId;
	private String customerId;
	private Date startDate;
	private Date endDate;

	public Rental(int id, String customerId, String carId) {
		this.id = id;
		this.customerId = customerId;
		this.carId = carId;
		this.startDate = new Date();
	}

	public Rental(int id, String customerId, String carId, Date startDate, Date endDate) {
		this.id = id;
		this.customerId = customerId;
		this.carId = carId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Aluguer{" + "id='" + id + '\'' + ", idCarro='" + carId + '\'' + ", idCliente='" + customerId + '\''
				+ ", dataInicio='" + startDate + '\'' + ", dataFinal='" + endDate + '}';
	}

}
