package org.julius.quarkus.microservices.number;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import java.time.Instant;

@Schema(description = "several ISBN numbers for books")
public class IsbnNumbers {

    @Schema(required = true, example = "10-000000")
    @JsonbProperty("isbn10")
    private String isbn10;
    @Schema(required = true, example = "13-000000000")
    @JsonbProperty("isbn13")
    private String isbn13;
    @JsonbTransient
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
