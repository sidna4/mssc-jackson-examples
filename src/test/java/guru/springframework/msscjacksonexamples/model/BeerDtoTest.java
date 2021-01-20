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

        System.out.println("XXX" + beerDto.toString()+ "XXX");
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123,\"price\":\"12.99\",\"createdDate\":\"2021-01-20T17:17:08.3349893-05:00\",\"lastUpdatedDate\":\"2021-01-20T17:17:08.3359895-05:00\",\"myLocalDate\":\"2021-01-20\",\"beerId\":\"b0c4d5d6-a121-4e5d-aeda-6614fe333448\"}";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println("DTO is: " + dto);
    }
}