SELECT b.book_id, a.author_name, to_char(b.published_date, 'YYYY-MM-DD') AS PUBLISHED_DATE
FROM Author a, (
    SELECT BOOK_ID, AUTHOR_ID, PUBLISHED_DATE
    FROM BOOK
    WHERE CATEGORY = '경제'
) b
WHERE a.author_id = b.author_id
ORDER BY 3;