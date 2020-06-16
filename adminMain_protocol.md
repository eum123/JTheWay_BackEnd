
# admin
## 메인
  1. 클래스 목록
     - 요청
       http://....
     - 응답
      ```json
      [{ "class": "클래스1",      //클래스
         "appearance": "5/6",   //출석
         "examination": "6/6",  //온라인테스트
         "pass": "90%",         //pass 비율
         "average": "82"},      //평균
         { "class": "클래스2", 
         "appearance": "5/6", 
         "examination": "6/6", 
         "pass": "90%", 
         "average": "82"}
      ]
      ``` 
  2. 출석률/온라인테스트 응시률
     - 요청
     - 응답
      ```json
       
      {
       "appearance": 30,    //수업참가율
       "examination": 80    //시험참가율
      }
       
       ```
  3. 테스트결과
     - 요청
     - 응답
      ```json
        [
         ["data1", 30, 200, 100, 400, 150, 250],
         ["data2", 50, 20, 10, 40, 15, 25]
        ]
      ```


  4. 3월 2주 수입 스케줄
     - 요청
        * 전체 : http://....
     - 응답
      ```json
       {  "date" : [3,4,5,6,7,8,9],
         "list" : [
           {
             "startTime":"2020",
             "endTime": "class",
             "class": "01 소인수분해",
             "level": ["A", "B"]  //난이도
           },
           {
             "startTime":"2020",
             "endTime": "class",
             "class": "01 소인수분해",
             "level": ["A", "B"]  //난이도
           }
           
         ]
       }
      ```