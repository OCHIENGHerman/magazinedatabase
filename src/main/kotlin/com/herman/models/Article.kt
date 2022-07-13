package com.herman.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

@Serializable

data class Article(val id: Int, val title: String, val body: String)


object Articles : IntIdTable() {
    val title = varchar("title", 128)
    val body = varchar("body", 1024)
}
class ArticleEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ArticleEntity>(Articles)
    var title by Articles.title
    var body by Articles.body
    override fun toString(): String = "Article($title, $body)"
    fun toArticle() = Article(id.value, title, body)
}


