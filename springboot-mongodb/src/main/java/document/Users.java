package document;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class Users {
	
	@Id
	private String userId;
	private String lastname;
	private String name;
	private Integer weight;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public Users(String userId,String lastname, String name, Integer weight) {
		super();
		
		this.userId = userId;
		this.lastname = lastname;
		this.name = name;
		this.weight = weight;
	}

	public String getLastname() {
		return lastname;
	}

	public void setId(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
