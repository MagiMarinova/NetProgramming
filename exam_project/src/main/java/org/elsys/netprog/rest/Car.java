package org.elsys.netprog.rest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Car {
    public String carReg;
    public Boolean active;
    public String zone;
    public String due;
    public String lastAction;
    private Date beginDate;

    public Car(String carReg, String zone) {
        this.carReg = carReg;
        this.active = true;
        this.zone = zone;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss z d/M/yyyy");
        this.beginDate = new Date(); //Get the current date.
        this.lastAction = sdf.format(this.beginDate); //Formats the current date into a string.

        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        cal.add(Calendar.HOUR, 1); //change current date with 1 hour to make the end date
        this.due = sdf.format(cal.getTime());
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carReg, car.carReg) &&
                Objects.equals(active, car.active) &&
                Objects.equals(zone, car.zone) &&
                Objects.equals(due, car.due) &&
                Objects.equals(lastAction, car.lastAction) &&
                Objects.equals(beginDate, car.beginDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carReg, active, zone, due, lastAction, beginDate);
    }
}
