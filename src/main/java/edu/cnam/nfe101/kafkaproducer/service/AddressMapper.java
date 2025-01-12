package edu.cnam.nfe101.kafkaproducer.service;

import edu.cnam.nfe101.kafkaproducer.model.AddressCsv;
import edu.cnam.nfe101.kafkaproducer.model.AddressJson;

public class AddressMapper {

    public static AddressJson toJson(AddressCsv csv) {
        AddressJson json = new AddressJson();

        json.setInteroperabilityKey(csv.getCleInterop());
        json.setAddress(csv.getVoieNom());
        json.setNumber(csv.getNumero());
        json.setSuffix(csv.getSuffixe());
        json.setCadastralParcel(csv.getCadParcelles());
        json.setX(csv.getX());
        json.setY(csv.getY());
        json.setLongitude(csv.getLongitude());
        json.setLatitude(csv.getLatitude());

        return json;
    }
}
