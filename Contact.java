/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ds_project;
/**
 *
 * @author Rafiq
 */
public class Contact {
    String PhoneNum;
    String firstName;
    String lastName;
    Contact next;
public Contact(String phoneNum, String firstName, String lastName) {
        this.PhoneNum = phoneNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.next = null; // Initially, next is null
    }
public Contact head;


}
class InsertContact {
   public Contact head;
   public Contact temp;
   public InsertContact() {
        this.head = null;
    }
  public void addContact(String PN,String FN,String LN){
      Contact newContact = new Contact(PN,FN,LN);
      if(head==null){
          head=newContact;
      }
      else{
         temp=head;
         while(temp.next!=null){
             temp=temp.next;
         }
         temp.next=newContact;
      }
     
  }

 public void printContacts() {
        temp = head;  // Use a temporary variable to iterate through the list
        while (temp != null) {
            System.out.print("\nContact Name:"+  temp.firstName +" "+ temp.lastName+"\n Phone Number:"+temp.PhoneNum);
            temp = temp.next;
}
 }
}

