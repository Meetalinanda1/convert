using { sap.capire.celsius as db } from '../db/schema';
using { CelsiusService as external } from './srv/external/CelsiusService';
//using {  CelsiusService as external } from './../srv1/external';
//using { CelsiusService as external } from '../srv/external/CelsiusService';



service FahrenheitService{



//extend service CelsiusService with {
                           //      entity Fahrenheit as projection on db.Fahrenheit;
                            //    }














entity Celsius1 as projection on external.Celsius;
entity Fahrenheit as projection on db.Fahrenheit; 
}

//entity Fahrenheit as projection on db.Fahrenheit;