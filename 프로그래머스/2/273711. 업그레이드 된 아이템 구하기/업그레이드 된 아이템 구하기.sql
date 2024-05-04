select a.item_id, a.item_name, a.rarity
from item_info a inner join item_tree b on (a.item_id = b.item_id)
where b.parent_item_id in (select item_id from item_info a1 where a1.rarity = 'RARE')
order by 1 desc;