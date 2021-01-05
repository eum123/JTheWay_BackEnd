-- root/djaakswls
-- root/djaakswls1!

-- create database
CREATE DATABASE haaim_db;

-- create user
CREATE USER 'haaim'@'localhost' IDENTIFIED BY 'haaim01';

-- insert , update, delete etc
GRANT ALL PRIVILEGES on haaim_db.* TO 'haaim'@'localhost';
FLUSH PRIVILEGES;

-- sample table
create table sample (
	name varchar (10) not null, 
    age int(3) default 0,
    PRIMARY KEY (name)
) default charset=utf8;

insert into sample values('hong', 30);

-- ---------------
CREATE TABLE IF NOT EXISTS `user` (
  `no` INT(10) NOT NULL  AUTO_INCREMENT primary key,
  `user_id` VARCHAR(45) NOT NULL,
  `user_pw` VARCHAR(200) NOT NULL,
  `user_type` INT(1) NOT NULL COMMENT '사용자의구분/권한 ( 4:관리자/3:원장/2:교사/1:코디/0:학생)',
  `use_yn` INT(1) NOT NULL COMMENT '사용여부',
  `name` VARCHAR(20) NULL,
  `mobile` VARCHAR(15) NULL,
  `email` VARCHAR(200) NULL,
  `student_no` INT(10) NULL,
  `state` INT(1) NULL,
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME  NULL,
   INDEX (student_no),
  FOREIGN KEY(student_no) REFERENCES student_info(student_no)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '사용자';


CREATE TABLE IF NOT EXISTS student_info (
  `student_no` INT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `birth` VARCHAR(8) NULL COMMENT '생년월일',
  `mobile` VARCHAR(15) NOT NULL COMMENT '연락처',
  `email` VARCHAR(100) NOT NULL,
  `father_mobile` VARCHAR(20) NULL COMMENT '아버지연락처',
  `mother_mobile` VARCHAR(20) NULL COMMENT '어머니연락처',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL,
   PRIMARY KEY (student_no)
  
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '학생정보';

CREATE TABLE IF NOT EXISTS class_student (
  `no` INT(10) NOT NULL AUTO_INCREMENT primary key,
  `class_no` INT(10) NOT NULL,
  `student_no` INT(10) NOT NULL,
  `status` INT(1) NOT NULL COMMENT 'drop 여부',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL
  )
ENGINE = InnoDB
COMMENT = '클래스&학생 매핑정보';

CREATE TABLE IF NOT EXISTS `haaim`.`class_mngt` (
  `student_no` INT(10) NOT NULL,
  `date` VARCHAR(8) NOT NULL,
  `attendance` INT(2) NULL COMMENT '출석',
  `homework` VARCHAR(45) NULL COMMENT '과제',
  `comment` VARCHAR(45) NULL COMMENT '교사의견',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`student_no`, `date`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '출석/테스트/과제/ 학업상태 레포트.';

CREATE TABLE IF NOT EXISTS class (
  `class_no` INT(10) NOT NULL AUTO_INCREMENT primary key COMMENT '클래스 번호',
   `year` INT(4) NOT NULL COMMENT '기간',
  `class_name` VARCHAR(100) NULL COMMENT '클래스명',
  `teacher_no` INT(10) NULL COMMENT '교사 no.',
  `start_date` VARCHAR(10) NOT NULL COMMENT '클래스 시작 기간',
  `end_date` VARCHAR(10) NOT NULL COMMENT '클래스 종료 기간',
  `day_time` VARCHAR(45) NULL COMMENT '수업 요일 & 시간 ',
  `textbook` VARCHAR(500) NULL COMMENT '교재',
  `pass_score` INT(3) NULL COMMENT 'PASS 기준 점수',
  `description` VARCHAR(1024) NULL COMMENT '기타정보',
  `input_id` VARCHAR(45) NULL,
  `input_date` DATETIME NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '수업관리';


CREATE TABLE IF NOT EXISTS class_curriculum (
  `no` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `class_no` INT(10) NOT NULL COMMENT '클래스번호',
  `cur_id` INT(10) NOT NULL COMMENT '컬리큘럼ID',
  `input_id` VARCHAR(45) NULL,
  `input_date` DATETIME NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL)
ENGINE = InnoDB
COMMENT = '클래스&커리큘럼 매핑';


CREATE TABLE IF NOT EXISTS curriculum (
  `no` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `year` INT(4) NOT NULL,
  `grade` INT(2) NOT NULL COMMENT '학년',
  `course` INT(4) NOT NULL COMMENT '학기/과정',
  `large_category` VARCHAR(10) NULL COMMENT '대분류',
  `medium_category` VARCHAR(10) NULL COMMENT '중분류',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '커리큘럼';

CREATE TABLE IF NOT EXISTS `score_mngt` (
  `no` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `year` INT NOT NULL,
  `student_no` INT NOT NULL,
  `term` VARCHAR(45) NULL COMMENT '학기, 기간',
  `exam` VARCHAR(45) NOT NULL COMMENT '시험 (midterm exam / finals / mock test / sat)',
  `score` VARCHAR(45) NOT NULL COMMENT '점수',
  `description` VARCHAR(500) NULL,
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '시험점수관리(중간/기말/모의고사/수능점수)';

CREATE TABLE IF NOT EXISTS `haaim`.`student_detail` (
  `year` INT(4) NOT NULL COMMENT '년도',
  `student_no` INT(10) NOT NULL COMMENT '학생NO',
  `school` VARCHAR(45) NULL COMMENT '학교',
  `grade` INT(2) NULL COMMENT '학년',
  `test_date` VARCHAR(8) NULL COMMENT '테스트일자',
  `test_range` VARCHAR(45) NULL COMMENT '테스트 범위',
  `counsel_date` VARCHAR(8) NULL COMMENT '상담일자',
  `join_date` VARCHAR(8) NULL COMMENT '등록일자',
  `intelligibility` INT(1) NULL COMMENT '이해도',
  `concentrativeness` INT(1) NULL COMMENT '집중도',
  `practical_ability` INT(1) NULL COMMENT '응용력',
  `precedence_degree` INT(1) NULL COMMENT '선행정도',
  `first_time` VARCHAR(8) NULL COMMENT '최초 수업일',
  `haaim_goal` INT(3) NULL COMMENT '학원 목표치',
  `parents_goal` INT(3) NULL COMMENT '학부모 목표치',
  `comments` VARCHAR(1024) NULL COMMENT '특이사항',
  `merits` VARCHAR(1024) NULL COMMENT '장점',
  `lesson_aims` VARCHAR(1024) NULL COMMENT '학습목표',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`year`, `student_no`),
  INDEX `fk_student_detail_student_info1_idx` (`student_no` ASC))
ENGINE = InnoDB
COMMENT = '년도별 학생정보';

CREATE TABLE IF NOT EXISTS monthly_report (
  `no` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `class_no` INT(10) NOT NULL,
  `student_no` INT(10) NOT NULL,
  `year` INT(4) NOT NULL COMMENT '년',
  `month` INT(2) NOT NULL COMMENT '월',
  `title` VARCHAR(200) NULL COMMENT '월간리포트 타이틀',
  `start_date` VARCHAR(8) NULL COMMENT '기간 시작일',
  `end_date` VARCHAR(8) NULL COMMENT '기간 종료일',
  `homework` INT(3) NULL COMMENT '과제이행 회수',
  `homework_total` INT(3) NULL COMMENT '과제 총 횟수',
  `excellence` VARCHAR(300) NULL COMMENT '장점',
  `goal` VARCHAR(300) NULL  COMMENT '목표',
  `notice` VARCHAR(500) NULL  COMMENT '전달사항',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL
  )
ENGINE = InnoDB
COMMENT = '월간리포트';

CREATE TABLE IF NOT EXISTS `haaim`.`answer_sheet` (
  `exam_no` INT(20) NOT NULL COMMENT '시험지번호',
  `student_no` INT(10) NOT NULL COMMENT '학생번호',
  `question_no` INT(2) NOT NULL COMMENT '문제번호',
  `answer` VARCHAR(500) NULL COMMENT '답',
  `file_path` VARCHAR(200) NULL,
  `result` INT(1) NULL COMMENT '채점결과 (0:X/ 1:O)',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`exam_no`, `student_no`, `question_no`),
  INDEX `fk_table1_class_student1_idx` (`student_no` ASC))
ENGINE = InnoDB
COMMENT = '답안지';

CREATE TABLE IF NOT EXISTS exam_list (
  `exam_no` INT(20) NOT NULL AUTO_INCREMENT COMMENT '출제번호',
  `date` VARCHAR(8) NOT NULL COMMENT '출제일자',
  `class_no` INT(10) NOT NULL,
  `grade` INT(2) NULL COMMENT '학년',
  `course` VARCHAR(4) NULL COMMENT '학기/과정',
  `medium_category` VARCHAR(10) NULL COMMENT '중분류',
  `type_group` VARCHAR(4) NULL COMMENT '유형그룹',
  `count` INT(4) NULL COMMENT '문항수',
  `level_difficulty` INT(1) NULL COMMENT '난이도',
  `target` VARCHAR(500) NULL COMMENT '응시대상',
  `goal_score` INT(3) NULL COMMENT 'pass 기준점수',
  `state` INT(1) NULL COMMENT '출제상태(출제/미출제)',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`exam_no`),
  INDEX `fk_exam_list_class1_idx` (`class_no` ASC))
ENGINE = InnoDB
COMMENT = '문제출제목록';

CREATE TABLE IF NOT EXISTS learn_plan_mngt (
  `no` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `year` INT(4) NOT NULL COMMENT '년도',
  `class_no` INT(10) NOT NULL COMMENT '클래스NO',
  `teacher_id` VARCHAR(45) NOT NULL COMMENT '교사id',
  `date` VARCHAR(8) NOT NULL COMMENT '일자',
  `time` VARCHAR(8) NOT NULL COMMENT '시간',
  `desc` VARCHAR(500) NULL COMMENT '의견',
  `input_date` VARCHAR(45) NULL,
  `input_id` DATETIME NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL)
ENGINE = InnoDB
COMMENT = '진도관리';

CREATE TABLE IF NOT EXISTS `haaim`.`item_pool` (
  `item_no` INT(30) NOT NULL,
  `year` INT(4) NOT NULL,
  `grade` INT(2) NOT NULL,
  `course` INT(4) NOT NULL,
  `medium_category` VARCHAR(10) NOT NULL COMMENT '중분류코드',
  `type_group` VARCHAR(10) NOT NULL COMMENT '유형그룹',
  `type` VARCHAR(10) NOT NULL COMMENT '유형',
  `question_type` INT(1) NOT NULL COMMENT '문제형태(객관식/주관식)',
  `question` VARCHAR(1024) NOT NULL,
  `choice1` VARCHAR(1024) NULL COMMENT '객관식 보기1',
  `choice2` VARCHAR(1024) NULL COMMENT '객관식 보기2',
  `choice3` VARCHAR(1024) NULL COMMENT '객관식 보기3',
  `choice4` VARCHAR(1024) NULL COMMENT '객관식 보기4',
  `choice5` VARCHAR(1024) NULL COMMENT '객관식 보기5',
  `file_path` VARCHAR(500) NULL,
  `mark_type` INT(1) NOT NULL COMMENT '채점 방법(자동/수동)',
  `answer` VARCHAR(1024) NULL COMMENT '주관식 답',
  `answer_path` VARCHAR(500) NULL COMMENT '주관식 답 image',
  `publisher` VARCHAR(200) NULL COMMENT '출판사',
  `workbook` VARCHAR(300) NULL COMMENT '문제집',
  `level_difficulty` INT(1) NULL COMMENT '난이도',
  `useYn` INT(1) NOT NULL COMMENT '사용여부',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`item_no`))
ENGINE = InnoDB
COMMENT = '문제은행';

CREATE TABLE IF NOT EXISTS `haaim`.`exam_item` (
  `exam_no` INT(20) NOT NULL,
  `no` INT(4) NOT NULL COMMENT '문제순서',
  `item_no` INT(30) NOT NULL,
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`exam_no`, `item_no`, `no`),
  INDEX `fk_exam_item_exam_list1_idx` (`exam_no` ASC) ,
  INDEX `fk_exam_item_item_pool1_idx` (`item_no` ASC))
ENGINE = InnoDB
COMMENT = '문제출제';

CREATE TABLE IF NOT EXISTS `menu` (
  `menu_code` VARCHAR(10) NOT NULL COMMENT '메뉴코드',
  `menu_name` VARCHAR(100) NOT NULL COMMENT '메뉴명',
  `parent_menu_code` VARCHAR(10) NULL COMMENT '부모 메뉴 코드',
  `depth` INT(1) NOT NULL COMMENT '메뉴 depth',
  `url` VARCHAR(200) NULL,
  `use_yn` INT(1) NOT NULL COMMENT '사용여부',  -- authority 테이블에 use_yn과 의미가 중복됨. menu에는 필요없음
  `sort` INT(2) NULL COMMENT '정렬순서',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`menu_code`))
