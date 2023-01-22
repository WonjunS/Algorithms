-- 코드를 입력하세요
SELECT O.PRODUCT_ID, P.PRODUCT_NAME, SUM(AMOUNT) * (SELECT PRICE
                                                   FROM FOOD_PRODUCT
                                                   WHERE PRODUCT_ID = O.PRODUCT_ID) AS "TOTAL_SALES"
FROM FOOD_PRODUCT P JOIN FOOD_ORDER O
ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE SUBSTR(TO_CHAR(PRODUCE_DATE, 'YYYY-MM-DD'), 6, 2) = '05'
GROUP BY O.PRODUCT_ID, P.PRODUCT_NAME
ORDER BY "TOTAL_SALES" DESC, O.PRODUCT_ID;