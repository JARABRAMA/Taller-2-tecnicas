package culturemedia.repository.impl;

import culturemedia.model.View;
import culturemedia.repository.ViewsRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewsRepositoryImpl implements ViewsRepository {
    List<View> views = new ArrayList<>();

    @Override
    public View add(View view) {
        if (views.add(view)) {
            return view;
        }
        return null;
    }
}
