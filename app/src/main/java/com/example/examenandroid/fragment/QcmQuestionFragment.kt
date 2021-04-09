package com.example.examenandroid.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Build
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.R
import com.example.examenandroid.SecondeActivity
import com.example.examenandroid.adapter.QuestionAdapter
import com.example.examenandroid.model.Chapitre
import com.example.examenandroid.model.DataManager
import com.example.examenandroid.model.QcmDBHelper
import com.example.examenandroid.model.QuestionReponse
import android.widget.Toast


class QcmQuestionFragment : Fragment() {

    var myView : View? = null
    var myAdapter: RecyclerView.Adapter<QuestionAdapter.ViewHolder>? = null
    var recyclerViewChapitre : RecyclerView? = null
    var layoutManager : RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_qcm_question, container, false)
        return myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val arrayQuestionReponse = ArrayList<QuestionReponse>()
        val args = arguments

        val qcmDBHelper = this.activity?.let { QcmDBHelper(it) }
        val id_chapitre = args?.getParcelable<Chapitre>("chapitre")?.id
        val arrayQuestionReponse = DataManager.recupererQuestionReponse(qcmDBHelper!!, id_chapitre!!)



//        val questionReponse1 = QuestionReponse(1, "question 1","choix 1", "choix 2", "choix 3", "choix 1")
//        val questionReponse2 = QuestionReponse(2, "question 2","choix 1", "choix 2", "choix 3", "choix 2")
//        val questionReponse3 = QuestionReponse(3, "question 3","choix 1", "choix 2", "choix 3", "choix 3")
//        arrayQuestionReponse.add(questionReponse1)
//        arrayQuestionReponse.add(questionReponse2)
//        arrayQuestionReponse.add(questionReponse3)
//        arrayQuestionReponse.add(questionReponse1)
//        arrayQuestionReponse.add(questionReponse2)
//        arrayQuestionReponse.add(questionReponse3)

        recyclerViewChapitre = myView?.findViewById(R.id.questionRecyclerView)

        layoutManager = LinearLayoutManager(this.activity)
        recyclerViewChapitre?.layoutManager = layoutManager
        myAdapter = QuestionAdapter(this.activity as FragmentActivity?, arrayQuestionReponse)
        recyclerViewChapitre?.adapter = myAdapter
//        if(args != null){
//            Log.i("qcm", args.getParcelable<Chapitre>("chapitre")?.id.toString())
//        }
        var validetBtn = myView?.findViewById<Button>(R.id.validetBtn)
            validetBtn?.setOnClickListener {
                val builder = AlertDialog.Builder(this.activity)
                builder.setTitle("Validez-vous vos réponses")
                builder.setMessage("Voulez-vous vraiment valider vos réponses ?")

                builder.setNegativeButton(android.R.string.no) { dialog, which ->
                    Toast.makeText(this.context,
                        android.R.string.no, Toast.LENGTH_SHORT).show()
                }
                builder.setNeutralButton("Résultat") { dialog, which ->
                    Toast.makeText(this.context,
                        "Résultat", Toast.LENGTH_SHORT).show()
                }
                builder.show()
            }
    }

    interface ShowFrag{
        fun afficherFrag()
    }

}