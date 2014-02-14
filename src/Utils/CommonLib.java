package Utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.os.AsyncTask;
import android.os.Environment;

import com.application.zomato.Category;
import com.application.zomato.CommonLib;
import com.application.zomato.INSTR;
import com.application.zomato.RequestWrapper;
import com.application.zomato.Special;
import com.application.zomato._L1;
import com.application.zomato._L3;

public class CommonLib
{
    public static class CategoriesComparator
        implements Comparator
    {

        public int compare(Category category, Category category1)
        {
            int i = category1.getOrder();
            return category.getOrder() - i;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Category)obj, (Category)obj1);
        }

        public CategoriesComparator()
        {
        }
    }

    public static class CitiesComparator
        implements Comparator
    {

        int currentCountryId;

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((String)obj, (String)obj1);
        }

        public int compare(String s, String s1)
        {
            int i = Integer.parseInt(s.substring(1 + s.substring(0, s.lastIndexOf(":")).lastIndexOf(":"), s.lastIndexOf(":")));
            int j = Integer.parseInt(s1.substring(1 + s1.substring(0, s1.lastIndexOf(":")).lastIndexOf(":"), s1.lastIndexOf(":")));
            String s2 = s.substring(1 + s.indexOf(":city"));
            String s3 = s2.substring(3, s2.indexOf(":"));
            String s4 = s1.substring(1 + s1.indexOf(":city"));
            String s5 = s4.substring(3, s4.indexOf(":"));
            String s6 = s.substring(0, s.indexOf(":"));
            String s7 = s1.substring(0, s1.indexOf(":"));
            if (i == j)
            {
                return s6.compareTo(s7);
            }
            if (i == currentCountryId)
            {
                return -1;
            }
            if (j == currentCountryId)
            {
                return 1;
            } else
            {
                return s3.compareTo(s5);
            }
        }

        public CitiesComparator(int i)
        {
            currentCountryId = i;
        }
    }

    public static class SpecialsComparator
        implements Comparator
    {

        public int compare(Special special, Special special1)
        {
            int i = special1.getOrder();
            return special.getOrder() - i;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Special)obj, (Special)obj1);
        }

        public SpecialsComparator()
        {
        }
    }

    public static class getImageFromUrl extends AsyncTask
    {

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Object[])aobj);
        }

        protected transient Void doInBackground(Object aobj[])
        {
            try
            {
                URL url = new URL((String)aobj[0]);
                Context context = (Context)aobj[1];
                Bitmap bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
                CommonLib.addBitmapToDisk((String)aobj[0], bitmap, context);
            }
            catch (MalformedURLException malformedurlexception)
            {
                malformedurlexception.printStackTrace();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            catch (OutOfMemoryError outofmemoryerror) { }
            return null;
        }

        public getImageFromUrl()
        {
        }
    }


    public static final String APIKEY = "7749b19667964b87a3efc739e254ada2";
    public static Typeface Bold;
    public static final int CITY_IDENTIFIED = 4;
    public static final int CITY_NOT_IDENTIFIED = 5;
    public static String CLIENT_ID = "zomato_android_v2";
    public static final int DELETE_PHOTO_DIALOG = 1372;
    public static final int DELETE_REVIEW_DIALOG = 1373;
    public static final int DIFFERENT_CITY_IDENTIFIED = 7;
    public static final int DROPDOWN_ANIMATION_DURATION = 250;
    public static final int EDIT_PROFILE_ACTIVITY = 600;
    public static final int EDIT_PROFILE_FACEBOOK_CONNECT = 602;
    public static final int EDIT_PROFILE_SUCCESSFUL = 601;
    public static final int GETZONE_CALLED = 3;
    public static final int LOCATION_DETECTED = 2;
    public static final int LOCATION_DETECTION_RUNNING = 6;
    public static final int LOCATION_NOT_DETECTED = 1;
    public static final int LOCATION_NOT_ENABLED = 0;
    public static Typeface Metro;
    public static final int NOTIFICATIONS = 500;
    static final String PREFERENCE_NAME = "twitter_oauth";
    static final String PREF_KEY_OAUTH_SECRET = "oauth_token_secret";
    static final String PREF_KEY_OAUTH_TOKEN = "oauth_token";
    static final String PREF_KEY_TWITTER_LOGIN = "isTwitterLogedIn";
    public static final int PROFILE_PICTURE_UPDATED = 701;
    public static final int RESTAURANT_FINDER = 6752;
    public static final int RESULT_FACEBOOK_LOGIN_OK = 1432;
    public static final int RESULT_GOOGLE_LOGIN_OK = 1434;
    public static final int RESULT_ZOMATO_LOGIN_OK = 1433;
    public static Typeface Ratings;
    public static Typeface Regular;
    public static int SCREEN_HEIGHT = 0;
    public static int SCREEN_WIDTH = 0;
    public static final int SELECT_PROFILE_PICTURE_ACTIVITY = 700;
    public static final String SERVER = "https://api.zomato.com/v2/";
    public static final int SHARE = 10;
    public static final String SOURCE;
    public static final int START_ACTIVITY_LOGIN_INTENT = 200;
    public static final int START_UPLOAD_PHOTO = 2331;
    public static final int START_WRITE_REVIEW = 2333;
    static final String TWITTER_CALLBACK_URL = "zomatooauth://twittereditprofile";
    static final String TWITTER_CONSUMER_KEY = "FH3jjypfBTtUyHb0Bf5KQ";
    static final String TWITTER_CONSUMER_SECRET = "0K3YR9IYcFnWtygF7pXXr1JUAC7tfTd4q48flriyY";
    public static int UPLOAD_IMAGE_HEIGHT = 0;
    public static int UPLOAD_IMAGE_WIDTH = 0;
    static final String URL_TWITTER_AUTH = "auth_url";
    static final String URL_TWITTER_OAUTH_TOKEN = "oauth_token";
    static final String URL_TWITTER_OAUTH_VERIFIER = "oauth_verifier";
    public static final int VERSION = 33;
    public static final int ZOMATO_LOGIN = 100;
    public static final int ZOMATO_SIGNUP = 200;
    private static final boolean ZomatoLog = false;
    public static boolean callCapable = false;
    public static final boolean checkVersion = false;
    public static final int minTimeBwLocationUpdates = 60;
    public static final boolean showDiscounts = true;
    public static final boolean showPromotions = true;
    public static final boolean showTransitionAds = true;
    public static int socialCount_favorties = 0;
    public static int socialCount_followedby = 0;
    public static int socialCount_follows = 0;
    public static int socialCount_reviews = 0;
    public static int socialCount_unread = 0;
    public static int socialCount_wishlist = 0;

    public CommonLib()
    {
    }

    public static void ZLog(String s, int i)
    {
    }

    public static void ZLog(String s, String s1)
    {
    }

    public static void ZLog(String s, boolean flag)
    {
    }

    public static void addBitmapToDisk(String s, Bitmap bitmap, Context context)
    {
        writeBitmapToDisk(s, bitmap, context, android.graphics.Bitmap.CompressFormat.PNG);
    }

    public static int calculateInSampleSize(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int i1;
label0:
        {
label1:
            {
                int k = 1;
                int l = (int)Math.ceil(options.outHeight / j);
                i1 = (int)Math.ceil(options.outWidth / i);
                if (l > 1 || i1 > 1)
                {
                    if (l <= i1)
                    {
                        break label0;
                    }
                    if (l < 2)
                    {
                        break label1;
                    }
                    k = l;
                }
                return k;
            }
            return 2;
        }
        if (i1 >= 2)
        {
            return i1;
        } else
        {
            return 2;
        }
    }

    private static String constructFileName(String s)
    {
        return s.replaceAll("/", "_");
    }

    public static String convert_time(long l, Context context)
    {
        long l1 = 60L * 1L;
        long l2 = 60L * l1;
        long l3 = 24L * l2;
        long l4 = 30L * l3;
        long l5 = System.currentTimeMillis() / 1000L - l;
        if (l5 < 1L * l1)
        {
            if (l5 < 60L)
            {
                return context.getString(0x7f07029a);
            } else
            {
                Object aobj6[] = new Object[1];
                aobj6[0] = Long.valueOf(l5);
                return context.getString(0x7f07029f, aobj6);
            }
        }
        if (l5 < 2L * l1)
        {
            return context.getString(0x7f0702a2);
        }
        if (l5 < 45L * l1)
        {
            Object aobj5[] = new Object[1];
            aobj5[0] = Integer.valueOf((int)Math.floor(l5 / l1));
            return context.getString(0x7f07029d, aobj5);
        }
        if (l5 < 90L * l1)
        {
            return context.getString(0x7f0702a3);
        }
        if (l5 < 24L * l2)
        {
            Object aobj4[] = new Object[1];
            aobj4[0] = Integer.valueOf((int)Math.floor(l5 / l2));
            return context.getString(0x7f07029c, aobj4);
        }
        if (l5 < 48L * l2)
        {
            return context.getString(0x7f0702a7);
        }
        if (l5 < 7L * l3)
        {
            Object aobj3[] = new Object[1];
            aobj3[0] = Integer.valueOf((int)Math.floor(l5 / l3));
            return context.getString(0x7f07029b, aobj3);
        }
        if (l5 < l4)
        {
            Object aobj2[] = new Object[1];
            aobj2[0] = Integer.valueOf((int)Math.floor(l5 / l3 / 7L));
            return context.getString(0x7f0702a0, aobj2);
        }
        if (l5 < 12L * l4)
        {
            int j = (int)Math.floor(l5 / l3 / 30L);
            if (j <= 1)
            {
                return context.getString(0x7f0702a9);
            } else
            {
                Object aobj1[] = new Object[1];
                aobj1[0] = Integer.valueOf(j);
                return context.getString(0x7f07029e, aobj1);
            }
        }
        int i = (int)Math.floor(l5 / l3 / 30L / 12L);
        if (i <= 1)
        {
            return context.getString(0x7f0702a8);
        } else
        {
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(i);
            return context.getString(0x7f0702a1, aobj);
        }
    }

    public static Bitmap createCenterCroppedImage(Bitmap bitmap, int i, int j)
    {
        int k = bitmap.getWidth() - j;
        int l = bitmap.getHeight() - i;
        if (k >= 0 && l >= 0)
        {
            return Bitmap.createBitmap(bitmap, k / 2, l / 2, j, i);
        }
        if (k >= 0 && l < 0)
        {
            return Bitmap.createBitmap(bitmap, (bitmap.getWidth() - bitmap.getHeight()) / 2, 0, bitmap.getHeight(), bitmap.getHeight());
        }
        if (k < 0 && l >= 0)
        {
            return Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - bitmap.getWidth()) / 2, bitmap.getWidth(), bitmap.getWidth());
        }
        if (bitmap.getHeight() > bitmap.getWidth())
        {
            return Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - bitmap.getWidth()) / 2, bitmap.getWidth(), bitmap.getWidth());
        } else
        {
            return Bitmap.createBitmap(bitmap, (bitmap.getWidth() - bitmap.getHeight()) / 2, 0, bitmap.getHeight(), bitmap.getHeight());
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(String s, int i, int j)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, options);
        options.inSampleSize = calculateInSampleSize(options, i, j);
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(s, options);
        int k = getExifOrientation(s);
        if (k == 0)
        {
            return bitmap;
        } else
        {
            Matrix matrix = new Matrix();
            matrix.preRotate(k);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
    }

    public static boolean deleteBitmapFromDisk(String s, Context context)
    {
        return context.deleteFile(s);
    }

    public static double distFrom(double d, double d1, double d2, double d3)
    {
        double d4 = Math.toRadians(d2 - d);
        double d5 = Math.toRadians(d3 - d1);
        double d6 = Math.toRadians(d);
        double d7 = Math.toRadians(d2);
        double d8 = Math.sin(d4 / 2D);
        double d9 = Math.sin(d5 / 2D);
        double d10 = Math.pow(d8, 2D) + Math.pow(d9, 2D) * Math.cos(d6) * Math.cos(d7);
        return 6371D * (2D * Math.atan2(Math.sqrt(d10), Math.sqrt(1.0D - d10)));
    }

    public static String friendlyDistanceFromDistance(double d, boolean flag)
    {
        if (flag)
        {
            double d1 = (62D * Math.floor(d / 1000D)) / 100D;
            if (d1 < 0.10000000000000001D)
            {
                return "< .1 mi";
            }
            if (d1 < 99.998999999999995D)
            {
                return (new StringBuilder(String.valueOf(d1))).append(" mi").toString();
            } else
            {
                return "100+ mi";
            }
        }
        int i = (int)Math.floor(d / 1000D);
        int j = (int)d % 1000;
        if (i == 0)
        {
            return (new StringBuilder(String.valueOf(Math.round(j)))).append(" m").toString();
        }
        int k = (int)Math.round((double)j / 100D);
        if (k == 10)
        {
            i++;
            k = 0;
        }
        if ((double)i >= 99.998999999999995D)
        {
            return "100+ km";
        } else
        {
            return (new StringBuilder(String.valueOf(getNumberFormat().format((double)i + (double)k / 10D)))).append(" km").toString();
        }
    }

    public static Bitmap getBitmapFromDisk(String s, Context context)
    {
        File file;
        boolean flag;
        Bitmap bitmap;
        boolean flag1;
        boolean flag2;
        android.graphics.BitmapFactory.Options options;
        Bitmap bitmap1;
        try
        {
            file = context.getFileStreamPath(constructFileName(s));
            flag = file.exists();
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            filenotfoundexception.printStackTrace();
            return null;
        }
        catch (Exception exception)
        {
            return null;
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            return null;
        }
        bitmap = null;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        flag1 = file.isFile();
        bitmap = null;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        flag2 = file.isDirectory();
        bitmap = null;
        if (flag2)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        bitmap1 = BitmapFactory.decodeStream(new FileInputStream(file), null, options);
        bitmap = bitmap1;
        return bitmap;
    }

    public static Camera getCameraInstance()
    {
        Camera camera;
        try
        {
            camera = Camera.open();
        }
        catch (Exception exception)
        {
            return null;
        }
        return camera;
    }

    public static int getCuisineId(String s)
    {
        if (s.equals("American"))
        {
            return 1;
        }
        if (s.equals("Andhra"))
        {
            return 2;
        }
        if (s.equals("Arabian"))
        {
            return 4;
        }
        if (s.equals("Asian"))
        {
            return 3;
        }
        if (s.equals("Bakery"))
        {
            return 5;
        }
        if (s.equals("Bengali"))
        {
            return 10;
        }
        if (s.equals("Biryani"))
        {
            return 7;
        }
        if (s.equals("Burmese"))
        {
            return 22;
        }
        if (s.equals("Cafe"))
        {
            return 30;
        }
        if (s.equals("Chinese"))
        {
            return 25;
        }
        if (s.equals("Continental"))
        {
            return 35;
        }
        if (s.equals("Desserts"))
        {
            return 100;
        }
        if (s.equals("European"))
        {
            return 38;
        }
        if (s.equals("Fast Food"))
        {
            return 40;
        }
        if (s.equals("French"))
        {
            return 45;
        }
        if (s.equals("Goan"))
        {
            return 47;
        }
        if (s.equals("Gujrati"))
        {
            return 48;
        }
        if (s.equals("Italian"))
        {
            return 55;
        }
        if (s.equals("Japanese"))
        {
            return 60;
        }
        if (s.equals("Kashmiri"))
        {
            return 65;
        }
        if (s.equals("Kerela"))
        {
            return 62;
        }
        if (s.equals("Konkan"))
        {
            return 63;
        }
        if (s.equals("Korean"))
        {
            return 67;
        }
        if (s.equals("Lebanese"))
        {
            return 66;
        }
        if (s.equals("Lounge"))
        {
            return 68;
        }
        if (s.equals("Maharashtrian"))
        {
            return 102;
        }
        if (s.equals("Malaysian"))
        {
            return 69;
        }
        if (s.equals("Malwani"))
        {
            return 71;
        }
        if (s.equals("Mediterranean"))
        {
            return 70;
        }
        if (s.equals("Mexican"))
        {
            return 73;
        }
        if (s.equals("Mughlai"))
        {
            return 75;
        }
        if (s.equals("Multi Cuisine"))
        {
            return 80;
        }
        if (s.equals("North Indian"))
        {
            return 50;
        }
        if (s.equals("Others"))
        {
            return 110;
        }
        if (s.equals("Persian"))
        {
            return 81;
        }
        if (s.equals("Pizza"))
        {
            return 82;
        }
        if (s.equals("Portuguese"))
        {
            return 87;
        }
        if (s.equals("Pub"))
        {
            return 105;
        }
        if (s.equals("Rajasthani"))
        {
            return 88;
        }
        if (s.equals("Raw Meats"))
        {
            return 27;
        }
        if (s.equals("Russian"))
        {
            return 84;
        }
        if (s.equals("Sea Food"))
        {
            return 83;
        }
        if (s.equals("South Indian"))
        {
            return 85;
        }
        if (s.equals("Sri Lankan"))
        {
            return 86;
        }
        if (s.equals("Street Food"))
        {
            return 90;
        }
        if (s.equals("Thai"))
        {
            return 95;
        }
        if (s.equals("Tibetan"))
        {
            return 93;
        }
        return !s.equals("Vietnamese") ? 0 : 99;
    }

    public static int getCurrencySortDrawable(int i, int j)
    {
        if (i == 215)
        {
            if (j == 0)
            {
                return 0x7f0202a3;
            }
            return j != 1 ? 0x7f0202a2 : 0x7f0202a4;
        }
        if (i == 162)
        {
            if (j == 0)
            {
                return 0x7f02029e;
            }
            return j != 1 ? 0x7f02029d : 0x7f02029f;
        }
        if (i == 189)
        {
            if (j == 0)
            {
                return 0x7f0202a7;
            }
            return j != 1 ? 0x7f0202a6 : 0x7f0202a8;
        }
        if (i == 30)
        {
            if (j == 0)
            {
                return 0x7f0202af;
            }
            return j != 1 ? 0x7f0202ae : 0x7f0202b0;
        }
        if (i == 94)
        {
            if (j == 0)
            {
                return 0x7f0202b3;
            }
            return j != 1 ? 0x7f0202b2 : 0x7f0202b4;
        }
        if (i == 208)
        {
            if (j == 0)
            {
                return 0x7f020298;
            }
            return j != 1 ? 0x7f020297 : 0x7f020299;
        }
        if (i == 1)
        {
            if (j == 0)
            {
                return 0x7f02028d;
            }
            return j != 1 ? 0x7f02028c : 0x7f02028e;
        }
        if (j == 0)
        {
            return 0x7f020291;
        }
        return j != 1 ? 0x7f020290 : 0x7f020292;
    }

    public static int getExifOrientation(String s)
    {
        ExifInterface exifinterface = new ExifInterface(s);
        ExifInterface exifinterface1 = exifinterface;
_L8:
        if (exifinterface1 == null) goto _L2; else goto _L1
_L1:
        int i = exifinterface1.getAttributeInt("Orientation", -1);
        if (i == -1) goto _L2; else goto _L3
_L3:
        i;
        JVM INSTR tableswitch 3 8: default 68
    //                   3 73
    //                   4 68
    //                   5 68
    //                   6 70
    //                   7 68
    //                   8 77;
           goto _L2 _L4 _L2 _L2 _L5 _L2 _L6
_L2:
        return 0;
_L5:
        return 90;
_L4:
        return 180;
_L6:
        return 270;
        IOException ioexception;
        ioexception;
        exifinterface1 = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static String getFooterText(String s, String s1, double d, double d1, String s2, int i, 
            int j)
    {
        String s3;
        s3 = "";
        boolean flag;
        if (s.indexOf("search") != -1 || s == "restaurant")
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            return "Share Zomato with your friends.";
        }
        Element element;
        NodeList nodelist;
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(((String)RequestWrapper.Request((new StringBuilder("https://api.zomato.com/v2/promotions.xml?screen=")).append(s).append("&lat=").append(String.valueOf(d)).append("&lon=").append(String.valueOf(d1)).append("&uuid=").append(s1).append("&screen_height=").append(i).append("&screen_width=").append(j).append(SOURCE).append(s2).toString(), "PROMOTIONS", 0x15180)).getBytes("UTF-8"));
        element = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(bytearrayinputstream).getDocumentElement();
        nodelist = element.getElementsByTagName("text");
        if (nodelist == null)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        if (nodelist.getLength() > 0)
        {
            s3 = (new StringBuilder(String.valueOf(nodelist.item(0).getFirstChild().getNodeValue()))).append("~text;").toString();
        }
        NodeList nodelist1 = element.getElementsByTagName("res_id");
        if (nodelist1 == null)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        if (nodelist1.getLength() > 0)
        {
            int k = Integer.parseInt(nodelist1.item(0).getFirstChild().getNodeValue());
            s3 = (new StringBuilder(String.valueOf(s3))).append(k).append("~res_ID;").toString();
        }
        NodeList nodelist2 = element.getElementsByTagName("res_ids");
        if (nodelist2 == null)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        if (nodelist2.getLength() > 0)
        {
            String s9 = nodelist2.item(0).getFirstChild().getNodeValue();
            s3 = (new StringBuilder(String.valueOf(s3))).append(s9).append("~res_ids;").toString();
        }
        NodeList nodelist3 = element.getElementsByTagName("image");
        if (nodelist3 == null)
        {
            break MISSING_BLOCK_LABEL_467;
        }
        if (nodelist3.getLength() > 0)
        {
            String s8 = nodelist3.item(0).getFirstChild().getNodeValue();
            s3 = (new StringBuilder(String.valueOf(s3))).append(s8).append("~image;").toString();
        }
        NodeList nodelist4 = element.getElementsByTagName("type");
        if (nodelist4 == null)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        if (nodelist4.getLength() > 0)
        {
            String s7 = nodelist4.item(0).getFirstChild().getNodeValue();
            s3 = (new StringBuilder(String.valueOf(s3))).append(s7).append("~type;").toString();
        }
        NodeList nodelist5 = element.getElementsByTagName("destination_url");
        if (nodelist5 == null)
        {
            break MISSING_BLOCK_LABEL_617;
        }
        if (nodelist5.getLength() > 0)
        {
            String s6 = nodelist5.item(0).getFirstChild().getNodeValue();
            s3 = (new StringBuilder(String.valueOf(s3))).append(s6).append("~destinationUrl;").toString();
        }
        NodeList nodelist6 = element.getElementsByTagName("title");
        if (nodelist6 == null)
        {
            break MISSING_BLOCK_LABEL_696;
        }
        String s5;
        if (nodelist6.getLength() <= 0)
        {
            break MISSING_BLOCK_LABEL_696;
        }
        String s4 = nodelist6.item(0).getFirstChild().getNodeValue();
        s5 = (new StringBuilder(String.valueOf(s3))).append(s4).append("~title;").toString();
        s3 = s5;
_L2:
        if (s3.equals(""))
        {
            s3 = "Share Zomato with your friends.";
        }
        return s3;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static NumberFormat getNumberFormat()
    {
        NumberFormat numberformat = NumberFormat.getInstance();
        if (numberformat instanceof DecimalFormat)
        {
            ((DecimalFormat)numberformat).setDecimalSeparatorAlwaysShown(true);
            ((DecimalFormat)numberformat).setMinimumFractionDigits(1);
        }
        return numberformat;
    }

    public static String getRatingChar(int i)
    {
        switch (i)
        {
        default:
            return "\u255B";

        case 2: // '\002'
            return "\u255B";

        case 3: // '\003'
            return "\u2550";

        case 4: // '\004'
            return "\u2514";

        case 5: // '\005'
            return "\u2534";

        case 6: // '\006'
            return "\u255A";

        case 7: // '\007'
            return "\u251C";

        case 8: // '\b'
            return "\u2500";

        case 9: // '\t'
            return "\u253C";

        case 10: // '\n'
            return "\u255E";
        }
    }

    public static String getRatingColor(double d)
    {
        if (d > 4.5D)
        {
            return "305d02";
        }
        if (d > 4D)
        {
            return "3f7e00";
        }
        if (d > 3.5D)
        {
            return "5ba829";
        }
        if (d > 3D)
        {
            return "9acd32";
        }
        if (d > 2.5D)
        {
            return "edd614";
        }
        if (d > 2D)
        {
            return "ffba00";
        }
        if (d > 1.5D)
        {
            return "ff7800";
        }
        if (d > 1.0D)
        {
            return "de1d0f";
        }
        if (d == 1.0D)
        {
            return "cb202d";
        } else
        {
            return "2d2d2d";
        }
    }

    public static String getVersionString()
    {
        String s = Locale.getDefault().getLanguage();
        if (!s.equals("pt")) goto _L2; else goto _L1
_L1:
        s = "por";
_L4:
        return (new StringBuilder(String.valueOf(SOURCE))).append("&lang=").append(s).toString();
_L2:
        if (s.equals("in"))
        {
            s = "id";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static double kmToMiles(double d)
    {
        return (double)(int)(62D * d) / 100D;
    }

    public static String readRawTextFile(Context context, int i)
    {
        BufferedReader bufferedreader;
        StringBuilder stringbuilder;
        bufferedreader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i)));
        stringbuilder = new StringBuilder();
_L1:
        String s;
        try
        {
            s = bufferedreader.readLine();
        }
        catch (IOException ioexception)
        {
            return null;
        }
        if (s == null)
        {
            return stringbuilder.toString();
        }
        stringbuilder.append(s);
        stringbuilder.append('\n');
          goto _L1
    }

    public static ContentValues storeImage(Bitmap bitmap)
    {
        int ai[];
        File file;
        long l;
        int i;
        Date date;
        String s;
        String s1;
        String s2;
        String s3;
        File file1;
        FileOutputStream fileoutputstream;
        ByteArrayOutputStream bytearrayoutputstream;
        File file2;
        long l1;
        ContentValues contentvalues;
        try
        {
            ai = new int[1];
            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Zomato");
            if (!file.exists())
            {
                file.mkdirs();
            }
            l = System.currentTimeMillis();
        }
        catch (Exception exception)
        {
            return null;
        }
        i = (int)(l % 10000L);
        date = new Date(l);
        s = (new SimpleDateFormat("yyyyMMdd_HHmmss.SSS")).format(date);
        s1 = (new StringBuilder("filters_")).append(i).append("_").append(s).toString();
        s2 = (new StringBuilder(String.valueOf(s1))).append(".jpg").toString();
        s3 = (new StringBuilder(String.valueOf(file.getPath()))).append(File.separator).append(s2).toString();
        file1 = new File(s3);
label0:
        {
            try
            {
                fileoutputstream = new FileOutputStream(file1);
            }
            catch (FileNotFoundException filenotfoundexception1)
            {
                break label0;
            }
            catch (IOException ioexception1)
            {
                break label0;
            }
            try
            {
                bytearrayoutputstream = new ByteArrayOutputStream();
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, bytearrayoutputstream);
                fileoutputstream.write(bytearrayoutputstream.toByteArray());
                ai[0] = getExifOrientation(s3);
                fileoutputstream.close();
            }
            catch (FileNotFoundException filenotfoundexception) { }
            catch (IOException ioexception) { }
        }
        file2 = new File(file, s2);
        l1 = file2.length();
        contentvalues = new ContentValues(7);
        contentvalues.put("title", s1);
        contentvalues.put("_display_name", s2);
        contentvalues.put("datetaken", Long.valueOf(l));
        contentvalues.put("mime_type", "image/jpeg");
        contentvalues.put("orientation", Integer.valueOf(ai[0]));
        contentvalues.put("_data", s3);
        contentvalues.put("_size", Long.valueOf(l1));
        bitmap.recycle();
        return contentvalues;
    }

    public static final String unescapeHTML(String s, int i)
    {
        String as[][] = {
            {
                "&lt;", "<"
            }, {
                "&gt;", ">"
            }, {
                "&amp;", "&"
            }, {
                "&quot;", "\""
            }, {
                "&agrave;", "\303\240"
            }, {
                "&Agrave;", "\303\u20AC"
            }, {
                "&acirc;", "\303\242"
            }, {
                "&auml;", "\303\244"
            }, {
                "&Auml;", "\303\u201E"
            }, {
                "&Acirc;", "\303\u201A"
            }, {
                "&aring;", "\303\245"
            }, {
                "&Aring;", "\303\u2026"
            }, {
                "&aelig;", "\303\246"
            }, {
                "&AElig;", "\303\u2020"
            }, {
                "&ccedil;", "\303\247"
            }, {
                "&Ccedil;", "\303\u2021"
            }, {
                "&eacute;", "\303\251"
            }, {
                "&Eacute;", "\303\u2030"
            }, {
                "&egrave;", "\303\250"
            }, {
                "&Egrave;", "\303\u02C6"
            }, {
                "&ecirc;", "\303\252"
            }, {
                "&Ecirc;", "\303\u0160"
            }, {
                "&euml;", "\303\253"
            }, {
                "&Euml;", "\303\u2039"
            }, {
                "&iuml;", "\303\257"
            }, {
                "&Iuml;", "\357\277\275?"
            }, {
                "&ocirc;", "\303\264"
            }, {
                "&Ocirc;", "\303\u201D"
            }, {
                "&ouml;", "\303\266"
            }, {
                "&Ouml;", "\303\u2013"
            }, {
                "&oslash;", "\303\270"
            }, {
                "&Oslash;", "\303\u02DC"
            }, {
                "&szlig;", "\303\u0178"
            }, {
                "&ugrave;", "\303\271"
            }, {
                "&Ugrave;", "\303\u2122"
            }, {
                "&ucirc;", "\303\273"
            }, {
                "&Ucirc;", "\303\u203A"
            }, {
                "&uuml;", "\303\274"
            }, {
                "&Uuml;", "\303\u0153"
            }, {
                "&nbsp;", " "
            }, {
                "&reg;", "\251"
            }, {
                "&copy;", "\256"
            }, {
                "&euro;", "\u20A0"
            }, {
                "&#039;", "'"
            }
        };
        int j = s.indexOf("&", i);
        if (j > -1)
        {
            int k = s.indexOf(";", j);
            int l = j + 1;
            if (k > j)
            {
                String s1 = s.substring(j, k + 1);
                int i1 = 0;
                while (i1 < as.length && !as[i1][0].equals(s1)) 
                {
                    i1++;
                }
                if (i1 < as.length)
                {
                    s = unescapeHTML((new StringBuilder(String.valueOf(s.substring(0, j)))).append(as[i1][1]).append(s.substring(k + 1)).toString(), l);
                }
            }
        }
        return s;
    }

    public static void writeBitmapToDisk(String s, Bitmap bitmap, Context context, android.graphics.Bitmap.CompressFormat compressformat)
    {
        String s1;
        s1 = constructFileName(s);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        FileOutputStream fileoutputstream = context.openFileOutput(s1, 0);
        bitmap.compress(compressformat, 75, fileoutputstream);
        fileoutputstream.close();
        return;
        FileNotFoundException filenotfoundexception;
       // filenotfoundexception;
        filenotfoundexception.printStackTrace();
        return;
        IOException ioexception;
       // ioexception;
        ioexception.printStackTrace();
        return;
    }

    static 
    {
        SOURCE = (new StringBuilder("&source=android_market&version=")).append(android.os.Build.VERSION.RELEASE).append("&app_version=").append(33).toString();
        callCapable = true;
        SCREEN_WIDTH = 0;
        SCREEN_HEIGHT = 0;
        UPLOAD_IMAGE_HEIGHT = 1000;
        UPLOAD_IMAGE_WIDTH = 1000;
    }
}

