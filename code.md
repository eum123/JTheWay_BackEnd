# 코드
## 코드 전체 조회
	- 내용
		group_code에 해당하는 모든 code를 조회 한다.
   	- 요청 (GET)
       http://localhost:8080/code/all
       page : 현재 페이지
       size : 한페이지에 보여줄 개수
       usage : 사용여부(1-사용, 0-비사용)
    - 응답
      ```json
      {
		  "success": true,
		  "code": 0,
		  "msg": "OK",
		  "data": {
		    "content": [
		      {
		        "group_code": "1",
		        "code": "title",
		        "code_name": "content",
		        "use_yn": "0"
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
		      "unpaged": false,
		      "paged": true
		    },
		    "last": true,
		    "totalElements": 0,
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
## 코드 목록 조회
	- 내용
		group_code에 해당하는 모든 code를 조회 한다.
   	- 요청(GET)
       http://.../code/search?name=1[&use_yn=1]
       name: 코드명 또는 그룹명 (like로 조회)
       use_yn : optional 사용여부 (1-사용, 0-미사용)
    - 응답
      ```json
      
		{
		  "success": true,
		  "code": 0,
		  "msg": "OK",
		  "data": {
		    "content": [
		      {
		        "group_code": "1",
		        "code": "title",
		        "code_name": "content",
		        "use_yn": "0"
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
		    "last": true,
		    "totalElements": 0,
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
      
