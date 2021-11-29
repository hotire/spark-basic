import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.{ClientConfiguration, Protocol}

/**
 * https://wiki.linecorp.com/display/verda/Verda-Dev+Object+Storage+S3+API
 */
object AmazonS3Client {

  val accessKey = ""
  val secretKey = ""
  val endpoint = ""
  val signingRegion = ""
  val credentials = new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey))
  val clientConfiguration = new ClientConfiguration() {
    setProtocol(Protocol.HTTPS)
  }
  val endpointConfiguration = new EndpointConfiguration(endpoint, signingRegion)

  val client = AmazonS3ClientBuilder
    .standard()
    .withCredentials(credentials)
    .withClientConfiguration(clientConfiguration)
    .withEndpointConfiguration(endpointConfiguration)
    .build()


}
