package com.fastcampus.javaallinone.project3.mycontact.domain;

import com.fastcampus.javaallinone.project3.mycontact.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

// 지인 정보를 저장하기 위한 domain 클래스
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
@Where(clause = "deleted = false")
public class Person {
    /*
    * 기본 키인 id 값은 유저가 직접 입력하지 않고 자동적으로 생성되게 하였다.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*이름 값은 null 값이나 비어있지 않도록 어노테이션을 사용하여 유효성 검사를 실시한다.*/
    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    private String hobby;

    private String address;

    @Valid
    @Embedded
    private Birthday birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    @ColumnDefault("0")
    private boolean deleted;

    public void set(PersonDto personDto) {
        if(!StringUtils.isEmpty(personDto.getHobby()))  {
            this.setHobby(personDto.getHobby());
        }

        if(!StringUtils.isEmpty(personDto.getAddress())) {
            this.setAddress(personDto.getAddress());
        }

        if(!StringUtils.isEmpty(personDto.getJob())) {
            this.setJob(personDto.getJob());
        }

        if(!StringUtils.isEmpty(personDto.getPhoneNumber())) {
            this.setPhoneNumber(personDto.getPhoneNumber());
        }

        if(personDto.getBirthday() != null) {
            this.setBirthday(Birthday.of(personDto.getBirthday()));
        }
    } // StringUtils 를 사용하여 Dto에 있는 값이 비어있지 않은 경우 Dto에 있는 값을 가져온다.

    public Integer getAge() {
        if(this.birthday != null) {
            return LocalDate.now().getYear() - this.birthday.getYearOfBirthday() + 1;
        }
        else {
            return null;
        }
    } // 나이는 Birthday 객체의 연도 값을 가져와 현재 연도와 비교하여 구하도록 한다.

    public boolean isBirthdayToday() {
        return LocalDate.now().equals(LocalDate.of(
                this.birthday.getYearOfBirthday(),
                this.birthday.getMonthOfBirthday(),
                this.birthday.getDayOfBirthday()));
    }
}
