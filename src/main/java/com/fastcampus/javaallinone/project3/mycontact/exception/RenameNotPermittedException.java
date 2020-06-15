package com.fastcampus.javaallinone.project3.mycontact.exception;

import lombok.extern.slf4j.Slf4j;

/*사용자가 올바른 방법으로 이름을 변경하지 않았을 때 발생하는 Exception*/
@Slf4j
public class RenameNotPermittedException extends RuntimeException {
    private static final String MESSAGE = "이름 변경이 허용되지 않습니다.";

    public RenameNotPermittedException() {
        super(MESSAGE);
        log.error(MESSAGE);
    }

}
