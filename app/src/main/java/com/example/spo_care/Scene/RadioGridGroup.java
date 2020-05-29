package com.example.spo_care.Scene;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.IdRes;

import com.example.spo_care.R;

public class RadioGridGroup extends TableLayout implements View.OnClickListener {
    private static final String TAG = "ToggleButtonGroupTableLayout";
    private int checkedButtonID = -1;
    public static double scoreN1, scoreN10, scoreS1, scoreS8, scoreS10;

    public RadioGridGroup(Context context){
        super(context);
    }

    public RadioGridGroup(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public void onClick(View v){
        if(v instanceof RadioButton){
            int id = v.getId();
            check(id);
        }

        if(v.getId() == R.id.cavity_n1_1 || v.getId() == R.id.cavity_n1_2) {
            scoreN1 = 1.2;
        } else if(v.getId() == R.id.cavity_n1_3 || v.getId() == R.id.cavity_n1_4 || v.getId() == R.id.cavity_n1_5 || v.getId() == R.id.cavity_n1_6){
            scoreN1 = 0;
        } else if(v.getId() == R.id.cavity_n10_3 || v.getId() == R.id.cavity_n10_4){
            scoreN10 = 1.2;
        } else if(v.getId() == R.id.cavity_n10_1 || v.getId() == R.id.cavity_n10_2){
            scoreN10 = 0;
        } else if(v.getId() == R.id.periodontl_disease_n1_1 || v.getId() == R.id.periodontl_disease_n1_2 || v.getId() == R.id.periodontl_disease_n1_3){
            scoreS1 = 0;
        } else if(v.getId() == R.id.periodontl_disease_n1_5 || v.getId() == R.id.periodontl_disease_n1_6){
            scoreS1 = 1.2;
        } else if(v.getId() == R.id.periodontl_disease_n1_4){
            scoreS1 = 1.5;
        } else if(v.getId() == R.id.periodontl_disease_n8_2){
            scoreS8 = 2.0;
        } else if(v.getId() == R.id.periodontl_disease_n10_3 || v.getId() ==R.id.periodontl_disease_n10_4){
            scoreS10 = 1.2;
        }
    }

    private void setCheckedStateForView(int viewId, boolean checked){
        View checkedView = findViewById(viewId);
        if(checkedView != null && checkedView instanceof RadioButton){
            ((RadioButton) checkedView).setChecked(checked);
        }
    }

    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params){
        super.addView(child, index, params);
        setChildrenOnClickListener((TableRow) child);
    }

    private void setChildrenOnClickListener(TableRow tr){
        final int c = tr.getChildCount();
        for(int i = 0; i < c; i++){
            final View v = tr.getChildAt(i);
            if(v instanceof RadioButton){
                v.setOnClickListener(this);
            }
        }
    }

    public int getCheckedRadioButton(){
        return checkedButtonID;
    }

    public void check(@IdRes int id){
        if(id != -1 && (id == checkedButtonID)){
            return;
        }
        if(checkedButtonID != -1){
            setCheckedStateForView(checkedButtonID, false);
        }
        if(id != -1){
            setCheckedStateForView(id, true);
        }
        setCheckedId(id);
    }

    private void setCheckedId(int id){
        this.checkedButtonID = id;
    }

    public void clearCheck(){
        check(-1);
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }

        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        this.checkedButtonID = ss.buttonId;
        setCheckedStateForView(checkedButtonID, true);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState savedState = new SavedState(superState);
        savedState.buttonId = checkedButtonID;
        return savedState;
    }
    static class SavedState extends BaseSavedState {
        int buttonId;

        public SavedState(Parcel source) {
            super(source);
            buttonId = source.readInt();
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(buttonId);
        }

        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {
                    public SavedState createFromParcel(Parcel in) {
                        return new SavedState(in);
                    }

                    public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
                };
    }
}
