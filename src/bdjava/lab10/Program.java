package bdjava.lab10;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class Program {
        public static void main(String[] args) {
            // создаем конфигурацию Spark
            SparkConf conf = new SparkConf().setAppName("CSV Reader").setMaster("local[*]");

            // создаем контекст Spark
            JavaSparkContext sc = new JavaSparkContext(conf);

            // создаем SQL-контекст Spark
            SQLContext sqlContext = new SQLContext(sc);

            // создаем DataFrame
            Dataset<Row> df = sqlContext.read().format("csv").option("header", "true").option("inferSchema", "true").load("src/bdjava/lab10/russian_demography.csv");

            // выполняем 10 выборок SQL-данных
            df.createOrReplaceTempView("data");
            Dataset<Row> result1 = sqlContext.sql("SELECT * FROM data WHERE year = 1990");
            Dataset<Row> result2 = sqlContext.sql("SELECT * FROM data WHERE region LIKE '%Oblast'");
            Dataset<Row> result3 = sqlContext.sql("SELECT region, birth_rate FROM data WHERE birth_rate > 15");
            Dataset<Row> result4 = sqlContext.sql("SELECT year, AVG(birth_rate) AS avg_birth_rate FROM data GROUP BY year");
            Dataset<Row> result5 = sqlContext.sql("SELECT region, death_rate FROM data ORDER BY death_rate DESC LIMIT 10");
            Dataset<Row> result6 = sqlContext.sql("SELECT year, SUM(npg) AS total_npg FROM data GROUP BY year");
            Dataset<Row> result7 = sqlContext.sql("SELECT region, urbanization FROM data WHERE urbanization > 70 AND urbanization < 80");
            Dataset<Row> result8 = sqlContext.sql("SELECT region, gdw FROM data WHERE gdw > 80 ORDER BY gdw DESC");
            Dataset<Row> result9 = sqlContext.sql("SELECT year, region, npg FROM data WHERE npg > 5 ORDER BY npg DESC LIMIT 10");
            Dataset<Row> result10 = sqlContext.sql("SELECT year, region, birth_rate, death_rate, npg FROM data WHERE birth_rate > death_rate");

            // выводим результаты
            result1.show();
            result2.show();
            result3.show();
            result4.show();
            result5.show();
            result6.show();
            result7.show();
            result8.show();
            result9.show();
            result10.show();

            // останавливаем контекст Spark
            sc.stop();
        }
    }
}