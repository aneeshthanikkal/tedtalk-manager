package com.io.tedtalk.repository

import com.io.tedtalk.model.Tedtalk
import org.springframework.data.repository.CrudRepository

interface TedtalkRepository : CrudRepository<Tedtalk, String>, TedTalkRepositoryCustom {

}