package com.example.wachiraya_kam.helloworld;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/**
 * Created by Wachiraya_Kam on 2/7/2017.
 */

public class CustomViewSavedState extends View.BaseSavedState  {
    private boolean blue;

    public boolean isBlue() {
        return blue;
    }

    public void setBlue(boolean blue) {
        this.blue = blue;
    }

    public CustomViewSavedState(Parcel source) {
        super(source);
        // Read back
        blue = source.readInt() == 1;
        //blue : 1 true, blue : 0 false
    }

    public CustomViewSavedState(Parcelable superState) {
        super(superState);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        //Write var here
        out.writeInt(blue ? 1 : 0);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new CustomViewSavedState(source);

        }

        @Override
        public Object[] newArray(int size) {
            return new CustomViewSavedState[size];
        }
    };
}
