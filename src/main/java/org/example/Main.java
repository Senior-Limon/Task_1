package org.example;

import org.example.comparator.DataVectorSizeComparator;
import org.example.customArray.IntegerDataVector;
import org.example.customException.IntegerDataVectorException;
import org.example.factory.impl.DataVectorFactoryImpl;
import org.example.fileParser.impl.DataVectorParserImpl;
import org.example.observer.DataVectorObserver;
import org.example.observer.impl.DataVectorObserverImpl;
import org.example.repository.impl.DataVectorRepositoryImpl;
import org.example.specification.DataVectorSpecification;
import org.example.specification.impl.SumGreaterThanSpecification;
import org.example.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final DataVectorFactoryImpl factory = new DataVectorFactoryImpl();

    public static void main(String[] args) throws Exception {
        logger.info("Application started.");

        DataVectorRepositoryImpl repository = DataVectorRepositoryImpl.getInstance();
        Warehouse warehouse = Warehouse.getInstance();
        DataVectorObserver observer = new DataVectorObserverImpl();
        DataVectorParserImpl parser = new DataVectorParserImpl();

        String filePath = "D:\\task1_inno\\task1_Inno\\src\\main\\resources\\numsForArray.txt";

        try {
            List<Integer> numbers = parser.parseIntegers(filePath);
            logger.info("Loaded {} numbers from file", numbers.size());

            //Create Vectors
            int vectorSize = 3;
            for (int i = 0; i < numbers.size(); i += vectorSize) {
                int end = Math.min(i + vectorSize, numbers.size());
                int[] vectorData = new int[end - i];
                for (int j = 0; j < vectorData.length; j++) {
                    vectorData[j] = numbers.get(i + j);
                }
                IntegerDataVector vector = factory.createWithData(vectorData);
                observer.vectorChanged(vector);
                vector.attach(observer);
                repository.add(vector);
            }


            //Search vector with size < 10
            DataVectorSpecification sumSpec = new SumGreaterThanSpecification(10);
            List<IntegerDataVector> foundBySum = repository.query(sumSpec);
            logger.info("Vectors with sum > 10 found: {}", foundBySum.size());

            // sorting by size
            List<IntegerDataVector> sorted = repository.sort(new DataVectorSizeComparator());
            logger.info("Sorted vectors:");
            for (IntegerDataVector v : sorted) {
                logger.info("ID: {}, Data: {}", v.getId(), v);
            }

        } catch (IOException e) {
            logger.fatal("Error reading file: {}", e.getMessage());
        } catch (IntegerDataVectorException e) {
            throw new Exception(e);
        }

        logger.info("Application finished.");
    }
}

