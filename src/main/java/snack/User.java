package snack;


import lombok.Getter;

@Getter
public class User {
    String name;
    String authority;
    int totalAmount;

    User(String name,String authority,int totalAmount){
        this.name = name;
        this.authority = authority;
        this.totalAmount = totalAmount;
    }
}
