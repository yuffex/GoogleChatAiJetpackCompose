package com.example.aichatcompose.domain

import android.graphics.Bitmap
import com.example.aichatcompose.domain.Chat
/**
 *  @author  Yusuf Yuldashov
 */
data class ChatState(
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
    val bitmap: Bitmap? = null
)
