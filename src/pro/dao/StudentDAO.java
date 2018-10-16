package pro.dao;

import pro.pojo.Student;

public interface StudentDAO {
     public boolean addStudent(Student student);
     public boolean checkStudent(Student student);
     public boolean removeStudent(Student student);
     public boolean updateStudent(Student student);
     public Student viewStudent();
}
