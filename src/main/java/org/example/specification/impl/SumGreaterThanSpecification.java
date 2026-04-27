package org.example.specification.impl;

import org.example.specification.DataVectorSpecification;
import org.example.customArray.IntegerDataVector;
import org.example.warehouse.DataVectorStats;
import org.example.warehouse.Warehouse;

public class SumGreaterThanSpecification implements DataVectorSpecification {
    private final int targetSum;

    public SumGreaterThanSpecification(int targetSum) {
        this.targetSum = targetSum;
    }

    @Override
    public boolean specify(IntegerDataVector vector) {
        DataVectorStats stats = Warehouse.getInstance().getStatsById(vector.getId());
        return stats.getSum() > targetSum;
    }
}
