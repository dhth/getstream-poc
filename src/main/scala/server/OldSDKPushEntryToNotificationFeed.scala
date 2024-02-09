package server

import io.getstream.client.Client
import io.getstream.client.StreamClient;
import io.getstream.client.config.ClientConfiguration;
import io.getstream.client.apache.StreamClientImpl;
import io.getstream.client.model.activities.BaseActivity;

object OldSDKPushEntryToNotificationFeed {

  class BasicActivity extends BaseActivity

  def main(args: Array[String]): Unit = {
    val apiKey: String = System.getenv("GETSTREAM_API_KEY")
    val apiSecret: String = System.getenv("GETSTREAM_API_SECRET")

    val streamConfig = new ClientConfiguration();
    val streamClient = new StreamClientImpl(streamConfig, apiKey, apiSecret);
    val feed =
      streamClient.newFeed("notification", System.getenv("GETSTREAM_USER_ID"))

    val activityService =
      feed.newNotificationActivityService(classOf[BaseActivity])
    val activity = new BasicActivity()
    activity.setActor("user13")
    activity.setVerb("publish")
    activity.setObject("picture:20")

    activityService.addActivity(activity)
  }
}
