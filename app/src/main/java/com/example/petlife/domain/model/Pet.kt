package com.example.petlife.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Pet(
    var name: String,
    var birthDate: String,
    var size: String,
    var type: String,
    var color: String,
    var lastVetVisit: String,
    var lastVaccination: String,
    var lastPetshopVisit: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
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
