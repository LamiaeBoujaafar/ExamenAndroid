package com.example.examenandroid.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.R
import com.example.examenandroid.adapter.QuestionAdapter
import com.example.examenandroid.model.Chapitre
import com.example.examenandroid.model.DataManager
import com.example.examenandroid.model.QcmDBHelper
import kotlin.collections.HashMap


class QcmQuestionFragment : Fragment(), QuestionAdapter.IAfficheScore {

    var myView : View? = null
    var myAdapter: RecyclerView.Adapter<QuestionAdapter.ViewHolder>? = null
    var recyclerViewChapitre : RecyclerView? = null
    var layoutManager : RecyclerView.LayoutManager? = null
    lateinit var dialog : Dialog
    lateinit var dialogResult : Dialog

    lateinit var myIreset : Ireset

//    init {
//        myIreset = activity as Ireset
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.fragment_qcm_question, container, false)
        return myView
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //      pour recuperer le bundle qui contient le chapitre selectionner
        val args = arguments

        val qcmDBHelper = this.activity?.let { QcmDBHelper(it) }
        val id_chapitre = args?.getParcelable<Chapitre>("chapitre")?.id
        //      recuperer les questions et leurs reponses selon l id du chapitre choisit
        val arrayQuestionReponse = DataManager.recupererQuestionReponse(qcmDBHelper!!, id_chapitre!!)

        //      si l'utlisateur valider ses reponses cette var devient true pour afficher son score ainsi que les reponses correctes
        var afficherResultat = false

        //      map pour stocker les reponses choisi
        val reponses = HashMap<Int, String>()

        //      fonction pour afficher les reponses aleatoirement
        arrayQuestionReponse.shuffle()

        recyclerViewChapitre = myView?.findViewById(R.id.questionRecyclerView)
        layoutManager = LinearLayoutManager(this.activity)
        recyclerViewChapitre?.layoutManager = layoutManager

        //      arrayQuestionReponse : array qui contient les questions ainsi que le reponses du chapitre choisi depuis la BD
        //      reponses: map pour stocker les reponses choisi
        //      afficherResultat : boolean pour tester si l'utilisateur a valide ses reponses
        myAdapter = QuestionAdapter(this.activity, arrayQuestionReponse, reponses, afficherResultat, this)
        recyclerViewChapitre?.adapter = myAdapter

        var validetBtn = myView?.findViewById<Button>(R.id.validetBtn)
        validetBtn?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                dialogResult = myView?.let { Dialog(it?.context) }!!
                dialogResult.setContentView(R.layout.custom_dialog_result)
                dialogResult.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                val revisertBtnDialog = dialogResult.findViewById<Button>(R.id.revisertBtnDialog)
                val validerBtnDialog = dialogResult.findViewById<Button>(R.id.validerBtnDialog)
                val imageView = dialogResult.findViewById<ImageView>(R.id.imageViewClose)
                dialogResult.show()
                revisertBtnDialog.setOnClickListener {
                    val scollView = myView?.findViewById<ScrollView>(R.id.scrollView)
                    scollView?.scrollTo(0, 0);
                    dialogResult.dismiss()
                }
                imageView.setOnClickListener {
                    dialogResult.dismiss()
                }
                validerBtnDialog.setOnClickListener {
//                    val scollView = myView?.findViewById<ScrollView>(R.id.scrollView)
//                    scollView?.scrollTo(0, 0);



                    myAdapter = QuestionAdapter(activity, arrayQuestionReponse, reponses, true, this@QcmQuestionFragment)
                    recyclerViewChapitre?.adapter = myAdapter
                    dialogResult.dismiss()
                    validetBtn.isEnabled = false
                }
            }

        })

        val resetBtn = myView?.findViewById<Button>(R.id.resetBtn)
        resetBtn?.setOnClickListener(View.OnClickListener {
            myIreset = activity as Ireset
            myIreset.reset()
            Log.i("resett", "test")
        })

    }

    override fun afficherScore(score: Int) {
//        val scoreText = myView?.findViewById<TextView>(R.id.scoreText)
//        scoreText?.text = "Votre Score est : $score"
//
//        //      pour revenir en haut
//        val scollView = myView?.findViewById<ScrollView>(R.id.scrollView)
//        scollView?.scrollTo(0, 0);

        dialog = myView?.let { Dialog(it?.context) }!!
        if(score >= 7 )  openWinDialog(score)
        else openLoseDialog(score)

    }

    private fun openWinDialog(score: Int) {
        dialog.setContentView(R.layout.custom_dialog_valider)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val imageView = dialog.findViewById<ImageView>(R.id.imageViewClose)
        val btnOk = dialog.findViewById<Button>(R.id.btnOk)
        val textScore = dialog.findViewById<TextView>(R.id.textScore)
        textScore.text = "Votre score est : $score"
        dialog.show()

        imageView.setOnClickListener {
            dialog.dismiss()

        }
        btnOk.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun openLoseDialog(score: Int) {
        dialog.setContentView(R.layout.custom_dialog_echouer)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val imageView = dialog.findViewById<ImageView>(R.id.imageViewClose)
        val btnOk = dialog.findViewById<Button>(R.id.btnOk)
        val textScore = dialog.findViewById<TextView>(R.id.textScore)
        textScore.text = "Votre score est : $score"
        dialog.show()

        imageView.setOnClickListener {
            dialog.dismiss()

        }
        btnOk.setOnClickListener {
            dialog.dismiss()

        }

    }

    interface Ireset {
        fun reset();
    }


}