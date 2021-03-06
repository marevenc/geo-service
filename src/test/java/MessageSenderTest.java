import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {
    @Test
    void testSendRussia(){
        GeoServiceMock geoService = new GeoServiceMock();
        geoService.setCountry(Country.RUSSIA);

        LocalizationServiceMock localizationService = new LocalizationServiceMock();
        localizationService.setValue("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String expected = "Добро пожаловать";

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        String actual = messageSender.send(headers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testSendUSA(){
        GeoServiceMock geoService = new GeoServiceMock();
        geoService.setCountry(Country.USA);

        LocalizationServiceMock localizationService = new LocalizationServiceMock();
        localizationService.setValue("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String expected = "Welcome";

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.123.12.19");
        String actual = messageSender.send(headers);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void TestSendMoscow(){
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn (new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String expected = "Добро пожаловать";

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String actual = messageSender.send(headers);
        Assertions.assertEquals(expected, actual);
    }
}
