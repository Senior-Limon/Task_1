package org.example.specification.impl;

import org.example.customArray.IntegerDataVector;
import org.example.specification.DataVectorSpecification;

public class IdSpecification implements DataVectorSpecification {

    private final int targetId;

    public IdSpecification(int expectedId) {
        this.targetId = expectedId;
    }

    @Override
    public boolean specify(IntegerDataVector vector) {
        return vector != null && vector.getId() == targetId;
    }
}
