package com.io.tedtalk.talks

import lombok.Getter
import lombok.Setter

@Getter
@Setter
data class TedtalkDto(
    val id: String,
    val title: String,
    val date: String,
    val author: String,
    val views: Long,
    val likes: Long,
    val link: String
)
