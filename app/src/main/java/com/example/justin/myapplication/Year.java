package com.example.justin.myapplication;

public class Year {
    private  int year;

    public Year(int year) throws YearOutsideBoundsException {
        if (year > 10000) {
            throw new YearOutsideBoundsException("Year " + year + " is not valid.");
        }
        if (year < 0) {
            throw new YearOutsideBoundsException("Year " + year + " is not valid.");
        }
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) throws YearOutsideBoundsException {
        if (year > 10000) {
            throw new YearOutsideBoundsException("Year " + year + " is not valid.");
        }
        if (year < 0) {
            throw new YearOutsideBoundsException("Year " + year + " is not valid.");
        }
        this.year = year;
    }

    public class YearOutsideBoundsException extends Exception {
        public YearOutsideBoundsException(String message) {
            super(message);
        }
    }
}
