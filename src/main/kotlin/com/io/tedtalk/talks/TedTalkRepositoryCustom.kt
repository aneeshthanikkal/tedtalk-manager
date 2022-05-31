package com.io.tedtalk.talks

interface TedTalkRepositoryCustom {

    fun findTedTalksByAuthorAndTitleAndViewsAndLikes(
        author: String?,
        title: String?,
        views: Long?,
        likes: Long?
    ): List<Tedtalk>
}