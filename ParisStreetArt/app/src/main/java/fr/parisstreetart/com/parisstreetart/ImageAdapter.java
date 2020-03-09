package fr.parisstreetart.com.parisstreetart;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ImageAdapter extends ArrayAdapter<MyImage> {
    private final int THUMBSIZE = 96;

    /**
     * Utiliser un ViewHolder pattern pour que le Listview se montre plus rapidement.
     * Le chargement des items sera plus rapide en mettant en cache la view dans un objet ViewHolder
     */
    private static class ViewHolder {
        ImageView imgIcon;
        TextView description;
    }

    public ImageAdapter(Context context, ArrayList<MyImage> images) {
        super(context, 0, images);
    }

    @Override public View getView(int position, View convertView,
                                  ViewGroup parent) {
        ViewHolder viewHolder;
        // Voir si une view existant est en train d'être utilisée, sinon on crée la view des items
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_image, parent, false);
            viewHolder.description =
                    (TextView) convertView.findViewById(R.id.item_img_infor);
            viewHolder.imgIcon =
                    (ImageView) convertView.findViewById(R.id.item_img_icon);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Obtenir l'item data depuis cette position
        MyImage image = getItem(position);
        // établir texte de la description
        viewHolder.description.setText(image.toString());
        // établir l'image de l'icônes
        viewHolder.imgIcon.setImageBitmap(ThumbnailUtils
                .extractThumbnail(BitmapFactory.decodeFile(image.getPath()),
                        THUMBSIZE, THUMBSIZE));

        // Retourner la view complète pour la montrer à l'écran
        return convertView;
    }
}
