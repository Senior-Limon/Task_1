package org.example.observer;

import org.example.customException.IntegerDataVectorException;

import java.util.zip.DataFormatException;

public interface DataVectorObservable {
    void attach(DataVectorObserver observer);
    void detach(DataVectorObserver observer);
    void notifyObservers() throws IntegerDataVectorException;
}
