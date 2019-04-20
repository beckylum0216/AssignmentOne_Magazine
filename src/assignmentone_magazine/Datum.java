/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentone_magazine;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @title Student Record System
 * @filename DOB.java
 * @purpose This class is the object class that contains the date of birth
 * object. Contains all the associated validation methods 
 * @assumptions the inputs will only take in strings and doubles and do error 
 * checking on the input
 * @author Rebecca Lim
 */
public class Datum {
    private int day;
    private int month;
    private int year;
    
    /**
     *
     */
    public Datum()
    {
        this.day = -1;
        this.month = -1;
        this.year = -1;
    }
    
    /**
     * <p>Constructor that allows the input of the Date.</p>
     * 
     * @param inputDay
     * @param inputMonth
     * @param inputYear
     */
    public Datum(int inputDay, int inputMonth, int inputYear)
    {
        this.day = inputDay;
        this.month = inputMonth;
        this.year = inputYear;
    }

    /**
     * <p> The accessor for the day field. </p>
     * @return day gets the day field of the date 
     */
    public int getDay() {
        return day;
    }

    /**
     * <p> The mutator for the day field. </p>
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * <p> The accessor for the month field. </p>
     * @return month the month field of the date
     */
    public int getMonth() {
        return month;
    }

    /**
     * <p> the mutator for the month field </p>
     * @param month sets the month field
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * <p> accessor for the year field. </p>
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * <p> mutator for the year field </p>
     * @param year sets the year field.
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * <p>This method validates if the dates are the same.</p>
     * @param inputDate
     * @return theFlag boolean 
     */
    public boolean isEqual(Datum inputDate)
    {
        boolean theFlag = false;
        if((this.day == inputDate.day) 
                && (this.month == inputDate.month) 
                && (this.year == inputDate.year))
        {
            theFlag = true;
        }
        return theFlag;
    }
    
    /**
     * <p>This method checks if the date held in the date object is a valid date.
     * It validates the date against a year, leap year, month and day. </p>
     * @return theFlag a boolean
     */
    public boolean isValidDate()
    {
        boolean theFlag;
        int theYear = this.year;
        int theMonth = this.month;
        int theDay = this.day;
        
        if(theYear >= 1900 && theYear <= 9999)
        {
            if(theMonth >= 1 && theMonth <= 12)
            {
                if(((theDay >=1) && (theDay <= 31))&&(theMonth == 1|| theMonth == 3)
                        || theMonth == 5 || theMonth == 7 || theMonth==8
                        || theMonth == 10 || theMonth == 12)
                {
                    theFlag = true;
                }
                else if(((theDay >= 1) && (theDay <= 30)) && (theMonth == 4 
                        || theMonth == 6|| theMonth == 9|| theMonth == 11))
                {
                    theFlag = true;
                }
                else if(((theDay >= 1) && (theDay <= 28)) && theMonth ==2)
                {
                    theFlag = true;
                }
                else if((theDay == 29)&&(theYear % 400 == 0 
                        || ((theYear % 4 == 0) && theYear%100 != 0)))
                {
                    theFlag = true;
                }
                else
                {
                    theFlag = false;
                }
            }
            else
            {
                theFlag = false;
            }
            
        }
        else
        {
            theFlag = false;
        }
        
        return theFlag;
    }
    
    /**
     * <p>This method checks if the date object has empty fields. </p>
     * @return theFlag a boolean
     */
    public boolean isEmpty()
    {
        boolean theFlag = false;
        if(this.getDay() == -1)
        {
            theFlag = true;
        }
        
        if(this.getMonth() == -1)
        {
            theFlag = true;
        }
        
        if(this.getYear() == -1)
        {
            theFlag = true;
        }
        
        return theFlag;
    }
    
    @Override
    public String toString() { 
        return this.year+"-"+this.month+"-"+this.day; 
    } 
           
}
