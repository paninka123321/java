select 
--przypisanie kazdemu poziomowi (wartosci liczbowej) kolumny 
    case nvl(to_number(:P2_LEVEL),0)
        when 0 then nvl(USŁUGA_LEV1, 'null') 
        when 1 then nvl(KATEGORIA, 'null')  
        when 2 then nvl(PODKATEGORIA, 'Klient: ')
    end as LEVEL_DESC
    -- nadanie id poziomom
    , case nvl(to_number(:P2_LEVEL),0)
        when 0 then 1
        when 1 then 2
        when 2 then 3
    end as LEV_ID
    , sum(VALUE) as VALUE  
from DO_SZKOLENIA_DRAZENIE
where 
    -- tutaj patrzymy co wczesniej użytkownik wybrał (Żeby dla depozytów wyświetlały się tylko depozytowe podkategorie a nie jeszcze podkategorie z kredytow)
        nvl(to_number(:P2_LEVEL),0)=0
        or (to_number(:P2_LEVEL)=1 and USŁUGA_LEV1 =:P2_PREVIOUS_LEVEL) 
        or (to_number(:P2_LEVEL)=2 and KATEGORIA =:P2_PREVIOUS_LEVEL)

group by
    case nvl(to_number(:P2_LEVEL),0)
        when 0 then nvl(USŁUGA_LEV1, 'null')
        when 1 then nvl(KATEGORIA, 'null')
        when 2 then nvl(PODKATEGORIA, 'Klient: ') 
    end /*as LEVEL_DESC*/

    , case nvl(to_number(:P2_LEVEL),0)
        when 0 then 1
        when 1 then 2
        when 2 then 3
    end /*as LEV_ID*/

order by 1;
