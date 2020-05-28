package com.company;

public class MaClasse {

    /**
     *
     */
    public int calcul ()

    {

        int bn = 0;
        bn = bn+10;
        System.out.println("La valeur de bn est " + bn);
        return calcul ();
    }

}
