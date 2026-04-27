package org.example.comparator;

import org.example.customArray.IntegerDataVector;

import java.util.Comparator;

public class DataVectorSizeComparator implements Comparator<IntegerDataVector>{

    @Override
    public int compare(IntegerDataVector v1, IntegerDataVector v2){
        return Integer.compare(v1.getSize(), v2.getSize());
    }
}
