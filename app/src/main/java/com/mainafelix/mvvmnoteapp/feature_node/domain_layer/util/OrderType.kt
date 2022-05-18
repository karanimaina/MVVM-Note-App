package com.mainafelix.mvvmnoteapp.feature_node.domain_layer.util

sealed class OrderType{
    // the order type will be descending or ascending
    object Ascending:OrderType()
    object Descending:OrderType()
}
