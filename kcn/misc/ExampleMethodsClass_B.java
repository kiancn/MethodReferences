package kcn.misc;

import kcn.methodreferencing.MePack;

import java.util.ArrayList;


/* [Class/object is purely placeholder]
Class mocks the function of an object that fires packs of MeRefs on command */
public class ExampleMethodsClass_B
{

    MePack<String, String> clientMethods;
    String[] stringArray;

    ArrayList<String> receivedStrings;

    ArrayList<String> processedStrings;

    public ExampleMethodsClass_B()
    {
        clientMethods = new MePack<>();
        receivedStrings = new ArrayList<>();
        processedStrings = new ArrayList<>();
    }

    public void processStringArray()
    {
        System.out.println("Processesing recieved strings with received methods.");
        for(int i = 0; i < stringArray.length - 1; i++)
        {
            processStringPairWithMePack(clientMethods, stringArray[i], stringArray[i + 1]);
        }

    }

    private void processStringPairWithMePack(MePack<String, String> mePack, String string1, String string2)
    {
        System.out.println("\n Newly processing strings 1:");
        for(int i = 0; i < mePack.getMeRefs().size(); i++)
        {
            System.out.print("MeRef[" + (int)(i + 1) + "] ");

            /* running the MeRef in spot i .... btw arguments are type-safe (return is an Object, so cast)*/
            processedStrings.add(  (String)mePack.getMeRefs().get(i).run(string1, string2)  );

        }

        System.out.println("\n Processed list (until now):");
        printStrings();
    }

    private void printStrings(){ for(String s : processedStrings) { System.out.println(s); } }

    /*Pseudo-random number between zero and array-length */
    int getRandomAccess(String[] stringsToMessWith)
    {
        int r = (int)(Math.random() * (double)stringsToMessWith.length - 1);
        return r;
    }
}