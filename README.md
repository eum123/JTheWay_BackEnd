# HAAIM
 
# was
- JDK 1.8 (open JDK 포함)
- SpringBoot 1.5.1
- MySQL 5.X
- jpa
- api doc 참고(https://www.popit.kr/spring-rest-docs/)

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
