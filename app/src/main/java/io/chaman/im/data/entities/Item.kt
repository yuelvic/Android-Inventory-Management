package io.chaman.im.data.entities

data class Item(
        var imageUrl: String = "",
        var name: String = "",
        var barCode: String = "",
        var quantity: Int = 0,
        var description: String = "",
        var price: Double = 0.0,
        var remainingSupply: Int = 0
)