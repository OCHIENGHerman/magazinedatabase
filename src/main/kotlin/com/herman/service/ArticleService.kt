package com.herman.service

import com.herman.models.Article
import com.herman.models.ArticleEntity
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.transactions.transaction

class ArticleService {
    fun allArticles(): List<Article> = transaction {
        ArticleEntity.all().map(ArticleEntity::toArticle)
    }
    fun addNewArticle(article: Article) = transaction {
        ArticleEntity.new {
            this.title = article.title
            this.body = article.body
        }
    }
    fun deleteArticle(articleId: Int) = transaction {
        ArticleEntity[articleId].delete()
    }
}
val articleService = ArticleService().apply {
    runBlocking {

    }
}
