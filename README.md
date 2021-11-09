# HAAIM

# 사전 준비
 ## MySQL 설치 및 설정 
  - create user haaim@'%' identified by 'haaim01';
  - create user haaim@localhost identified by 'haaim01';
  - create database haaim_db default character set utf8;
  - grant all privileges on haaim_db.* to haaim@'%';
  - grant all privileges on haaim_db.* to haaim@localhost;
  - flush privileges;
  - SET GLOBAL log_bin_trust_function_creators = 1;
 
 ## 참고 
  - 사용자 확인 : select host, user from user;
  - 권한 확인 : show grants for haaim@'%';

# 개발환경
- DB에 테이블을 생성한다.
- mvn generate-sources 를 이용하여 테이블에 해당하는 java source를 생성한다.
- 테이블이 변경 또는 생성 될때 마다 소스를 생성해야 한다.
- 2021.10.12 jooq 에서 mybatis로 변경.
 
 
# was
- JDK ~~1.8~~ 11 (open JDK 포함)
- SpringBoot ~~1.5.1~~ 2.x
- MySQL 5.X
- jpa
- api doc 참고(https://www.popit.kr/spring-rest-docs/)
- ~~querydsl 추가로 entity 추가 할때 마다 mvn package 실행 해야됨.~~
- ~~JOOQ 추가로 table 변경시 source-generate 실행 해야 됨~~
- mybatis paging : https://oingdaddy.tistory.com/329

# web
- http-server 설치
  ```
  http-server가 없다면

  npm install http-server -g
  위 키워드로 http-server를 전역으로 설치해 준 다음

  npx http-server
  위 명령어로 http-server를 실행시켜 해당 폴더를 서버에 올립니다.

  http://127.0.0.1:8080
  위 URI로 접속해서 에러가 사라진 것을 확인합니다.

  만약 서버가 올라가는 포트를 기본인 8080이 아닌 다른 포트로 실행하고 싶다면

  npx http-server -p 원하는 포트번호
  로 서버를 실행해 해당 포트로 접속하면 됩니다.
  ```
- 화면과 연동 규격
  ```
  *.md 파일에 정의
  ex) student_protocol.md
  ```
- 약간의 vue.js

# ERROR
- 테스트 시 java.sql.SQLException: Unable to load authentication plugin 'caching_sha2_password'. mysql 오류 처리 방법
```
 ALTER USER 'haaim'@'localhost' IDENTIFIED WITH mysql_native_password BY 'haaim01';
```

# 개발상황
```
- 학생
	1. 메인 () E
	2. 온라인테스트 () E (작업중)
	    - 목록 
	    	- 전체 (backend 완료)
	    	- 검색 (backend 완료)
	    - 온라인테스트 E
	    - 온라인테스트 결과 E
- admin 
	0. 메인 () E
	1. 사용자 관리
		- 목록 (완료) E
		- 등록 () E
	2. 수업관리
		1. 커리큘럼관리 
			- 목록 () E
			- 등록 () E
		2. 클래스관리
			- 목록 () E
			- 등록 () E
		3. 진도관리
			- 목록 () E
			- 등록 ()
	3. 학생관리
		1. 학생관리
			- 목록 () E
			- 등록 ()
			- 학생 정보 ()
		2. 온라인테스트 ()
		3. 월간리포트 ()
		4. 커피큘럼교사의견 ()
		5. 시험점수
			- 목록 ()
			- 등록 ()
	4. 문제관리
		1. 문제은행 ()
			- 목록 (70%) E
			- 등록 ()
		2. 문제출제 ()
	5. 시스템관리
		1. 메뉴관리 (제외 하기로 합의)
			- 목록 () E
			- 등록 ()
		2. 코드관리
			- 목록 (완료) E
			- 등록 (완료) E
			- 그룹추가 (완료) E
		3. 공지사항관리
			- 목록 (완료) E
			- 등록 (완료) E
```