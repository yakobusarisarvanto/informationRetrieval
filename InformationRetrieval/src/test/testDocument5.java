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
public class testDocument5 {
    public static void main(String[] args) {

        Document doc1 = new Document(1, "computer information retrieval");
        Document doc2 = new Document(2, "computer organisation and architecture");
        Document doc3 = new Document(3, "machine learning architecture");
        //buat object InvertedIndex
        InvertedIndex index = new InvertedIndex();
        //tambahkan document ke index
        index.addNewDocument(doc1);
        index.addNewDocument(doc2);
        index.addNewDocument(doc3);
        //panggil function unsorted posting list
        ArrayList<Posting> list = index.getSortedPostingList();
        //panggil list posting
        System.out.println("Ukuran list = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTerm() + "," + list.get(i).getDocument().getId());
        }
    }
}
