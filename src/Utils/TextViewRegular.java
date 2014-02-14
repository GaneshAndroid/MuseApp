package Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;



public class TextViewRegular extends TextView
{

    public TextViewRegular(Context context)
    {
        super(context);
        setTypeface(CommonLib.Regular);
    }

    public TextViewRegular(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setTypeface(CommonLib.Regular);
    }

    public TextViewRegular(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setTypeface(CommonLib.Regular);
    }
}