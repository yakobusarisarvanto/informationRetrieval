/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author admin
 */
public class InvertedIndex {

    private ArrayList<Document> listOfDocument = new ArrayList<Document>();
    private ArrayList<Term> dictionary = new ArrayList<Term>();

    public InvertedIndex() {
    }

    public void addNewDocument(Document document) {
        getListOfDocument().add(document);
    }

    public ArrayList<Posting> getUnsortedPostingList() {
        //siapkan posting List
        ArrayList<Posting> list = new ArrayList<Posting>();
        //buat node Posting utk listofdocument
        for (int i = 0; i < getListOfDocument().size(); i++) {
            //buat listOfTerm dari document ke -i
            String[] termResult = getListOfDocument().get(i).getListofTerm();
            //loop sebanyak term dari document ke i
            for (int j = 0; j < termResult.length; j++) {
                //buat object tempPosting
                Posting tempPosting = new Posting(termResult[j],
                        getListOfDocument().get(i));
                list.add(tempPosting);
            }
        }
        return list;
    }

    public ArrayList<Posting> getSortedPostingList() {
        //siapkan posting List
        ArrayList<Posting> list = new ArrayList<Posting>();
        //panggil list yang belum terurut
        list = this.getUnsortedPostingList();
        //urutkan
        Collections.sort(list);
        return list;
    }

    public ArrayList<Posting> search(String query) {
        //buat index/dictionary
        makeDictionary();
        String tempQuery[] = query.split(" ");
        for (int i = 0; i < tempQuery.length; i++) {
            String string = tempQuery[i];
        }
        return null;
    }

    public ArrayList<Posting> intersection(ArrayList<Posting> p1,
            ArrayList<Posting> p2) {
        return null;
    }

    public ArrayList<Posting> searchOneWord(String word) {
        Term tempTerm = new Term(word);
        if (getDictionary().isEmpty()) {
            //dictionary kosong
            return null;
        } else {
            int positionTerm = Collections.binarySearch(dictionary, tempTerm);
            if (positionTerm < 0) {
                //tidak ditemukan
                return null;
            } else {
                return dictionary.get(positionTerm).getPostingList();
            }
        }
    }

    public void makeDictionary() {
        //buat posting list term terurut
        ArrayList<Posting> list = getSortedPostingList();
        //looping buat list of term (dictionary)
        for (int i = 0; i < list.size(); i++) {
            //cek dictionary kososng atau tidak 
            if (getDictionary().isEmpty()) {
                //buat term
                Term term = new Term(list.get(i).getTerm());
                //tambah posting ke posting list utk term ini
                term.getPostingList().add(list.get(i));
                //tambah term ke dictionary
                getDictionary().add(term);
            } else {
                Term tempTerm = new Term(list.get(i).getTerm());
                //pembandingan apakah term sudah ada atau belum
                //luaran binary search adalah posisi
                int position = Collections.binarySearch(getDictionary(), tempTerm);
                if (position < 0) {
                    //term baru
                    //tambah posting list ke term
                    tempTerm.getPostingList().add(list.get(i));
                    //tambahkan term ke dictionary
                    getDictionary().add(tempTerm);
                } else {
                    //term ada
                    //tambahkan postinglist saja dari existing term
                    getDictionary().get(position).getPostingList().add(list.get(i));
                    Collections.sort(getDictionary().get(position).getPostingList());
                }
                //urutkan term dictionary
                Collections.sort(getDictionary());
            }
        }
    }

    /**
     * @return the listOfDocument
     */
    public ArrayList<Document> getListOfDocument() {
        return listOfDocument;
    }

    /**
     * @param listOfDocument the listOfDocument to set
     */
    public void setListOfDocument(ArrayList<Document> listOfDocument) {
        this.listOfDocument = listOfDocument;
    }

    /**
     * @return the dictionary
     */
    public ArrayList<Term> getDictionary() {
        return dictionary;
    }

    /**
     * @param dictionary the dictionary to set
     */
    public void setDictionary(ArrayList<Term> dictionary) {
        this.dictionary = dictionary;
    }
}
