package org.example.repository;

import org.example.customArray.IntegerDataVector;
import org.example.specification.DataVectorSpecification;

import java.util.Comparator;
import java.util.List;

public interface DataVectorRepository {
    void add(IntegerDataVector array);
    void remove(IntegerDataVector array);
    List<IntegerDataVector> query(DataVectorSpecification specification);
    List<IntegerDataVector> sort(Comparator<IntegerDataVector> comparator);
}
