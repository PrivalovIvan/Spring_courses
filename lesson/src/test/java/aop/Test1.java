package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLib = context.getBean("uniLibrary", UniLibrary.class);
        // SchoolLibrary sLibrary = context.getBean("schoolLibrary",
        // SchoolLibrary.class);
        Book book = context.getBean("book", Book.class);

        uniLib.getBook(book);
        // uniLib.returnBook();
        // uniLib.getMagazine();

        // sLibrary.getBook();

        context.close();
    }
}
