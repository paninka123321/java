select 
    case when nvl(:P4_D1_LEV,0)=0 then nvl(LEV1_DESC, 'Klient: '||CIF) 
        when nvl(:P4_D1_LEV,0)=1 then nvl(LEV2_DESC, 'Klient: '||CIF)  
        when nvl(:P4_D1_LEV,0)=2 then nvl(LEV3_DESC, 'Klient: '||CIF)  
        when nvl(:P4_D1_LEV,0)=3 then nvl(LEV4_DESC, 'Klient: '||CIF) 
        when nvl(:P4_D1_LEV,0)=4 then nvl(LEV5_DESC, 'Klient: '||CIF) 
    end as LEV_DESC
    , case when nvl(:P4_D1_LEV,0)=0 then LEV1
        when nvl(:P4_D1_LEV,0)=1 then LEV2
        when nvl(:P4_D1_LEV,0)=2 then LEV3
        when nvl(:P4_D1_LEV,0)=3 then LEV4
        when nvl(:P4_D1_LEV,0)=4 then LEV5
    end as LEV_ID
    , case when nvl(:P4_D1_LEV,0)=0 then 1
        when nvl(:P4_D1_LEV,0)=1 then 2
        when nvl(:P4_D1_LEV,0)=2 then 3
        when nvl(:P4_D1_LEV,0)=3 then 4
        when nvl(:P4_D1_LEV,0)=4 then 5
    end as LEV
    , sum(VALUE) as VALUE  
from OBIEE.DO_TMP_APEX_SZKOL f
left join OBIEE.M19_D_MN_PRODUCT_CURRENT dp on f.MN_PRODUCT_NO=dp.MN_PRODUCT_NO
where 
    MEASURE=:P4_D1_MEASURE
    and (
        nvl(:P4_D1_LEV,0)=0
        or :P4_D1_LEV=1 and LEV1=:P4_D1_LEV_ID
        or :P4_D1_LEV=2 and LEV2=:P4_D1_LEV_ID
        or :P4_D1_LEV=3 and LEV3=:P4_D1_LEV_ID
        or :P4_D1_LEV=4 and LEV4=:P4_D1_LEV_ID   
        or :P4_D1_LEV=5 and LEV5=:P4_D1_LEV_ID
    )
group by 
    case when nvl(:P4_D1_LEV,0)=0 then nvl(LEV1_DESC, 'Klient: '||CIF) 
        when nvl(:P4_D1_LEV,0)=1 then nvl(LEV2_DESC, 'Klient: '||CIF)  
        when nvl(:P4_D1_LEV,0)=2 then nvl(LEV3_DESC, 'Klient: '||CIF)  
        when nvl(:P4_D1_LEV,0)=3 then nvl(LEV4_DESC, 'Klient: '||CIF) 
        when nvl(:P4_D1_LEV,0)=4 then nvl(LEV5_DESC, 'Klient: '||CIF) 
    end /*as LEV_DESC*/
    , case when nvl(:P4_D1_LEV,0)=0 then LEV1
        when nvl(:P4_D1_LEV,0)=1 then LEV2
        when nvl(:P4_D1_LEV,0)=2 then LEV3
        when nvl(:P4_D1_LEV,0)=3 then LEV4
        when nvl(:P4_D1_LEV,0)=4 then LEV5
    end /*as LEV_ID*/
    , case when nvl(:P4_D1_LEV,0)=0 then 1
        when nvl(:P4_D1_LEV,0)=1 then 2
        when nvl(:P4_D1_LEV,0)=2 then 3
        when nvl(:P4_D1_LEV,0)=3 then 4
        when nvl(:P4_D1_LEV,0)=4 then 5
    end /*as LEV*/
order by 1;
