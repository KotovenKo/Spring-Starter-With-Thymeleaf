package com.kot.spring.tester;

import com.kot.spring.DAO.PersonDAO;
import com.kot.spring.models.Person;

import java.util.List;

public class Tester {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
      List<Person> personList =   personDAO.showNumberPerson(2);
        System.out.println(personList);

    }
}
