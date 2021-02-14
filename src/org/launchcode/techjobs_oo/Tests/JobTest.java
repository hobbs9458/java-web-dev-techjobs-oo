package org.launchcode.techjobs_oo.Tests;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class JobTest {

  Job job1;
  Job job2;
  Job job3;
  Job job4;
  Job jobObjNoName;
  Job jobObjNoPosition;
  Job jobObjNoEmployer;
  Job jobNull;

  @Before
  public void createJobObjects() {
    job1 = new Job();
    job2 = new Job();
  }



  @Test
  public void testSettingJobId() {

    assertEquals(1, job2.getId() - job1.getId());
  }

  @Test
  public void testJobConstructorSetsAllFields() {
    job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
        new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertEquals("Product tester", job3.getName());
    assertEquals("ACME", job3.getEmployer().getValue());
    assertEquals("Desert", job3.getLocation().getValue());
    assertEquals("Quality control", job3.getPositionType().getValue());
    assertEquals("Persistence", job3.getCoreCompetency().getValue());
    assertTrue(job3 instanceof Job);
  }

  @Test
  public void testJobsForEquality() {
    assertNotEquals(job1.getId(), job2.getId());
  }

  @Test
  public void testJobToString() {
    job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
        new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertEquals("\n" + "ID: " + job4.getId() + "\n"
        + "Name: Product tester\n"
        + "Employer: ACME\n"
        + "Location: Desert\n"
        + "Position Type: Quality control\n"
        + "Core Competency: Persistence\n", job4.toString());
  }

  @Test
  public void testNoName() {
    jobObjNoName = new Job("", new Employer("ACME"), new Location("Desert"),
        new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertEquals("\n" + "ID: " + jobObjNoName.getId() + "\n"
        + "Name: Data not available\n"
        + "Employer: ACME\n"
        + "Location: Desert\n"
        + "Position Type: Quality control\n"
        + "Core Competency: Persistence\n", jobObjNoName.toString());
  }

  @Test
  public void testNoEmployer() {
    jobObjNoEmployer = new Job("Product tester", new Employer(""), new Location("Desert"),
        new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertEquals("\n" + "ID: " + jobObjNoEmployer.getId() + "\n"
        + "Name: Product tester\n"
        + "Employer: Data not available\n"
        + "Location: Desert\n"
        + "Position Type: Quality control\n"
        + "Core Competency: Persistence\n", jobObjNoEmployer.toString());
  }

  @Test
  public void testNoPosition() {
    jobObjNoPosition = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
        new PositionType(""), new CoreCompetency("Persistence"));
    assertEquals("\n" + "ID: " + jobObjNoPosition.getId() + "\n"
        + "Name: Product tester\n"
        + "Employer: ACME\n"
        + "Location: Desert\n"
        + "Position Type: Data not available\n"
        + "Core Competency: Persistence\n", jobObjNoPosition.toString());
  }

  @Test
  public void testNullJob() {
    jobNull = new Job("", new Employer(""), new Location(""),
        new PositionType(""), new CoreCompetency(""));
    assertEquals("OOPS! This job does not seem to exist.", jobNull.toString());
  }
}
