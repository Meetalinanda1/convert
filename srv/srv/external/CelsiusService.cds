/* checksum : 6edcbbf955912e7fb372cf5594a40ee2 */
@cds.persistence.skip : true
entity CelsiusService.Celsius {
  key ID : Integer;
  celsiusinput : Double;
};

@cds.external : true
service CelsiusService {};

