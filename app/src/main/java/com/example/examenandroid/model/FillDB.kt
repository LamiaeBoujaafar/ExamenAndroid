package com.example.examenandroid.model

import android.content.Context

class FillDB (){
    companion object{
        fun FillUser(myQcmHelper : QcmDBHelper){
            DataManager.ajouterUser(myQcmHelper,User(1,"lamiae","lamiae","lamiae20ber@gmail.com"))
            DataManager.ajouterUser(myQcmHelper,User(2,"sakhr","sakhr","sakhr@gmail.com"))
            DataManager.ajouterUser(myQcmHelper,User(3,"prof","prof","prof@gmail.com"))

        }
        fun FillChapitre(myQcmHelper : QcmDBHelper){
            DataManager.ajouterChapitre(myQcmHelper, Chapitre(1,"Introduction au développement Android avec Android Studio"))
            DataManager.ajouterChapitre(myQcmHelper, Chapitre(2,"Introduction au langage Kotlin"))
            DataManager.ajouterChapitre(myQcmHelper, Chapitre(3,"Les activitées"))
            DataManager.ajouterChapitre(myQcmHelper, Chapitre(4,"Stockage et SQLite"))
            DataManager.ajouterChapitre(myQcmHelper, Chapitre(5,"Les fragments"))

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
            DataManager.ajouterReponses(myQcmHelper,Reponse(6,"Juin 2012",false,2))
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


            //CHAPITRE 2
            //REPONSE DE QUESTION 1
            DataManager.ajouterReponses(myQcmHelper,Reponse(31,"Oui",true,11))
            DataManager.ajouterReponses(myQcmHelper,Reponse(32,"Non",false,11))
            DataManager.ajouterReponses(myQcmHelper,Reponse(33,"Je ne sais pas",false,11))
            //REPONSE DE QUESTION 2
            DataManager.ajouterReponses(myQcmHelper,Reponse(34,"Private val timeout :Int = 10",true,12))
            DataManager.ajouterReponses(myQcmHelper,Reponse(35,"Private var timeout :Int = 10",false,12))
            DataManager.ajouterReponses(myQcmHelper,Reponse(36,"Private val timeout :Int ? = 10",false,12))
            //REPONSE DE QUESTION 3
            DataManager.ajouterReponses(myQcmHelper,Reponse(37,"Private lateinit val currentToken :String ? = null",false,13))
            DataManager.ajouterReponses(myQcmHelper,Reponse(38,"Private lateinit var currentToken :String ? = null",true,13))
            DataManager.ajouterReponses(myQcmHelper,Reponse(39,"Private lateinit var currentToken :String",false, 13))
            //REPONSE DE QUESTION 4
            DataManager.ajouterReponses(myQcmHelper,Reponse(40,"Fun transformToUppercase(username : String):String{return username.toUpperCase()}",false,14))
            DataManager.ajouterReponses(myQcmHelper,Reponse(41,"Fun transformToUppercase(username : String):String = username.toUpperCase()",false,14))
            DataManager.ajouterReponses(myQcmHelper,Reponse(42,"Fun transformToUppercase(username : String) =  username.toUpperCase()",true,14))
            //REPONSE DE QUESTION 5
            DataManager.ajouterReponses(myQcmHelper,Reponse(43,"Oui, cela est obligatoire, sinon le compilateur lèvera une erreur.",false,15))
            DataManager.ajouterReponses(myQcmHelper,Reponse(44,"Non, cela n'est pas obligatoire.",true,15))
            DataManager.ajouterReponses(myQcmHelper,Reponse(45,"Je ne sais pas",false,15))
            //REPONSE DE QUESTION 6
            DataManager.ajouterReponses(myQcmHelper,Reponse(46,"0123",false,16))
            DataManager.ajouterReponses(myQcmHelper,Reponse(47,"123",false,16))
            DataManager.ajouterReponses(myQcmHelper,Reponse(48,"L'instruction affichera  0  à l'infini et finira par faire planter le programme.",true,16))
            //REPONSE DE QUESTION 7
            DataManager.ajouterReponses(myQcmHelper,Reponse(49,"1 – 6 – 11  - 16 – 21 – 26 – 31 – 36 – 41 – 46  ",true,17))
            DataManager.ajouterReponses(myQcmHelper,Reponse(50,"5 – 10 – 15 – 20 – 25 – 30 – 35 – 35 – 40 – 45 – 50",false,17))
            DataManager.ajouterReponses(myQcmHelper,Reponse(51,"0 – 10 – 20 – 30 – 40  - 50",false,17))
            //REPONSE DE QUESTION 8
            DataManager.ajouterReponses(myQcmHelper,Reponse(52,"Aucune. Les deux types sont utilisés pour des soucis de compatibilités avec la JVM.. ",false,18))
            DataManager.ajouterReponses(myQcmHelper,Reponse(53,"Le type  List  permet de définir une liste d’éléments ordonnée et immuable alors que le type  MutableList  permet de définir une liste d’éléments ordonnée et muable ",true,18))
            DataManager.ajouterReponses(myQcmHelper,Reponse(54,"Je ne sais pas",false,18))
            //REPONSE DE QUESTION 9
            DataManager.ajouterReponses(myQcmHelper,Reponse(55,"value my_var: Char",true,19))
            DataManager.ajouterReponses(myQcmHelper,Reponse(56,"Value varchar",false,19))
            DataManager.ajouterReponses(myQcmHelper,Reponse(57,"var varchar",false,19))
            //REPONSE DE QUESTION 10
            DataManager.ajouterReponses(myQcmHelper,Reponse(58,"Je ne sais pas",false,20))
            DataManager.ajouterReponses(myQcmHelper,Reponse(59,"Oui",false,20))
            DataManager.ajouterReponses(myQcmHelper,Reponse(60,"Non",true,20))


            //CHAPITRE 3
            //REPONSE DE QUESTION 1
            DataManager.ajouterReponses(myQcmHelper,Reponse(61,"AndroidManifest.xml",true,21))
            DataManager.ajouterReponses(myQcmHelper,Reponse(62,"MainActivity",false,21))
            DataManager.ajouterReponses(myQcmHelper,Reponse(63,"Gradle",false,21))
            //REPONSE DE QUESTION 2
            DataManager.ajouterReponses(myQcmHelper,Reponse(64,"Un pont entre les activités",true,22))
            DataManager.ajouterReponses(myQcmHelper,Reponse(65,"Un type d'adapter",false,22))
            DataManager.ajouterReponses(myQcmHelper,Reponse(66,"Un objet qui sert à stocker les données",false,22))
            //REPONSE DE QUESTION 3
            DataManager.ajouterReponses(myQcmHelper,Reponse(67,"val intent= Intent(this,nameSpace::ActivityName)",false,23))
            DataManager.ajouterReponses(myQcmHelper,Reponse(68,"Intent(this,ActivityName::class.java)",true,23))
            DataManager.ajouterReponses(myQcmHelper,Reponse(69,"val intent= Intent(this,ActivityName)",false, 23))
            //REPONSE DE QUESTION 4
            DataManager.ajouterReponses(myQcmHelper,Reponse(70,"Non",false,24))
            DataManager.ajouterReponses(myQcmHelper,Reponse(71,"Oui,mais elle ne peut pas envoyer des données",false,24))
            DataManager.ajouterReponses(myQcmHelper,Reponse(72,"Oui,elle ne peut pas envoyer des données",true,24))
            //REPONSE DE QUESTION 5
            DataManager.ajouterReponses(myQcmHelper,Reponse(73,"L'intent ne transmet pas les données",false,25))
            DataManager.ajouterReponses(myQcmHelper,Reponse(74,"Intent.putExtra(\"name\",value)",true,25))
            DataManager.ajouterReponses(myQcmHelper,Reponse(75,"Intent.sendExtra(\"name\",value)",false,25))
            //REPONSE DE QUESTION 6
            DataManager.ajouterReponses(myQcmHelper,Reponse(76,"StartActivity",false,26))
            DataManager.ajouterReponses(myQcmHelper,Reponse(77,"StartActivityForAnswer",false,26))
            DataManager.ajouterReponses(myQcmHelper,Reponse(78,"StartActivityForResult",true,26))
            //REPONSE DE QUESTION 7
            DataManager.ajouterReponses(myQcmHelper,Reponse(79,"Identification unique",true,27))
            DataManager.ajouterReponses(myQcmHelper,Reponse(80,"Le nom de l'activity",false,27))
            DataManager.ajouterReponses(myQcmHelper,Reponse(81,"Identification unique",false,27))
            //REPONSE DE QUESTION 8
            DataManager.ajouterReponses(myQcmHelper,Reponse(82,"StartActivityForResult",false,28))
            DataManager.ajouterReponses(myQcmHelper,Reponse(83,"SetResult ",true,28))
            DataManager.ajouterReponses(myQcmHelper,Reponse(84,"StartResult",false,28))
            //REPONSE DE QUESTION 9
            DataManager.ajouterReponses(myQcmHelper,Reponse(85,"OnActivityResult",true,29))
            DataManager.ajouterReponses(myQcmHelper,Reponse(86,"OnIntentAnswer",false,29))
            DataManager.ajouterReponses(myQcmHelper,Reponse(87,"OnResultIntent",false,29))
            //REPONSE DE QUESTION 10
            DataManager.ajouterReponses(myQcmHelper,Reponse(88,"Un Intent qui relance la meme activity dans l'application",false,30))
            DataManager.ajouterReponses(myQcmHelper,Reponse(89,"Un Intent qui se lance implicitement par defaut sans le déclarer",false,30))
            DataManager.ajouterReponses(myQcmHelper,Reponse(90,"Un Intent qui lance une autre application, sans la nommer cette application spécifique",true,30))

            //CHAPITRE 4
            //REPONSE DE QUESTION 1
            DataManager.ajouterReponses(myQcmHelper,Reponse(91,"SharedPreferences",true,31))
            DataManager.ajouterReponses(myQcmHelper,Reponse(92,"Bundles",false,31))
            DataManager.ajouterReponses(myQcmHelper,Reponse(93,"Bases de données SQLite",false,31))
            //REPONSE DE QUESTION 2
            DataManager.ajouterReponses(myQcmHelper,Reponse(94,"Put, remove",true,32))
            DataManager.ajouterReponses(myQcmHelper,Reponse(95,"Get, put, remove",false,32))
            DataManager.ajouterReponses(myQcmHelper,Reponse(96,"Get",false,32))
            //REPONSE DE QUESTION 3
            DataManager.ajouterReponses(myQcmHelper,Reponse(97,"GetSharedPreferences(\"activity1\")",false,33))
            DataManager.ajouterReponses(myQcmHelper,Reponse(98,"GetPreferences()",true,33))
            DataManager.ajouterReponses(myQcmHelper,Reponse(99,"GetSharedPreferences()",false, 33))
            //REPONSE DE QUESTION 4
            DataManager.ajouterReponses(myQcmHelper,Reponse(100,"Accessible méme aprés la desinstallation de l'application",false,34))
            DataManager.ajouterReponses(myQcmHelper,Reponse(101,"Toutes les applications",false,34))
            DataManager.ajouterReponses(myQcmHelper,Reponse(102,"Que votre application",true,34))
            //REPONSE DE QUESTION 5
            DataManager.ajouterReponses(myQcmHelper,Reponse(103,"Toujours accessible",false,35))
            DataManager.ajouterReponses(myQcmHelper,Reponse(104,"Accessible méme aprés la desinstallation de l'application",true,35))
            DataManager.ajouterReponses(myQcmHelper,Reponse(105,"Que votre application",false,35))
            //REPONSE DE QUESTION 6
            DataManager.ajouterReponses(myQcmHelper,Reponse(106,"SendStream()",false,36))
            DataManager.ajouterReponses(myQcmHelper,Reponse(107,"OpenFile()",false,36))
            DataManager.ajouterReponses(myQcmHelper,Reponse(108,"OpenFileInput()",true,36))
            //REPONSE DE QUESTION 7
            DataManager.ajouterReponses(myQcmHelper,Reponse(109,"petits data",true,37))
            DataManager.ajouterReponses(myQcmHelper,Reponse(110,"grands data",false,37))
            DataManager.ajouterReponses(myQcmHelper,Reponse(111,"Les deux",false,37))
            //REPONSE DE QUESTION 8
            DataManager.ajouterReponses(myQcmHelper,Reponse(112,"L'activité",false,38))
            DataManager.ajouterReponses(myQcmHelper,Reponse(113,"L'application ",true,38))
            DataManager.ajouterReponses(myQcmHelper,Reponse(114,"Le contexte ",false,38))
            //REPONSE DE QUESTION 9
            DataManager.ajouterReponses(myQcmHelper,Reponse(115,"AndroidManifest.xml",true,39))
            DataManager.ajouterReponses(myQcmHelper,Reponse(116,"ActivityMain",false,39))
            DataManager.ajouterReponses(myQcmHelper,Reponse(117,"Gradle",false,39))
            //REPONSE DE QUESTION 10
            DataManager.ajouterReponses(myQcmHelper,Reponse(118,"Renvoie le répertoire externe \"name\"",false,40))
            DataManager.ajouterReponses(myQcmHelper,Reponse(119,"Renvoie le répertoire externe \"public\" sous name",false,40))
            DataManager.ajouterReponses(myQcmHelper,Reponse(120,"Renvoie le répertoire externe \"privé\" sous \"name\"",true,40))
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

            //AJOUTER QUESTIONS POUR CHAPITRE 3
            DataManager.ajouterQuestion(myQcmHelper, Question(21,"Chaque activité a une entrée dans le fichier ?",3))
            DataManager.ajouterQuestion(myQcmHelper, Question(22,"C'est quoi un Intent ?",3))
            DataManager.ajouterQuestion(myQcmHelper, Question(23,"Comment déclarer un Intent ?",3))
            DataManager.ajouterQuestion(myQcmHelper, Question(24,"La deuxième activité peut répondre à l'intent?",3))
            DataManager.ajouterQuestion(myQcmHelper, Question(25,"On trasmet les données dans l'intent avec la methode?",3))
            DataManager.ajouterQuestion(myQcmHelper, Question(26,"Si l’ activité appelante veut attendre le résultat de l'activité appelée, on utilise ?",3))
            DataManager.ajouterQuestion(myQcmHelper, Question(27,"Comment la seconde activité connaitre l'activité appelante ?",3))
            DataManager.ajouterQuestion(myQcmHelper, Question(28,"Pour renvyer des données à l'activité appelante, on appelle la fonction?",3))
            DataManager.ajouterQuestion(myQcmHelper, Question(29,"Quel est le nom de la fonction à definir dans la premiere acticity pour récuperer les donnés?",3))
            DataManager.ajouterQuestion(myQcmHelper, Question(30,"C'est quoi un Intent Implicite ?",3))

            //AJOUTER QUESTIONS POUR CHAPITRE 4
            DataManager.ajouterQuestion(myQcmHelper, Question(31,"Quelle type de fichiers utilisés pour manipulerdes petits data?",4))
            DataManager.ajouterQuestion(myQcmHelper, Question(32,"On utilise un editor pour SharedPreferences pour ?",4))
            DataManager.ajouterQuestion(myQcmHelper, Question(33,"Comment récuperer les preferences spécifiques à l'activité?",4))
            DataManager.ajouterQuestion(myQcmHelper, Question(34,"Le stockage interne est toujours accessible par ?",4))
            DataManager.ajouterQuestion(myQcmHelper, Question(35,"Le stockage externe est accessible?",4))
            DataManager.ajouterQuestion(myQcmHelper, Question(36,"Pour créer un FileInputStream, On utilise ?",4))
            DataManager.ajouterQuestion(myQcmHelper, Question(37,"Les fichiers SharedPreferences sont utilisés pour manipuler?",4))
            DataManager.ajouterQuestion(myQcmHelper, Question(38,"getSharedPreferences(),Accède aux préférences au niveau de?",4))
            DataManager.ajouterQuestion(myQcmHelper, Question(39,"Si vous voulez lire/écrire dns le stockage externe du périphérique, vous devez demander l' autorisation?",4))
            DataManager.ajouterQuestion(myQcmHelper, Question(30,"Que fais la fonction getExternalFilesDir (\" name \")?",4))
        }
    }
}