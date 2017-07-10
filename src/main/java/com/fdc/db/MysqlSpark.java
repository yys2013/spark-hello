package com.fdc.db;

import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fdc.util.DBUtils;

/**
 * mysql
 *
 * @author HE
 * @version 1.0 2017-07-09
 **/
public class MysqlSpark {

    private final  static Logger logger = LoggerFactory.getLogger(MysqlSpark.class);

    public static void main(String[] args) {

        SparkSession spark = SparkSession
                .builder()
                .master("local")
                .appName("Spark SQL Example")
                .getOrCreate();
        
        String url = "jdbc:mysql://192.168.1.6:3306/answ?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        Dataset<Row> rowDataset = spark.read().format("jdbc")
                .option("url", url)
                .option("dbtable", "answ.customer")
                .option("user", "spark")
                .option("password", "123456")
                .option("fetchSize", "20")
                .load();
        
        Encoder<Customer> customerEncoder = Encoders.bean(Customer.class);

        Dataset<Customer> customerDataset = rowDataset.map(new MapFunction<Row, Customer>() {
            @Override
            public Customer call(Row value) throws Exception {

                Customer customer = new Customer();
                Integer id = value.getAs("id");
                String address = value.getAs("address");
                String email = value.getAs("email");
                String name = value.getAs("name");
                
                customer.setId(id * 100);
                customer.setAddress(address + customer.getId());
                customer.setEmail(email + customer.getId());
                customer.setName(name + customer.getId());
                
                String sql = "select * from answ.customer where id=?";
                
                Connection conn = DBUtils.getConnect();
                QueryRunner run = new QueryRunner();
                List<Customer> list = run.query(conn, sql, 
                        new BeanListHandler<Customer>(Customer.class),
                        id);
                
                logger.info("----------------------------------------------");
                for(Customer temp : list) {
                    logger.info("Customer : " + temp.getId() + "---" + temp.getName());
                }
                logger.info("----------------------------------------------");
                
                return customer;
            }
        }, customerEncoder);

        customerDataset.show();
        
        
        
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "spark");
        connectionProperties.put("password", "123456");
        customerDataset.write().mode(SaveMode.Append).jdbc(url, "answ.customer", connectionProperties);
        
//        customerDataset.foreachPartition(new ForeachPartitionFunction<Customer>() {
//            
//            @Override
//            public void call(Iterator<Customer> t) throws Exception {
//                
//                
//                
//                
//            }
//        });
        
        

    }



}
