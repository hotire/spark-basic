
name := "spark-basic"

version := "0.1"

scalaVersion := "2.11.10"


aggregate in runMain := true

val sparkVersion = "2.4.8"
val hadoopVersion = "2.7.1"
val hiveVersion = "2.4.8"

libraryDependencies ++= Seq(
  "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion exclude("commons-daemon", "commons-daemon"),
  "org.apache.hadoop" % "hadoop-auth" % hadoopVersion exclude("commons-daemon", "commons-daemon"),
  "org.apache.hadoop" % "hadoop-client" % hadoopVersion exclude("commons-daemon", "commons-daemon"),
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-repl" % sparkVersion,
  "org.apache.spark" %% "spark-yarn" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % hiveVersion,
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}


javacOptions ++= Seq("-source", "1.8", "-target", "1.8")