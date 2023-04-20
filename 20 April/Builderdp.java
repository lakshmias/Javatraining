class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    
    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
    }
    
    // Getters for all fields go here...
    
    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }
        
        public User build() {
            return new User(this);
        }
    }

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ "]";
	}
    
}


public class Builderdp {

	public static void main(String[] args) {
		User user = new User.Builder()
                .firstName("Shiva")
                .lastName("priya")
                .email("shiva.priya@example.com")
                .phone("555-666-888")
                .build();
		System.out.println(user);

	}

}

/*
 *
 The Builder pattern is commonly used when we need to create complex objects with many optional parameters, and when we want to create these objects using a fluent and readable API. 
 Here are some real-time use cases where the Builder pattern can be useful:

Creating a Configuration Object: 
When creating a configuration object for an application or system, 
the Builder pattern can be used to 
set all the various configuration options in a fluent and readable way.

Creating a Database Query Object: When creating a database query object, 
the Builder pattern can be used to 
set all the various query parameters in a fluent and readable way. 
This makes it easier to create complex queries
 with many optional parameters.

Creating a GUI Component: When creating a complex GUI component, 
the Builder pattern can be used to
 set all the various configuration options in a fluent and readable way. 
 This makes it easier to create 
 complex GUI components with many optional parameters.

Creating an Email Object: When creating an email object, the Builder pattern can be used to set all 
the various parameters such as the email subject, sender, recipient, body, attachments, etc. in a fluent 
and readable way.

In general, the Builder pattern is useful in any situation where you need 
to create an object with many optional parameters, 
and you want to make the process of setting those parameters as easy and 
readable as possible.
 */