ENGINE = InnoDB
COMMENT = '메뉴';

CREATE TABLE IF NOT EXISTS `authority` (
  `menu_code` VARCHAR(10) NOT NULL COMMENT '메뉴코드',
  `user_type` INT(1) NOT NULL COMMENT '사용자권한',
  `use_yn` INT(1) NOT NULL,
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL,
  PRIMARY KEY (`menu_code`, `user_type`))
ENGINE = InnoDB
COMMENT = '메뉴권한관리';

CREATE TABLE IF NOT EXISTS `code` (
  `no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `group_code` VARCHAR(20) NOT NULL COMMENT '그룹코드',
  `code` VARCHAR(20) NOT NULL COMMENT '코드',
  `code_name` VARCHAR(100) NOT NULL COMMENT '코드명',
  `use_yn` INT(1) NOT NULL COMMENT '사용여부',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL
  )
ENGINE = InnoDB
COMMENT = '코드';

CREATE TABLE IF NOT EXISTS `haaim`.`code_group` (
  `no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `code` VARCHAR(20) NOT NULL COMMENT '코드',
  `code_name` VARCHAR(100) NOT NULL COMMENT '코드명',
  `use_yn` INT(1) NOT NULL COMMENT '사용여부',
  `input_id` VARCHAR(45) NOT NULL,
  `input_date` DATETIME NOT NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL
  )
ENGINE = InnoDB
COMMENT = '코드 그룹';

CREATE TABLE IF NOT EXISTS `haaim`.`notice` (
  `no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title` VARCHAR(100) NULL COMMENT '제목',
  `contents` VARCHAR(1024) NULL COMMENT '내용',
  `state` INT(1) NULL COMMENT '상태(0:HIDDEN/1:VIEW)',
  `input_id` VARCHAR(45) NULL,
  `input_date` DATETIME NULL,
  `update_id` VARCHAR(45) NULL,
  `update_date` DATETIME NULL)
ENGINE = InnoDB
COMMENT = '공지사항';