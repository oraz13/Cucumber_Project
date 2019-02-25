package apitests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;


public class CMstudent {

 //  @Test
   public void studentList(){
       Response response = RestAssured.get("http://cybertekchicago.com/student/87");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

   @Test
    public void singleStudent(){
        Response response = RestAssured.get("http://cybertekchicago.com/student/87");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        
        JsonPath jp = response.jsonPath();
        int b =  jp.get("batch");
        System.out.println(b);
        
        String firstName = jp.get("firstName");
        System.out.println(firstName);
       
        String expected="Game";
        assertEquals(expected, firstName);
        
        String email = jp.get("contact.emailAddress");
        System.out.println(email);
        
       String  street = jp.get("company.address.street");
       System.out.println(street);
       
      
    }

  //  @Test
    public void instructorAll(){
        Response response = RestAssured.get("http://cybertekchicago.com/instructor/all");
        System.out.println(response.asString());
        System.out.println(response.statusCode());
        
        JsonPath jp = response.jsonPath();
        
        
        List<String> name = jp.get("batch");
        int siz = name.size();
        System.out.println(siz);
        
        for(String subject: name){
            System.out.println(subject.isEmpty());
        }
    }


}
