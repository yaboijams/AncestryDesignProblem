package main;

import dna.DnaSequence;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String dna = "GCTCGCAACATCGGATATAGA";
        System.out.println("DNA: " + dna);
        System.out.println("The amino acids produced by this DNA Sequence is:");

        DnaSequence dnaSequence = new DnaSequence();
        List<String> aminoacid = dnaSequence.transcribe(dna);

        String separater = "";
        for(String acid : aminoacid) {
            System.out.print(separater + acid);
            separater = "-";
        }
        System.out.println();

    }
}
