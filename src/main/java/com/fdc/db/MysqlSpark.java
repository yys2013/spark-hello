package com.fdc.db;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * mysql
 *
 * @author HE
 * @version 1.0 2017-07-09
 **/
public class MysqlSpark {


    public static void main(String[] args) {


        SparkConf conf = new SparkConf().setAppName("Mysql Spark").setMaster("local");

        JavaSparkContext jsc = new JavaSparkContext(conf);

        SQLContext sqlContext = new SQLContext(jsc);

        String url = "jdbc:mysql://192.168.1.6:3306/answ?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        Map<String, String> options = new HashMap<>();
        options.put("driver", "com.mysql.cj.jdbc.Driver");
        options.put("url", url);
        options.put("dbtable", "customer");
        options.put("user", "spark");
        options.put("password", "123456");
        options.put("fetchSize", "20");
        Dataset<Row> rowDataset = sqlContext.read().format("jdbc").options(options).load();

        rowDataset.show();


        Encoder<Customer> customerEncoder = Encoders.kryo(Customer.class);

        Dataset<Customer> customerDataset = rowDataset.map(new MapFunction<Row, Customer>() {
            @Override
            public Customer call(Row value) throws Exception {

                Customer customer = new Customer();
                Integer id = value.getAs("id");
                String address = value.getAs("address");
                String email = value.getAs("email");
                String name = value.getAs("name");

                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://192.168.1.6:3306/answ?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC" ;
                String username = "root" ;
                String password = "root" ;
                Connection conn = new DriverManager.getConnection(url, username, password);



                return customer;
            }
        }, customerEncoder);




//        SparkSession spark = SparkSession
//                .builder()
//                .appName("Spark SQL Example")
//                .getOrCreate();
//        Dataset<Row> dataset = spark.read().format("jdbc")
//                .option("url", "jdbc:mysql://192.168.1.6:3306/answ?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC")
//                .option("dbtable", "answ.customer")
//                .option("user", "spark")
//                .option("password", "123456")
//                .option("fetchSize", "1")
//                .load();


    }



}

class Customer implements Serializable {

    private Integer id;
    private String address;
    private String mail;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
