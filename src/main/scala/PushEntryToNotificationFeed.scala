import io.getstream.client.Client
import io.getstream.core.models.Activity
import scala.util.Random

object PushEntryToNotificationFeed {
  def main(args: Array[String]): Unit = {
    val apiKey: String = System.getenv("GETSTREAM_API_KEY")
    val apiSecret: String = System.getenv("GETSTREAM_API_SECRET")
    val userId: String = System.getenv("GETSTREAM_USER_ID")

    val client = Client.builder(apiKey, apiSecret).build()
    val feed = client.notificationFeed("notifications", userId)
    val activity: Activity = Activity
      .builder()
      .actor(Random.alphanumeric take 5 mkString (""))
      .verb("add")
      .`object`("picture:10")
      .build()

    feed.addActivity(activity)
    Thread.sleep(1000)
  }
}
