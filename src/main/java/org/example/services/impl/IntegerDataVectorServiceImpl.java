package org.example.services.impl;

import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;
import org.example.services.IntegerDataVectorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class IntegerDataVectorServiceImpl implements IntegerDataVectorService {

    @Override
    public int findMaxElement(IntegerDataVector vector) throws IntegerDataVectorException {
        if (vector.getSize() == 0) {
            throw new IntegerDataVectorException("No max element in empty vector");
        }
        int max = vector.getElementByIndex(0);
        int lengthOfVector = vector.getSize();
        for (int i = 1; i < lengthOfVector; i++) {
            max = Math.max(max, vector.getElementByIndex(i));
        }
        return max;
    }

    @Override
    public int findMinElement(IntegerDataVector vector) throws IntegerDataVectorException {
        if (vector.getSize() == 0) {
            throw new IntegerDataVectorException("No min element in empty vector");
        }
        int min = vector.getElementByIndex(0);
        int lengthOfVector = vector.getSize();
        for (int i = 1; i < lengthOfVector; i++) {
            min = Math.min(min, vector.getElementByIndex(i));
        }
        return min;
    }

    @Override
    public  int sum(IntegerDataVector vector) throws IntegerDataVectorException{
        int sum = 0;
        int lengthOfVector = vector.getSize();
        for (int i = 0; i < lengthOfVector; i++) {
            sum += vector.getElementByIndex(i);
        }
        return sum;
    }
}
