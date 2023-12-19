package com.example.proyecto_ppg

import android.os.Parcel
import android.os.Parcelable

data class Personaje(
    private var nombre: String?,
    private var estadoVital: String?,
    private var raza: String?,
    private var clase: String?,

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(estadoVital)
        parcel.writeString(raza)
        parcel.writeString(clase)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Personaje> {
        override fun createFromParcel(parcel: Parcel): Personaje {
            return Personaje(parcel)
        }

        override fun newArray(size: Int): Array<Personaje?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "Personaje(nombre=$nombre, estadoVital=$estadoVital, raza=$raza, clase=$clase)"
    }
}