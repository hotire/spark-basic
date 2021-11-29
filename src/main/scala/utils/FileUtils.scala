package utils

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.sql.SparkSession

object FileUtils {

  def renameFirst(spark: SparkSession, pathPattern: String, dst: String): Unit = {
    val fs = FileSystem.get(spark.sparkContext.hadoopConfiguration)
    val origin = fs.globStatus(new Path(pathPattern)).head
    fs.rename(origin.getPath, new Path(dst))
  }

  /**
   * Directory 일 경우 파일이 존재할 경 삭제할 수 없다.
   * recursive true 설정한 경우 재귀로 모든 file을 삭제하고 Directory 삭제한다.
   *
   */
  def delete(spark: SparkSession, path: String, recursive: Boolean): Boolean = {
    val fs = FileSystem.get(spark.sparkContext.hadoopConfiguration)
    fs.delete(new Path(path), true)
  }

}
