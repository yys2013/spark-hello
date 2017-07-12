package com.fdc.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;

public class MyBasicRowProcessor extends BasicRowProcessor {

    private final BeanProcessor beanProcessor;
    
    public MyBasicRowProcessor() {
        beanProcessor = new MyBeanProcessor();
    }
    
    @Override
    public <T> List<T> toBeanList(ResultSet rs, Class<T> type) throws SQLException {
        return this.beanProcessor.toBeanList(rs, type);
    }
    
    
}
