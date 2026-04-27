package org.example.services;

import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;

public interface IntegerDataVectorService {
    int findMaxElement(IntegerDataVector vector) throws IntegerDataVectorException;
    int findMinElement(IntegerDataVector vector) throws IntegerDataVectorException;
    int sum(IntegerDataVector vector) throws IntegerDataVectorException;
    IntegerDataVector qSort(IntegerDataVector vector) throws IntegerDataVectorException;
    IntegerDataVector bubbleSort(IntegerDataVector vector) throws IntegerDataVectorException;
}
