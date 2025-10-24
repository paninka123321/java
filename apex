ORA-20999: Failed to parse SQL query! ORA-06550: line 19, column 53: ORA-00904: "USLUGA_LEV1": invalid identifier
select 
--przypisanie kazdemu poziomowi (wartosci liczbowej) kolumny 
    case when nvl(:P2_LEVEL,0)=0 then nvl(USLUGA_LEV1, 'null') 
        when nvl(:P2_LEVEL,0)=1 then nvl(KATEGORIA, 'null')  
        when nvl(:P2_LEVEL,0)=2 then nvl(PODKATEGORIA, 'Klient: ')
    end as LEVEL_DESC
    -- nadanie id poziomom
    , case when nvl(:P2_LEVEL,0)=0 then 1
        when nvl(:P2_LEVEL,0)=1 then 2
        when nvl(:P2_LEVEL,0)=2 then 3
    end as LEV
    , sum(VALUE) as VALUE  
from DO_SZKOLENIA_DRAZENIE
where 
        nvl(:P2_LEVEL,0)=0
        or :P2_LEVEL=1 
        or :P2_LEVEL=2 
group by
    case when nvl(:P2_LEVEL,0)=0 then nvl(USLUGA_LEV1, 'null')
        when nvl(:P2_LEVEL,0)=1 then nvl(KATEGORIA, 'null')
        when nvl(:P2_LEVEL,0)=2 then nvl(PODKATEGORIA, 'null') 

    end /*as LEV_DESC*/

    , case when nvl(:P2_LEVEL,0)=0 then 1
        when nvl(:P2_LEVEL,0)=1 then 2
        when nvl(:P2_LEVEL,0)=2 then 3
    end /*as LEV*/
order by 1;
