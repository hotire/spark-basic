# spark-basic

- Spark SQL Reference : https://spark.apache.org/docs/latest/sql-programming-guide.html
- git : https://github.com/apache/spark


## RDD(Resilient Distributed Dataset)


## Transformation

### Narrow

만일 데이터가 이미 키 값으햣로 파티셔닝 되어 있고 키 값에 대해 변화를 주고 싶다면, 좌측의 그림처럼 수행하게 된다. filter(), sample(), map(), flatMap() 등의 transformation이 이에 해당하며, 
 
이 경우 Shuffle이 필요 없다. 이를 Narrow Transformation 

### Wide
서로 다른 파티션으로부터 특정한 값을 기준으로 추출하고 싶은 경우, 

그 값을 기준으로 Shuffle이 발생하게 됩니다. groupByKey(), reduceByKey() 등이 이에 해당하며, 이를 Wide Transformation 이라고 한다.


## Shuffle

Shuffle 은 Spark 에서 데이터를 재분배하는 방법이다. 

### Background

Shuffle 을 이해하기 위해서는, reduceByKey 의 작동 방식을 알아야한다.

reduceByKey 는 동일한 Key 를 가지고 있는, 모든 record 값을 취합하는 작업이다. (A, 1), (A, 2), (A, 3) → (A, 6)

하지만 Spark 의 분산처리는 파티션 단위로 진행되기 때문에 동일한 Key 의 모든 record 값을 취합하기 위해선 

동일한 Key 를 가진 튜플 데이터가 전부 같은 파티션에 있어야한다. 따라서 모든 튜플 데이터가 여러 클러스터에 분산 저장되어 있을 때 

동일한 Key 를 가진 튜플 데이터를 동일한 파티션에 두기 위해, 데이터의 위치를 재조정하는 방법이 Shuffle이다. 



## Coalesce





## SBT Simple Build Tool

SBT는 최신 빌드 도구 중 하나이다. 스칼라로 작성되었고, 스칼라에 사용하기 편한 기능을 많이 제공하기는 하지만, SBT 자체는 범용 빌드 도구이다.

### SBT를 쓰는 이유는?
- 건전한(?) 의존성 관리
- 의존성 관리에 Ivy를 사용
- 요청이 올때만 업데이트(Only-update-on-request) 모델
- 태스크를 작성할 수 있도록 스칼라 언어 전체를 지원
- 연속으로 명령 실행
- 프로젝트 문맥(환경)하에서 REPL 실행 가능


## Zeppelin

https://zeppelin.apache.org/download.html download

- start
~~~
bin/zeppelin-daemon.sh start
~~~

- stop
~~~
bin/zeppelin-daemon.sh stop
~~~


### References
- Apache Spark로 시작하는 머신러닝 입문 : https://youtu.be/PRLz11vv7VA


