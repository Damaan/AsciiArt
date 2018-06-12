public class Printer {
    char[][] al;
    int tamanyLletra;

// Constructor: accepta un String amb la representació de tot l'alfabet
// Hi haurà 27 lletres en total, separades per un espai en blanc.


    public Printer(String alphabet) {

        //Amb aquest bucle contam cuantes files tindra el nostre array bidimensional basant-nos en la quantitat de salts de linea.
        char[] we = alphabet.toCharArray();
        int con = 0;
        for (int i = 0; i < we.length; i++) {
            if (we[i] == '\n'){ con++; }
        }

        //com que lla ultima linea del String alphabet no conte salt de linia,incrementam una ultima vegada
        //per a les columnes dividim ell String entre el numero de files.
        int fila = con +1;
        int col = (alphabet.length() + 1)/ fila;

        char[][] alf= new char[fila][col];

        //Calculam tambe el tamany de la lletra el cual emprarem a la funció render.
        int tamanyLletra = ((alf[0].length -1) -26)/27;
        this.tamanyLletra = tamanyLletra;

        //Una vegada que tenim la array creada simplement inserim 1 per 1 tots els caracters del String.
        int cont = 0;
        for (int i = 0; i < alf.length; i++) {
            for (int j = 0; j < alf[0].length; j++) {
                if (cont == alphabet.length()){alf[i][j]=' '; break;}
                alf[i][j]=alphabet.charAt(cont);
                cont++;
            }
        }
        this.al = alf;

    }

// Mètode render: accepta un String amb el text a representar i torna
// també un String amb el text en forma d'ASCII Art.

// Només es consideren les lletres majúscules de la A a la Z. Les
// minúscules es passen a majúscules, i els altres caràctes es tradueixen
// a «?» (manco l'espai en blanc).

    public String render(String text) {
        text = text.toUpperCase();
        int calc;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.al.length ; i++) {
         //Aquest bucle s'executara tantes vegades com files tinguem a l'array.
            for (int j = 0; j < text.length(); j++) {
                //Aquest bucle, per a cada lletra del text agafa el seu valor ascii
                int z = text.charAt(j);
                if (z < 'A' | z > 'Z'){
                    if(z == ' '){
                        //En cas de que el caracter sigui el espai, afegim al resultat tants espais com tamany de lletra tinguem.
                        for (int k = 0; k <= tamanyLletra; k++) { sb.append(" "); }
                        continue;
                    }
                    //En cas de que no sigui cap caracter a tenir el compte, li indicam la posició al eix x del simbol '?'.
                    else { calc = this.al[0].length - (tamanyLletra +1); }
                } else {
                    //En cas de que sigui una lletra mayuscula de la a fins a la z, li restam el valor ascii de la lletra 'A',
                    //Amb aixo tenim la posició al eix x de la array
                    int valor = z - 65;
                    calc = valor + (valor * tamanyLletra);
                }
                //Una vegada tenim el calcul del eix x, simplement, a partir d'aquest punt, afegim al resultat tants caracters com tamany de lletra.
                for (int k = 0; k < tamanyLletra; k++) {
                    sb.append(this.al[i][calc]);
                    calc++;
                }
                //Despres de cada lletra inserirem un espai sempre i quan no estiguem a la darrera lletra
                if (!(j == text.length() -1)){ sb.append(" "); }
            }
         //En cas de que no estiguem a l'ultima fila del array,inserirem un salt de linea al resultat.
         if (i < al.length -1){ sb.append("\n"); }
        }
        return sb.toString();
    }
}