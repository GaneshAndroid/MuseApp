package Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;



public class MH3 extends TextView
{

    public MH3(Context context)
    {
        super(context);
        setTypeface(CommonLib.Bold);
        setTextSize(0, getResources().getDimension(0x7f09000f));
        setTextColor(getResources().getColor(0x7f080022));
    }

    public MH3(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setTypeface(CommonLib.Bold);
        setTextSize(0, getResources().getDimension(0x7f09000f));
        setTextColor(getResources().getColor(0x7f080022));
    }

    public MH3(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setTypeface(CommonLib.Bold);
        setTextSize(0, getResources().getDimension(0x7f09000f));
        setTextColor(getResources().getColor(0x7f080022));
    }
}

