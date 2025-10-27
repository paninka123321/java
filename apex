select 
    LEV1_DESC
    , case when nvl(:P4_D2_LEV,0)>=1 then LEV2_DESC end as LEV2_DESC
    , case when nvl(:P4_D2_LEV,0)>=2 then LEV3_DESC end as LEV3_DESC
    , case when nvl(:P4_D2_LEV,0)>=3 then LEV4_DESC end as LEV4_DESC
    , case when nvl(:P4_D2_LEV,0)>=4 then LEV5_DESC end as LEV5_DESC
    , LEV1
    , case when nvl(:P4_D2_LEV,0)>=1 then LEV2 end as LEV2
    , case when nvl(:P4_D2_LEV,0)>=2 then LEV3 end as LEV3
    , case when nvl(:P4_D2_LEV,0)>=3 then LEV4 end as LEV4
    , case when nvl(:P4_D2_LEV,0)>=4 then LEV5 end as LEV5
    , sum(VALUE) as VALUE  
from OBIEE.DO_TMP_APEX_SZKOL f
left join OBIEE.M19_D_MN_PRODUCT_CURRENT dp on f.MN_PRODUCT_NO=dp.MN_PRODUCT_NO
where 
    MEASURE=:P4_D2_MEASURE
    and (
        nvl(:P4_D2_LEV,0)=0
        or :P4_D2_LEV=1 and LEV1=:P4_D2_LEV_ID
        or :P4_D2_LEV=2 and LEV2=:P4_D2_LEV_ID
        or :P4_D2_LEV=3 and LEV3=:P4_D2_LEV_ID
        or :P4_D2_LEV=4 and LEV4=:P4_D2_LEV_ID   
        or :P4_D2_LEV=5 and LEV5=:P4_D2_LEV_I
    )
group by
    LEV1_DESC 
    , case when nvl(:P4_D2_LEV,0)>=1 then LEV2_DESC end /*as LEV2_DESC*/
    , case when nvl(:P4_D2_LEV,0)>=2 then LEV3_DESC end /*as LEV3_DESC*/
    , case when nvl(:P4_D2_LEV,0)>=3 then LEV4_DESC end /*as LEV4_DESC*/
    , case when nvl(:P4_D2_LEV,0)>=4 then LEV5_DESC end /*as LEV5_DESC*/
    , LEV1
    , case when nvl(:P4_D2_LEV,0)>=1 then LEV2 end /*as LEV2*/
    , case when nvl(:P4_D2_LEV,0)>=2 then LEV3 end /*as LEV3*/
    , case when nvl(:P4_D2_LEV,0)>=3 then LEV4 end /*as LEV4*/
    , case when nvl(:P4_D2_LEV,0)>=4 then LEV5 end /*as LEV5*/
order by 1;
