package server

import io.getstream.client.Client
import io.getstream.client.StreamClient;
import io.getstream.client.config.ClientConfiguration;
import io.getstream.client.apache.StreamClientImpl;
import io.getstream.client.model.activities.BaseActivity;

object OldSDKPushEntryToFlatFeed {

  class BasicActivity extends BaseActivity

  def main(args: Array[String]): Unit = {
    val apiKey: String = System.getenv("GETSTREAM_API_KEY")
    val apiSecret: String = System.getenv("GETSTREAM_API_SECRET")

    val streamConfig = new ClientConfiguration();
    val streamClient = new StreamClientImpl(streamConfig, apiKey, apiSecret);
    val feed =
      streamClient.newFeed("user", System.getenv("GETSTREAM_USER_ID"))

    val activityService = feed.newFlatActivityService(classOf[BaseActivity])
    val activity = new BasicActivity()
    activity.setActor("user11")
    activity.setVerb("publish")
    activity.setObject("picture:21")

    activityService.addActivity(activity)
  }
}
