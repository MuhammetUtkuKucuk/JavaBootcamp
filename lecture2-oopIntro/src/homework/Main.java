package homework;

import java.util.Date;

import homework.models.Lecture;
import homework.models.Student;
import homework.models.User;
import homework.services.LectureService;
import homework.services.StudentService;

public class Main {

	public static void main(String[] args) {
		
		studentTest();
		System.out.println("");
		lectureTest();

		
	}
	
	private static void studentTest() {

		StudentService studentService = new StudentService();
		
		Student user1 = new Student(1,"Karcan","Özbal","karcanozbal@outlook.com.tr","karcan","deneme12345");
		Student user2 = new Student(2,"Ömer","Acar","acar.0mer@hotmail.com","omer","deneme12345");
		Student user3 = new Student(3,"Uğur","Yıldız","","ugur","deneme12345");
		Student user4 = new Student(4,"Pinar","Darıcı","","pinar","deneme12345");
		
		// single adding method. 
		studentService.add(user1);
		
		// multiple adding method.
		Student[] students = {user2,user3,user4};
		studentService.add(students);
		
		// business rule testing for user name length.
		System.out.println("");
		Student user5 = new Student(5,"Haşim Ahmet Abdulbaki Buğra Bahadır","Nebioğulları","","hasim","deneme12345");
		studentService.add(user5);
		
		// update user before get all list 
		user4.name = "Pınar";
		studentService.update(user4);
		
		// delete user before get all list
		studentService.delete(user3);

		
		// get all user list. 
		System.out.println("");
		System.out.println("id	name	surname");
		System.out.println("--	----	-------");
		for (User user : studentService.getAll()) {
			System.out.println(user.id + "	" + user.name + "	" + user.surname);
		} 
		
		// get user by id;
		System.out.println(studentService.getById(2).name);
	}
	
	private static void lectureTest() {
		LectureService lectureService = new LectureService();
		
		Lecture lecture1 = new Lecture(1,1,"Ders 1",new Date());
		Lecture lecture2 = new Lecture(2,1,"Ders 2",new Date());
		Lecture lecture3 = new Lecture(3,1,"Ders 3",new Date());
		Lecture lecture4 = new Lecture(4,1,"Ders 4",new Date());
		Lecture lecture5 = new Lecture(5,1,"Ders 5",new Date());
		
		// single adding method.
		lectureService.add(lecture1);
		
		// multiple adding method.
		Lecture[] lectures = {lecture2,lecture3,lecture4,lecture5};
		lectureService.add(lectures);
		
		// get all lecture list.
		System.out.println("");
		System.out.println("id	courseId	name	date");
		System.out.println("--	--------	----	----");
		for (Lecture lecture : lectureService.getAll()) {
			System.out.println(lecture.id + "	" + lecture.courseId + "		" + lecture.name + "	" + lecture.date);
		}
		
		// get lectures by id.
		System.out.println("");
		System.out.println("id	courseId	name	date");
		System.out.println("--	--------	----	----");
		for (Lecture lecture : lectureService.getAllById(2)) {
			System.out.println(lecture.id + "	" + lecture.courseId + "		" + lecture.name + "	" + lecture.date);
		}
		
		// get lectures by courseId.
		System.out.println("");
		System.out.println("id	courseId	name	date");
		System.out.println("--	--------	----	----");
		for (Lecture lecture : lectureService.getAllByCourseId(1)) {
			System.out.println(lecture.id + "	" + lecture.courseId + "		" + lecture.name + "	" + lecture.date);
		}
	}
}
