package com.example.justin.myapplication;

public class Year {
    private  int year;

    /**
     * A constructor of the Year.
     * @param year
     * @throws YearOutsideBoundsException
     */
    public Year(int year) throws YearOutsideBoundsException {
        if (year > 10000) {
            throw new YearOutsideBoundsException("Year " + year + " is not valid.");
        }
        if (year < 0) {
            throw new YearOutsideBoundsException("Year " + year + " is not valid.");
        }
        this.year = year;
    }

    /**
     * Getting a number of the year.
     * @return
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Setting a limitation of the year.
     * @param year
     * @throws YearOutsideBoundsException
     */
    public void setYear(int year) throws YearOutsideBoundsException {
        if (year > 10000) {
            throw new YearOutsideBoundsException("Year " + year + " is not valid.");
        }
        if (year < 0) {
            throw new YearOutsideBoundsException("Year " + year + " is not valid.");
        }
        this.year = year;
    }

    /**
     * An exception function of year.
     */
    public class YearOutsideBoundsException extends Exception {
        public YearOutsideBoundsException(String message) {
            super(message);
        }
    }
}
