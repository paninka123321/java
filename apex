CASE
    WHEN INSTR(:P2_PATH, '|', -1) > 0 THEN 
        SUBSTR(:P2_PATH, 1, INSTR(:P2_PATH, '|', -1) - 1)
    ELSE 
        NULL
END
