selectUserById
===
select * from user where id = #id#


selectUserByNameAndAge
===
select * from user where 1=1
@if(!isEmpty(age)){
and age = #age#
@}
@if(!isEmpty(name)){
and name = #name#
@}


selectUserByAge
===
select * from user where 1=1
@if(!isEmpty(age)){
and age = #age#
@}
ORDER BY id limit 10,20


insertUser
===
insert into  user values(#id#,#age#,#name#,#createDate#)

deleteUserById
===
delete from user where  id = #id#