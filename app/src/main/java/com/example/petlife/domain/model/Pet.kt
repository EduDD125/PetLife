package com.example.petlife.domain.model

import java.time.LocalDate
import java.util.Date

class Pet(
    var name: String,
    var color: String,
    var birthDate: String,
    var size: String,
    var type: String,
    var petsCares: List<Care>
) {
    fun setName(newName: String) {
        name = newName
    }
    fun getName(): String {
        return name
    }
    fun setColor(newColor: String) {
        color = newColor
    }
    fun getColor(): String {
        return color
    }
    fun setBirthdate(newBirthDate: String) {
        birthDate = newBirthDate
    }
    fun getBirthdate(): String {
        return birthDate
    }
    fun setSize(newSize: String) {
        size = newSize
    }
    fun getSize(): String {
        return size
    }
    fun setType(newType: String) {
        type = newType
    }
    fun getType(): String {
        return type
    }
    fun getPetYearsOld(): Int {
        return LocalDate.now().year - birthDate.takeLast(4).toInt()
    }
    fun getPetsCares(): List<Care> {
        return petsCares;
    }
    fun getCareLastVisityOfAType (type: CareType): Care? {
        return petsCares.filter { petCare -> petCare.type == type }
            .maxByOrNull { it.date }
    }
}