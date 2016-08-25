package tooHotToMow;

public class Weather {

    Double temp;
    Double rh;

    public Weather(Double temp, Double rh) {
        this.temp = temp;
        this.rh = rh;
    }

    public Double heatIndex() {
        Double heatIndex = 0.0;

        heatIndex = 0.5 * (temp + 61.0 + ((temp-68.0)*1.2) + (rh*0.094));

        return heatIndex;
    }
}
