# 코드
## 코드 목록 조회
	- 내용
		group_code에 해당하는 모든 code를 조회 한다.
   	- 요청
       http://.../code/search?groupcode=1[&usage=1]
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
		    ]
		  }
		}
      
      ```
      
