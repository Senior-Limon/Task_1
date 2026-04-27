package org.example.repository.impl;

import org.example.customArray.IntegerDataVector;
import org.example.repository.DataVectorRepository;
import org.example.specification.DataVectorSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataVectorRepositoryImpl implements DataVectorRepository {

    private static final Logger logger = LogManager.getLogger(DataVectorRepositoryImpl.class);

    private static DataVectorRepositoryImpl instance;
    private final List<IntegerDataVector> items;

    private DataVectorRepositoryImpl() {
        items = new ArrayList<>();
        logger.info("DataVectorRepository instance created.");
    }

    public static DataVectorRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new DataVectorRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void add(IntegerDataVector vector) {

        if (!items.contains(vector)) {
            items.add(vector);
            logger.info("Added vector to repository with ID: {}", vector.getId());
        } else {
            logger.warn("Vector with ID: {} already exists in repository", vector.getId());
        }
    }

    @Override
    public void remove(IntegerDataVector vector) {

        if (items.remove(vector)) {
            logger.info("Removed vector from repository with ID: {}", vector.getId());
        } else {
            logger.warn("Failed to remove vector with ID: {} - vector not found in repository", vector.getId());
        }
    }

    @Override
    public List<IntegerDataVector> query(DataVectorSpecification specification) {

        List<IntegerDataVector> results = new ArrayList<>();

        if (specification == null) {
            logger.warn("Query called with null specification, returning empty list");
            return results;
        }

        for (IntegerDataVector vector : items) {
            if (specification.specify(vector)) {
                results.add(vector);
                logger.debug("Vector with ID: {} matched specification", vector.getId());
            }
        }

        logger.info("Query completed, found {} matching vectors", results.size());
        return results;
    }

    @Override
    public List<IntegerDataVector> sort(Comparator<IntegerDataVector> comparator) {
        if (comparator == null) {
            logger.warn("Sort called with null comparator, returning unsorted copy");
            return new ArrayList<>(items);
        }

        List<IntegerDataVector> sortedList = new ArrayList<>(items);
        sortedList.sort(comparator);
        logger.info("Sort completed, sorted {} vectors", sortedList.size());
        return sortedList;
    }
}