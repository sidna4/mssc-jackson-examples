package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * User: sidna * Date: 1/20/2021 10:50 AM
 */
@JsonTest
class BeerDtoTest extends BaseTest {
    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println("My JSON String is: " + jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"beerId\":\"af9a0ce6-7b4d-4543-8ed6-fcb7cde92ea2\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123,\"price\":12.99,\"createdDate\":\"2021-01-20T11:46:28.6811635-05:00\",\"lastUpdatedDate\":\"2021-01-20T11:46:28.6821649-05:00\"}";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println("DTO is: " + dto);
    }
}