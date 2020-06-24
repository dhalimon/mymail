package emailApp;


// Creating the Outline for the Email Admin Class
// Scenario: You are an IT Support Administrator Specialist and are charged with the task of creating email accounts for new hires.
// Your application should do the following:
// Generate an email with the following syntax: firstname.lastname@department.company.com
// Determine the department (sales, development, accounting), if none leave blank
// Generate a random String for a password
// Have set methods to change the password, set the mailbox capacity, and define an alternate email address
// Have get methods to display the name, email, and mailbox capacity

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int defaultPasswordLength = 7;
    private int mailboxCapacity = 200 ;
    private String alternateEmail;
    private String companySuffix = "computermentors.org";


    // Constructor to receive the first name and the last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;



        // call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call a method calling for random password
        this.password =randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + password);



        // https:github.com/dhalimon/mymail

                      //Start here

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"."+ companySuffix;
        System.out.println("Your email is: " + email);
    }



    // Ask for the department
    private String setDepartment() {
        System.out.print("Department Codes:\n1 for Sales\n2 for Instructors\n3 for Technology\n4 for Office\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Teachers";
        } else if (depChoice == 3) {
            return "Tech";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPKRSTUWXYZ0123456789!!#@$";
        char[] password = new char[length];
        for (int i = 0; i < length; i++ ){
            int rand =(int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);

        }
        return new String(password);
    }

// Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {this.mailboxCapacity = capacity;}
    public int getMailboxCapacity() { return mailboxCapacity;}

// Set the alternate email
    public void setAlternateEmail(String altEMail) {this.alternateEmail = altEMail;}
    public String getAlternateEmail(){return alternateEmail;}

// Change the password
    public void changePassword(String password) {this.password = password;}
    public String getPassword() {return password;}

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }

}
