package lv.rvt.repository;

import org.springframework.data.repository.CrudRepository;
import lv.rvt.model.Student;


public interface StudentRepository extends CrudRepository<Student, Long> {

}
