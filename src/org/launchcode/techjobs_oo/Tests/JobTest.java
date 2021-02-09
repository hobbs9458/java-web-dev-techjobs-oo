package org.launchcode.techjobs_oo.Tests;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class JobTest {
  Job jobObj1;
  Job jobObj2;
  Job jobObj3;
  Job jobObj4;
  Job jobObjNoName;

  @Before
  public void createJobObjects() {
    jobObj1 = new Job();
    jobObj2 = new Job();
    jobObj3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    jobObj4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    jobObjNoName = new Job(null, new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
  }



  @Test
  public void testSettingJobId() {
    assertEquals(1, jobObj1.getId());
    assertEquals(2, jobObj2.getId());
    assertEquals(1, jobObj2.getId() - jobObj1.getId());
  }

  @Test
  public void testJobConstructorSetsAllFields() {
//    Job jobObj3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertEquals("Product tester", jobObj3.getName());
    assertEquals(3, jobObj3.getId());
    assertEquals("ACME", jobObj3.getEmployer().getValue());
    assertEquals("Desert", jobObj3.getLocation().getValue());
    assertEquals("Quality control", jobObj3.getPositionType().getValue());
    assertEquals("Persistence", jobObj3.getCoreCompetency().getValue());
  }

  @Test
  public void testJobsForEquality() {
    assertNotEquals(jobObj3.getId(), jobObj4.getId());
  }

  @Test
  public void testJobToString() {
    if(jobObjNoName.getName() == null) {
      assertEquals("\n" + "ID: 5\n"
          + "Name: Data not available\n"
          + "Employer: ACME\n"
          + "Location: Desert\n"
          + "Position Type: Quality control\n"
          + "Core Competency: Persistence\n", jobObjNoName.toString());
    } else {
      assertEquals("\n" + "ID: 4\n"
          + "Name: Product tester\n"
          + "Employer: ACME\n"
          + "Location: Desert\n"
          + "Position Type: Quality control\n"
          + "Core Competency: Persistence\n", jobObj4.toString());
    }


  }









}
