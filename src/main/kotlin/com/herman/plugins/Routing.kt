package com.herman.plugins

import com.herman.routes.*
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        addNewArticle()
        allArticles()
        deleteArticle()
    }
}
