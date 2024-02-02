WITH BASE_DATA AS (
    SELECT M.MEMBER_ID, M.MEMBER_NAME, COUNT(R.MEMBER_ID) AS REVIEWS
    FROM MEMBER_PROFILE M INNER JOIN REST_REVIEW R
    WHERE M.MEMBER_ID = R.MEMBER_ID
    GROUP BY M.MEMBER_ID, M.MEMBER_NAME
    ORDER BY REVIEWS DESC
    LIMIT 1
)
SELECT B.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
FROM REST_REVIEW R INNER JOIN BASE_DATA B
WHERE R.MEMBER_ID = B.MEMBER_ID
ORDER BY 3, 2;