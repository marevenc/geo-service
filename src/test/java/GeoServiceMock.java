import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;

public class GeoServiceMock implements GeoService {
    private Location location;
    @Override
    public Location byIp(String ip){
        return location;
    }

    public void setCountry(Country country){
        this.location = new Location(null, country, null, 0);
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        throw new RuntimeException("Not implemented");
    }

}
