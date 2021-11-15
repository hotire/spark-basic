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

    println(s"count: ${df.count()}")

    spark.stop()
  }
}
