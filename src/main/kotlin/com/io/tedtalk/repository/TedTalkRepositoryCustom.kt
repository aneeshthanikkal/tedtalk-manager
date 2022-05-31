package com.io.tedtalk.repository

import com.io.tedtalk.model.Tedtalk

interface TedTalkRepositoryCustom {
    fun findTedTalksByAuthorTitleViewsAndLikes(
        author: String, title: String,
        views: Long, likes: Long
    ): List<Tedtalk>
}