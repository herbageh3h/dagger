package com.icbc.dagger.hunter;

import java.util.List;

import com.icbc.dagger.hunter.checker.Checker;
import com.icbc.dagger.hunter.data.OpenSoft;

/**
 * Finder to detect soft category
 * 
 * @author huanghao
 * @since 20170501
 *
 */
public class CategoryFinder {
    private List<Checker> checkerList;

    public CategoryFinder() {
        CheckerArmy checkers = new CheckerArmy();
        checkerList = checkers.jarCheckers();
    }

    public String findCategory(String path) {
        for (Checker checker : checkerList) {
            if (checker.pass(path)) {
                return checker.getName();
            }
        }
        return "NO-CATEGORY";
    }

    public void fillCategory(OpenSoft soft) {
        if (soft == null) {
            return;
        }

        soft.setCategory(findCategory(soft.getPath()));
    }

}
