/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testLucene;

import model.Document;

/**
 *
 * @author admin
 */
public class testDocumentIndonesiaStemming {

    public static void main(String[] args) {
        Document doc = new Document(1, "Dia sedang pergi berbelanja di pusat perbelanjaan."
                + "Namun, ibunya melarangnya pergi kesana karena tempat itu sangat berbahaya.");
        System.out.println("Tanpa Stemming");
        System.out.println(doc);
        System.out.println("Dengan stemming");
        doc.IndonesiaStemming();
        System.out.println(doc);
    }
}
