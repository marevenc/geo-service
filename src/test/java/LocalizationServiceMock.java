import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;

public class LocalizationServiceMock implements LocalizationService {
    private String value;

    public String locale(Country country){
        return value;
    }

    public void setValue(String msg){
        this.value = msg;
    }
}
