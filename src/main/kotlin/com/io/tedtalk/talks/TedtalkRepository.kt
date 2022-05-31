package com.io.tedtalk.talks

import org.springframework.data.repository.CrudRepository

interface TedtalkRepository : CrudRepository<Tedtalk, String>, TedTalkRepositoryCustom {

}