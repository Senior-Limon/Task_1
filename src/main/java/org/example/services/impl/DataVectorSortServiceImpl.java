package org.example.services.impl;

import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;
import org.example.factory.impl.DataVectorFactoryImpl;
import org.example.services.IntegerDataVectorSortService;

import java.util.ArrayList;
import java.util.Random;

public class DataVectorSortServiceImpl implements IntegerDataVectorSortService {

    private final DataVectorFactoryImpl factory = new DataVectorFactoryImpl();


    @Override
    public IntegerDataVector qSort(IntegerDataVector vector) throws IntegerDataVectorException {

        Random rnd = new Random();

        if (vector.getSize() == 0) {
            return factory.createBySize(0);
        }
        // IntegerDataVector => array; array => ArrayList
        int[] vectorArray = vector.getFullDataVector();
        ArrayList<Integer> list = new ArrayList<>();
        for (int el : vectorArray) {
            list.add(el);
        }

        ArrayList<Integer> sortedArray = qSortHelper(list, rnd);

        // Sorted ArrayList => array; array => IntegerDataVector; return new sorted IntegerDataVector
        int[] result = new int[sortedArray.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = sortedArray.get(i);
        }
        return factory.createWithData(result);
    }

    @Override
    public IntegerDataVector bubbleSort(IntegerDataVector vector) throws IntegerDataVectorException {

        if (vector.getSize() == 0) {
            return factory.createBySize(0);
        }

        IntegerDataVector sortedVector = factory.createWithData(vector.getFullDataVector());
        int length = sortedVector.getSize();

        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                int current = sortedVector.getElementByIndex(j);
                int next = sortedVector.getElementByIndex(j + 1);

                if (current > next) {
                    sortedVector.setElement(j, next);
                    sortedVector.setElement(j + 1, current);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        return sortedVector;
    }


    private ArrayList<Integer> qSortHelper(ArrayList<Integer> arr, Random rnd) {

        if (arr.size() < 2) {
            return new ArrayList<>(arr);
        }

        int opornEl = arr.get(rnd.nextInt(0,arr.size()));

        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> bigger = new ArrayList<>();

        for (int el : arr) {
            if (el > opornEl) {
                bigger.add(el);
            }
            else if (el < opornEl) {
                smaller.add(el);
            }
            else {
               equal.add(el);
            }
        }

        ArrayList<Integer> result = qSortHelper(smaller,rnd);
        result.addAll(equal);
        result.addAll(qSortHelper(bigger,rnd));
        return result;
    }
}
