package com.example.aichatcompose.domain

import android.graphics.Bitmap

/**
 *  @author  Yusuf Yuldashov
 */
data class Chat(
    val prompt: String,
    val bitmap: Bitmap?,
    val isFromUser: Boolean
)