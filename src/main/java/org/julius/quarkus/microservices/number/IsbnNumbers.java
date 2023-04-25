package org.julius.quarkus.microservices.number;

import java.time.Instant;

public class IsbnNumbers {

    private String isbn10;
    private String isbn13;
    private Instant generationTime;

    public String getIsbn10(){
        return isbn10;
    }
    public void setIsbn10(String isbn10){
        this.isbn10 = isbn10;
    }

    public String getIsbn13(){
        return isbn13;
    }
    public void setIsbn13(String isbn13){
        this.isbn13 = isbn13;
    }

    public Instant getGenerationTime(){
        return generationTime;
    }

    public void setGenerationTime(Instant generationTime){
        this.generationTime = generationTime;
    }

    @Override
    public String toString() {
        return "IsbnNumbers{" +
                "isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", generationTime=" + generationTime +
                '}';
    }
}
