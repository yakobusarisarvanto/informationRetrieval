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
public class testDocument8 {
    public static void main(String[] args) {

        Document doc1 = new Document(1, "computer information retrieval.");
        Document doc2 = new Document(2, "computer organization and architecture");
        Document doc3 = new Document(3, "machine learning architecture");
        Document doc4 = new Document(4, "machine learning artificial inteligence");
        //buat object InvertedIndex
        InvertedIndex index = new InvertedIndex();
        //tambahkan document ke index
        index.addNewDocument(doc1);
        index.addNewDocument(doc2);
        index.addNewDocument(doc3);
        index.addNewDocument(doc4);
        index.makeDictionary();
        // panggil fungsi search
        ArrayList<Posting> result = index.search("machine learning inteligence");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("id_doc = " +result.get(i).getDocument().getId());
            System.out.println(result.get(i).getDocument().getContent());
        }
    }
}
