package tooHotToMow;

public class HeatIndexService {

    Double temp;
    Double rh;

    public HeatIndexService(Double temp, Double rh) {
        this.temp = temp;
        this.rh = rh;
    }

    public Double heatIndex() {

        if(shouldUseSimpleFormula()) {
            return simpleHeatIndexFormula();
        }

        if(shouldAddLowHumidityAdjustment()) {
            return rothfuszRegression() - lowHumidiytAdjustment();
        }

        if(shouldAddHighHumidityAdjusment()) {
            return rothfuszRegression() + highHumidityAdjustment();
        }

        return rothfuszRegression();
    }

    private Double highHumidityAdjustment() {
        return ((rh-85)/10) * ((87 - temp)/5);
    }

    private boolean shouldAddHighHumidityAdjusment() {
        return rh > 85.0 && temp > 80.0 && temp < 87.0;
    }

    private Double lowHumidiytAdjustment() {
        return ((13-rh)/4)*Math.sqrt((17-Math.abs(temp-95.0))/17);
    }

    private boolean shouldAddLowHumidityAdjustment() {
        return rh < 13 && temp > 80 && temp < 112;
    }

    private Double rothfuszRegression() {
        return -42.379 + 2.04901523 * temp +10.14333127 * rh - 0.22475541 * temp * rh - 0.00683783 *
                temp * temp - 0.05481717 * rh * rh + 0.00122874 * temp * temp * rh + 0.00085282 *
                temp * rh * rh - 0.00000199 * temp * temp * rh * rh;
    }

    private double simpleHeatIndexFormula() {
        return 0.5 * (temp + 61.0 + ((temp-68.0)*1.2) + (rh*0.094));
    }

    private boolean shouldUseSimpleFormula() {
        return ((simpleHeatIndexFormula() + temp) /2) < 80.0;
    }
}
