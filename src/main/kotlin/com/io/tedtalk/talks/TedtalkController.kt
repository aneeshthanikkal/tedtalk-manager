package com.io.tedtalk.talks

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class TedtalkController(private val tedtalkService: TedtalkService) {

    @GetMapping("/tedtalk/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getTedtalkById(@PathVariable id: String) : Tedtalk? {
        return tedtalkService.findTedtalkById(id)
    }

    @PutMapping("/tedtalk/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun updateTedtalk(@PathVariable id: String, @RequestBody tedtalkDto: TedtalkDto) : Tedtalk {
        tedtalkDto.id=id
        return tedtalkService.updateTedtalk(tedtalkDto)
    }

    @DeleteMapping("/tedtalk/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTedtalk(@PathVariable id: String) {
        return tedtalkService.deleteTedtalkById(id)

    }

    @GetMapping("/tedtalk")
    @ResponseStatus(HttpStatus.OK)
    fun findTedTalks(
        @RequestParam author: String?,
        @RequestParam title: String?,
        @RequestParam views: Long?,
        @RequestParam likes: Long?
    ) : List<Tedtalk> {
        return tedtalkService.findTedTalks(author, title, views, likes)
    }

    @PostMapping("/tedtalk")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveTedtalk(@RequestBody dto: TedtalkDto): TedtalkDto {
        return dto
    }
}