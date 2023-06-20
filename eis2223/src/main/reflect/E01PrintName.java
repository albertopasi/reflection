package it.unipd.dei.eis.reflect;

public class E01PrintName {
    public void printName() {
        System.out.println(this.getClass().getName());
    }

    public static void main(String[] args) {

        (new E01PrintName()).printName();

    }
}
