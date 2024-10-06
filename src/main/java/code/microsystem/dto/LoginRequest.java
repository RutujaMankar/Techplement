package code.microsystem.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	
	private int id;
	
	//@NotBlank(message = "Username is required ")
	private String username;
	
	//@NotBlank(message = "Address is required")
	private String address;
	
	@Email(message = "Email should be valid")
	private String email;
	
	@NotBlank(message = "Password is required")
	@Size(min = 8,message = "Password must be at least 8 characters")
	private String password;

}
