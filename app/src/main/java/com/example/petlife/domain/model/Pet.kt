package com.example.petlife.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Pet(
    val name: String,
    val breed: String,
    val birthDate: String,
    val size: String,
    val type: String,
    val color: String,
    val lastVetVisit: String,
    val lastVaccination: String,
    val lastPetshopVisit: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "" ,
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(breed)
        parcel.writeString(birthDate)
        parcel.writeString(size)
        parcel.writeString(color)
        parcel.writeString(type)
        parcel.writeString(lastVetVisit)
        parcel.writeString(lastVaccination)
        parcel.writeString(lastPetshopVisit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pet> {
        override fun createFromParcel(parcel: Parcel): Pet {
            return Pet(parcel)
        }

        override fun newArray(size: Int): Array<Pet?> {
            return arrayOfNulls(size)
        }
    }
}
