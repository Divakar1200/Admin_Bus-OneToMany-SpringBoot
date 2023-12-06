package org.jsp.adminbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Create the Following entities  --------

1)Admin (id, name,gst,phone,email,password,travels_name)
2)Bus (id,bus_number,date_of_departure,no_of_seats,cost_per_seat,from_location,to_location, Image_url)

Admin and Bus have One-to-Many relationship -------

Create the REST API's to perform the following tasks

1)Admin Registration
2)Admin Login by phone and password
3)Admin Login by email and password
4)Updating Admin
5)Bus Registration
6)Updating Bus 
7)Find Admin By Id
8)Find Bus by date_of_departure, from_location and to_location
9)Find Bus by Admin Id 
10)Find Bus by bus number
11)Find Bus by travels_name 
12)Find Bus by date_of_departure

Note: You can use Spring Boot and for Database Connectivity You can use Spring Data JPA. 

*/

@SpringBootApplication
public class AdminBusOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminBusOneToManyApplication.class, args);
	}

}
