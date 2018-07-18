package com.example.justin.myapplication;

public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private final int id;

    /**
     * A constructor of enum.
     * @param id
     */
    Month(int id) {
        this.id = id;
    }

    /**
     * Getting an integer.
     * @return
     */
    public int getInt(){
        return this.id;
    }

    /**
     * Checking if the month is smaller than 1 or greater than 12,
     * then it will be throwing an exception.
     * @param m
     * @return
     * @throws OutsideMonthBoundsException
     */
    static public Month of(int m) throws OutsideMonthBoundsException {
        if (m < 1 || m > 12) {
            throw new OutsideMonthBoundsException("The number " + m + " is not a Month.");
        }
        Month returnVal = null;
        for (Month month : Month.values()) {
            if (month.getInt() == m) {
                returnVal = month;
            }
        }
        return returnVal;
    }

    /**
     * Matching the month from the user and converting into a string.
     * @param m
     * @return
     */
    static public Month of(String m) {
        switch(m.toString()) {
            case "January":
                return Month.JANUARY;
            case "February":
                return Month.FEBRUARY;
            case "March":
                return Month.MARCH;
            case "April":
                return Month.APRIL;
            case "May":
                return Month.MAY;
            case "June":
                return Month.JUNE;
            case "July":
                return Month.JULY;
            case "August":
                return Month.AUGUST;
            case "September":
                return Month.SEPTEMBER;
            case "October":
                return Month.OCTOBER;
            case "November":
                return Month.NOVEMBER;
            case "December":
                return Month.DECEMBER;
        }
        return null;
    }

    /**
     * Getting the previous month.
     * @return
     */
    public Month getPrevMonth() {
        Month retMonth = null;
        if (this.getInt() == 1) {
            return Month.DECEMBER;
        }
        try{
             retMonth = Month.of(id - 1);
        } catch (OutsideMonthBoundsException e) {
            System.err.println(e);
        }
        return retMonth;
    }

    /**
     * Getting the next month.
     * @return
     */
    public Month getNextMonth() {
        Month retMonth = null;
        if (this.getInt() == 12) {
            return Month.JANUARY;
        }
        try{
            retMonth = Month.of(this.id + 1);
        } catch (OutsideMonthBoundsException e) {
            System.err.println(e);
        }
        return retMonth;
    }

    /**
     * An exception function of month.
     */
    static class OutsideMonthBoundsException extends Exception {
        public OutsideMonthBoundsException(String message) {
            super(message);
        }
    }

}
