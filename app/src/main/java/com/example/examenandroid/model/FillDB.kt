package com.example.examenandroid.model

import android.content.Context

class FillDB (){
    companion object{
        fun FillUser(myQcmHelper : QcmDBHelper){
            DataManager.ajouterUser(myQcmHelper,User(1,"lamiae","lamiae","lamiae20ber@gmail.com"))
            DataManager.ajouterUser(myQcmHelper,User(2,"sakhr","sakhr","sakhr@gmail.com"))

        }
        fun FillChapitre(myQcmHelper : QcmDBHelper){
            DataManager.ajouterChapitre(myQcmHelper, Chapitre(1,"Introduction au développement Android avec Android Studio"))
            DataManager.ajouterChapitre(myQcmHelper, Chapitre(2,"Introduction au langage Kotlin"))
            DataManager.ajouterChapitre(myQcmHelper, Chapitre(3,"Cycle de vie d'une activité"))
            DataManager.ajouterChapitre(myQcmHelper, Chapitre(4,"Les fragments"))
            DataManager.ajouterChapitre(myQcmHelper, Chapitre(5,"Stockage et SQLite"))
        }
        fun FillReponse(myQcmHelper : QcmDBHelper){
            //CHAPITRE 1
            //REPONSE DE QUESTION 1
            DataManager.ajouterReponses(myQcmHelper,Reponse(1,"Un service d'exploitation mobile",true,1))
            DataManager.ajouterReponses(myQcmHelper,Reponse(2,"Un service d'exploitation desktop",false,1))
            DataManager.ajouterReponses(myQcmHelper,Reponse(3,"Un service d'exploitation web",false,1))
            //REPONSE DE QUESTION 2
            DataManager.ajouterReponses(myQcmHelper,Reponse(4,"Juin 2007",true,2))
            DataManager.ajouterReponses(myQcmHelper,Reponse(5,"Juin 2010",false,2))
            DataManager.ajouterReponses(myQcmHelper,Reponse(6,"Juin 20012",false,2))
            //REPONSE DE QUESTION 3
            DataManager.ajouterReponses(myQcmHelper,Reponse(7,"non",false,3))
            DataManager.ajouterReponses(myQcmHelper,Reponse(8,"oui",true,3))
            DataManager.ajouterReponses(myQcmHelper,Reponse(9,"Je ne sais pas",false, 3))
            //REPONSE DE QUESTION 4
            DataManager.ajouterReponses(myQcmHelper,Reponse(10,"Plusieurs écrans d’interface apparaitront dans votre application",false,4))
            DataManager.ajouterReponses(myQcmHelper,Reponse(11,"Aucune des réponses ci-dessus",false,4))
            DataManager.ajouterReponses(myQcmHelper,Reponse(12,"Un seul écran d’interface utilisateur qui apparait dans votre application",true,4))
            //REPONSE DE QUESTION 5
            DataManager.ajouterReponses(myQcmHelper,Reponse(13,"Service",false,5))
            DataManager.ajouterReponses(myQcmHelper,Reponse(14,"Activity",true,5))
            DataManager.ajouterReponses(myQcmHelper,Reponse(15,"Content Provider",false,5))
            //REPONSE DE QUESTION 6
            DataManager.ajouterReponses(myQcmHelper,Reponse(16,"Aucune des réponses ci-dessus",false,6))
            DataManager.ajouterReponses(myQcmHelper,Reponse(17,"Sur un serveur via REST",false,6))
            DataManager.ajouterReponses(myQcmHelper,Reponse(18,"Avec SQlite",true,6))
            //REPONSE DE QUESTION 7
            DataManager.ajouterReponses(myQcmHelper,Reponse(19,"Décrit la configuration de l'application Android ",true,7))
            DataManager.ajouterReponses(myQcmHelper,Reponse(20,"Décrit en xml l'interface graphique de l'application Android ",false,7))
            DataManager.ajouterReponses(myQcmHelper,Reponse(21,"Décrit les redirections à effectuer lorsqu'une erreur d'exécution se produit",false,7))
            //REPONSE DE QUESTION 8
            DataManager.ajouterReponses(myQcmHelper,Reponse(22,"Button bt = (Button) findViewbyId(R.layout.mon_bouton); ",false,8))
            DataManager.ajouterReponses(myQcmHelper,Reponse(23,"Button bt = (Button) findViewbyId(R.id.mon_bouton);",true,8))
            DataManager.ajouterReponses(myQcmHelper,Reponse(24,"Button bt = (Button) findViewbyId(R.main.mon_bouton);",false,8))
            //REPONSE DE QUESTION 9
            DataManager.ajouterReponses(myQcmHelper,Reponse(25,"JDK",true,9))
            DataManager.ajouterReponses(myQcmHelper,Reponse(26,"JVM",false,9))
            DataManager.ajouterReponses(myQcmHelper,Reponse(27,"JRE",false,9))
            //REPONSE DE QUESTION 10
            DataManager.ajouterReponses(myQcmHelper,Reponse(28,"JRE",false,10))
            DataManager.ajouterReponses(myQcmHelper,Reponse(29,"JDK",false,10))
            DataManager.ajouterReponses(myQcmHelper,Reponse(30,"JVM",true,10))
        }
        fun FillQuestion(myQcmHelper : QcmDBHelper){
            //AJOUTER QUESTIONS POUR CHAPITRE 1
            DataManager.ajouterQuestion(myQcmHelper, Question(1,"Qu'est-ce qu'Android?",1))
            DataManager.ajouterQuestion(myQcmHelper, Question(2,"Android est lancé en ?",1))
            DataManager.ajouterQuestion(myQcmHelper, Question(3,"Pouvez-vous développé une application Android en java ?",1))
            DataManager.ajouterQuestion(myQcmHelper, Question(4,"Qu’est-ce qu’une activité?",1))
            DataManager.ajouterQuestion(myQcmHelper, Question(5,"Quels sont les composants ci-dessous qui existent sous Android?",1))
            DataManager.ajouterQuestion(myQcmHelper, Question(6,"Comment peut-on stocker une données sus Android?",1))
            DataManager.ajouterQuestion(myQcmHelper, Question(7,"Le fichier AndroidManifest.xml d'une application Android ",1))
            DataManager.ajouterQuestion(myQcmHelper, Question(8,"Comment récuperer l ID de ce composant ?" +
                    "<Button   ...   android:id='@+id/mon_bouton'    ...   />",1))
            DataManager.ajouterQuestion(myQcmHelper, Question(9,"Quel composant est utilisé pour compiler, déboguer et exécuter un programme en Java ?",1))
            DataManager.ajouterQuestion(myQcmHelper, Question(10,"Quel composant est responsable de la conversion de byte-codes en code spécifique à ",1))

            //AJOUTER QUESTIONS POUR CHAPITRE 2
            DataManager.ajouterQuestion(myQcmHelper, Question(11,"Peut-on faire coexister du code écrit en Java ET en Kotlin dans un même projet ? ",2))
            DataManager.ajouterQuestion(myQcmHelper, Question(12,"Je souhaite déclarer une variable qui ne pourra pas être modifiée une fois initialisée. Quelle réponse correspondrait le mieux à mon besoin ?",2))
            DataManager.ajouterQuestion(myQcmHelper, Question(13," Je souhaite créer une variable pouvant possiblement contenir une valeur nulle. Quelle réponse correspondrait le mieux à mon besoin ?",2))
            DataManager.ajouterQuestion(myQcmHelper, Question(14,"J'aimerais créer une fonction qui renvoie un nom d'utilisateur en majuscule. Quelle est la meilleure solution en Kotlin ?",2))
            DataManager.ajouterQuestion(myQcmHelper, Question(15,"Le modificateur de visibilité  public  est-il obligatoire devant le mot-clé  class  ?",2))
            DataManager.ajouterQuestion(myQcmHelper, Question(16,"Qu’affichera l’instruction suivante « var i = 0 while(i<3){print(i)} »  ?",2))
            DataManager.ajouterQuestion(myQcmHelper, Question(17,"Qu’affichera l’instruction suivante « for(i..50 step 5) println(i) »?",2))
            DataManager.ajouterQuestion(myQcmHelper, Question(18,"Quel est la différence entre une liste de type  List  et une liste de type  MutableList  ?",2))
            DataManager.ajouterQuestion(myQcmHelper, Question(19,"Comment on declare un variable en Kotlin ?",2))
            DataManager.ajouterQuestion(myQcmHelper, Question(20," Y a-t-il un opérateur conditionnel ternaire dans Kotlin comme en Java?",2))
        }
    }
}