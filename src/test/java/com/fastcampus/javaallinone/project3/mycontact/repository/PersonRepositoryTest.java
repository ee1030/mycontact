package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = new Person().builder()
                .name("John")
                .age(35)
                .bloodType("O")
                .build();

        personRepository.save(person);

        List<Person> result = personRepository.findByName("John");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("John");
        assertThat(result.get(0).getAge()).isEqualTo(35);
        assertThat(result.get(0).getBloodType()).isEqualTo("O");
    }

    @Test
    void findByBloodType() {
        List<Person> result = personRepository.findByBloodType("O");

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("John Wick");
        assertThat(result.get(1).getName()).isEqualTo("King");
    }

    @Test
    void findByBirthdayBetween() {
        List<Person> result = personRepository.findByMonthOfBirthday(8);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("John Wick");
        assertThat(result.get(1).getName()).isEqualTo("Eminem");
    }
}