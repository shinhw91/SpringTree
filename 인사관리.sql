select * from (select rownum as rn, a.* from (
	 
	 SELECT EMPLOYEE_ID
			, FIRST_NAME
			, LAST_NAME
			, EMAIL
			, PHONE_NUMBER
			, HIRE_DATE
			, JOB_ID
			, SALARY
			, COMMISSION_PCT
			, MANAGER_ID
			, DEPARTMENT_ID
	 FROM employees e
	 ORDER BY employee_id
           
 ) a where rownum <=10) b where rn >=  1;
 
 
 
 
 SELECT * FROM (
 	 SELECT /*+INDEX_DESC(employees DEPT_ID_PK) */
                              rownum rn
                              , EMPLOYEE_ID
			, FIRST_NAME
			, LAST_NAME
			, EMAIL
			, PHONE_NUMBER
			, HIRE_DATE
			, JOB_ID
			, SALARY
			, COMMISSION_PCT
			, MANAGER_ID
			, DEPARTMENT_ID
	 FROM employees
           WHERE rownum <= 20
) where rn >= 10;

select * from departments;

create table tbl_reply (
          rno number(10, 0),
          bno number(10, 0) not null,
          reply varchar2(1000) not null,
          replyer varchar2(50) not null,
          replyDate date default sysdate,
          updateDate date default sysdate
          );
          
create sequence seq_reply;

alter table tbl_reply add constraint pk_reply primary key(rno);

alter table tbl_reply add constraint fk_reply_board
foreign key(bno) references board(board_no);

commit;
