package com.fastcampus.javaallinone.project3.mycontact.exception;

import lombok.extern.slf4j.Slf4j;

/*찾는 지인이 존재하지 않을 때 발생하는 Exception*/
@Slf4j
public class PersonNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Entity가 존재하지 않습니다.";

    public PersonNotFoundException() {
        super(MESSAGE);
        log.error(MESSAGE);
    }
}
