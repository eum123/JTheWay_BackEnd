
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
         
         [
          {
            "day" : "1",
            "list": [
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
          },
          {
            "day": "2",
            "list": []
          },
          {
            "day" : "3",
            "list": [
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
          },
          {
            "day": "4",
            "list": []
          },
          {
            "day": "5",
            "list": []
          },
          {
            "day": "6",
            "list": []
          },
          {
            "day": "7",
            "list": []
          },
         ]
       
      ```
## 사용자 목록
 1. 목록
    - 요청
       http://....
    - 응답
      ```json
      {
        "total": 400,
        "list" : [{ 
          "no": "2",               //번호
          "userKindCode": "0",     //사용자구분
          "userKindName": "관리자",
          "userName": "장덕일",      //사용자명
          "id": "jdi",             //아이디
          "mobile": "010-1111-1111",      //휴대폰번호
          "email": "jdi@mail.com",         //이메일
          "usage": "1"             //사용여부
          },      
          { 
          "no": "1",             //번호
          "userKindCode": "1",   //사용자구분
          "userKindName": "교사",
          "userName": "김교사",    //사용자명
          "id": "jdi",           //아이디
          "mobile": "010-1111-2222",      //휴대폰번호
          "email": "jdi@mail.com",         //이메일
          "usage": "1"           //사용여부
          }
        ]
      }
      ```

## 시스템
1. 코드 조회
    - 요청
       http://....
    - 응답
      ```json
      {
        "code": "400",
      }
      ```
2. 코드 목록 조회
   - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
            "no": "1",
            "groupCode": {
              "code": "222",
              "name": "그룹코드명"
            },
            "code": {
              "code": "111",
              "name": "코드명"
            },
            "usage": "1",
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```
