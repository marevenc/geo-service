import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {
    @Test
    void testByIp(){
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("96.44.183.149");
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);

        Assertions.assertEquals(expected, actual);
    }
}
