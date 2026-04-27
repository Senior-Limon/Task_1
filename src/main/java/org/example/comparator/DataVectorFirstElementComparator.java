package org.example.comparator;

import org.example.customArray.IntegerDataVector;
import org.example.services.impl.IntegerDataVectorServiceImpl;
import java.util.Comparator;

public class DataVectorFirstElementComparator implements Comparator<IntegerDataVector> {


    @Override
    public int compare(IntegerDataVector v1, IntegerDataVector v2){

        if (v1.getSize() == 0 && v2.getSize() == 0) return 0;
        if (v1.getSize() == 0) return -1;
        if (v2.getSize() == 0) return 1;

        int[] vector1 = v1.getFullDataVector();
        int[] vector2 = v2.getFullDataVector();

        return Integer.compare(vector1[0], vector2[0]);
    }
}
