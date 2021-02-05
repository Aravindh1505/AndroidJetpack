package com.aravindh.androidjetpack.ui.login

data class EmployeesResponse(
    val status: String?,
    val `data`: List<Data?>?,
    val message: String?
) {
    data class Data(
        val id: Int?,
        val employee_name: String?,
        val employee_salary: Int?,
        val employee_age: Int?,
        val profile_image: String?
    )
}