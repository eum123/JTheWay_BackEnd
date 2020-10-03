# 사용자
## 사용자 전체 조회
	- 내용
		group_code에 해당하는 모든 code를 조회 한다.
   	- 요청 (GET)
       http://localhost:8080/user/all
       page : 현재 페이지
       size : 한페이지에 보여줄 개수
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
## 사용자 검색
	- 내용
		group_code에 해당하는 모든 code를 조회 한다.
   	- 요청(GET)
       http://.../code/search?user_type=1[&use_yn=1][&key=1]
       page : 현재 페이지
       size : 한페이지에 보여줄 개수
       user_type: 사용가 권한 구분
       use_yn : optional 사용여부 (1-사용, 0-미사용)
       key : optional 이름, 전화번호 like 검색
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
      
