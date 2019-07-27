package effectivejava.staticfactorymethod;

/**
 * @author : chelei
 * @description: static factory method
 * @date : 2019/7/27 15:28
 */
public class PersonSFMDemo {
    private String name;
    private int age;
    private static PersonSFMDemo newPerson(String name, int age) {
        PersonSFMDemo person = new PersonSFMDemo();
        person.name = name;
        person.age = age;
        return person;
    }
}
