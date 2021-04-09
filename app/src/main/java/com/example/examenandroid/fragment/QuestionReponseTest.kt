package com.example.examenandroid.fragment

import android.os.Parcel
import android.os.Parcelable

class QuestionReponseTest(var id_question:Int, var question: String?, var choix: Array<String?>, var reponseCorrecte: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.createStringArray() as Array<String?>,
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_question)
        parcel.writeString(question)
        parcel.writeStringArray(choix)
        parcel.writeString(reponseCorrecte)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionReponseTest> {
        override fun createFromParcel(parcel: Parcel): QuestionReponseTest {
            return QuestionReponseTest(parcel)
        }

        override fun newArray(size: Int): Array<QuestionReponseTest?> {
            return arrayOfNulls(size)
        }
    }
}