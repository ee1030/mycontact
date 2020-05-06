package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    @InjectMocks // 테스트의 대상이 되는 클래스에 붙여준다.
    private PersonService personService;
    @Mock // 해당 대상이 되는 클래스에서 AutoWired 하는 클래스들은 대부분 Mock으로 만든다.
    private PersonRepository personRepository;

    @Test
    void getPeopleByName() {
        when(personRepository.findByName("John Wick"))
                .thenReturn(Lists.newArrayList(new Person("John Wick")));

        List<Person> result = personService.getPeopleByName("John Wick");
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("John Wick");
    }

    @Test
    void getPerson() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.of(new Person("John Wick")));

        Person person = personService.getPerson(1L);
        assertThat(person.getName()).isEqualTo("John Wick");
    }

    @Test
    void getPersonIfNotFound() {
        when(personRepository.findById(1L))
                .thenReturn(Optional.empty());

        Person person = personService.getPerson(1L);
        assertThat(person).isNull();
    }

    @Test
    void put() {
        PersonDto dto = PersonDto.of("John Wick", "Contract",
                "New York", LocalDate.now(), "Killer",
                "010-1111-2222");

        personService.put(dto);

        verify(personRepository, times(1)).save(any(Person.class));
    }
}