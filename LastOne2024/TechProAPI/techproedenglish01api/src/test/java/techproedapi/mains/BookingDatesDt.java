package techproedapi.mains;

import javax.annotation.processing.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

                        /*
                               1). private variables
                               2). getter() and setter() methods for all variables
                               3). Constructor with all parameters
                               4). Constructor without parameters
                               5). toString()
                         */

@Generated("jsonschema2pojo")
public class BookingDatesDt {

    @SerializedName("checkin")
    @Expose
    private String checkin;
    @SerializedName("checkout")
    @Expose
    private String checkout;

    @Override
    public String toString() {
        return "BookingDatesDt{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }

    public BookingDatesDt() {
    }

    public BookingDatesDt(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

}
