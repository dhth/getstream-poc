package server
import io.getstream.client.Client
import io.getstream.client.StreamClient;
import io.getstream.client.config.ClientConfiguration;
import io.getstream.client.apache.StreamClientImpl;

object OldSDKGetFeedToken {
  def main(args: Array[String]): Unit = {
    val apiKey: String = System.getenv("GETSTREAM_API_KEY")
    val apiSecret: String = System.getenv("GETSTREAM_API_SECRET")

    val streamConfig = new ClientConfiguration();
    val streamClient = new StreamClientImpl(streamConfig, apiKey, apiSecret);
    // change the feed when needed
    val feed = streamClient.newFeed("notification", System.getenv("GETSTREAM_USER_ID"))
    val feedToken = feed.getToken()
    println(feedToken)
  }
}
