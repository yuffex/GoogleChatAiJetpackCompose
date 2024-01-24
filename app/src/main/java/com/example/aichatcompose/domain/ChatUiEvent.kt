package com.example.aichatcompose.domain

import android.graphics.Bitmap
/**
 *  @author  Yusuf Yuldashov
 */
sealed class ChatUiEvent {
    data class UpdatePrompt(val newPrompt: String) : ChatUiEvent()
    data class SendPrompt(
        val prompt: String,
        val bitmap: Bitmap?
    ) : ChatUiEvent()
}