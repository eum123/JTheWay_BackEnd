
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
## 문제 출제 목록
1. 목록
	 - 요청
        * 전체 : http://localhost:8080/student/question/all
     - 응답
      ```json
      	{
		  "success": true,
		  "code": 0,
		  "msg": "OK",
		  "data": {
		    "content": [
		      {
		      	...
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
## 문제 출제 내용
1. 목록
	 - 요청
        * 전체 : http://localhost:8080/student/question/item
     - 응답
      ```json
      	
      ```
      
## 문제 출제 comment 저장
  - 설명
  	StudentExamController.java
  	
  - 요청
    * 전체 : http://localhost:8080/student/question/comments/save
  - 응답
    ```json
      	
    ```
    
## 객관식 문제 답 제출 
  - 설명
  	StudentExamController.java
  	
  - 요청
    * 전체 : http://localhost:8080/student/question/choice/save
    * Method : POST
  - 응답
    ```json
      	
    ```
## 주관식 문제 답 제출
  - 설명
  	StudentExamController.java
  	
  - 요청
    * 전체 : http://localhost:8080/student/question/contents/save
    * Method : POST
    
  - 응답
    ```json
      	
    ```
## 학생 메인 출석 그래프
  - 설명
  	StudentController.java
  	
  - 요청
    * 전체 : http://localhost:8080/student/attendance/monthly
    * Method : POST
    
  - 응답
    ```json
      	
    ```
## 학생 메인 시험 그래프
  - 설명
  	StudentExamController.java
  	
  - 요청
    * 전체 : http://localhost:8080/student/question/monthly
    * Method : POST
    
  - 응답
    ```json
      	
    ```
## 온라인 테스트 미진행 건수 조회
  - 설명
  	StudentExamController.java
  	
  - 요청
    * 전체 : http://localhost:8080/student/question/now
    * Method : POST
    
  - 응답
    ```json
      	
    ```