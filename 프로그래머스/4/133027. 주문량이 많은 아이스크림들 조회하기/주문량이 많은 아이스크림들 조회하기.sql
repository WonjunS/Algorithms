with tmp as (
    select flavor, sum(total_order) o2
    from July
    group by flavor
)
select f.FLAVOR
from First_half f, tmp t
where f.flavor = t.flavor
group by f.flavor
order by sum(f.total_order + t.o2) desc
fetch first 3 rows only;