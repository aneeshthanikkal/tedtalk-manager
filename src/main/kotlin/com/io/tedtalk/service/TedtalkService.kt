package com.io.tedtalk.service

import com.io.tedtalk.dto.TedtalkDto
import com.io.tedtalk.exception.CommonResourceNotFoundException
import com.io.tedtalk.model.Tedtalk
import com.io.tedtalk.repository.TedtalkRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class TedtalkService(val tedtalkRepository: TedtalkRepository) {

    fun findTedtalkById(id: String): Tedtalk {
        return tedtalkRepository.findById(id)?.orElseThrow { CommonResourceNotFoundException() }
    }

    fun updateTedtalk(tedtalkDto: TedtalkDto): Tedtalk {
        return if (tedtalkRepository.existsById(tedtalkDto.id)) {
            tedtalkRepository.save(
                Tedtalk(
                    tedtalkId = tedtalkDto.id,
                    title = tedtalkDto.title,
                    date = tedtalkDto.date,
                    author = tedtalkDto.author,
                    views = tedtalkDto.views,
                    likes = tedtalkDto.likes,
                    link = tedtalkDto.link
                )
            )
        } else throw CommonResourceNotFoundException()
    }

    fun deleteTedtalkById(id: String) {
        return if (tedtalkRepository.existsById(id)) {
            tedtalkRepository.deleteById(id)
        } else throw CommonResourceNotFoundException()
    }

    fun findTedTalks(author: String, title: String, views: Long, likes: Long): List<Tedtalk> {
        return tedtalkRepository.findTedTalksByAuthorAndTitleAndViewsAndLikes(author, title, views, likes)
    }
}