package com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mainafelix.mvvmnoteapp.ui.theme.*

@Entity
class Note (
    val title:String,
    val content :String,
    val timeStamp: Long,
    val  color:Int,
    @PrimaryKey val id:Int?= null
        ){
    companion object{
        //create   a hard coded list a node can posibly have
          val noteColor = listOf(RedOrange, lightGreen, violet,BabyBlue , redPink)

    }
}