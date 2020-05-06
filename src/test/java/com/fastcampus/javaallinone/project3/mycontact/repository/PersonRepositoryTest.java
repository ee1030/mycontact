package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@Transactional
@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void findByName() {
        List<Person> people = personRepository.findByName("Jinwoo");
        assertThat(people.size()).isEqualTo(1);

        Person person = people.get(0);
        assertAll(
                () -> assertThat(person.getName()).isEqualTo("Jinwoo"),
                () -> assertThat(person.getHobby()).isEqualTo("Level Up"),
                () -> assertThat(person.getJob()).isEqualTo("Hunter"),
                () -> assertThat(person.getBirthday()).isEqualTo(Birthday.of(LocalDate.of(1991, 7, 10))),
                () -> assertThat(person.getPhoneNumber()).isEqualTo("010-2222-5555"),
                () -> assertThat(person.getAddress()).isEqualTo("Seoul")
        );
    }

    @Test
    void findByNameIfDeleted() {
        List<Person> people = personRepository.findByName("Jinho");
        assertThat(people.size()).isEqualTo(0);
    }

    @Test
    void findByMonthOfBirthday() {
        List<Person> people = personRepository.findByMonthOfBirthday(7);
        assertThat(people.size()).isEqualTo(2);

        assertAll(
                () -> assertThat(people.get(0).getName()).isEqualTo("King"),
                () -> assertThat(people.get(1).getName()).isEqualTo("Jinwoo")
        );
    }

    @Test
    void findPeopleDeleted() {
        List<Person> people = personRepository.findPeopleDeleted();
        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("Jinho");
    }
}