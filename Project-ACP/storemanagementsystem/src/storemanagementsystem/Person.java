package storemanagementsystem;
abstract public class Person 
{
   public String name;
   public int contact;
   public String email;
   
  abstract public void display();
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  public int getContact() {
    return contact;
  }

  public void setContact(int contact) {
    this.contact = contact;
  }
}



