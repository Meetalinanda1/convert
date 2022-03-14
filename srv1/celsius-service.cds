
//using { sap.capire.celsius as db } from '../db/schema';
using { Currency, cuid, managed, sap.common.CodeList } from '@sap/cds/common';
service CelsiusService {
//entity Celsius as projection on db.Celsius;

entity Celsius   {
   key ID : Integer;
   celsiusinput  : Double;

}

}