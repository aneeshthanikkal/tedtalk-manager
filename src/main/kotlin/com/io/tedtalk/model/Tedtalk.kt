package com.io.tedtalk.model

import lombok.Getter
import lombok.Setter
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "T_TEDTALK")
@Getter
@Setter
class Tedtalk(
    @Id
    var tedtalkId: String,
    var title: String,
    var date: String,
    var author: String,
    var views: Long,
    var likes: Long,
    var link: String,
)
