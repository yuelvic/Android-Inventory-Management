package io.chaman.im.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "request")
data class Request(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @ColumnInfo(name = "employee_id")
        var employeeId: Int = 0,
        @ColumnInfo(name = "name")
        var name: String = "",
        @ColumnInfo(name = "last_requested")
        var lastRequested: Long = 0,
        @ColumnInfo(name = "requested")
        var requested: Int = 0,
        @ColumnInfo(name = "quantity")
        var quantity: Int = 0,
        @ColumnInfo(name = "unit")
        var unit: String = "",
        @ColumnInfo(name = "safety_stock")
        var safetyStock: Int = 0,
        @ColumnInfo(name = "price")
        var price: Double = 0.0,
        @ColumnInfo(name = "extended_price")
        var extendedPrice: Double = 0.0
)