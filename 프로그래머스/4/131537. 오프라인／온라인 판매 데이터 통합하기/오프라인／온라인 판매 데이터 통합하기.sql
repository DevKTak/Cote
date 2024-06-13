 SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d'), PRODUCT_ID, USER_ID, SALES_AMOUNT
   FROM 
   (
      SELECT SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
        FROM ONLINE_SALE
   UNION ALL
      SELECT SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
        FROM OFFLINE_SALE
   ) sum
   WHERE DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-03'
ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC;

