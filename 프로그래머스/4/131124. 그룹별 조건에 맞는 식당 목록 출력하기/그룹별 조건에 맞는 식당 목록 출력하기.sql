select m.member_name, r.review_text, to_char(r.review_date, 'YYYY-MM-DD') as review_date
from member_profile m, rest_review r
where m.member_id = r.member_id
and m.member_id in (select member_id from rest_review group by member_id having count(*) = (select max(count(*)) 
from rest_review 
group by member_id) )
order by 3, 2;
