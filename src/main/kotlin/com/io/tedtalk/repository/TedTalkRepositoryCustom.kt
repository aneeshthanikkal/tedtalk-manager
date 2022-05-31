package com.io.tedtalk.repository

import com.io.tedtalk.model.Tedtalk

interface TedTalkRepositoryCustom {
    fun findTedTalksByAuthorAndTitleAndViewsAndLikes(
        author: String, title: String,
        views: Long, likes: Long
    ): List<Tedtalk>
}