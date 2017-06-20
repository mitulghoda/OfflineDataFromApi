package com.offlinedata;

/**
 * Created by abc on 01-06-2017.
 */
public class Contact {

    //private variables
    int _id;
    String _name;


    String client_id;
    String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String name,String subject, String client_id){
        this._id = id;
        this._name = name;
        this.subject = subject;
        this.client_id = client_id;
    }

    // constructor
    public Contact(String name,String subject, String client_id){
        this._name = name;
        this.subject = subject;
        this.client_id = client_id;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone number
    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

}
