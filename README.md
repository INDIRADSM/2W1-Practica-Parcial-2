# Analisis COVID - US

Documentacion => https://covidtracking.com/data/api

ENDPOINTS 

GET > /v1/covid/
* Listar el total de casos testeados y el total de positivos detectados agrupados por estado


GET > /v1/covid/{estado}/{fecha}
* Listar el porcentaje de casos positivos para un determinado estado y fecha

POST > /v1/covid/{estado}/{fecha}
* Persistir en base de datos:
  
 -Nombre del estado
 
 -Sigla
 
 -Fecha
 
 -Total de casos
 
 -Total de positivos
 
 -Total de hospitalizados

* Test
* Docker
* Persistencia en DB

========================

REF SATES:

AL - AK - AS - AZ - AR - CA - CO - CT -
DE - DC - FL - GA - GU - HI - ID - IL -
IN - IA - KS - KY - LA - ME - MD - MA -
MI - MN - MS - MO - MT - NE - NV - NH -
NJ - NM - NY - NC - ND - MP - OH - OK -
OR - PA - PR - RI - SC - SD - TN - TX -
VI - UT - VT - VA - WA - WV - WI - WY -
