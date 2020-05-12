# mycontact

## 프로젝트 개요
mycontact 프로젝트는 SpringBoot를 익히기 위해 시작한 프로젝트 입니다.
간단한 지인정보관리프로그램을 목표로 프로젝트를 진행하였으며, 뷰를 제외한 백엔드단을 SpringBoot를 이용하여 개발하였습니다.
데이터베이스는 강력하진 않지만 가볍고 빠른 기능을 기반으로 하여 테스트에 적합한 H2DB를 사용하였으며, H2DB와 연동하여 지인들의 정보를
입력하거나 수정, 삭제(Soft-Delete 이용)할 수 있습니다.

Spring.io를 이용하여 스프링 부트 프로젝트를 생성하는 방법부터 Gradle을 이용한 의존성 관리, 반복주기 개발에 대해 공부하였습니다.
데이터모델, 서비스, 컨트롤러의 API들의 기본적인 기능을 순차적으로 구현하고 다시 한 번 앞의 주기를 반복하여 각각의 기능에 대한 고도화를
진행하였습니다.

## 사용법
API들만 구현하여 뷰 구성이 없으므로 서버를 실행하고 localHost에 접속하여 URL을 입력하는 방법으로 기능을 수행하거나, 터미널에서 Http 명령어를
이용하여 기능을 수행합니다.


## 학습 내용

### 1-cycle

#### 1.JPA
- Entity생성(@OneToOne Relation의 CascadeType, FetchType, Optional 등의 기능) 
- QueryMethod(Method의 네이밍을 기반으로 하는 QueryMethod)
- @Embedded
- @Valid
- @Query
- @Where(Soft-Delete를 위해)
- Data.sql 등의 기능들을 공부하였습니다.

#### 2. SpringMVC
- @GetMapping
- @PostMapping
- @PutMapping
- @PatchMapping
- @DeleteMapping
- @PathVariable
- @RequestBody
등의 어노테이션을 학습하였습니다.

이 외에도 Lombok 라이브러리의 활용법(Getter, Setter, ToString, Constructor, EqualsAndHashCode, @Data 등의 어노테이션)과
SpringTest, Java8의 기능인 Stream이나 Filter, Map 등의 관해서도 학습하였습니다.


### 2-cycle

#### SpringMVC
- CustomJsonSerializer

#### SpringTest
- MockMvc Test
- Matcher
- Junit5

#### MockTest
- Mockito
- CustomArgumnetMatcher

#### Exception Handling
- CustomException
- ExceptionHandler
- GlobalExceptionHandler

#### Parameter Validator
- @NotEmpty
- @NotBlank
- @Valid

#### paging
- Pageable
- Page<T>

등에 관하여 학습하였습니다.
