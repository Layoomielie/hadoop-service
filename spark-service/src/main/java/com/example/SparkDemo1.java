package com.example;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author：张鸿建
 * @time：2019/12/13 13:58
 * @desc：
 **/
public class SparkDemo1 {
    public static void main(String[] args) {
        SparkConf my_app = new SparkConf().setMaster("localhost").setAppName("My APP");
        JavaSparkContext sc = new JavaSparkContext(my_app);
        JavaRDD<String> input = sc.textFile("/opt/spark/spark-2.4.4-bin-hadoop2.7/result/wordcount.txt");
        JavaRDD<String> words = input.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String s) {
                return Arrays.asList(s.split(" ")).iterator();
            }
        });

        JavaPairRDD<String, Integer> counts = words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer x, Integer y) throws Exception {
                return x + y;
            }
        });
        counts.saveAsTextFile("/opt/spark/spark-2.4.4-bin-hadoop2.7/result/result.txt");

    }
}
