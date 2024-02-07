WITH BASE_BOARD AS (
    SELECT BOARD_ID, TITLE
    FROM USED_GOODS_BOARD
    WHERE DATE_FORMAT(CREATED_DATE, '%Y-%m') = '2022-10'
)
SELECT BASE.TITLE, 
    REPLY.BOARD_ID,
    REPLY.REPLY_ID,
    REPLY.WRITER_ID,
    REPLY.CONTENTS,
    DATE_FORMAT(REPLY.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM BASE_BOARD BASE INNER JOIN USED_GOODS_REPLY REPLY
    ON BASE.BOARD_ID = REPLY.BOARD_ID
ORDER BY 6, 1;
