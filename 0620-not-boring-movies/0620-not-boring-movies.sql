# Write your MySQL query statement below
select * from Cinema where id % 2 != 0 and description not regexp 'boring' order by rating desc