package hw_10;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import  hw_10.model.model;

import java.io.File;

public class ReadJsonFileTest {
        ObjectMapper objectMapper = new ObjectMapper();

        @Test
        void jsonTest() throws Exception {

        File file = new File("src/test/resources/testov.json");
        model user = objectMapper.readValue(file, model.class);

        Assertions.assertEquals(777, user.getId());
        Assertions.assertEquals("Aleksandr", user.getName());
        Assertions.assertEquals("Salagubov", user.getSurName());
        Assertions.assertEquals(26, user.getAge());
        Assertions.assertEquals("test@test.com", user.getEmail());
        Assertions.assertEquals("Tverskaya st.", user.getAddress().getStreet());
        Assertions.assertEquals("Moscow", user.getAddress().getCity());
        Assertions.assertEquals("MOW", user.getAddress().getState());
        Assertions.assertEquals("101010", user.getAddress().getZipcode());
        Assertions.assertEquals("dog", user.getPets().get(0));
        Assertions.assertEquals("cat", user.getPets().get(1));
        Assertions.assertEquals("pig", user.getPets().get(2));
        Assertions.assertEquals(true, user.getWorking());




    }
}
