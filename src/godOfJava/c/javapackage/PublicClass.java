package godOfJava.c.javapackage;

public class PublicClass {

    public static void main(String[] args) {
        DefaultClass defaultClass = new DefaultClass();
        defaultClass.callTest();
    }
}

class DefaultClass {

    public void callTest() {
        System.out.println(this);
    }
}
