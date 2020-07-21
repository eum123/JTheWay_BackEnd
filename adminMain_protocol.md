
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
3. 메뉴 목록 조회
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
            "no": "1",
            "depth1": {
              "code": "222",
              "name": "그룹코드명"
            },
            "depth2": {
              "code": "222",
              "name": "그룹코드명"
            },
            "depth3": {
              "code": "222",
              "name": "그룹코드명"
            },
            "isManager": "0",
            "isPartTime": "0",
            "isTeacher": "1",
            "isStudent": "0",
            "usage": "1",
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```
4. 공지사항 목록 조회
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
            "no": "1",
            "subject": "",
            "content": "0",
            "writeDate": "0",
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```

4. 테스트 목록 조회
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
            "no": "1",
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
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```

5. 학생 목록 조회
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
            "no": "1",
            "school":"2020",
            "grade": "2",
             "class": "class",
             "name": "홍길동",
             "studentMobile": "01001112222",
             "parentMobile": "01001113333",
             "regDate": "2020.05.01",
             
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```
6. class 목록
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
            "no": "1",
            "year":"2020",
             "class": "class",
             "curriculum": "중1 > 1학기 > 소인수분해 > 01 소인수분해",
             "number": "10",
             "startTime":"2020",
             "endTime": "class",
             "teacher": "김선생",
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```
7. curriculum 목록
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
            "no": "1",
            "year":"2020",
             "grade": "class",
             "curriculum": "중1 > 1학기 > 소인수분해 > 01 소인수분해",
             "depth1": "10",
             "depth2":"2020",
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```
8. 진도 목록
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
            "no": "1",
            "date":"2020.01.01",
             "class": "class",
             "startTime": "10:00",
             "endTime": "11:00",
             "teacher": "나선생",
             "progress": [
               {"order": 
                {
                 "name" : "A",
                 "status": "1"
                }
               },
               {"order": 
                {
                 "name" : "B",
                 "status": "1"
                }
               },
               {"order": 
                {
                 "name" : "C",
                 "status": "1"
                }
               },
               {"order": 
                {
                 "name" : "D",
                 "status": "0"
                }
               },
               {"order": 
                {
                 "name" : "E",
                 "status": "0"
                }
               },
               {"order": 
                {
                 "name" : "F",
                 "status": "0"
                }
               },
               {"order": 
                {
                 "name" : "G",
                 "status": "0"
                }
               },
               
             ],
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```
9. 문제은행 목록
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
            "no": "1",
            "year":"2020",
            "curriculum": "중3 > 1학기 > Ⅰ 소인수분해 > 01 소인수분해",
             "type": "A",
             "question": "다항식 f(x)를 x-1/3로 나누었을때의 몫을 Q(x), 나머지를
                        R라 할 때, f(x)를 3x-1로 나누었을 때의 몫과 나머지를
                        순서대로 적으면?",
             "level": "*****",
             "usage": "0",
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```
10. 문제 출제 목록
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
            "no": "1",
            "class":"2020",
            "curriculum": "중3 > 1학기 > Ⅰ 소인수분해 > 01 소인수분해",
             "questionDate": "2020.01.02",
             "questionCount": "10",
             "passBaseScore": "10",
             "doMember": "0",
             "avgScore": "10",
             "makeDate": "2020.01.01"
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```

11.월간 리포트
   - 요청
       http://....
    - 응답
      ```json
      {
        
        "school": "학교",
        "studentName": "나학생",
        "grade": "1",
        "report": [
          {
            "grade": "중3",
            "schoolTerm": "1학기",
            "m1": {
              "status": "0",
              "key": ""
            },
            "m2": {
              "status": "0",
              "key": ""
            },
            "m3": {
              "status": "0",
              "key": ""
            },
            "m4": {
              "status": "0",
              "key": ""
            },
            "m5": {
              "status": "0",
              "key": ""
            },
            "m6": {
              "status": "0",
              "key": ""
            },
            "m7": {
              "status": "1",
              "key": "111"
            },
            "m8": {
              "status": "0",
              "key": ""
            },
            "m9": {
              "status": "0",
              "key": ""
            },
            "m10": {
              "status": "0",
              "key": ""
            },
            "m11": {
              "status": "0",
              "key": ""
            },
            "m12": {
              "status": "0",
              "key": ""
            },
          },
          {
            "grade": "중2",
            "schoolTerm": "1학기",
            "m1": {
              "status": "0",
              "key": ""
            },
            "m2": {
              "status": "0",
              "key": ""
            },
            "m3": {
              "status": "0",
              "key": ""
            },
            "m4": {
              "status": "0",
              "key": ""
            },
            "m5": {
              "status": "0",
              "key": ""
            },
            "m6": {
              "status": "0",
              "key": ""
            },
            "m7": {
              "status": "1",
              "key": "111"
            },
            "m8": {
              "status": "0",
              "key": ""
            },
            "m9": {
              "status": "0",
              "key": ""
            },
            "m10": {
              "status": "0",
              "key": ""
            },
            "m11": {
              "status": "0",
              "key": ""
            },
            "m12": {
              "status": "0",
              "key": ""
            },
          }
        ]

      }
      ```

11. 시험 점수 조회
    - 요청
       http://....
    - 응답
      ```json
        {
          
          "list": [
            {
              "examName": "3월 모의고사",
              "score":"8",
              "maxScore": "10",
              "remark": "중3 > 1학기 > Ⅰ 소인수분해 > 01 소인수분해",
            }
          ],
          
        }
      ```

12. 커리큘럼별 교사 의견
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
          
            "class":"2020",
            "curriculum": "중3 > 1학기 > Ⅰ 소인수분해 > 01 소인수분해",
             "comment": "교사의견",
            
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```

13. 문제선택
    - 요청
       http://....
    - 응답
      ```json
      {
        
        "list": [
          {
          
            "no":"1",
            "question": "문제문제",
             "level": "1",
            
          }
        ],
        "pagination": {
            "total": 10,
            "countPerPage": 10  
         } 
      }
      ```     

     