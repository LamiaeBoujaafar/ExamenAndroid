package com.example.examenandroid.model

import android.os.Parcel
import android.os.Parcelable

class QuestionReponse(var id_question:Int, var question: String?, var id_chapitre:Int,var id_reponse:Int, var reponse: String?,var estCorrecte: Boolean?):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readValue(Boolean::class.java.classLoader) as? Boolean) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_question)
        parcel.writeString(question)
        parcel.writeInt(id_chapitre)
        parcel.writeInt(id_reponse)
        parcel.writeString(reponse)
        parcel.writeValue(estCorrecte)
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