package model;

public class Response {
	private int id;
	private String message;	
	
	public Response() {
		super();
	}

	public Response(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [id=" + id + ", message=" + message + "]";
	}
	
	
	
}
