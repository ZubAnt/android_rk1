package ru.pkcc.anton.rk1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity{

    private FragmentManager fragmentManager;
    private ArticleListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listFragment = new ArticleListFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.listFragment, listFragment)
                .commit();

        listFragment.setOnArticleClickListener(new OnArticleClickListener() {
            @Override
            public void onArticleClick(Article article) {
                showArticle(article);
            }
        });
    }

    private void showArticle(Article article) {

        if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
            ArticleFragment fragment = ArticleFragment.newInstance(article);

            fragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.listFragment, fragment)
                    .commit();
        } else {
            ArticleFragment fragment = ArticleFragment.newInstance(article);

            fragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.listFragment, listFragment)
                    .replace(R.id.article, fragment)
                    .commit();
        }
    }
}


