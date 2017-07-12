package com.fdc.util;

import java.beans.PropertyDescriptor;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.BeanProcessor;

public class MyBeanProcessor extends BeanProcessor {

    private final Map<String, String> myColumnToPropertyOverrides = new HashMap<>();
    
    
    public MyBeanProcessor() {
        
    }
    
//    public MyBeanProcessor(Map<String, String> columnToPropertyOverrides) {
//        super();
//        if (columnToPropertyOverrides == null) {
//            throw new IllegalArgumentException("columnToPropertyOverrides map cannot be null");
//        }
//        this.myColumnToPropertyOverrides = columnToPropertyOverrides;
//    }
    
    protected int[] mapColumnsToProperties(ResultSetMetaData rsmd,
            PropertyDescriptor[] props) throws SQLException {

        int cols = rsmd.getColumnCount();
        int[] columnToProperty = new int[cols + 1];
        Arrays.fill(columnToProperty, PROPERTY_NOT_FOUND);

        for (int col = 1; col <= cols; col++) {
            String columnName = rsmd.getColumnLabel(col);
            if (null == columnName || 0 == columnName.length()) {
              columnName = rsmd.getColumnName(col);
            }
            String propertyName = myColumnToPropertyOverrides.get(columnName);
            if (propertyName == null) {
                propertyName = columnName;
            }
            if(propertyName.contains("_")) {
                propertyName = propertyName.replace("_", "");
            }
            for (int i = 0; i < props.length; i++) {

                if (propertyName.equalsIgnoreCase(props[i].getName())) {
                    columnToProperty[col] = i;
                    break;
                }
            }
        }

        return columnToProperty;
    }
    
    
    
}
