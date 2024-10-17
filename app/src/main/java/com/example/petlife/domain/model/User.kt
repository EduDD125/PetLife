package com.example.petlife.domain.model

class User(
    var name: String,
    var email: String,
    var password: String,
    var pets: List<Pet>,
) {
}