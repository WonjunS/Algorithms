-- 코드를 입력하세요
SELECT LPAD(A.rest_id, 5, 0) AS "REST_ID"
     , A.rest_name AS "REST_NAME"
     , A.food_type AS "FOOD_TYPE"
     , A.favorites AS "FAVORITES"
     , A.address   AS "ADDRESS"
     , ROUND(AVG(B.review_score), 2) AS "SCORE"
  FROM rest_info A
    INNER JOIN rest_review B
            ON (A.rest_id = B.rest_id)
 WHERE SUBSTR(A.address, 1, 2) = '서울' 
 GROUP BY LPAD(A.rest_id, 5, 0), A.rest_name, A.food_type, A.favorites, A.address
 ORDER BY score desc, favorites desc
;