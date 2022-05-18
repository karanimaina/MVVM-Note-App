package com.mainafelix.mvvmnoteapp.feature_node.domain_layer.util;

sealed class NoteOrder(val orderType: OrderType ) {
    //orders by title, ascending,descendimg
    class Title(orderType: OrderType):NoteOrder(orderType)
    class Date(orderType: OrderType):NoteOrder(orderType)
    class Color(orderType: OrderType):NoteOrder(orderType)
}
