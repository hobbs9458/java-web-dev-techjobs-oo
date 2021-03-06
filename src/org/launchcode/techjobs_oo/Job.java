package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    //each job has its own id.
    // do other classes in the Job's fields contain their own unique ids?
    private int id;
    private static int nextId = 1;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location,
        PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        if(this.getName() == "" && this.employer.getValue() == "" && this.location.getValue() == "" && this.positionType.getValue() == "" && this.coreCompetency.getValue() == "") {
            return "OOPS! This job does not seem to exist.";
        }

        if (this.getName() == "") {
            this.setName("Data not available");
        }
        if (this.employer.getValue() == "") {
            this.employer.setValue("Data not available");
        }
        if (this.location.getValue() == "") {
            this.location.setValue("Data not available");
        }
        if (this.positionType.getValue() == "") {
            this.positionType.setValue("Data not available");
        }
        if (this.coreCompetency.getValue() == "") {
            this.coreCompetency.setValue("Data not available");
        }

        return "\n"
                + "ID: " + this.getId() + "\n"
                + "Name: " + this.getName() + "\n"
                + "Employer: " + this.getEmployer().getValue() + "\n"
                + "Location: " + this.getLocation().getValue() + "\n"
                + "Position Type: " + this.getPositionType().getValue() + "\n"
                + "Core Competency: " + this.getCoreCompetency().getValue() + "\n";
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    //getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
