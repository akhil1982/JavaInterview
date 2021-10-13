package com.javaSamples.codeProblmes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OnlineMovieBooking {
}

enum MovieStatus {
    Movie_Available, Movie_NotAvailable;
}
enum SeatType {
    Normal, Executive;
}
enum SeatAvailability {
    Seat_Available, Seat_NotAvailable;
}

enum MovieGenere {
    Comedy, Family, Horror;
}

enum MovieLanguage {
    English, Spanish;
}

enum PaymentStatus {
    Paid, NonPaid;
}
class City {
    private String name;
    private List<Theater> theates = new ArrayList<>();

    public List<Theater> getTheates() {
        return theates;
    }

}
class Theater {
    private int id;
    private String name;
    private String address;
    private String number;
    private List<Seat> seats = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();

    public List<Movie> getMovies() {
        return movies;
    }

    public boolean isSeatAvailable (){
        List<Seat> availableSeats = seats.stream().filter(x-> {
            if(x.isAvailable()){
                System.out.println("Seat is available "+x.getSeatNumber());
            }
            return false;
        }).collect(Collectors.toList());

        return availableSeats.size() <0 ?false:true;
    }
}

abstract class Seat {

    private int seatNumber;
    private SeatType type;
    private SeatAvailability availability;

    public int getSeatNumber() {
        return seatNumber;
    }

    public abstract SeatType seatType ();
    public abstract boolean isAvailable();
}

class NormalSeat extends Seat{

    public NormalSeat(){

    }
    @Override
    public SeatType seatType() {
        return SeatType.Normal;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}

class Movie {
    private MovieGenere genere;
    private MovieLanguage language;
    private MovieStatus status;
    private int id;
    private String name;
}
class User {
    private String name;
    private String address;
    private String number;

    public User (String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}