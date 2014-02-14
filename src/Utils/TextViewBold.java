package Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;



public class TextViewBold extends TextView
{

    public TextViewBold(Context context)
    {
        super(context);
        setTypeface(CommonLib.Bold);
    }

    public TextViewBold(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setTypeface(CommonLib.Bold);
    }

    public TextViewBold(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setTypeface(CommonLib.Bold);
    }
}
