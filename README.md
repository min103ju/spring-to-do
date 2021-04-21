# Spring-to-do Web Application

---
## Description
* Spring을 이용한 To-do Web
* Spring Security를 이용한 회원가입/로그인
* Strategy Pattern을 이용한 Search 기능
* View의 style은 BootStrap을 이용
* Java 8의 숙련도 상승
---
## Environment
* Java 1.8
* Spring boot 2.4.4
* Gradle
* Axios
* Bootstrap 4.0.0
* H2 In-Memory DB
* Jquery 3.2.1
---
## Dependencies
```
compile('org.springframework.boot:spring-boot-starter-thymeleaf')
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.springframework.boot:spring-boot-starter-web'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
testImplementation 'org.springframework.boot:spring-boot-starter-test'

implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'

runtimeOnly 'com.h2database:h2'

compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok'
```
---
## 주요 기능
1. 사용자 가입
2. 사용자 로그인/로그아웃
3. Todo 등록
4. Todo 목록 조회(로그인한 사용자 본인것만 조회 가능)
5. Todo 삭제
6. Todo 완료 처리
7. Todo 내용 검색
