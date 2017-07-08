package com.fdc.wc;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Matrix
 */
public class WordCountJava8 {

    private final  static Logger logger = LoggerFactory.getLogger(WordCountJava8.class);

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("Spark WordCount Java8").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile("E:\\logs\\Frankenstein.txt");

        JavaPairRDD<String, Integer> counts =
                lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator())
                        .mapToPair(word -> new Tuple2<>(word, 1))
                        .reduceByKey((x,y) -> x + y)
                        .mapToPair(word -> new Tuple2<>(word._2(), word._1()))
                        .sortByKey(false)
                        .mapToPair(word -> new Tuple2<>(word._2(), word._1()));

        counts.cache();
        counts.saveAsTextFile("E:\\logs\\spark");
        counts.foreach(count ->
                logger.info(count._1() + "---" + count._2())
        );
        sc.close();
    }



}

