package dev.eastar.studylog.notification

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class AndroidPushNotificationsService {
    @Async
    fun send(content: String): Response {
        val client = OkHttpClient().newBuilder()
            .build()

        val body = content.toRequestBody("application/json".toMediaType())
        val request = Request.Builder()
            .url(firebase_api_url)
            .method("POST", body)
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "key=$firebase_server_key")
            .build()
        return client.newCall(request).execute()
    }

    companion object {
        private const val firebase_server_key = "AAAAG_VRURA:APA91bG1CUwht_9h-md9AYLWk0heyvTb-tWr9K7MHrlvJXCDN2QR7PWt7kWvAZXlhcC2VUpv-pP9-20GKX3FqTuZ5Y5uuLPlwPcnaEcvaZAXYZb1jJCRLhG4XP2xPScSA4lKlqLAaxWH"
        private const val firebase_api_url = "https://fcm.googleapis.com/fcm/send"
    }
}