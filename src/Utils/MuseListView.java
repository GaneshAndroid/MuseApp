package Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MuseListView extends ListView
{

    public MuseListView(Context context)
    {
        super(context);
    }

    public MuseListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public MuseListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }
}
