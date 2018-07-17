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

    Month(int id) {
        this.id = id;
    }

    public int getInt(){
        return this.id;
    }

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

    static public Month of(String m) throws OutsideMonthBoundsException {
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

    static class OutsideMonthBoundsException extends Exception {
        public OutsideMonthBoundsException(String message) {
            super(message);
        }
    }

}
