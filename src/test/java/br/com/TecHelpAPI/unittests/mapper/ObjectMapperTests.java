package br.com.TecHelpAPI.unittests.mapper;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseListObjects;
import static br.com.TecHelpAPI.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import br.com.TecHelpAPI.data.dto.UserDTO;
import br.com.TecHelpAPI.model.User;
import br.com.TecHelpAPI.unittests.mapper.mocks.MockUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObjectMapperTests {
    MockUser inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockUser();
    }

    @Test
    public void parseEntityToDTOTest() {
        UserDTO output = parseObject(inputObject.mockEntity(), UserDTO.class);
        assertEquals(Long.valueOf(0L), output.getIdUser());
        assertEquals("User Name Test0", output.getNameUser());
        assertEquals("User Password Test0", output.getPassword());
        assertEquals("User Dept Test0", output.getDept());
        assertEquals("User Email Test0", output.getEmail());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<UserDTO> outputList = parseListObjects(inputObject.mockEntityList(), UserDTO.class);
        UserDTO outputZero = outputList.getFirst();

        assertEquals(Long.valueOf(0L), outputZero.getIdUser());
        assertEquals("User Name Test0", outputZero.getNameUser());
        assertEquals("User Password Test0", outputZero.getPassword());
        assertEquals("User Dept Test0", outputZero.getDept());
        assertEquals("User Email Test0", outputZero.getEmail());

        UserDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getIdUser());
        assertEquals("User Name Test7", outputSeven.getNameUser());
        assertEquals("User Password Test7", outputSeven.getPassword());
        assertEquals("User Dept Test7", outputSeven.getDept());
        assertEquals("User Email Test7", outputSeven.getEmail());

        UserDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getIdUser());
        assertEquals("User Name Test12", outputTwelve.getNameUser());
        assertEquals("User Password Test12", outputTwelve.getPassword());
        assertEquals("User Dept Test12", outputTwelve.getDept());
        assertEquals("User Email Test12", outputTwelve.getEmail());
    }

    @Test
    public void parseDTOToEntityTest() {
        User output = parseObject(inputObject.mockDTO(), User.class);
        assertEquals(Long.valueOf(0L), output.getIdUser());
        assertEquals("User Name Test0", output.getNameUser());
        assertEquals("User Password Test0", output.getPassword());
        assertEquals("User Dept Test0", output.getDept());
        assertEquals("User Email Test0", output.getEmail());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<User> outputList = parseListObjects(inputObject.mockDTOList(), User.class);
        User outputZero = outputList.getFirst();

        assertEquals(Long.valueOf(0L), outputZero.getIdUser());
        assertEquals("User Name Test0", outputZero.getNameUser());
        assertEquals("User Password Test0", outputZero.getPassword());
        assertEquals("User Dept Test0", outputZero.getDept());
        assertEquals("User Email Test0", outputZero.getEmail());

        User outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getIdUser());
        assertEquals("User Name Test7", outputSeven.getNameUser());
        assertEquals("User Password Test7", outputSeven.getPassword());
        assertEquals("User Dept Test7", outputSeven.getDept());
        assertEquals("User Email Test7", outputSeven.getEmail());

        User outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getIdUser());
        assertEquals("User Name Test12", outputTwelve.getNameUser());
        assertEquals("User Password Test12", outputTwelve.getPassword());
        assertEquals("User Dept Test12", outputTwelve.getDept());
        assertEquals("User Email Test12", outputTwelve.getEmail());
    }
}