package com.io.tedtalk.talks

import com.io.tedtalk.common.CommonResourceNotFoundException
import org.springframework.stereotype.Service

@Service
class TedtalkService(val tedtalkRepository: TedtalkRepository) {

    fun findTedtalkById(id: String): Tedtalk {
        return tedtalkRepository.findById(id).orElseThrow { CommonResourceNotFoundException() }
    }

    fun updateTedtalk(tedtalkDto: TedtalkDto): Tedtalk {
        return if (tedtalkRepository.existsById(tedtalkDto.id)) {
            tedtalkRepository.save(tedtalkDto.todDomain())
        } else throw CommonResourceNotFoundException()
    }


    fun deleteTedtalkById(id: String) {
        "This is some string".toMyWeirdClass() // Extension functions

        return if (tedtalkRepository.existsById(id)) {
            tedtalkRepository.deleteById(id)
        } else throw CommonResourceNotFoundException()
    }

    fun findTedTalks(author: String?, title: String?, views: Long?, likes: Long?): List<Tedtalk> {
        return tedtalkRepository.findTedTalksByAuthorAndTitleAndViewsAndLikes(author, title, views, likes)
    }
}

fun TedtalkDto.todDomain() = Tedtalk(
    tedtalkId = id,
    title = title,
    date = date,
    author = author,
    views = views,
    likes = likes,
    link = link
)

// Extension functions extending existing classes with cool new methods
fun String.toMyWeirdClass() = MyWeirdClass(this.substring(10), this.substring(5))

class MyWeirdClass(val firstPart: String, val secondPart: String)