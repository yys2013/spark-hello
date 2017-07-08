package com.fdc.wc;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 小于JAVA8版本实现
 *
 * @author HE
 * @version 1.0 2017-07-08
 **/
public class WordCountLtJava8 {

    private final static Logger logger = LoggerFactory.getLogger(WordCountJava8.class);

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("Spark WordCount Java8").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> lines = sc.textFile("E:\\logs\\Frankenstein.txt");

        JavaRDD<String> wordSet = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });

        JavaPairRDD<String, Integer> wordPair = wordSet.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s, 1);
            }
        });

        JavaPairRDD<String, Integer> wordCounts = wordPair.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });

        List<Tuple2<String, Integer>> tuple2s = wordCounts.collect();
        for (Tuple2<?, ?> tuple : tuple2s) {
            logger.info(tuple._1() + "---" + tuple._2());
        }

        sc.close();
    }


}
