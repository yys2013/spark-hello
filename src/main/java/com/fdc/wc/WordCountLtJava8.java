package com.fdc.wc;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * 小于JAVA8版本实现
 *
 * @author HE
 * @version 1.0 2017-07-08
 **/
public class WordCountLtJava8 {


    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("Spark WordCount Java8").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile("E:\\logs\\Frankenstein.txt");


    }



}
