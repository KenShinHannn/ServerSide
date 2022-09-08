package sit.int202.simple;

import sit.int202.simple.entities.Subject;

public class TestSubject {
    public static void main(String[] args) {
        Subject subject = new Subject("INT204", "Server Side !", 2.0);
        System.out.printf("Id: %s, Title: %s, Credit: %f\n", subject.getId(), subject.getSubjectName(), subject.getCredit());
        System.out.println(subject);
    }
}
