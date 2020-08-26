package api;

public class WeatherEvent {
    public String locationName;
    public Double temperature;
    public Long timestamp;
    public Double latitude;
    public Double longitude;

    public WeatherEvent() {
    }

    public WeatherEvent(String locationName, Double temperature, Long timestamp, Double latitude, Double longitude) {
        this.locationName = locationName;
        this.temperature = temperature;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
