package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void testLocaleMessageRussia() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        Country russia = Country.RUSSIA;
        String actualMessage = localizationService.locale(russia);
        String expectedMessage = "Добро пожаловать";

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testLocaleMessageGerman() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        Country russia = Country.GERMANY;
        String actualMessage = localizationService.locale(russia);
        String expectedMessage = "Welcome";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testLocaleMessageBrazil() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        Country russia = Country.BRAZIL;
        String actualMessage = localizationService.locale(russia);
        String expectedMessage = "Welcome";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testLocaleMessageUSA() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        Country russia = Country.USA;
        String actualMessage = localizationService.locale(russia);
        String expectedMessage = "Welcome";
        assertEquals(expectedMessage, actualMessage);
    }
}