package org.example.warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger log = LogManager.getLogger(Warehouse.class);
    private static Warehouse instance;
    public final Map<Integer, DataVectorStats> statMap;

    public Warehouse(){
        statMap = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
            log.info("Warehouse singleton instance created.");
        }
        return instance;
    }

    public void put(int id, DataVectorStats stats) {
        if (stats != null) {
            statMap.put(id, stats);
        }
    }

    public DataVectorStats getStatsById(int id) {
        return statMap.get(id);
    }

    public void removeById(int id){
        statMap.remove(id);
    }


}
