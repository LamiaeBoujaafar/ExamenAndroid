package com.example.examenandroid.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.R
import com.example.examenandroid.fragment.QuestionReponseTest
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class QuestionAdapter(context: FragmentActivity?, private val qcmArray: ArrayList<QuestionReponseTest>, private val reponses: HashMap<Int, String>, private val afficherResultat:Boolean, afficherScore:IAfficheScore) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {
    var score = 0
    var myActivity : IAfficheScore = afficherScore

    init {
        if(afficherResultat) {
            for (i in qcmArray.indices) {
                if (qcmArray[i].reponseCorrecte == reponses[i]) score++
            }

            myActivity.afficherScore(score)
        }
        var reponses= mapOf<Int, String>()
        var myOnRadioItemClickListener : IAfficheScore

    }
    interface IAfficheScore
    {
        fun afficherScore(score:Int)
    }


    inner class ViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val questionText:TextView = itemView.findViewById(R.id.textQuestion)
        val radioGroup:RadioGroup = itemView.findViewById(R.id.radioGroupQuestion)
        val radioButtonChoix1:RadioButton = itemView.findViewById(R.id.radioButtonChoix1Qst)
        val radioButtonChoix2:RadioButton = itemView.findViewById(R.id.radioButtonChoix2Qst)
        val radioButtonChoix3:RadioButton = itemView.findViewById(R.id.radioButtonChoix3Qst)

        init {

            radioButtonChoix1.setOnClickListener(this)
            radioButtonChoix2.setOnClickListener(this)
            radioButtonChoix3.setOnClickListener(this)
            itemView.setOnClickListener { view -> Log.i("ddd", "tr") }
        }

        override fun onClick(v: View?) {
            //Log.i("onClicks", v.toString())
            val p = getAdapterPosition();
            var s : String = ""
            if(radioButtonChoix1.isPressed) {
                reponses.put(p, radioButtonChoix1.text.toString())
            }
            if(radioButtonChoix2.isPressed) {
                reponses.put(p, radioButtonChoix2.text.toString())
            }
            if(radioButtonChoix3.isPressed){
                reponses.put(p, radioButtonChoix3.text.toString())
            }

            Log.i("choix", "-------------------------")

            val t:Boolean = (s == qcmArray[p].reponseCorrecte)
            Log.i("choix", qcmArray[p].reponseCorrecte + "|" + qcmArray[p].reponseCorrecte?.length + "     " + t)
            Log.i("choix", "")
            Log.i("choix", "*****************************************************")
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        Log.i("score", score.toString())
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_question_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.setIsRecyclable(false)
        viewHolder.questionText.text = "${position+1}- " + qcmArray[position].question
        viewHolder.radioGroup.id +=  qcmArray[position].id_question
        viewHolder.itemView.tag = "$viewHolder.radioGroup.id"
        Log.i("qstA", qcmArray[0].question.toString())

        val choix:ArrayList<String> = ArrayList<String>(qcmArray[position].choix.asList())
        Log.i("listi", choix.toList().toString())
        Collections.shuffle(choix)

        viewHolder.radioButtonChoix1.text = choix[0]
        viewHolder.radioButtonChoix2.text = choix[1]
        viewHolder.radioButtonChoix3.text = choix[2]

        if(reponses.containsKey(position)){
            when(reponses[position]) {
                viewHolder.radioButtonChoix1.text -> viewHolder.radioButtonChoix1.isChecked = true
                viewHolder.radioButtonChoix2.text -> viewHolder.radioButtonChoix2.isChecked = true
                viewHolder.radioButtonChoix3.text -> viewHolder.radioButtonChoix3.isChecked = true
            }
        }


        // Si l'utulisateur voudra afficher son score
        if(afficherResultat) {

            viewHolder.radioButtonChoix1.isEnabled = false
            viewHolder.radioButtonChoix2.isEnabled = false
            viewHolder.radioButtonChoix3.isEnabled = false

            if (qcmArray[position].reponseCorrecte != reponses[position]) {
                Log.i("posis", position.toString() + "    " + qcmArray[position].reponseCorrecte + "          " + reponses[position])
                when (reponses[position]) {
                    viewHolder.radioButtonChoix1.text.toString() -> {
                        viewHolder.radioButtonChoix1.setTextColor(Color.RED)
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            viewHolder.radioButtonChoix3.buttonTintList = ColorStateList.valueOf(Color.RED)
                        }
                    }
                    viewHolder.radioButtonChoix2.text.toString() -> {
                        viewHolder.radioButtonChoix2.setTextColor(Color.RED)
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            viewHolder.radioButtonChoix3.buttonTintList = ColorStateList.valueOf(Color.RED)
                        }
                    }
                    viewHolder.radioButtonChoix3.text.toString() -> {
                        viewHolder.radioButtonChoix3.setTextColor(Color.RED)
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            viewHolder.radioButtonChoix3.buttonTintList = ColorStateList.valueOf(Color.RED)
                        }
                    }
                    null -> {
                        viewHolder.radioButtonChoix1.setTextColor(Color.RED)
                        viewHolder.radioButtonChoix2.setTextColor(Color.RED)
                        viewHolder.radioButtonChoix3.setTextColor(Color.RED)
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            viewHolder.radioButtonChoix1.buttonTintList = ColorStateList.valueOf(Color.RED)
                            viewHolder.radioButtonChoix2.buttonTintList = ColorStateList.valueOf(Color.RED)
                            viewHolder.radioButtonChoix3.buttonTintList = ColorStateList.valueOf(Color.RED)
                        }
                    }
                }
            }

            when (qcmArray[position].reponseCorrecte) {
                viewHolder.radioButtonChoix1.text.toString() -> {
                    viewHolder.radioButtonChoix1.isChecked = true
                    viewHolder.radioButtonChoix1.setTextColor(Color.GREEN)
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        viewHolder.radioButtonChoix1.buttonTintList = ColorStateList.valueOf(Color.GREEN)
                    }
                }
                viewHolder.radioButtonChoix2.text.toString() -> {
                    viewHolder.radioButtonChoix2.isChecked = true
                    viewHolder.radioButtonChoix2.setTextColor(Color.GREEN)
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        viewHolder.radioButtonChoix2.buttonTintList = ColorStateList.valueOf(Color.GREEN)
                    }
                }
                viewHolder.radioButtonChoix3.text.toString() -> {
                    viewHolder.radioButtonChoix3.isChecked = true
                    viewHolder.radioButtonChoix3.setTextColor(Color.GREEN)
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        viewHolder.radioButtonChoix3.buttonTintList = ColorStateList.valueOf(Color.GREEN)
                    }
                }
            }


        }

        Log.i("test12", viewHolder.radioButtonChoix3.text.toString())

//        viewHolder.radioButtonChoix1.id += qcmArray[position].id_question
//        viewHolder.radioButtonChoix2.id += qcmArray[position].id_question
//        viewHolder.radioButtonChoix3.id += qcmArray[position].id_question

    }

    override fun getItemCount(): Int {
        return qcmArray.size
    }

}