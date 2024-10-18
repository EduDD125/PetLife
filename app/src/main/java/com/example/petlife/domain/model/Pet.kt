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
    fun setLastPetshopVisit(newDate: String) {
        lastPetshopVisit = newDate
    }
    fun getLastPetshopVisit(): String {
        return lastPetshopVisit
    }
    fun setLastVeterinariaVisit(newDate: String) {
        lastVeterinarianVisit = newDate
    }
    fun getLastVeterinarianVisit(): String {
        return lastVeterinarianVisit
    }
    fun setLastVaccination(newDate: String) {
        lastVaccination = newDate
    }
    fun getLastVaccination(): String {
        return lastVaccination
    }
}