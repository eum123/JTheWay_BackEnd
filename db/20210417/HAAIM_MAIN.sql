-- 교사Main 일별 [클래스 / 출석/ 온라인테스트 / 패스비율 / 평균점수]
select c.class_no, 
	   c.class_name,  
       a.date, 
       c.pass_score, 
       concat_ws('/',a.tot_atd,m.total) atd, 
       concat_ws('/',e.tot_test,e.tot_mem) test, 
       e.pass, 
       e.avg,
	   c.day_time, a.name  -- 팝업 노출 내용
from class c  
-- 클래스별 멤버정보
join (select  class_no, count(*) total
from class_members
where member_type=0 and status is null
group by class_no) m 
-- 일별 클래스별멤버 출석 정보 
join (select a.date, a.class_no, count(*) tot_atd, 
GROUP_CONCAT((select name from student_info where student_no = a.student_no)) as name
from class_mngt a
where a.attendance = 1
-- and date = '20210405'
group by a.date, a.class_no) a

-- 클래스 멤버의 테스트 응시여부 / 패스여부 / 평균 정보 
join (SELECT e.class_no, e.exam_no, 
sum(if(u.status=1,0,1)) tot_test, count(u.status) tot_mem, 
sum(if(e.goal_score < u.score,0,1)) pass, 
round(sum(u.score)/sum(if(u.status=1,0,1)),2) avg
FROM exam_list e join exam_user u
where e.exam_no = u.exam_no
and e.state = 1
and date_format(sysdate(),'%Y%m%d') >= e.sDate
and date_format(sysdate(),'%Y%m%d') <= e.eDate
group by e.class_no, e.exam_no
) e
where c.class_no = m.class_no 
and c.class_no = a.class_no
and c.class_no = e.class_no
and c.year='2021' 
-- and a.date='20210402'
and c.start_date < date_format(sysdate(),'%Y%m%d')
and c.end_date > date_format(sysdate(),'%Y%m%d')
and c.status = 0
;

-- 전체 출석률 / 결석률
-- select sum(total) 
-- from (
select  
-- class_no, count(*) total
count(members)
from class_members
where member_type=0 and status is null
-- group by class_no
-- ) a
;

-- 일별 클래스별멤버 출결 정보 

select a.date, 
round(sum(if(a.attendance=1,1,0))/(select count(members) from class_members where member_type=0 and status is null) * 100)  tot_atd, 
round(sum(if(a.attendance != 1, 1, 0)) /(select count(members) from class_members where member_type=0 and status is null) * 100) tot_absent
from class_mngt a
group by a.date;

-- 전체 응시률 / 미응시률 
-- 조회 기준일자는 응시종료일자
-- 당일 기준으로 뽑아야 할지 종료일 어제 기준으로 뽑아야 할지...추후 결정. 
SELECT  
e.eDate,
round(sum(if(u.status=1,0,1)) /count(u.status) * 100) tot_take, 
round((count(u.status) - sum(if(u.status=1,0,1)) ) / count(u.status) * 100) tot_miss
FROM exam_list e join exam_user u
where e.exam_no = u.exam_no
and state = 1
and date_format(sysdate(),'%Y%m%d') = e.eDate
group by e.eDate;



-- 해당 일자 또는 CURDATE() 의 주차 
select concat_ws('','04','월 ',aa.a,'주차') 
from ( 
		select 
		week('20210404',0) - 
		week(DATE_SUB('20210404',INTERVAL DAYOFMONTH('20210404')-1 DAY),0) + 1 as a
		from dual
) aa; 

select concat_ws('','04','월 ',aa.a,'주차') 
from ( 
		select 
		week(CURDATE(),0) - 
		week(DATE_SUB(CURDATE(),INTERVAL DAYOFMONTH(CURDATE())-1 DAY),0) + 1 as a
		from dual
) aa; 

-- 해당 주간 클래스별 테스트 평균 

SELECT av.class_no, av.eDate, sum(av.avg)/count(av.exam_no) avg
FROM (
SELECT e.class_no , e.exam_no, e.eDate, round(sum(u.score)/sum(if(u.status=1,0,1)),2) avg
FROM exam_list e join exam_user u
where e.exam_no = u.exam_no
and e.state = 1
and date_format(eDate,'%Y-%m-%d') in ( -- 해당 일자의 주간일자 일~토
										SELECT
											ADDDATE( '20210404', - DAYOFWEEK('20210404') + 1 ) AS DAY
										UNION ALL SELECT 
											ADDDATE( '20210404', - DAYOFWEEK('20210404') + 2 ) AS DAY
										UNION ALL SELECT 
											ADDDATE( '20210404', - DAYOFWEEK('20210404') + 3 ) AS DAY
										UNION ALL SELECT 
											ADDDATE( '20210404', - DAYOFWEEK('20210404') + 4 ) AS DAY
										UNION ALL SELECT 
											ADDDATE( '20210404', - DAYOFWEEK('20210404') + 5 ) AS DAY
										UNION ALL SELECT 
											ADDDATE( '20210404', - DAYOFWEEK('20210404') + 6 ) AS DAY
										UNION ALL SELECT 
											ADDDATE( '20210404', - DAYOFWEEK('20210404') + 7 ) AS DAY
									)
group by class_no, exam_no) av
-- where av.class_no = 33
group by av.class_no, av.eDate;

