package com.kot.spring.DAO;

import com.kot.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom", "Rassel"));
        people.add(new Person(++PEOPLE_COUNT, "Jack", "Nokolson"));
        people.add(new Person(++PEOPLE_COUNT,"RAS", "Buryy"));
        people.add(new Person(++PEOPLE_COUNT, "Gerry", "Goldman"));


    }

    public List<Person> index(){
        return people;
    }
    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public  void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public List<Person> showNumberPerson(int counter){
        List <Person> personList = people.subList(0, counter);
        return  personList;




    }

}
