package models;

/**
 * This class holds the data for a position result from the server, the
 * parameters extracted are what were asked in the exercise.
 * 
 * @author oded herbst
 * 
 */
public class LocationResult {

	private Long id;
	private String name;
	private String type;
	private Double latitude;
	private Double longitude;

	public LocationResult(Long id, String name, String type, Double latitude, Double longitude) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		char concat =',';
		sb.append("Id : ");
		sb.append(id);
		sb.append(concat);
		sb.append(" Name : ");
		sb.append(name);
		sb.append(concat);
		sb.append(" Type : ");
		sb.append(type);
		sb.append(concat);
		sb.append(" Latitude : ");
		sb.append(latitude);
		sb.append(concat);
		sb.append(" Longitude : ");
		sb.append(longitude);

		return sb.toString();
	}
}
