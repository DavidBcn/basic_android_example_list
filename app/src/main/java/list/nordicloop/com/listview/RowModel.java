package list.nordicloop.com.listview;

public class RowModel {
    private String mTitle;
    private String mSubTitle;
    private int mIcon;

    /**
     * Constructor of the RowModel object.
     * @param title the string that represents the title.
     * @param subTitle the string that represents the subtitle.
     * @param icon the resource id that represents the icon.
     */
    public RowModel(String title, String subTitle, int icon) {
        mTitle = title;
        mSubTitle = subTitle;
        mIcon = icon;
    }

    /**
     * Returns the title.
     * @return {@code String}
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the subtitle.
     * @return {@code String}
     */
    public String getSubTitle() {
        return mSubTitle;
    }


    /**
     * Returns the resource id of the icon.
     * @return {@code int}
     */
    public int getIcon() {
        return mIcon;
    }
}