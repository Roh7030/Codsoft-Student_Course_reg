package student.Registration;

import java.util.ArrayList;
import java.util.List;

class Cource
{
	    private int courseCode;
	    private String title;
	    private String description;
	    private int capacity;
	    private String schedule;
	    private int availableSlots;
	    
	    public void CourceDatabase(int CourseCode ,String Title, String Description,int Capacity,String Schedule ,int AvailableSlots)
	    {
	    	this.courseCode =CourseCode;
	    	this.title =Title;
	    	 this.description = Description;
	         this.capacity = Capacity;
	         this.schedule = Schedule;
	         this.availableSlots = capacity;
	    	
	    }

		public int getCourseCode() {
			return courseCode;
		}

		public void setCourseCode(int courseCode) {
			this.courseCode = courseCode;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public String getSchedule() {
			return schedule;
		}

		public void setSchedule(String schedule) {
			this.schedule = schedule;
		}

		public int getAvailableSlots() {
			return availableSlots;
		}

		public void setAvailableSlots(int availableSlots) {
			this.availableSlots = availableSlots;
		}
	    
		
		public void displayCourseDetails()
		{
			System.out.println("Course Code "+courseCode);
			System.out.println("Cource Title "+title);
			System.out.println("Cource Description "+description);
			System.out.println("Cource Capacity "+capacity);
			System.out.println("Cource Schedule "+schedule);
			System.out.println("Cource Available Slots"+availableSlots);
			
			
		}
		
		public boolean registerStudent()
		{
			if(availableSlots>0)
			{
				availableSlots++;
				return true;
				
			}
			else
			{
				System.out.println("Cource is Full . Con't Register");
				return false;
			}
		}
		
		public void dropStudent() 
		{
	        if (availableSlots < capacity) 
	        {
	            availableSlots++;
	            System.out.println("Student dropped from the course.");
	        }
	        else
	        {
	            System.out.println("No student registered for this course.");
	        }
	        
		} 

}

class Student
{
	public int Student_ID;
	public String Student_Name;
	public List<Cource>registeredCourese;
	
	public Student(int Student_ID,String Student_Name)
	{
		this.Student_ID=Student_ID;
		this.Student_Name=Student_Name;
		this.registeredCourese=new ArrayList<>();
	}
	
	
	
	public void dispalyStudentDetails()
	{
		System.out.println("Student ID: "+Student_ID);
		System.out.println("Student Name: "+Student_Name);
		System.out.println("Registered Courses:");
	
		if(registeredCourese.isEmpty())
		{
			System.out.println("No Courses Registered");
			
		}
		else
		{
			 for (Cource course : registeredCourese)
			 {
				 System.out.println("- " + course.getTitle());
			 }
		}
	}
	
	public void registerCourse(Cource course)
	{
        if (course.registerStudent()) 
        {
        	registeredCourese.add(course);
            System.out.println("Student registered for the course.");
        } 
        else
        {
            System.out.println("Registration failed.");
        }
    }

    public void dropCourse(Cource course) 
    {
        if (registeredCourese.contains(course))
        {
            course.dropStudent();
            registeredCourese.remove(course);
        }
        else
        {
            System.out.println("Student is not registered for this course.");
        }
    }
}
class Database
    {
        private List<Cource> courses;
        private List<Student> students;

        public Database() 
       {
            this.courses = new ArrayList<>();
            this.students = new ArrayList<>();
       }

         public void addCourse(Cource course) 
         {
             courses.add(course);
         }

        public void addStudent(Student student)
      {
           students.add(student);
      }

       public List<Cource> getCourses() 
       {
            return courses;
       }
 
       public List<Student> getStudents()
       {
        return students;
       }
    }      

public class CourseRegistrationSystem 
{
	public static void main(String []er)
	{
		Cource aobj1=new Cource();
		aobj1.CourceDatabase(11, "cse", "be",20 , "Moring", 10);// CourseCode ,Title,  Description, Capacity,Schedule ,AvailableSlots
		
		Student aobj2 =new Student(106,"rohit");
		
		Database aobj3=new Database();
		aobj3.addCourse(aobj1);
		aobj3.addStudent(aobj2);
		
		aobj2.registerCourse(aobj1);
		
		aobj1.displayCourseDetails();
		aobj2.dispalyStudentDetails();
		
		aobj2.dropCourse(aobj1);
		aobj2.dispalyStudentDetails();    
		
		
	}

}
