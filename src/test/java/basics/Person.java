package basics;

public class Person implements Comparable<Person>{
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person that){
        return this.getAge()-that.getAge();
    }
    @Override
    public String toString(){
        return "Person: "+this.getName()+" Age: "+this.getAge();
    }

    //builder class

    public static class PersonBuilder {
        private String name;
        private int age;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(name, age);
        }
    }

    // Static method to create a new builder
    public static PersonBuilder builder() {
        return new PersonBuilder();
    }
}
