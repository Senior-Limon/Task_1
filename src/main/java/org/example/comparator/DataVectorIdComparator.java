package org.example.comparator;

import org.example.customArray.IntegerDataVector;

import java.util.Comparator;

public class DataVectorIdComparator implements Comparator<IntegerDataVector> {

    @Override
    public int compare(IntegerDataVector v1, IntegerDataVector v2){
        return Integer.compare(v1.getId(), v2.getId());
    }
}
