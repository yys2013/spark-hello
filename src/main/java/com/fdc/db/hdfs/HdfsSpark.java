package com.fdc.db.hdfs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class HdfsSpark {

    public static void main(String[] args) {
        
        SparkConf conf = new SparkConf()
                        //.setMaster("")
                        .setAppName("HdfsSpark");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> input = 
                jsc.textFile("hdfs://server01:9000/user/aifjs/fjsdb/fj_rtl_order_571_201611/part-m-00000");
        //JavaRDD<String> linesMap = input.map(line -> line.split(",")[0]);
        
//        JavaPairRDD<String, Integer> map = input.mapToPair(line -> 
//            new Tuple2<>((line.split(",")[26].trim() + "" + line.split(",")[27].trim()), Integer.parseInt(line.split(",")[22].trim())));
        JavaPairRDD<String,Integer> linesMap = input.mapToPair(line -> {
            String region = line.split(",")[26].trim();
            String coutry = line.split(",")[27].trim();
            String dealSts = line.split(",")[22].trim();
            Integer iDealSts = Integer.parseInt(line.split(",")[22].trim());
            return new Tuple2<>(region + " " + coutry + " " + dealSts, 1);
        });
        
        JavaPairRDD<String,Integer> deslStat = linesMap.reduceByKey((x,y) -> x + y);
        
//        JavaPairRDD<String, String> linesMap2 = deslStat.mapToPair(line -> {
//            String key = line._1.split(" ")[0] + " " + line._1.split(" ")[1] + " ";
//            String value = line._1.split(" ")[3] + " " + line._2.toString();
//            return new Tuple2<>(key, value);
//        });
//        
//        JavaPairRDD<String, String> deslStat2 = linesMap2.reduceByKey((x, y) -> {
//            int iDealSts1 = Integer.parseInt(x.split(" ")[0]);
//            int iDealSts2 = Integer.parseInt(y.split(" ")[0]);
//            if(iDealSts1 > iDealSts2) {
//                return x.split(" ")[1] + "" + y.split(" ")[1];
//            }else {
//                return y.split(" ")[1] + "" + y.split(" ")[1];
//            }
//        });
        deslStat.coalesce(1).saveAsTextFile("hdfs://server01:9000/user/aifjs/fjsdb/result/fj_rtl_order_571_201611_deal_002");
        
        //deslStat.saveAsHadoopFile(path, keyClass, valueClass, outputFormatClass);
//        JavaPairRDD<String,Integer> deslStat = linesMap.reduceByKey((x,y) -> x + y, 1);
        //deslStat.saveAsTextFile("hdfs://server01:9000/user/aifjs/fjsdb/fj_rtl_order_571_201611_deal_result2");
//        deslStat.coalesce(1).saveAsTextFile("hdfs://server01:9000/user/aifjs/fjsdb/fj_rtl_order_571_201611_deal_result2");
        
        jsc.close();
    }

}
