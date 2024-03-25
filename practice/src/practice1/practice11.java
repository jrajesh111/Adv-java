package practice1;



class practice11 {
	int id;
	String name;
	int age;
	String team;
	

	


	@Override
	public String toString() {
		return "practice11 [id=" + id + ", name=" + name + ", age=" + age + ", team=" + team + "]";
	}


	public practice11(int id, String name, int age, String team) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.team = team;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}







}
