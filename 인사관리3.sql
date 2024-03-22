create table board2 ( seq number primary key
, title varchar2(100)
, writer varchar2(100)
, content varchar2(100)
, regdate date
, cnt number
, uploadfile varchar2(100));

commit;

create table comments(
          seq number primary key,
          name varchar2(100),
          content varchar2(100),
          boardseq number,
          regdate date
);

commit;