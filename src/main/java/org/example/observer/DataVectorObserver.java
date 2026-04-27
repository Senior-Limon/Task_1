package org.example.observer;

import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;

public interface DataVectorObserver {
    void vectorChanged(IntegerDataVector vector) throws IntegerDataVectorException;
}
