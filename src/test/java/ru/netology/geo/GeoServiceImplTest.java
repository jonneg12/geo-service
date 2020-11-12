package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    void testLocationByIpRussia() {
        String moscowIp = "172.0.32.11";
        GeoServiceImpl geoService = new GeoServiceImpl();
        Country actualCountry = geoService.byIp(moscowIp).getCountry();
        Country expectedCountry = Country.RUSSIA;
        assertEquals(expectedCountry, actualCountry);
    }

    @Test
    void testLocationByIpUSA() {

        String newYorkIp = "96.44.183.149";
        GeoServiceImpl geoService = new GeoServiceImpl();
        Country actualCountry = geoService.byIp(newYorkIp).getCountry();
        Country expectedCountry = Country.USA;
        assertEquals(expectedCountry, actualCountry);
    }
}