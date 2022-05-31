package com.io.tedtalk.model

import lombok.Getter
import lombok.Setter
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_TEDTALK")
@Getter
@Setter
class Tedtalk(
    @Id
    @Column(name = "TEDTALK_ID", length=36)
    var tedtalkId: String,
    @Column(name = "TITLE")
    var title: String,
    @Column(name = "DATE")
    var date: String,
    @Column(name = "AUTHOR")
    var author: String,
    @Column(name = "VIEWS")
    var views: Long,
    @Column(name = "LIKES")
    var likes: Long,
    @Column(name = "LINK")
    var link: String,
)
