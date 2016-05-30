package org.agilar.csd.codeSmells.bloaters.primitiveObsesion;

/**
 * Created by juanbacarditbarrera on 24/5/16.
 */
public class primiteveLess {

    private int Age;
    private Name Name;
    private String Email;
    private Address Address;
    private Phone Phone;
}

class Name {
    private String Name;
    private String FirstName;
    private String LastName;

}


class Address{
    private String StreetName;
    private String StreetType;
    private int StreetNumber;
    private int Floor;
    private int PostalCode;
    private String Region;
    private String State;
}

class Phone {

    private int Number;
    private PhoneType Type;
}

enum PhoneType {

    Home,
    Mobile,
    Work
}