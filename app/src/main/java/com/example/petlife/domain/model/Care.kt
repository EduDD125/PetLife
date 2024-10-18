package com.example.petlife.domain.model

import java.time.LocalDate

class Care(
    private var date: LocalDate,
    private var type: CareType,
    private var description: String
) {
    fun seCareDate(newDate: LocalDate) {
        date = newDate
    }
    fun getCareDate(): LocalDate {
        return date
    }
    fun setCareType(newType: CareType) {
        type = newType
    }
    fun getCareType(): CareType {
        return type
    }
    fun setCareDescription(newDescription: String) {
        description = newDescription
    }
    fun getCareDescription(): String {
        return description
    }
}