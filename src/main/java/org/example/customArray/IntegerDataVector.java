package org.example.customArray;

import org.example.customException.IntegerDataVectorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.observer.DataVectorObservable;
import org.example.observer.DataVectorObserver;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerDataVector implements DataVectorObservable {

    private static final Logger log = LogManager.getLogger(IntegerDataVector.class);
    private static final AtomicInteger idGenerator = new AtomicInteger(0);

    private final int id;
    private int[] array;
    private final List<DataVectorObserver> observers;

    public IntegerDataVector(int size) {
        this.array = new int[size];
        this.id = idGenerator.incrementAndGet();
        this.observers = new ArrayList<>();
        log.debug("IntegerDataVector created with id: {}, size: {}", id, size);
    }

    public IntegerDataVector(int... inputData) {
        this.array = inputData.clone();
        this.id = idGenerator.incrementAndGet();
        this.observers = new ArrayList<>();
        log.debug("IntegerDataVector created with id: {}, data: {}", id, Arrays.toString(array));
    }

    public int getSize() {
        return array.length;
    }

    public int[] getFullDataVector() {
        return array.clone();
    }

    public boolean contains(int element) {
        for (int value : array) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }

    public void setElement(int index, int value) throws IntegerDataVectorException {
        log.debug("Setting element at index {} to value {}", index, value);
        if (index < 0 || index >= array.length) {
            throw new IntegerDataVectorException("Index out of range");
        }
        array[index] = value;
        log.debug("Successfully updated element at index {}", index);
        notifyObservers();
    }

    public int getElementByIndex(int index) throws IntegerDataVectorException {
        log.debug("Looking for element by index: {}", index);
        if (index < 0 || index >= array.length) {
            throw new IntegerDataVectorException("Index out of range");
        }
        log.debug("Success! Element: {}", array[index]);
        return array[index];
    }

    public int getIndexOfElement(int element) {
        log.debug("Looking for element {} in vector", element);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                log.debug("Success! Index of element: {}", i);
                return i;
            }
        }
        log.debug("Element {} not found", element);
        return -1;
    }

    public void setArray(int[] newArray) throws IntegerDataVectorException {
        if (newArray == null || newArray.length == 0) {
            throw new IntegerDataVectorException("Trying to set null or empty array");
        }
        this.array = newArray.clone();
        log.debug("Array updated. New size: {}", array.length);
        notifyObservers();
    }

    public int getId() {
        return id;
    }

    // Observer methods

    @Override
    public void attach(DataVectorObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
            log.debug("Observer attached to vector with id: {}", id);
        }
    }

    @Override
    public void detach(DataVectorObserver observer) {
        if (observer != null) {
            observers.remove(observer);
            log.debug("Observer detached from vector with id: {}", id);
        }
    }

    @Override
    public void notifyObservers() throws IntegerDataVectorException {
        log.debug("Notifying {} observers about vector change (id: {})", observers.size(), id);
        for (DataVectorObserver observer : observers) {
            observer.vectorChanged(this);
        }
    }

    @Override
    public String toString() {
        log.debug("Converting vector to string representation");

        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder(array.length * 11 + 2);
        sb.append('[');

        sb.append(array[0]);

        for (int i = 1; i < array.length; i++) {
            sb.append(", ").append(array[i]);
        }

        sb.append(']');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        log.debug("Getting vector hash");
        return Arrays.hashCode(array);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        IntegerDataVector that = (IntegerDataVector) obj;
        return Arrays.equals(this.array, that.array);
    }
}