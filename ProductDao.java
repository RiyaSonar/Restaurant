/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Product;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Neha Sonar
 */
public class ProductDao {
    
    public static void save(Product product){                //void - because we are inserting details and we need to return anything          //(Product product)- to get the Product details
        String query = "insert into product(name,category,price) values('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";      //writting column names and their values
        DbOperations.setDataOrDelete(query, "Product Added Successfully");
    }
    
    
    public static ArrayList<Product> getAllRecords(){                           //creating a method which would return a arraylist
        ArrayList<Product> arrayList = new ArrayList<> ();                      //creating an ArrayList of Product Type in that we are setting the values by extracting it from the database
        try{
            ResultSet rs = DbOperations.getData("select * from product");   //calling the resultset and calling DbOperation method in that getData and in this we are passing the queries  
            while(rs.next()){
                Product product = new Product();                         //creating object(product) of Product table
                product.setId(rs.getInt("id"));                     //{setting the product detailes
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));             //}
                arrayList.add(product);              //in the arraylist we are adding object of Product
                
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    
    public static void update(Product product){               //creating update method of Product type
        String query = "update product set name = '"+product.getName()+"',category = '"+product.getCategory()+"',price = '"+product.getPrice()+"' where id = '"+product.getId()+"'";       //query for update method
        DbOperations.setDataOrDelete(query, "Product Updated Successfully");            //passing the above query in DbOpreation method and passing the message
    }
    
    public static void delete(String id){                        //creating delete method  //taking id to delete
        String query = "delete from product where id = '"+id+"'"; //query to delete
        DbOperations.setDataOrDelete(query, "Product Deleted Successfully");
    }
}
