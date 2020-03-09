package fr.parisstreetart.com.parisstreetart;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MyImage {
    private String title, description, path;
    private long datetimeLong;
    private SimpleDateFormat df = new SimpleDateFormat("MMMM d, yy  h:mm");

    public MyImage(String title, String description, String path,
                   long datetimeLong) {
        this.title = title;
        this.description = description;
        this.path = path;
        this.datetimeLong = datetimeLong;
    }

    public MyImage() {
    }

    /**
     * Obtenir le titre.
     *
     * @return Valeur du titre.
     */
    public String getTitle() { return title; }

    /**
     * Obtenir datetime.
     *
     * @return Valeur de datetime.
     */
    public Calendar getDatetime() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(datetimeLong);
        return cal;
    }

    /**
     * Etablir nouveau datetimeLong.
     *
     * @param datetimeLong Nouvelle valeur de datetimeLong.
     */
    public void setDatetime(long datetimeLong) {
        this.datetimeLong = datetimeLong;
    }

    /**
     * Etablir nouveau datetime.
     *
     * @param datetime Nouvelle valeur de datetime.
     */
    public void setDatetime(Calendar datetime) {
        this.datetimeLong = datetime.getTimeInMillis();
    }

    /**
     * Obtenir description.
     *
     * @return Valeur de description.
     */
    public String getDescription() { return description; }

    /**
     * Etablir nouveau titre.
     *
     * @param title Nouvelle valeur de titre.
     */
    public void setTitle(String title) { this.title = title; }

    /**
     * Obtenir datetimeLong.
     *
     * @return Valeur de datetimeLong.
     */
    public long getDatetimeLong() { return datetimeLong; }

    /**
     * Etablir nouvelle description.
     *
     * @param description Nouvelle valeur de description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Etablir nouvelle path.
     *
     * @param path Nouvelle valeur de path.
     */
    public void setPath(String path) { this.path = path; }

    /**
     * Obtenir path.
     *
     * @return Valeur de path.
     */
    public String getPath() { return path; }

    @Override public String toString() {
        return "Title:" + title + "   " + df.format(getDatetime().getTime()) +
                "\nDescription:" + description;
    }
}
