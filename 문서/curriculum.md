
## 커리큘럼
1. 목록
	 - 요청
       http://localhost/lessons/curriculum/all?page=1&size=10
     - 응답
      ```json
      {
		  "success": true,
		  "code": 0,
		  "msg": "OK",
		  "data": {
		    "content": [
		      {
		        "no": "1",
		        "year": "title",
		        "grade": "content",
		        "course": "content",
		        "large_category": "content",
		        "medium_category": "content",
		        "input_date": "0",
		        "input_id": "0",
		        "update e_date": "0",
		        "update_id": "0",
		      }
		    ],
		    "pageable": {
		      "sort": {
		        "sorted": true,
		        "unsorted": false,
		        "empty": false
		      },
		      "offset": 0,
		      "pageSize": 10,
		      "pageNumber": 0,
		      "paged": true,
		      "unpaged": false
		    },
		    "totalPages": 0,
		    "last": true,
		    "totalElements": 0,
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
			
2. 목록 (검색 조건 포함)
 	 - 요청
       http://localhost/lessons/curriculum/serach?page=1&size=10&title=title&contenst=contents
     - 응답
      ```json
      {
		  "success": true,
		  "code": 0,
		  "msg": "OK",
		  "data": {
		    "content": [
		      {
		        "no": "1",
		        "year": "title",
		        "grade": "content",
		        "course": "content",
		        "large_category": "content",
		        "medium_category": "content",
		        "input_date": "0",
		        "input_id": "0",
		        "update e_date": "0",
		        "update_id": "0",
		      }
		    ],
		    "pageable": {
		      "sort": {
		        "sorted": true,
		        "unsorted": false,
		        "empty": false
		      },
		      "offset": 0,
		      "pageSize": 10,
		      "pageNumber": 0,
		      "paged": true,
		      "unpaged": false
		    },
		    "totalPages": 0,
		    "last": true,
		    "totalElements": 0,
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
3. 저장 
 	 - 요청
       http://localhost/lessons/curriculum/regist
       method : POST
     - 응답
      ```json
      {
		  "success": true,
		  "code": 0,
		  "msg": "OK",
		  "data": {
		        "no": "1",
		        "year": "title",
		        "grade": "content",
		        "course": "content",
		        "large_category": "content",
		        "medium_category": "content",
		        "input_date": "0",
		        "input_id": "0",
		        "update e_date": "0",
		        "update_id": "0",
		      }
		}
      
      ``` 
4. 전체 조회
	 - 요청
       http://localhost/lessons/curriculum/list
     - 응답
      ```json
      {
		  "success": true,
		  "code": 0,
		  "msg": "OK",
		  "data": [
		      {
		        "no": "1",
		        "year": "title",
		        "grade": "content",
		        "course": "content",
		        "large_category": "content",
		        "medium_category": "content",
		        "input_date": "0",
		        "input_id": "0",
		        "update e_date": "0",
		        "update_id": "0",
		      }
		   ]
		}
      
      ``` 