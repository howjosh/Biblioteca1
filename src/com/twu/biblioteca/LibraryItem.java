package com.twu.biblioteca;

public abstract class LibraryItem {

    private String title;
    private int year;
    private boolean checkedOut;

    protected LibraryItem(String title, int year, boolean checkedOut) {
        this.title = title;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }



    public void returnItem() {
        checkedOut = false;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    @Override
    public boolean equals(Object _otherItem){

        LibraryItem otherItem = (LibraryItem)_otherItem;
        return title.equals(otherItem.getTitle());

    }
}
