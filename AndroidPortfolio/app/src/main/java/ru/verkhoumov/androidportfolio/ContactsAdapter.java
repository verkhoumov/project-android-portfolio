package ru.verkhoumov.androidportfolio;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<ContactsModel> contacts;
    private ContactsFragment contactsFragment;
    public Context mContext;

    public ContactsAdapter(List<ContactsModel> contacts, ContactsFragment contactsFragment) {
        this.contacts = contacts;
        this.contactsFragment = contactsFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_item, parent, false);

        // Запоминаем контекст.
        mContext = parent.getContext();

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ContactsModel post = contacts.get(position);

        String type = post.getType();
        String name = post.getName();
        String link = post.getLink();
        String code = post.getCode();

        if (type.equals("social")) {
            // Удаляем из ссылки https?.
            link = link.replace("https://", "");
            link = link.replace("http://", "");

            holder.name.setText(link);
        } else {
            holder.name.setText(name);
        }

        // Заменяем тире на нижнее подчёркивание.
        code = code.replace("-", "_");

        // Установка иконки в зависимости от контакта.
        int drawableId = mContext.getResources().getIdentifier(code, "drawable", mContext.getPackageName());

        if (drawableId > 0) {
            Drawable drawable = mContext.getResources().getDrawable(drawableId);

            if (drawable != null) {
                holder.image.setImageDrawable(drawable);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (contacts == null) {
            return 0;
        }

        return contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.contactsItemImage);
            name = (TextView) itemView.findViewById(R.id.contactsItemName);
        }
    }
}