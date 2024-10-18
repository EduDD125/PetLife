package com.example.petlife.domain.model

import java.time.LocalDate
import java.util.Date

class Pet(
    var name: String,
    var color: String,
    var birthDate: String,
    var size: String,
    var type: String,
    var lastPetshopVisit: String,
    var lastVeterinarianVisit: String,
    var lastVaccination: String
) {
    fun setPetName(newName: String) {
        name = newName
    }
    fun getPetName(): String {
        return name
    }
    fun setPetColor(newColor: String) {
        color = newColor
    }
    fun getPetColor(): String {
        return color
    }
    fun setPetBirthdate(newBirthDate: String) {
        birthDate = newBirthDate
    }
    fun getPetBirthdate(): String {
        return birthDate
    }
    fun setPetSize(newSize: String) {
        size = newSize
    }
    fun getPetSize(): String {
        return size
    }
    fun setPetType(newType: String) {
        type = newType
    }
    fun getPetType(): String {
        return type
    }
    fun getPetYearsOld(): Int {
        return LocalDate.now().year - birthDate.takeLast(4).toInt()
    }
    fun setPetLastPetshopVisit(newDate: String) {
        lastPetshopVisit = newDate
    }
    fun getPetLastPetshopVisit(): String {
        return lastPetshopVisit
    }
    fun setPetLastVeterinariaVisit(newDate: String) {
        lastVeterinarianVisit = newDate
    }
    fun getPetLastVeterinarianVisit(): String {
        return lastVeterinarianVisit
    }
    fun setPetLastVaccination(newDate: String) {
        lastVaccination = newDate
    }
    fun getPetLastVaccination(): String {
        return lastVaccination
    }
}