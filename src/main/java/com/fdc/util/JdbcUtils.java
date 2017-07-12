package com.fdc.util;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtils {  
    private static DataSource ds;  
    static{  
          try {
             String pro_name="dbcpconfig.properties";  
              InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream(pro_name);  
              Properties pro = new Properties();  
              pro.load(in);  
              //DBCP连接池--固定代码:由工厂创建数据源(即连接池)  
              //用类成员记住根据配置文件创建出来的连接池!  
              ds=BasicDataSourceFactory.createDataSource(pro);  
          } catch (Exception e) {  
             throw new ExceptionInInitializerError(e);  
          }  
    }  
    public static DataSource getDataSource(){  
        //Dbutils工具构造函数需要一个连接池  
        return ds;  
    }  
} 
