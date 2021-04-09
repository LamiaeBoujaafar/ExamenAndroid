package com.example.examenandroid.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.R
import com.example.examenandroid.SecondeActivity
import com.example.examenandroid.fragment.QuestionReponseTest
import com.example.examenandroid.model.QuestionReponse
import java.util.*
import kotlin.collections.ArrayList

class QuestionAdapter(context: FragmentActivity?, private val qcmArray: ArrayList<QuestionReponseTest>) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    init {

    }
    var count = 1

    inner class ViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
        val questionText:TextView = itemView.findViewById(R.id.textQuestion)
        val radioGroup:RadioGroup = itemView.findViewById(R.id.radioGroupQuestion)
        val radioButtonChoix1:RadioButton = itemView.findViewById(R.id.radioButtonChoix1Qst)
        val radioButtonChoix2:RadioButton = itemView.findViewById(R.id.radioButtonChoix2Qst)
        val radioButtonChoix3:RadioButton = itemView.findViewById(R.id.radioButtonChoix3Qst)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_question_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.questionText.text = "$count- " + qcmArray[position].question
        viewHolder.radioGroup.id +=  qcmArray[position].id_question
        count += 1

        val choix:ArrayList<String> = ArrayList<String>(qcmArray[position].choix.asList())
        Log.i("listi", choix.toList().toString())
        Collections.shuffle(choix)

        viewHolder.radioButtonChoix1.text = choix[0]
        viewHolder.radioButtonChoix2.text = choix[1]
        viewHolder.radioButtonChoix3.text = choix[2]

        viewHolder.radioButtonChoix1.id += qcmArray[position].id_question
        viewHolder.radioButtonChoix2.id += qcmArray[position].id_question
        viewHolder.radioButtonChoix3.id += qcmArray[position].id_question

    }

    override fun getItemCount(): Int {
        return qcmArray.size
    }
}