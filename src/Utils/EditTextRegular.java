package Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;



public class EditTextRegular extends EditText
{

    public EditTextRegular(Context context)
    {
        super(context);
        setTypeface(CommonLib.Regular);
    }

    public EditTextRegular(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setTypeface(CommonLib.Regular);
    }

    public EditTextRegular(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setTypeface(CommonLib.Regular);
    }
}