package com.example.petlife.domain.model

import java.time.LocalDate

class Care(
    var date: LocalDate,
    var type: CareType,
    var description: String
) {
    fun seDate(newDate: LocalDate) {
        date = newDate
    }
    fun getDate(): LocalDate {
        return date
    }
    fun setType(newType: CareType) {
        type = newType
    }
    fun getType(): CareType {
        return type
    }
    fun setDescription(newDescription: String) {
        description = newDescription
    }
    fun getDescription(): String {
        return description
    }
}