package maps_api;

public class SnappedPoint {

    private Location location;
    private int originalIndex;
    private String placeId;

    public Location getLocation() {
        return location;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }

    public String getPlaceId() {
        return placeId;
    }

    public SnappedPoint(Location location, int originalIndex, String placeId) {
        this.location = location;
        this.originalIndex = originalIndex;
        this.placeId = placeId;
    }

}
