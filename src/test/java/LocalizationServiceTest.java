import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    @Test
    void testLocale(){
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, actual);
    }
}
