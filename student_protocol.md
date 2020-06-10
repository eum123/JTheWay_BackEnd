
# 학생
## 메인
  1. 학생정보
     - 요청
       http://....
     - 응답
      ```json
      { "name": "홍길동"}
      ``` 
  2. 공지사항
     - 요청
     - 응답
      ```json
       
         ["1. 공지사항1","2. 공지사항1","3. 공지사항1","4. 공지사항1","5. 공지사항1"]
       
       ```
  3. 월별 현황
     - 요청
     - 응답
      ```json
       {
         "month": 3,
         "attendanceRate": 30,
         "examRate": 30 
       }
      ```
  4. 온라인테스트목록
     - 요청
        * 전체 : http://....
     - 응답
      ```json
       {
         "list": [
           {
             "year":"2020",
             "class": "class",
             "curriculum": "중1 > 1학기 > 소인수분해 > 01 소인수분해",
             "exam": {
               "count": 10, //문항수
               "questionsDate": "2020.02.09", //출제일자
               "doDate": "2020.02.10", //응시일자
               "status": "fail", 
               "score": 10, //점수
               "isTakeExam": "1" //응시여부 (1-응시, 0-미응시)
             }
           },
           {
             "year":"2020",
             "class": "class",
             "curriculum": "중1 > 1학기 > 소인수분해 > 01 소인수분해",
             "exam": {
               "count": 10,
               "questionsDate": "",
               "doDate": "",
               "status": "-",
               "score": 0,
               "isTakeExam": "0"
             }
           }
         ],
         "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
       }
      ```