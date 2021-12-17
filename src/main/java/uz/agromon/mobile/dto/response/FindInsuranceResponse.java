package uz.agromon.mobile.dto.response;

public class FindInsuranceResponse extends Response {
    private String insurance;

    public FindInsuranceResponse() {
        //
    }

    public FindInsuranceResponse(String insurance) {
        super();
        super.result = true;
        this.insurance = insurance;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
}
