package com.fdc.db.mongo;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;

import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;

public class MongoSparkDemo {

    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("MongoSparkConnectorIntro")
                .config("spark.mongodb.input.uri", "mongodb://10.19.18.75/fj.user")
                .config("spark.mongodb.output.uri", "mongodb://10.19.18.75/fj.user")
                .getOrCreate();
        
        
        JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
        
        JavaMongoRDD<Document> customRdd = MongoSpark.load(jsc);
        
        
        customRdd.first().toJson();
        
//        customRdd.foreach(new VoidFunction<Document>() {
//            
//            @Override
//            public void call(Document t) throws Exception {
//                
//                
//                
//            }
//        });
        
        

    }

}
