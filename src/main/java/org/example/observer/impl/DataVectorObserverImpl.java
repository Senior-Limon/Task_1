package org.example.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;
import org.example.observer.DataVectorObserver;
import org.example.services.impl.IntegerDataVectorServiceImpl;
import org.example.warehouse.DataVectorStats;
import org.example.warehouse.Warehouse;

import java.util.OptionalInt;

public class DataVectorObserverImpl implements DataVectorObserver {

    private static final Logger log = LogManager.getLogger(DataVectorObserverImpl.class);
    private final IntegerDataVectorServiceImpl service = new IntegerDataVectorServiceImpl();

    @Override
    public void vectorChanged(IntegerDataVector vector) throws IntegerDataVectorException {
        log.info("Observer triggered for vector ID: {}", vector.getId());

        int min = service.findMinElement(vector);
        int max = service.findMaxElement(vector);
        int sum = service.sum(vector);

        DataVectorStats stats = new DataVectorStats(min,max,sum);

        Warehouse.getInstance().put(vector.getId(), stats);
        log.debug("Warehouse updated with new stats for ID: {}", vector.getId());
    }
}
