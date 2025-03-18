package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utility.DBUtil;

public class UserIMPL implements Userdao{
    @Override
    public String UserLoginTable(int accountNumber, String username, String password, double balance){

         String msg="Account not registered";
        
        try( Connection conn=DBUtil.provideConnection()) {
            PreparedStatement ps=conn.prepareStatement("insert into account values(?,?,?,?)");
            ps.setInt(1,accountNumber);
            ps.setString(2,username);
            ps.setString(3,password);
            ps.setDouble(4,balance);
           
            int n=ps.executeUpdate();
            if(n>0){
                msg="Account registered successfully";
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        
        return msg;
         

    }

    @Override
    public Double getBalance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBalance'");
    }
}
