package io.chaman.im.data

data class Employee(
        var employeeNumber: Int = 0,
        var firstName: String = "",
        var lastName: String = "",
        var department: String = "",
        var imageUrl: String = ""
)