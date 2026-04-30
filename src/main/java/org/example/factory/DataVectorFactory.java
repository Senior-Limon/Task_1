package org.example.factory;

import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;

public interface DataVectorFactory {
    IntegerDataVector createBySize(int size) throws IntegerDataVectorException;
    IntegerDataVector createWithData(int... inputData) throws IntegerDataVectorException;


}
