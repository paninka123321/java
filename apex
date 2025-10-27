SELECT
    CASE WHEN safe_level >= 0 THEN USŁUGA_LEV1 END AS USŁUGA_LEV1,
    CASE WHEN safe_level >= 1 THEN KATEGORIA END AS KATEGORIA,
    CASE WHEN safe_level >= 2 THEN PODKATEGORIA END AS PODKATEGORIA,

    CASE safe_level
        WHEN 0 THEN USŁUGA_LEV1
        WHEN 1 THEN KATEGORIA
        WHEN 2 THEN PODKATEGORIA
    END AS LEVEL_DESC,

    CASE safe_level
        WHEN 0 THEN 1
        WHEN 1 THEN 2
        WHEN 2 THEN 3
    END AS LEV_ID,

    SUM(VALUE) AS VALUE
FROM DO_SZKOLENIA_DRAZENIE,
(
  -- obliczamy bezpieczną wersję level (liczba), jeśli :P2_LEVEL jest numeryczne
  SELECT CASE 
           WHEN regexp_like(:P2_LEVEL, '^\d+$') THEN to_number(:P2_LEVEL) 
           ELSE 0 
         END AS safe_level
  FROM dual
) SL
WHERE
    SL.safe_level = 0
 OR (SL.safe_level = 1 AND USŁUGA_LEV1 = TO_CHAR(:P2_PREVIOUS_LEVEL))
 OR (SL.safe_level = 2 AND (USŁUGA_LEV1 || '|' || KATEGORIA) = TO_CHAR(:P2_PATH))
GROUP BY
    CASE WHEN SL.safe_level >= 0 THEN USŁUGA_LEV1 END,
    CASE WHEN SL.safe_level >= 1 THEN KATEGORIA END,
    CASE WHEN SL.safe_level >= 2 THEN PODKATEGORIA END,
    CASE SL.safe_level
        WHEN 0 THEN USŁUGA_LEV1
        WHEN 1 THEN KATEGORIA
        WHEN 2 THEN PODKATEGORIA
    END,
    CASE SL.safe_level
        WHEN 0 THEN 1
        WHEN 1 THEN 2
        WHEN 2 THEN 3
    END
ORDER BY 1,2,3;
