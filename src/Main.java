/*  CRISPEN LEBLANC | UMGC | CMSC335 | DISCUSSION4
*
* The purpose of this program is to demonstrate an understanding
* of the Java Swing Components and how to write event listeners while
* effectively using object-oriented concepts such as encapsulation,
* inheritance, interfaces, information hiding, and polymorphism.
*
* */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        IdAndPasswords idandPasswords = new IdAndPasswords();

        new LoginPage(idandPasswords.getLoginInfo());

        System.out.println("It worked!");
    }
}