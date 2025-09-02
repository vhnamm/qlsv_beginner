/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddStudentDatabase.model;

/**
 *
 * @author Admin
 */
public class Student {
    private int id;
    private String msv, name, lop;
    private double gpa;

    public Student(int id, String msv, String name, String lop, double gpa) {
        this.id = id;
        this.msv = msv;
        this.name = name;
        this.lop = lop;
        this.gpa = gpa;
    }

    public Student(String msv, String name, String lop, double gpa) {
        this.msv = msv;
        this.name = name;
        this.lop = lop;
        this.gpa = gpa;
    }
    
    
    public Student() {
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    public int getId(){
        return id;
    }
    public void chuanHoa(String name, String lop){
        this.lop = lop.toUpperCase();
        String[] tmp = name.trim().toLowerCase().split("\\s+");
        String newName = "";
        for(String x : tmp){
            newName += Character.toUpperCase(x.charAt(0)) + x.substring(1) + " ";
        }
        this.name  = newName.trim();
    }
}
