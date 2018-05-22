package com.example.chsamirkrishna.railwayapistation;

public class PnrStatus {

    private Train train;
    private String doj;
    private int total_passengers;
    private FromStation from_station;
    private ToStation to_station;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public int getTotal_passengers() {
        return total_passengers;
    }

    public void setTotal_passengers(int total_passengers) {
        this.total_passengers = total_passengers;
    }

    public FromStation getFrom_station() {
        return from_station;
    }

    public void setFrom_station(FromStation from_station) {
        this.from_station = from_station;
    }

    public ToStation getTo_station() {
        return to_station;
    }

    public void setTo_station(ToStation to_station) {
        this.to_station = to_station;
    }
}