package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Преступление и наказание.")
    private String name;
    @Value("Федор Михайлович Достоевский")
    private String author;
    @Value("1866")
    private int eyarOfPublication;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getEyarOfPublication() {
        return eyarOfPublication;
    }

}
