import org.apache.spark.{SparkConf, SparkContext}
import java.io.File
/**
  * Word Count Scala
  *
  * @author HE
  * @version 1.0 2017-07-08
  **/
object WordCountScala {


    def main(args: Array[String]): Unit = {

        val conf = new SparkConf().setAppName("Word Count Scala").setMaster("local")
        val sc = new SparkContext(conf)

        val lines = sc.textFile("E:\\logs\\Frankenstein.txt")
        val wc = lines.flatMap(line => line.split(" "))
                .map(word => (word, 1))
                .reduceByKey(_+_)

        

        wc.cache()
        wc.collect.foreach(println)

        val file = new File("E:\\logs\\spark1");
        if(file.exists()) {
            file.delete()
        }
        wc.saveAsTextFile("E:\\logs\\spark1")

        sc.stop()
    }


}
