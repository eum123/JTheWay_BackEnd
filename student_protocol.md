
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
## 학교 시험
	1. 목록
	 - 요청
        * 전체 : http://localhost:8080/student/school/exam/all
     - 응답
      ```json
       
       {
		  "success": true,
		  "code": 0,
		  "msg": "OK",
		  "data": {
		    "content": [
		      {
		      	"no": 111,
		      	"student_no": 11,
		      	"year": 2020,
		      	"term": "1111",
		      	"exam": "1231231",
		      	"score": "12",
		      	"description": "12",
		      	"input_id": "12",
		      	"input_date": "12",
		      	"update_id": "12",
		      	"update_date": "12"
		      }
		    ],
		    "pageable": {
		      "sort": {
		        "sorted": true,
		        "unsorted": false,
		        "empty": false
		      },
		      "offset": 0,
		      "pageNumber": 0,
		      "pageSize": 10,
		      "paged": true,
		      "unpaged": false
		    },
		    "totalElements": 0,
		    "last": true,
		    "totalPages": 0,
		    "number": 0,
		    "size": 10,
		    "sort": {
		      "sorted": true,
		      "unsorted": false,
		      "empty": false
		    },
		    "numberOfElements": 0,
		    "first": true,
		    "empty": true
		  }
		}
      ```