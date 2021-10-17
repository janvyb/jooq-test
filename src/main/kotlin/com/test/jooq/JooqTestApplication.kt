package com.test.jooq

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JooqTestApplication

fun main(args: Array<String>) {
    runApplication<JooqTestApplication>(*args)
}
