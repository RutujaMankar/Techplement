package code.microsystem.entity;

import code.microsystem.encoder.BCryptPasswordEncoder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="user_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @NotBlank
	private String username;
    
    @NotBlank
    @Email
	private String email;
    
    @NotBlank
	private String address;

    @NotBlank(message = "Password Must be 8 character")
    @Size(min = 8)
    private String password;
	
}