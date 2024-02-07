SELECT dr_name, dr_id, mcdp_cd, DATE_FORMAT(hire_ymd, '%Y-%m-%d') AS HIRE_YMD
FROM Doctor
WHERE mcdp_cd IN ('CS', 'GS')
ORDER BY 4 desc, 1;