SELECT INFO.ITEM_ID, INFO.ITEM_NAME, INFO.RARITY
FROM ITEM_INFO INFO LEFT JOIN ITEM_TREE TREE
ON INFO.ITEM_ID = TREE.PARENT_ITEM_ID
WHERE TREE.PARENT_ITEM_ID IS NULL
ORDER BY 1 DESC;