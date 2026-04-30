package org.example.factory.impl;

import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;
import org.example.factory.DataVectorFactory;

public class DataVectorFactoryImpl implements DataVectorFactory {

    @Override
    public IntegerDataVector createBySize(int size) throws IntegerDataVectorException {
        if (size < 0) {
            throw new IntegerDataVectorException("Trying create vector with negative size");
        }
        return new IntegerDataVector(size);
    }

    @Override
    public IntegerDataVector createWithData(int... inputData) throws IntegerDataVectorException {
        if (inputData == null || inputData.length == 0) {
            throw new IntegerDataVectorException("Trying create vector without data");
        }
        return new IntegerDataVector(inputData);
    }
}
