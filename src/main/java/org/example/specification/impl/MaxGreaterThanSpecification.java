package org.example.specification.impl;

import org.example.customArray.IntegerDataVector;
import org.example.specification.DataVectorSpecification;
import org.example.warehouse.DataVectorStats;
import org.example.warehouse.Warehouse;

public class MaxGreaterThanSpecification implements DataVectorSpecification {

    private final int target;

    public MaxGreaterThanSpecification(int target) {
        this.target = target;
    }

    @Override
    public boolean specify(IntegerDataVector vector) {
        DataVectorStats stats = Warehouse.getInstance().getStatsById(vector.getId());
        return stats != null && stats.getMax() > target;
    }
}
