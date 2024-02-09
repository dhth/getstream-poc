package server

import io.getstream.client.Client

object NewSDKGetUserToken {
  def main(args: Array[String]): Unit = {
    val apiKey: String = System.getenv("GETSTREAM_API_KEY")
    val apiSecret: String = System.getenv("GETSTREAM_API_SECRET")

    val client = Client.builder(apiKey, apiSecret).build()
    val userToken = client.frontendToken(System.getenv("GETSTREAM_USER_ID"))
    println(userToken)
  }
}
