package uz.agromon.mobile.dto.response;

import uz.agromon.metrics.domain.Crop;

import java.util.List;

public class CropsResponse extends Response {
    //
    List<Crop> crops;

    public CropsResponse(List<Crop> crops) {
        //
        super();
        setResult(true);
        this.crops = crops;
    }

    public List<Crop> getCrops() {
        return crops;
    }

    public void setCrops(List<Crop> crops) {
        this.crops = crops;
    }

    public boolean getResult() {
        return super.getResult();
    }

    public String getMessage() {
        return super.getMessage();
    }

    public String getError_code() {
        return super.getError_code();
    }
}
