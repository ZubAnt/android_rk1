package ru.pkcc.anton.rk1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.mail.park.articlelistlib.Article;

public class ArticleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle b = getArguments();
        Article article = (Article) b.getSerializable("article");

        LinearLayout view = (LinearLayout) inflater.inflate(R.layout.article, container, false);

        TextView vTitle = view.findViewById(R.id.artTitleId);
        if (article != null) {
            vTitle.setText(article.getTitle());
        }

        TextView vDate = view.findViewById(R.id.artDateId);
        if (article != null) {
            vDate.setText(article.getDate().toString());
        }

        TextView vContent = view.findViewById(R.id.artContentId);
        if (article != null) {
            vContent.setText(article.getContent());
        }

        return view;

    }

    public static ArticleFragment newInstance(Article article) {

        Bundle args = new Bundle();
        args.putSerializable("article", article);

        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
