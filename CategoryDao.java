/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Category;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Set;

/**
 *
 * @author Neha Sonar
 */
public class CategoryDao {
    
    public static void save(Category category){                 //whenever save button is clicked this method (save) will be trigger
        String query = "insert into category (name) values('"+category.getName()+"')";              //insert query for category table
                    //JOptionPane.showMessageDialog(null, "Line 1","Message", JOptionPane.ERROR_MESSAGE);

        DbOperations.setDataOrDelete(query, "Category Added Successfully");                 //calling DbOpreation method in this we are passing setDataorDelete and in this we are passing query and message                        
    }
    
    public static ArrayList<Category> getAllRecords(){               //we need category type of arrayList that is why we are returning ArrayList<category>  //method is getAllRecords   //this method is for saving values in table
        ArrayList<Category> arrayList = new ArrayList<>();           //creating variable(arrayList)
        try{
            ResultSet rs = DbOperations.getData("select * from category");              //calling DbOpration and passing query in it
            while(rs.next()){                                               
                Category category = new Category();          //creating object of Category
                category.setId(rs.getInt("id"));     //in the category object we are setting the value  //and we retrieving this from the database
                category.setName(rs.getString("name"));
                arrayList.add(category);                   //here we are passing category
                
            }
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;               //returning arrayList
            
    }
    
    public static void delete(String id){                   //this method is to delete any category      //the category will deleted by the id
        String query = "delete from category where id = '"+id+"'";                          //query to delete category
        DbOperations.setDataOrDelete(query, "Category Deleted Successfully");       //calling DbOpreation method in this we are passing setDataorDelete and in this we are passing query and message 
    }    
    
}
