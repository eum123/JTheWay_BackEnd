


## 메뉴
1. 목록
	 - 요청
       http://localhost/common/menu
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
		        "title": "title",
		        "contents": "content",
		        "input_date": "0"
		      }
		    ]
		  }
		}
      
      ``` 
			
2. 목록 (검색 조건 포함)
 	 - 요청
       http://localhost/common/menu?menu_code=1
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
		        "title": "title",
		        "contents": "content",
		        "input_date": "0"
		      }
		    ]
		  }
		}
      
      ``` 
      
3. 참고사항
 3 depth 이상 시 쿼리 변경 해야됨
 ### 테스트 데이터
	 ```
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) values('1', '이름1', '', 1, 'url1', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) values('11', 'sub1', '1', 2, 'url1', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) values('12', 'sub1', '1', 2, 'url1', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) values('2', '이름2', '', 1, 'url1', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) values('22', 'sub1', '2', 2, 'url1', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) values('23', 'sub2', '2', 2, 'url1', 0, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) values('3', '이름3', '', 1, 'url1', 0, 'id', sysdate());
	 ```
 
 ### 쿼리
	 ```
	 WITH RECURSIVE CTE AS (
	    SELECT 
			menu_code,
			parent_menu_code,
	        menu_name,
	        use_yn
		FROM menu 
		WHERE 
			parent_menu_code = ''
			and use_yn = 1
		UNION ALL
		SELECT
			a.menu_code,
			a.parent_menu_code,
	        a.menu_name,
	        a.use_yn
		FROM menu a
		inner JOIN CTE b ON a.parent_menu_code = b.menu_code and a.use_yn = 1
	)
	SELECT menu_code, parent_menu_code, menu_name FROM CTE;
	 ```