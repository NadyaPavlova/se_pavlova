package sef.module18.activity;

import junit.framework.AssertionFailedError;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import junit.framework.TestCase;
import java.sql.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectRepositoryTest extends TestCase {
    private Connection conn;

    private String url ;
    private String username;
    private String password;
@Before
    protected void setUp() throws Exception {
        super.setUp();
        username = "sa";
        password = "";
        Class.forName("org.h2.Driver");
        url = "jdbc:h2:~/test";
        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);
        System.out.println("Connection successfully established!");

    }
@Test
    public void testFindProjectByID(){
    ProjectRepository projectRepository =   new ProjectRepositoryImpl(conn);
        try {
            Project result = projectRepository.findProjectByID(1);
            //assertEquals(result.getProjectID(), 3);
            assertEquals(result.getProjectName(), "Online Insurance System");
            result = projectRepository.findProjectByID(0);

        }
        catch (HRSSystemException e) {
            fail();
        }
    }
    @Test
   public void testFindProjectByName(){
       ProjectRepository projectRepository =   new ProjectRepositoryImpl(conn);
        try {
            List<Project> results = projectRepository.findProjectByName("ONLINE INSURANCE SYSTEM");
            assertEquals(1, results.size());

            assertEquals(results.get(0).getProjectID(), 1);
            assertEquals(results.get(0).getProjectName().toUpperCase(), "ONLINE INSURANCE SYSTEM");

        } catch (HRSSystemException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindProjectByEmployee(){
        ProjectRepository projectRepository =   new ProjectRepositoryImpl(conn);
        try {
            List <Project>results = projectRepository.findProjectByEmployee(1);
            assertEquals(1, results.size());

            assertEquals(results.get(0).getProjectID(), 1);
            assertEquals(results.get(0).getProjectName().toUpperCase(), "ONLINE INSURANCE SYSTEM");

        } catch (HRSSystemException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testInsertProject(){
        ProjectRepository projectRepository =   new ProjectRepositoryImpl(conn);
        try {
            boolean insCorrect= false;
            Project project = new ProjectImpl(0, "Altair system", "Employee time tracking");
            int result = projectRepository.insertProject(project);
            if(result>0)
                insCorrect= true;
            assertTrue(insCorrect);

        } catch (HRSSystemException e) {
                  fail();
        }

    }
    @Test
    public void testUpdateProject(){
        ProjectRepository projectRepository =   new ProjectRepositoryImpl(conn);
        try {
            Project project = new ProjectImpl(3, "Online-system Altair", "Employee time tracking");
            assertTrue( projectRepository.updateProject(project));
        } catch (HRSSystemException e) {
            fail();
        }

    }
@After
    protected void tearDown() throws Exception {
        try{
            super.tearDown();
            conn.close();
            System.out.println("Connection closed!");
        }catch(AssertionFailedError e){
            fail();
        }
    }

}