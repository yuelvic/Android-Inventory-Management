package io.chaman.im.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class Employee(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @ColumnInfo(name = "employee_number")
        var employeeNumber: Int = 0,
        @ColumnInfo(name = "first_name")
        var firstName: String = "",
        @ColumnInfo(name = "last_name")
        var lastName: String = "",
        @ColumnInfo(name = "department")
        var department: String = "",
        @ColumnInfo(name = "image_url")
        var imageUrl: String = "",
        @ColumnInfo(name = "role")
        var role: String = ""
)