package com.io.tedtalk.talks

import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root


@Repository
class TedTalkRepositoryImpl : TedTalkRepositoryCustom {

    @PersistenceContext protected lateinit var entityManager: EntityManager
    override fun findTedTalksByAuthorAndTitleAndViewsAndLikes(
        author: String?,
        title: String?,
        views: Long?,
        likes: Long?
    ): List<Tedtalk> {
        val builder: CriteriaBuilder = entityManager.criteriaBuilder
        val query: CriteriaQuery<Tedtalk> = builder.createQuery(Tedtalk::class.java)
        val tedTalk: Root<Tedtalk> = query.from(Tedtalk::class.java)

        val predicates: MutableList<Predicate> = ArrayList<Predicate>()
        if (StringUtils.hasText(author)) {
            predicates.add(builder.like(tedTalk.get("author"), "author%"))
        }
        if (StringUtils.hasText(title)) {
            predicates.add(builder.like(tedTalk.get("title"), "title%"))
        }
        if (views != null) {
            predicates.add(builder.greaterThanOrEqualTo(tedTalk.get("views"), views))
        }
        if (likes != null) {
            predicates.add(builder.greaterThanOrEqualTo(tedTalk.get("likes"), likes))
        }
        query.where(*predicates.toTypedArray())
        return entityManager.createQuery(query).resultList
    }
}
