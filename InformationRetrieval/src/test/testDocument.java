/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import model.Document;
import model.Posting;

/**
 *
 * @author admin
 */
public class testDocument {
    public static void main(String[] args) {
        Document doc1 = new Document(1, "computer information retrieval");
        Document doc2 = new Document(2, "computer organisation and architecture");
        //keluarannya kata computer information retrieval
        //dipotong-potong menjadi 3 string
        //luarannya:
        //computer
        //information
        //retrieval
        
        //Tokenisasi dokument
        String tokenDoc1[] = doc1.getListofTerm();
        String tokenDoc2[] = doc2.getListofTerm();
        //siapkan posting list
        ArrayList<Posting> list = new ArrayList<Posting>();
        //buat node posting utk doc1
        for (int i = 0; i < tokenDoc1.length; i++) {
            //buat temp Posting
            Posting tempPosting = new Posting(tokenDoc1[i], doc1);
            //masukkan ke list
            list.add(tempPosting);
        }
        //buat note posting utk doc2
        for (int i = 0; i < tokenDoc2.length; i++) {
            //buat temp Posting
            Posting tempPosting = new Posting(tokenDoc2[i], doc2);
            //masukkan ke list
            list.add(tempPosting);
        }
        
        //panggil list posting
        System.out.println("Ukuran list = "+list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTerm()+","+list.get(i).getDocument().getId());
        }
    }
}
