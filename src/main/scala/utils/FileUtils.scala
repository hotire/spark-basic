package utils

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.sql.SparkSession

object FileUtils {

  def renameFirst(spark: SparkSession, pathPattern: String, dst: String): Unit = {
    val fs = FileSystem.get(spark.sparkContext.hadoopConfiguration)
    val origin = fs.globStatus(new Path(pathPattern)).head
    fs.rename(origin.getPath, new Path(dst))
  }

}
