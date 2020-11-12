package ru.netology.sender;

import org.junit.jupiter.api.*;
import org.mockito.*;
import ru.netology.entity.*;
import ru.netology.geo.*;
import ru.netology.i18n.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {

    @Test
    void testSendLanguageRussian() {
        String moscowIp = "172.0.32.11";

//        GeoServiceImpl geoService = new GeoServiceImpl();

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(moscowIp))
                .thenReturn(new Location("", Country.RUSSIA, null, 0));

//        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, moscowIp);

        String actual = messageSender.send(headers);
        String expected = "Добро пожаловать";

        assertEquals(expected, actual);
    }

    @Test
    void testSendLanguageEnglish() {
        String moscowIp = "96.0.32.11";

//        GeoServiceImpl geoService = new GeoServiceImpl();

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(moscowIp))
                .thenReturn(new Location("", Country.USA, null, 0));

//        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, moscowIp);

        String actual = messageSender.send(headers);
        String expected = "Welcome";

        assertEquals(expected, actual);
    }
}

//
//    Написать тесты для проверки языка отправляемого сообщения (класс MessageSender) с использованием Mockito
//                Поверить, что MessageSenderImpl всегда отправляет только русский текст, если ip относится к российскому сегменту адресов.
//                Поверить, что MessageSenderImpl всегда отправляет только английский текст, если ip относится к американскому сегменту адресов.

