package com.io.tedtalk.dto

import lombok.Getter
import lombok.Setter

@Getter
@Setter
data class TedtalkDto(var id: String, var title: String, var date: String, var author: String, var views: Long, var likes: Long, var link: String)
