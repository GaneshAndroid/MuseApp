package Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;



public class MBigLabel extends TextView
{

    public MBigLabel(Context context)
    {
        super(context);
        setTypeface(CommonLib.Bold);
        setTextSize(0, context.getResources().getDimension(0x7f090013));
    }

    public MBigLabel(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setTypeface(CommonLib.Bold);
        setTextSize(0, context.getResources().getDimension(0x7f090013));
    }

    public MBigLabel(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setTypeface(CommonLib.Bold);
        setTextSize(0, context.getResources().getDimension(0x7f090013));
    }
}
