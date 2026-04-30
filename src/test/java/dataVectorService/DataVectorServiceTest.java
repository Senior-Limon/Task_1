package dataVectorService;

import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;
import org.example.services.impl.DataVectorSortServiceImpl;
import org.example.services.impl.IntegerDataVectorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataVectorServiceTest {

    private final DataVectorSortServiceImpl sortService = new DataVectorSortServiceImpl();
    private final IntegerDataVectorServiceImpl classicService = new IntegerDataVectorServiceImpl();

    @Test
    @DisplayName("sum should return correct sum of elements")
    void sumTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createWithData(1, 2, 3, 4, 5);

        int actual = classicService.sum(vector);
        int expected = 15;

        assertEquals(expected, actual, "Sum should be 15");
    }

    @Test
    @DisplayName("sum should return 0 for empty vector")
    void sumEmptyTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createBySize(0);

        int actual = classicService.sum(vector);
        int expected = 0;

        assertEquals(expected, actual, "Sum of empty vector should be 0");
    }

    @Test
    @DisplayName("findMaxElement should return maximum element")
    void findMaxTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createWithData(3, 7, 2, 9, 1);

        int actual = classicService.findMaxElement(vector);
        int expected = 9;

        assertEquals(expected, actual, "Max element should be 9");
    }

    @Test
    @DisplayName("findMaxElement should throw exception for empty vector")
    void findMaxEmptyTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createBySize(0);

        assertThrows(IntegerDataVectorException.class,
                () -> classicService.findMaxElement(vector),
                "Should throw exception for empty vector");
    }

    @Test
    @DisplayName("findMinElement should return minimum element")
    void findMinTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createWithData(3, 7, 2, 9, 1);

        int actual = classicService.findMinElement(vector);
        int expected = 1;

        assertEquals(expected, actual, "Min element should be 1");
    }

    @Test
    @DisplayName("findMinElement should throw exception for empty vector")
    void findMinEmptyTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createBySize(0);

        assertThrows(IntegerDataVectorException.class,
                () -> classicService.findMinElement(vector),
                "Should throw exception for empty vector");
    }

    @Test
    @DisplayName("bubbleSort should return sorted vector")
    void bubbleSortTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createWithData(5, 2, 8, 1, 9);

        IntegerDataVector sorted = sortService.bubbleSort(vector);

        int[] expected = {1, 2, 5, 8, 9};
        int[] actual = sorted.getFullDataVector();

        assertArrayEquals(expected, actual, "Bubble sort should return sorted array");
    }

    @Test
    @DisplayName("qSort should return sorted vector")
    void qSortTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createWithData(5, 2, 8, 1, 9);

        IntegerDataVector sorted = sortService.qSort(vector);

        int[] expected = {1, 2, 5, 8, 9};
        int[] actual = sorted.getFullDataVector();

        assertArrayEquals(expected, actual, "Quick sort should return sorted array");
    }

    @Test
    @DisplayName("bubbleSort should return empty vector for empty input")
    void bubbleSortEmptyTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createBySize(0);

        IntegerDataVector sorted = sortService.bubbleSort(vector);

        assertEquals(0, sorted.getSize(), "Should return empty vector");
    }

    @Test
    @DisplayName("qSort should return empty vector for empty input")
    void qSortEmptyTest() throws IntegerDataVectorException {
        IntegerDataVector vector = IntegerDataVector.createBySize(0);

        IntegerDataVector sorted = sortService.qSort(vector);

        assertEquals(0, sorted.getSize(), "Should return empty vector");
    }
}