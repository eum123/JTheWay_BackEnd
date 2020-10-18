


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
3. 메뉴관리 목록
	- 요청
	 http://localhost:8080/menu/searchAll
	- 응답
	 ```json
      {
		  "success": true,
		  "code": 0,
		  "msg": "OK",
		  "data": [
		    {
		      "menu": {
		        "depth": 0,
		        "url": "/admin/user/userList.html",
		        "input_id": null,
		        "input_date": null,
		        "update_id": null,
		        "update_date": null,
		        "menu_code": "100",
		        "menu_name": "사용자관리",
		        "parent_menu_code": "",
		        "use_yn": 0
		      },
		      "user_types": [
		        "1",
		        "2",
		        "4"
		      ]
		    },
		    {
		      "menu": {
		        "depth": 0,
		        "url": "/admin/lessons/curriculumList.html",
		        "input_id": null,
		        "input_date": null,
		        "update_id": null,
		        "update_date": null,
		        "menu_code": "200",
		        "menu_name": "수업관리",
		        "parent_menu_code": "",
		        "use_yn": 0
		      },
		      "user_types": [
		        "1",
		        "2",
		        "4"
		      ]
		    },
		   ]
		  }
      
      ``` 
      
3. 참고사항
 3 depth 이상 시 쿼리 변경 해야됨
 ### 데이터
	 ```
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('100', '사용자관리', '', 1, '/admin/user/userList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('200', '수업관리', '', 1, '/admin/lessons/curriculumList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('210', '커리큘럼관리', '200', 1, '/admin/lessons/curriculumList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('220', '클래스관리', '200', 1, '/admin/lessons/classList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('230', '진도관리', '200', 1, '/admin/lessons/progressList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('300', '학생관리', '', 1, '/admin/student/studentList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('310', '학생관리', '300', 1, '/admin/student/studentList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('320', '온라인테스트', '300', 1, '/admin/student/examList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('330', '월간리포트', '300', 1, '/admin/student/monthlyReport.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('340', '커리큘럼교사의견', '300', 1, '/admin/student/curriculumComment.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('350', '시험점수', '300', 1, '/admin/student/schoolExamScoreList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('400', '문제관리', '', 1, '/admin/exam/examBankList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('410', '문제은행', '400', 1, '/admin/exam/examBankList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('420', '문제출제', '400', 1, '/admin/exam/examQuestionsList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('500', '시스템관리', '', 1, '/admin/system/menuList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('510', '메뉴관리', '500', 1, '/admin/system/menuList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('520', '코드관리', '500', 1, '/admin/system/codeList.html', 1, 'id', sysdate());
	insert into menu (menu_code, menu_name, parent_menu_code, depth, url, use_yn, input_id, input_date) 
	values('530', '공지사항관리', '500', 1, '/admin/system/noticeList.html', 1, 'id', sysdate());
	 ```

 ### 권한 저장
 	```
 	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('100', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('200', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('210', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('220', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('230', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('300', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('310', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('320', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('330', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('340', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('350', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('400', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('410', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('420', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('500', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('510', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('520', 2, 1, 'id', sysdate());
	insert into authority (menu_code, user_type, use_yn, input_id, input_date) 
	values('530', 2, 1, 'id', sysdate());
 	```
 
 ### 참고 쿼리
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