package com.archit.myapplication;

public class Products {

    //name
    //rollno
    //address
    //phone
    //DOB
    //NSS
    //council
    //percent
    //year

    private String _rollno;
    private String _name;
    private String _address;
    private String _phone;
    private String _DOB;
    private Boolean _NSS;
    private Boolean _council;
    private Double _percent;
    private int _year;

    public Products(String rollno, String name, String address, String phone, String DOB, Boolean NSS, Boolean council, Double percent, int year) {
        this._rollno = rollno;
        this._name = name;
        this._address = address;
        this._phone = phone;
        this._DOB = DOB;
        this._NSS = NSS;
        this._council = council;
        this._percent = percent;
        this._year = year;
    }

    public String get_rollno() {
        return _rollno;
    }

    public String get_name() {
        return _name;
    }

    public String get_address() {
        return _address;
    }

    public String get_phone() {
        return _phone;
    }

    public String get_DOB() {
        return _DOB;
    }

    public Boolean get_NSS() {
        return _NSS;
    }

    public Boolean get_council() {
        return _council;
    }

    public Double get_percent() {
        return _percent;
    }

    public int get_year() {
        return _year;
    }

}
