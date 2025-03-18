package dao;

public interface Userdao {
    public String UserLoginTable(int accountNumber, String username, String password, double balance);
    public Double getBalance(){
        
    }
}
