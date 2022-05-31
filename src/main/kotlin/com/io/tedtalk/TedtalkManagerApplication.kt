package com.io.tedtalk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class TedtalkManagerApplication

fun main(args: Array<String>) {
	runApplication<TedtalkManagerApplication>(*args)
}
