package storemanagementsystem;
public class Employee implements Staff 
{
    private String name;
    private int id;
    private String Contact;
     private String Email;
     private String Job;
          
     public Employee() {
        // Constructor code here, if needed
    }
     
     public Employee(int id, String name,String contact, String Email,String Job ) {
        this.id = id;
        this.name = name;
        this.Contact = contact;
        this.Email = Email;
        this.Job = Job;
    }
    

    @Override
    public void setName(String name) 
    {
        this.name = name;
    }

    @Override
    public String getName() 
    {
        return name;
    }
     @Override
    public void setId(int id) 
    {
        this.id = id;
    }

    @Override
    public int getId() 
    {
        return id; 
    }
    @Override
    public void setContact(String cntct) 
    {
        this.Contact = cntct;
    }

    @Override
    public String getContact() 
    {
        return Contact;
    }
    @Override
   public void setEmail(String Email)
     
    {
        this.Email = Email;
    }

    @Override
    public String getEmail()
    {
        return Email;
    }
     @Override
    public void setJob(String job) 
    {
        this.Job = job;
    }

    @Override
    public String getJob() 
    {
        return Job;
    }
}
