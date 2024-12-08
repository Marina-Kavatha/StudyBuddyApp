package org.javawavers.studybuddy;



//κλαση SimulateAnnealing
public class SimulateAnnealing {

    private static final double tempreture = 100; // αρχικοποιουμε την μεταβλητη tempreture = 100 ωστε ο αλγοριθμος να ελενξει αρκετες λυσεις
    private static final double coolingrate = 0.99; // καθοριζει τον ρυθμο μειωσης της θερμοκρασιας σε καθε επαναληψη την αρχικοποιουμε ρυθμος ψυξης = 0.99 ετσι ωστε να ελενχει αρκετες λυσεις 
    // μεταβλητες τερματισμου του αλγοριθμου
    private static final int repetions = 1000; // o αριθμος των επαναληψεων που θελουμε να κανει ο αλγοριθμος ως τον τερματισμο του
    private static final double mintempreture = 0.1; //η ελαχιστη θερμοκρασια που μπορει να φτασει ο αλγοριθμος για να τερματισει 
    private static final int maxnoimprovment = 500; // μεταβλητη η οποια στην συνεχει θα ελενχει αν ο αλγοριθμος εχει κανει 500 επαναληψεις στις οποιες δεν βρεθηκε καλυτερη λυση 
    int improvment = 0;// μετραει το πληθος των επαναληψεων που δεν υπαρχει βελτιωση 

    Solution currentsolution = startsolution();//υποθετουμε πως εχουμε μια αρχικη λυση
    Solution bestsolution = currentsolution;//ορζουμε την bestsolution με την currentaolution

    double currentemprute = tempreture;//οριζουμε την τωρινη θερμοκρασια με την γενικη θερμοκρασια
    int i = 0;

    while (tempreture > mintempreture && i < repetions && improvment < maxnoimprovment) {
        Solution newsolution = generatesolution(currentsolution);//υποθετουμε οτι εχουν γινει αλλαγες στο προγραμμα η εχουμε κανει αλλαγες  
        double currentcost = calculatecost(currentsolution);//μετραμε το κοστος της τωρινης λυσης 
        double newcost = calculatecost(newsolution);//μετραμε το κοστος της νεας λυσης
    
        if (newcost < currentcost  || acceptpropability(newcost, currentcost, currentemprute)) {  //ελενχουμε εαν το νεο κοστος ειναι μικροτερο απο το παλιο που στην περιπτωση αυτην το αποδεχομαστε αν δεν ειναι υπαρχει μια πιθανοτητα αποδοχης που οσο καλυτερη ειναι η τωρινη λυση τοσο μικροτερη ειναι η πιθανοτητα αποδοχης της
            currentsolution = newsolution;
        }

        if (calculatecost(currentsolution) > calculatecost(bestsolution)) { //στην περιπτωση που αποδεχθηκε την λυση με μια πιθανοτητα δεν γινεται καλυτερη λυση αλλα τωρινη λυση και η καλυτερη παραμενει η προηγουμενη  αλλιως γινεται καλυτερη λυση 
            bestsolution = currentsolution;
        }
        
        currentemprute = currentemprute * coolingrate; //αλλαζουμε την θερμοκρασια για την επομενη επαναληψη
    }


}

