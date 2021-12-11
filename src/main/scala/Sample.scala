import org.apache.spark.sql.functions.regexp_replace
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object Sample {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder
      .master("local")
      .getOrCreate()

    val rows = Seq(
      Row(1, "hello"),
      Row(2, "world")
    )

    val schema = StructType(List(
      StructField("number", IntegerType, nullable = true),
      StructField("word", StringType, nullable = true)
    ))

    val df = spark.createDataFrame(
      spark.sparkContext.parallelize(rows),
      schema
    )

    df.select("number").show()
    df.select("word").show()

    import spark.implicits._

    val dfWithText = df.withColumn("text", regexp_replace($"number", "ll", "LL"))

    dfWithText.printSchema()

    dfWithText
      .coalesce(1)
      .write
      .option("header", "true")
      .csv("temp/teenagers.csv")

    println(s"count: ${df.count()}")

    spark.stop()
  }
}
