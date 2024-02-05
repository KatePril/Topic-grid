package com.example.topicgrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicName: Int,
    val courseNumber: Int,
    @DrawableRes val topicImage: Int
)
