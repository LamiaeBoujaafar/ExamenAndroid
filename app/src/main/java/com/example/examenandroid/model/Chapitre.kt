package com.example.examenandroid.model

import android.os.Parcel
import android.os.Parcelable

class Chapitre(var id:Int, var titre: String?) :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(titre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Chapitre> {
        override fun createFromParcel(parcel: Parcel): Chapitre {
            return Chapitre(parcel)
        }

        override fun newArray(size: Int): Array<Chapitre?> {
            return arrayOfNulls(size)
        }
    }
}