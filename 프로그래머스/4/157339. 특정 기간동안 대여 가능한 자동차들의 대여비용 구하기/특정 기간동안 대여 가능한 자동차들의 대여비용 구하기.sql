SELECT CAR_ID, CAR_TYPE, FEE
FROM (
    SELECT C.CAR_ID, C.CAR_TYPE, 30 * DAILY_FEE * (100 - DISCOUNT_RATE) / 100 AS FEE
    FROM CAR_RENTAL_COMPANY_CAR C JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
    ON C.CAR_TYPE = P.CAR_TYPE
    WHERE P.DURATION_TYPE = '30일 이상'
    AND C.CAR_TYPE IN ('SUV', '세단')
    AND C.CAR_ID NOT IN (
        SELECT H.CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
        WHERE H.END_DATE >= TO_DATE('2022-11-01', 'YYYY-MM-DD')
        AND H.START_DATE <= TO_DATE('2022-11-30', 'YYYY-MM-DD')
    )
)
WHERE FEE >= 500000
AND FEE < 2000000
ORDER BY 3 DESC, 2, 1 DESC;