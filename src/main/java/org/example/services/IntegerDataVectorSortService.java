package org.example.services;

import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;

public interface IntegerDataVectorSortService {
    IntegerDataVector qSort(IntegerDataVector vector) throws IntegerDataVectorException;
    IntegerDataVector bubbleSort(IntegerDataVector vector) throws IntegerDataVectorException;
}
