package com.myweb;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by Виталик on 26.05.2016.
 */
public class DAO {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/TaskManager","root","admin");
    }
    public static void AddUser(String name,String email,String password) throws SQLException, ClassNotFoundException {
        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("INSERT INTO person (Name,Email,Password) VALUES (?,?,?)");) {
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.executeUpdate();
        }
    }
    public static User RegisteredId(String email) throws SQLException, ClassNotFoundException {
        String scoupEmail="'"+email+"'";
        System.out.println(scoupEmail);
        User user=null;
        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("SELECT Id,Name,Email,Password FROM person WHERE Email like "+scoupEmail);
            ResultSet resultSet=ps.executeQuery();) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String Email = resultSet.getString(3);
                String Password = resultSet.getString(4);
                user=new User(id,name,Email,Password);
                return  user;
            }

            return null;
        }
    }
    public static List<Second_Task> getSubtaskById(int id) throws SQLException, ClassNotFoundException {
        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("SELECT Id,Task_Task_Id,Description, Deadline FROM second_task where Task_Task_Id="+id);//SELECT Task_Id,Person_id,Name,Description,Deadline,Start_Date,condition FROM TASK where Person_Id="+id
            ResultSet resultSet=ps.executeQuery();){
            ArrayList<Second_Task> sub_tasks=new ArrayList<Second_Task>();
            while (resultSet.next()){
                int sec_Tasc_Id=resultSet.getInt(1);
                int task_Id=resultSet.getInt(2);
                String description=resultSet.getString(3);
                Date deadline=resultSet.getDate(4);
                sub_tasks.add(new Second_Task(sec_Tasc_Id,task_Id,description,deadline));
                //System.out.println(tasks);

            }
            return sub_tasks;
        }
    }
    public static void AddSubTask(
            int Task_Id,
            String description,
            Date deadline ) throws SQLException, ClassNotFoundException {
        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("INSERT INTO second_task (Task_Task_Id,Description,Deadline) VALUES (?,?,?)");) {
            ps.setInt(1,Task_Id);
            ps.setString(2,description);
            ps.setDate(3,deadline);
            ps.executeUpdate();
        }

    }
    public static void MakeDone(int id) throws SQLException, ClassNotFoundException {
        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("UPDATE task SET Conditit = 1 WHERE Task_Id = "+id);) {
            ps.executeUpdate();
        }
    }
    public static void DeleteTask(int id) throws SQLException, ClassNotFoundException {
        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("DELETE FROM task WHERE Task_Id ="+id);) {
            ps.executeUpdate();
        }
    }
    public static void AddComment(
            int Task_Id,
            String description
            ) throws SQLException, ClassNotFoundException {
        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("INSERT INTO comment (Task_Task_Id,Description) VALUES (?,?)");) {
            ps.setInt(1,Task_Id);
            ps.setString(2,description);
            ps.executeUpdate();
        }
    }
    public static Task getTaskById(int id) throws SQLException, ClassNotFoundException {
        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("SELECT Task_Id,Person_id,Name,Description,Deadline,Start_Date,Conditit FROM TASK where Task_Id="+id);//SELECT Task_Id,Person_id,Name,Description,Deadline,Start_Date,condition FROM TASK where Person_Id="+id
            ResultSet resultSet=ps.executeQuery();){
            Task task=null;
            while (resultSet.next()){
                int task_Id=resultSet.getInt(1);
                int person_Id=resultSet.getInt(2);
                String name=resultSet.getString(3);
                String description=resultSet.getString(4);
                Date start_date =resultSet.getDate(5);
                Date deadline=resultSet.getDate(6);
                int condition=resultSet.getInt(7);
                System.out.println(name);
                task=new Task(task_Id,person_Id,name,description,start_date,deadline,condition);
                System.out.println(task);
            }
            return task;
        }
    }
    public static List<Comment> getCommentById(int SubTask_Id)throws SQLException, ClassNotFoundException {
        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("SELECT Id,Task_Task_Id,Description FROM comment where Task_Task_Id="+SubTask_Id);//SELECT Task_Id,Person_id,Name,Description,Deadline,Start_Date,condition FROM TASK where Person_Id="+id
            ResultSet resultSet=ps.executeQuery();){
            ArrayList<Comment> comments=new ArrayList<Comment>();
            while (resultSet.next()){
                int sec_Tasc_Id=resultSet.getInt(1);
                int task_Id=resultSet.getInt(2);
                String description=resultSet.getString(3);
                comments.add(new Comment(sec_Tasc_Id,description,task_Id));
                //System.out.println(tasks);

            }
            return comments;
        }
    }

    public static List<Task> getTasksById(int id) throws SQLException, ClassNotFoundException {

        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("SELECT Task_Id,Person_id,Name,Description,Deadline,Start_Date,Conditit FROM TASK where Person_Id="+id);//SELECT Task_Id,Person_id,Name,Description,Deadline,Start_Date,condition FROM TASK where Person_Id="+id
            ResultSet resultSet=ps.executeQuery();){
            ArrayList<Task> tasks=new ArrayList<Task>();
            while (resultSet.next()){
                int task_Id=resultSet.getInt(1);
                int person_Id=resultSet.getInt(2);
                String name=resultSet.getString(3);
                String description=resultSet.getString(4);
                Date start_date =resultSet.getDate(5);
                Date deadline=resultSet.getDate(6);
                int condition=resultSet.getInt(7);
                System.out.println(name);
                tasks.add(new Task(task_Id,person_Id,name,description,start_date,deadline,condition));
                System.out.println(tasks);

            }
            return tasks;
        }
    }
    public static void AddTask(
                                int person_Id,
                                String name,
                                String description,
                                Date start_date,
                                Date deadline ) throws SQLException, ClassNotFoundException {
        try(Connection c=getConnection();
            PreparedStatement ps=c.prepareStatement("INSERT INTO task (Person_id,Name,Description,Deadline,Start_Date) VALUES (?,?,?,?,?)");) {
            ps.setInt(1,person_Id);
            ps.setString(2,name);
            ps.setString(3,description);
            ps.setDate(4,deadline);
            ps.setDate(5,start_date);
            ps.executeUpdate();
        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AddUser("1","1","1");

    }
}


