package com.herman.routes

import com.herman.models.Article
import com.herman.service.articleService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.allArticles() {

        get("/api/v1/articles") {
            val allArticle = articleService.allArticles()
            call.respond(allArticle)
        }
    }

fun Route.addNewArticle() {
    post("/api/v1/article") {
        val articleRequest = call.receive<Article>()
        articleService.addNewArticle(articleRequest)
        call.respond(HttpStatusCode.Accepted)
    }
}



fun Route.deleteArticle() {
    delete("/api/v1/article/{id}") {
        val articleId = call.parameters.getOrFail<Int>("id").toInt()
        articleService.deleteArticle(articleId)
        call.respond(HttpStatusCode.OK)
    }
}
