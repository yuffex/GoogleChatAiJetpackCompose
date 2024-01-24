package com.example.aichatcompose.data

import android.graphics.Bitmap
import com.example.aichatcompose.domain.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *  @author  Yusuf Yuldashov
 */

object ChatData {

    val api_key = "AIzaSyAQTArvOPgzBYHlAiBw0B7Qer_lwBydwq4"
    private fun handleErrorResponse(e: Exception): Chat {
        return Chat(
            prompt = e.message ?: "error",
            bitmap = null,
            isFromUser = false
        )
    }

     suspend fun getResponse(prompt: String): Chat {
        val generativeModel = GenerativeModel(
            modelName = "gemini-pro", apiKey = api_key
        )

        return try {
            val response = withContext(Dispatchers.IO) {
                generativeModel.generateContent(prompt)
            }

            Chat(
                prompt = response.text ?: "error",
                bitmap = null,
                isFromUser = false
            )
        } catch (e: Exception) {
            handleErrorResponse(e)
        }
    }

     suspend fun getResponseWithImage(prompt: String, bitmap: Bitmap): Chat {
        val generativeModel = GenerativeModel(
            modelName = "gemini-pro-vision", apiKey = api_key
        )

        return try {
            val inputContent = content {
                image(bitmap)
                text(prompt)
            }

            val response = withContext(Dispatchers.IO) {
                generativeModel.generateContent(inputContent)
            }

            Chat(
                prompt = response.text ?: "error",
                bitmap = null,
                isFromUser = false
            )
        } catch (e: Exception) {
            handleErrorResponse(e)
        }
    }


}