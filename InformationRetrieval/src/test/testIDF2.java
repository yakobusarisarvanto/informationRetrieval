/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import model.Document;
import model.InvertedIndex;
import model.Posting;

/**
 *
 * @author admin
 */
public class testIDF2 {

    public static void main(String[] args) {
        // seting dokumen
        Document doc2 = new Document(2, "delivery of silver arrived in a silver truck");

        //buat arraylist posting untuk result
        ArrayList<Posting> result = doc2.getListofPosting();

        // tampilan posting list untuk doc2
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).getTerm() + " "
                    + result.get(i).getNumberOfTerm());

        }
    }
}
