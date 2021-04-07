package com.example.examenandroid.model

import android.os.Parcel
import android.os.Parcelable

class Reponse (var id:Int, var reponse: String?,var estCorrecte: Boolean?, var id_question:Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(reponse)
        parcel.writeValue(estCorrecte)
        parcel.writeInt(id_question)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Reponse> {
        override fun createFromParcel(parcel: Parcel): Reponse {
            return Reponse(parcel)
        }

        override fun newArray(size: Int): Array<Reponse?> {
            return arrayOfNulls(size)
        }
    }
}