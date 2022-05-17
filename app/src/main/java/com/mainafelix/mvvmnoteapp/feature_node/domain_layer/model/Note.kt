package com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note (
    val title:String,
    val content :String,
    val timeStamp: Long,
    val  color:Int,
    @PrimaryKey val id:Int?= null
        ){
}