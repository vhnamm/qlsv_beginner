/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddStudentDatabase.connect;

import AddStudentDatabase.model.Student;
import java.sql.*;
import java.util.ArrayList;


public class StudentDAO implements DAOinteface<Student>{

    @Override
    public ArrayList<Student> getAllData() {
        ArrayList<Student> stuList = new ArrayList<>();
        PreparedStatement prep = null;
        ResultSet rs = null;
        
        try{
            Connection conn = ConnectStuDB.getConnection();
            String sql = "SELECT * FROM sinh_vien;";
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("ID");
                String msv = rs.getString("studentId");
                String name = rs.getString("fullName");
                String lop = rs.getString("className");
                double gpa = rs.getDouble("gpa");
                
                stuList.add(new Student(id, msv, name, lop, gpa));
                
                
            }
            ConnectStuDB.closeConnection(conn);
            return stuList;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addData(Student a) {
        Connection conn = null;
        PreparedStatement prep = null;
        
        try{
            conn = ConnectStuDB.getConnection();
            String sql = "INSERT INTO sinh_vien(studentId, fullName, className, gpa) VALUES (?,?,?,?);";
                      
            prep = conn.prepareStatement(sql);
            
            prep.setString(1, a.getMsv());
            prep.setString(2, a.getName());
            prep.setString(3, a.getLop());
            prep.setDouble(4, a.getGpa());
            
            prep.executeUpdate();
            ConnectStuDB.closeConnection(conn);
            return true;
        }catch(Exception e){
            System.out.println("loi");
        }
        return false;
    }
    
    @Override
    public boolean deleteByID(int id){
        Connection conn = null;
        try {
            conn = ConnectStuDB.getConnection();
            String sql = "DELETE FROM sinh_vien WHERE ID = ?";
            PreparedStatement prep = conn.prepareStatement(sql);
            
            prep.setInt(1, id);
            prep.executeUpdate();
            ConnectStuDB.closeConnection(conn);
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    @Override
    public boolean updateData(Student a){
        Connection conn = null;
        PreparedStatement prep = null;
        
        try {
            conn = ConnectStuDB.getConnection();
            String sql = "UPDATE sinh_vien SET STUDENTID = ? , FULLNAME =? , CLASSNAME =?, GPA=? WHERE ID = ?";
            
            prep = conn.prepareStatement(sql);
            prep.setString(1, a.getMsv());
            prep.setString(2, a.getName());
            prep.setString(3, a.getLop());
            prep.setDouble(4, a.getGpa());
            prep.setInt(5, a.getId());
            
            prep.executeUpdate();
            ConnectStuDB.closeConnection(conn);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

class ConnectStuDB{
    private static String url = "jdbc:mySQL://localhost:3306/qlsvDB";
    private static String username = "root";
    private static String password = "vohoainam10012005";

    public static Connection getConnection(){
        Connection c = null;
        try{
            c = DriverManager.getConnection(url, username, password);
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return c;
    }
    
    public static void closeConnection(Connection c){
        try{
            if(c != null){
            c.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}