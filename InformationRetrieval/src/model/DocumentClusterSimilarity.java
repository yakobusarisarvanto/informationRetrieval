/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class DocumentClusterSimilarity implements Comparable<DocumentClusterSimilarity>{
    private double similarity;
    private Cluster cluster;

    public DocumentClusterSimilarity() {
    }

    public DocumentClusterSimilarity(double similarity, Cluster cluster) {
        this.similarity = similarity;
        this.cluster = cluster;
    }

    /**
     * @return the similarity
     */
    public double getSimilarity() {
        return similarity;
    }

    /**
     * @param similarity the similarity to set
     */
    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    /**
     * @return the cluster
     */
    public Cluster getCluster() {
        return cluster;
    }

    /**
     * @param cluster the cluster to set
     */
    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    @Override
    public int compareTo(DocumentClusterSimilarity o) {
        return Double.compare(similarity, similarity);
    }
    
}
