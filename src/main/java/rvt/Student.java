package rvt;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;

    private String surname;

    private int age;

    private String password;

    private LocalDate birthday;

    private String gender;

    private boolean married;

    private String note;

    private String email;

    private String group;

   
    public String toString() {
        return String.format(
                "{%s, %s, %s, %s, %s, %s, %s, %s, %s, %s}",
                this.name,
                this.surname,
                this.age,
                this.password,
                this.birthday,
                this.gender,
                this.married,
                this.note,
                this.email,
                this.group);
    }

}
