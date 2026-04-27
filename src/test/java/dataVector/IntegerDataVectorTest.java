package dataVector;

import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerDataVectorTest {

    @Test
    @DisplayName("createWithData should create vector with data")
    void createWithDataTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createWithData(1, 2, 3);

        int[] elements = vector.getFullDataVector();

        assertNotNull(elements, "Elements should not be null");
        assertEquals(3, elements.length, "Array should have 3 elements");
    }

    @Test
    @DisplayName("Constructor should copy elements")
    void constructorEncapsulationTest() throws IntegerDataVectorException {
        int[] input = {1, 2, 3};
        IntegerDataVector vector = IntegerDataVector.createWithData(input);

        input[0] = 99;

        int actual = vector.getElementByIndex(0);
        int expected = 1;

        assertNotEquals(99, actual, "Internal array should not change when external array is modified");
        assertEquals(expected, actual, "Original value should be preserved");
    }

    @Test
    @DisplayName("getFullDataVector should return a clone, not the original reference")
    void getFullDataVectorCloneTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createWithData(1, 2, 3);
        int[] extracted = vector.getFullDataVector();

        extracted[0] = 99;

        int actual = vector.getElementByIndex(0);

        assertNotEquals(99, actual, "Modifying returned array should not affect internal state");
        assertEquals(1, actual, "Original value should be preserved");
    }

    @Test
    @DisplayName("setElement should update element at index")
    void setElementTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createWithData(1, 2, 3);
        vector.setElement(1, 99);

        int actual = vector.getElementByIndex(1);
        int expected = 99;

        assertEquals(expected, actual, "Element should be updated");
    }

    @Test
    @DisplayName("setElement should throw exception for invalid index")
    void setElementInvalidTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createWithData(1, 2, 3);

        assertThrows(IntegerDataVectorException.class,
                () -> vector.setElement(10, 99),
                "Invalid index should throw exception");
    }

    @Test
    @DisplayName("equals and hashCode should work correctly for identical content")
    void equalsHashCodeTest() throws IntegerDataVectorException {
        IntegerDataVector vector1 = IntegerDataVector.createWithData(1, 2, 3);
        IntegerDataVector vector2 = IntegerDataVector.createWithData(1, 2, 3);
        IntegerDataVector vector3 = IntegerDataVector.createWithData(4, 5, 6);

        assertAll(
                () -> assertEquals(vector1, vector2, "Vectors with same content should be equal"),
                () -> assertEquals(vector1.hashCode(), vector2.hashCode(), "HashCodes should match for equal objects"),
                () -> assertNotEquals(vector1, vector3, "Vectors with different content should not be equal"),
                () -> assertNotEquals(null, vector1, "Should not be equal to null")
        );
    }

    @Test
    @DisplayName("toString should contain array elements representation")
    void toStringTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createWithData(1, 2, 3);
        String result = vector.toString();

        assertTrue(result.contains("1, 2, 3"), "toString should include array content");
    }
}