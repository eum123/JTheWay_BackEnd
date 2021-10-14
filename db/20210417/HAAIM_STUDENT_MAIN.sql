-- 학생 메인 
-- 월별 출결, 

select a.date,
--  a.class_no, 
sum(if(a.attendance=1,1,0)) tot_atd, sum(if(a.attendance!=1,1,0)) tot_miss
from class_mngt a
where  a.student_no = 1
and date between '20210401' and '20210431'
group by a.date;

-- 온라인테스트 pass,fail count
-- 응시 완료일 기준
select sum(a.pass) pass, sum(fail) fail
from (
SELECT e.class_no, e.exam_no, 
sum(if(e.goal_score <= u.score,1,0)) pass, 
sum(if(e.goal_score > u.score,1,0)) fail, u.score, e.goal_score
FROM exam_list e join exam_user u
where e.exam_no = u.exam_no
and e.state = 1
and u.student_no=1
and date_format(sysdate(),'%Y%m%d') >= e.sDate
and date_format(sysdate(),'%Y%m%d') <= e.eDate
group by e.class_no, e.exam_no
) a 
;

-- No, 년도, 클래스, 커리큘럼, 출제일자, 응시일자, 문항수, 점수, 응시여부  

select c.year, b.class_no, c.cur, b.출제일, b.응시일, b.문항수, b.점수, b.pass여부, b.응시여부
from (
select b.cc_no, b.class_no, b.exam_no, a.student_no, 
		date_format(b.sDate,'%Y-%m-%d') 출제일, 
		date_format(a.input_date,'%Y-%m-%d') 응시일, 
		b.count 문항수, 
		a.score 점수, 
		if(a.status != 2, if(a.score >= b.goal_score,'pass' ,'fail'),'-') pass여부, 
		if(a.status = 1, '미응시', '응시') 응시여부,
        a.status
from exam_user a join exam_list b 
where a.exam_no = b.exam_no) b join (
select a.year, c.no, c.class_no, a.class_name,
--  c.cur_id, m.cno, 
concat(m.grade,'> ', m.course, '> ', getCurNm(m.large_category, m.medium_category)) as cur
from class_curriculum c join class a
join curriculum m
where c.class_no = a.class_no
and c.cur_id = m.cno) c
where b.cc_no = c.no
and b.student_no=1
-- and date_format(b.출제일,'%Y%m') = date_format(sysdate(),'%Y%m')   -- 조회조건 : 년월
-- and b.status = '3'  												-- 조회조건 : 응시여부 
order by year, class_no, cur
;




