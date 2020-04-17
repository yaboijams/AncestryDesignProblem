package dna;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DNACodonTest {
    DNACodon dnaCodon;

    @org.junit.Before
    public void setUp() throws Exception {
        dnaCodon = new DNACodon();
    }

    @Test
    public void checkForAllStandardCodons() {
        char[] letters = {'A', 'T', 'G', 'C'};
        for(char first : letters) {
            for(char second: letters) {
                for (char third: letters) {
                    String codon = first + "" + second + "" + third;
                    try {
                        this.dnaCodon.acidFor(codon);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void checkForCodonForStop() throws Exception {
        List<String> codons = this.dnaCodon.codonsFor("stop");
        assertEquals(3, codons.size());
    }

    @Test(expected = Exception.class)
    public void errorOnInvalidCodonSize() throws Exception {
        String badSizedCodon = "BB";
        this.dnaCodon.acidFor(badSizedCodon);
    }

    @Test(expected = Exception.class)
    public void errorOnNonExistingCodon() throws Exception {
        String nonExistingCodon = "some codon";
        this.dnaCodon.acidFor(nonExistingCodon);
    }

    @Test(expected = Exception.class)
    public void errorOnInvalidAcidSize() throws Exception {
        String badSizedAcid = "al";
        this.dnaCodon.codonsFor(badSizedAcid);
    }

    @Test(expected = Exception.class)
    public void errorOnNonExistingAcid() throws Exception {
        String nonExistingAcid = "someacid";
        this.dnaCodon.codonsFor(nonExistingAcid);
    }

}