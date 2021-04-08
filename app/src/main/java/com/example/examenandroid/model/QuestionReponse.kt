package com.example.examenandroid.model

import android.os.Parcel
import android.os.Parcelable

class QuestionReponse( var id_question:Int,var question: String?,var choix1 : String?,var choix2 : String?,var choix3 : String?,var reponseCorrecte : String?):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_question)
        parcel.writeString(question)
        parcel.writeString(choix1)
        parcel.writeString(choix2)
        parcel.writeString(choix3)
        parcel.writeString(reponseCorrecte)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionReponse> {
        override fun createFromParcel(parcel: Parcel): QuestionReponse {
            return QuestionReponse(parcel)
        }

        override fun newArray(size: Int): Array<QuestionReponse?> {
            return arrayOfNulls(size)
        }
    }

}